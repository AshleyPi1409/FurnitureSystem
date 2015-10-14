/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lehai
 */
public class FunctionEntityManager extends AbstractEntityManager<Action> {

    public FunctionEntityManager() {
        super(Action.class);
    }

    final public static int ACCOUNT_MANAGEMENT = 1;
    final public static int ACCOUNT_PERMISSION = 2;
    final public static int PRODUCT_MANAGEMENT = 3;
    final public static int SELL_PRODUCTS = 4;
    final public static int BILL_OVERVIEW = 5;
    final public static int UNIT_MANAGEMENT = 6;
    final public static int CATEGORY_MANAGEMENT = 7;
    final public static int PUBLISHER_MANAGEMENT = 8;
    final public static int REPORT = 9;
    final public static int BACKUP = 10;
    final public static int RESTORE = 11;
    final public static int DIARY = 12;

    /**
     * List cac doi tuong dang con duoc su dung (isActive=true)
     *
     * @return list doi tuong
     */
    @Override
    public List<Action> getAll() {
        List<Action> list = super.getAll();

        List<Action> res = new ArrayList<>();

        for (Action ins : list) {
            if (ins.getIsActive()) {
                res.add(ins);
            }
        }
        return res;
    }

    public List<Action> getAllFromDB() {
        List<Action> list = super.getAll();
        return list;
    }

    /**
     * Tim kiem doi tuong theo ten
     *
     * @param name
     * @return doi tuong tim thay
     */
    public Action find(String name) {
        for (Action ins : getAll()) {
            if (ins.getName().equalsIgnoreCase(name)) {
                return ins;
            }
        }
        System.out.println("Function \"" + name + "\" chua ton tai");
        return null;
    }

    /**
     * Them doi tuong moi, co kiem tra tinh hop le
     *
     * @param instance
     * @return insert thanh cong hay khong
     */
    public boolean addNew(Action instance) {
        if (instance.getName().isEmpty()) {
            return false;
        }
        try {
            if (find(instance.getName()) != null) {
                System.err.println("Function da ton tai!");
                return false;
            }

            instance.setIsActive(true);
            super.insert(instance);
            DiaryEntityManager.createLog("Created function \"" + instance.getName() + "\"");
            return true;
        } catch (Exception ex) {
            System.out.println("Them function moi khong thanh cong: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Update doi tuong moi, co kiem tra tinh hop le
     *
     * @param instance ID cua instance phai ton tai trong CSDL, neu ko se tao
     * mot ban ghi moi
     * @param name
     */
    public boolean edit(Action instance) {
        if (instance.getName().isEmpty()) {
            return false;
        }

        try {
            Action search = find(instance.getName());
            //Neu doi ten thi phai bao dam la ten nay chua ton tai
            if (search == null || Objects.equals(search.getId(), instance.getId())) {
                instance.setIsActive(true);
                super.update(instance);
                DiaryEntityManager.createLog("Edited function \"" + instance.getName() + "\"");
                return true;
            }

            return false;

        } catch (Exception ex) {
            System.out.println("Update function khong thanh cong: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Xoa mot doi tuong (isActive=false)
     *
     * @param instance
     * @return 
     */
    @Override
    public boolean delete(Action instance) {
        try {
            instance.setIsActive(false);
            if (super.update(instance)) {
                DiaryEntityManager.createLog("Deleted action \"" + instance.getName() + "\"");
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Failed to disable instance: " + ex.getMessage());
            return false;
        }
    }

}
