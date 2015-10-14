/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Ashley
 */
public class OrderEntityManager extends AbstractEntityManager<Order> {

    public OrderEntityManager() {
        super(Order.class);
    }

    /**
     * List cac doi tuong dang con duoc su dung (isActive=true)
     *
     * @return list doi tuong
     */
    @Override
    public List<Order> getAll() {
        List<Order> list = super.getAll();

        List<Order> res = new ArrayList<>();

        for (Order ins : list) {
            if (ins.getIsActive()) {
                res.add(ins);
            }
        }
        return res;
    }

    /**
     * Tim kiem doi tuong theo id
     *
     * @param name
     * @return doi tuong tim thay
     */
    public Order find(int id) {
        return super.find(id);
    }

    /**
     * Them doi tuong moi
     *
     * @param instance
     * @return
     */
    public boolean addNew(Order instance) {

        super.insert(instance);
        DiaryEntityManager.createLog( "Created bill #"+instance.getId());
        return true;

    }

    /**
     * Update doi tuong moi
     *
     * @param instance ID cua instance phai ton tai trong CSDL, neu ko se tao
     * mot ban ghi moi
     * @return
     */
    public boolean edit(Order instance) {

        Order search = find(instance.getId());

        if (search == null || Objects.equals(search.getId(), instance.getId())) {
            super.update(instance);
            DiaryEntityManager.createLog( "Edited bill #"+instance.getId());
            return true;
        }

        return false;

    }

    /**
     * Xoa mot doi tuong (isActive=false)
     *
     * @param instance
     */
    @Override
    public boolean delete(Order instance) {
        try {
            instance.setIsActive(false);
            if (super.update(instance)) {
                DiaryEntityManager.createLog("Deleted order \"" + instance.getId()+ "\"");
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
