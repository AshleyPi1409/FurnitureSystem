/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Action;
import entities.Role;
import entities.RoleAction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author lehai
 */
public class RoleEntityManager extends AbstractEntityManager<Role> {

    public RoleEntityManager() {
        super(Role.class);
    }

    /**
     * List cac doi tuong dang con duoc su dung (isActive=true)
     *
     * @return list doi tuong
     */
    @Override
    public List<Role> getAll() {
        List<Role> list = super.getAll();

        List<Role> res = new ArrayList<>();

        for (Role ins : list) {
            if (ins.getIsActive()) {
                res.add(ins);
            }
        }
        return res;
    }

    public List<Role> getAllFromDB() {
        List<Role> list = super.getAll();
        return list;
    }

    /**
     * Tim kiem doi tuong theo ten
     *
     * @param name
     * @return doi tuong tim thay
     */
    public Role find(String name) {
        for (Role ins : getAll()) {
            if (ins.getName().equalsIgnoreCase(name)) {
                return ins;
            }
        }
        return null;
    }

    /**
     * Them doi tuong moi, co kiem tra tinh hop le
     *
     * @param instance
     * @param funcList list function
     * @return insert thanh cong hay khong
     */
    public boolean addNew(Role instance, Set<Action> funcList) {
        if (instance.getName().isEmpty()) {
            return false;
        }

        if (find(instance.getName()) != null) {
            System.err.println("Role da ton tai!");
            return false;
        }

        try {
            instance.setIsActive(true);
            super.insert(instance);

            DiaryEntityManager.createLog("Created role \"" + instance.getName() + "\"");

            RoleActionEntityManager rfModel = new RoleActionEntityManager();

            for (Action func : funcList) {
                RoleAction rf = new RoleAction();
                rf.setRole(instance);
                rf.setAction(func);
                rfModel.insert(rf);
                DiaryEntityManager.createLog("Grant \"" + func.getName() + "\" permission to role \"" + instance.getName() + "\"");
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    /**
     * Update doi tuong moi, co kiem tra tinh hop le
     *
     * @param instance ID cua instance phai ton tai trong CSDL, neu ko se tao
     * mot ban ghi moi
     * @param funcList list function
     * @return
     */
    public boolean edit(Role instance, Set<Action> funcList) {
        if (instance.getName().isEmpty()) {
            return false;
        }

        Role search = find(instance.getName());

        try {

            //Neu doi ten thi phai bao dam la ten nay chua ton tai
            if (search == null || Objects.equals(search.getId(), instance.getId())) {
                instance.setIsActive(true);
                super.update(instance);

                RoleActionEntityManager rfModel = new RoleActionEntityManager();

                //Xoa danh sach function cu
                for (RoleAction rf : rfModel.getAll()) {
                    if (rf.getRole().getId() == instance.getId()) {
                        rfModel.delete(rf);
                    }
                }
                //Add lai danh sach moi
                for (Action func : funcList) {
                    RoleAction rf = new RoleAction();
                    rf.setRole(instance);
                    rf.setAction(func);
                    rfModel.insert(rf);
                }
                DiaryEntityManager.createLog("Edited role \"" + instance.getName() + "\"");
                return true;
            }
            return false;
        } catch (Exception ex) {
            System.err.println("Update role khong thanh cong: " + ex.getMessage());
            return false;
        }

    }

    /**
     * Xoa mot doi tuong (isActive=false)
     *
     * @param instance
     */
    @Override
    public boolean delete(Role instance) {
        if (instance == null) {
            return false;
        }

        try {
            instance.setIsActive(false);
            if (super.update(instance)) {
                DiaryEntityManager.createLog("Deleted role \"" + instance.getName() + "\"");
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Failed to disable instance: " + ex.getMessage());
            return false;
        }

    }

    /**
     * Lay danh sach cac function cua role
     *
     * @param instance
     * @return list function
     */
    public Set<Action> getFunctionList(Role instance) {
        if (instance == null) {
            return null;
        }

        Set<Action> res = new HashSet<>();
        RoleActionEntityManager rfModel = new RoleActionEntityManager();

        for (RoleAction rf : rfModel.getAll()) {
            if (Objects.equals(rf.getRole().getId(), instance.getId())) {
                res.add(rf.getAction());
            }
        }

        return res;

    }
}
