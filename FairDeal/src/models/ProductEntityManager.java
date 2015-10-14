/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class ProductEntityManager extends AbstractEntityManager<Product> {

    public ProductEntityManager() {
        super(Product.class);
    }

    /**
     * List cac doi tuong dang con duoc su dung (isActive=true)
     *
     * @return list doi tuong
     */
    @Override
    public List<Product> getAll() {
        List<Product> list = super.getAll();

        List<Product> res = new ArrayList<>();

        for (Product ins : list) {
            if (ins.getIsActive()) {
                res.add(ins);
            }
        }
        return res;
    }

    public List<Product> getAllFromDB() {
        List<Product> list = super.getAll();
        return list;
    }

    /**
     * Tim kiem doi tuong theo ten
     *
     * @param name
     * @return doi tuong tim thay
     */
    public Product find(String name) {
        for (Product ins : getAll()) {
            if (ins.getProductName().equalsIgnoreCase(name)) {
                return ins;
            }
        }

        System.err.println("Khong tim thay \"" + name + "\"");
        return null;
    }

    /**
     * Them doi tuong moi, co kiem tra tinh hop le
     *
     * @param instance
     * @return
     */
    public boolean addNew(Product instance) {
        if (find(instance.getProductName()) != null) {
            return false;
        }

        instance.setIsActive(true);

        super.insert(instance);
        DiaryEntityManager.createLog("Created product \"" + instance.getProductName()+ "\"");
        return true;
    }

    /**
     * Update doi tuong moi, co kiem tra tinh hop le
     *
     * @param instance ID cua instance phai ton tai trong CSDL, neu ko se tao
     * mot ban ghi moi
     * @param name
     * @return
     */
    public boolean edit(Product instance) {
        try {
            Product search = find(instance.getProductName());
            //Neu doi ten thi phai bao dam la ten nay chua ton tai
            if (search == null || Objects.equals(search.getId(), instance.getId())) {
                instance.setIsActive(true);
                super.update(instance);
                DiaryEntityManager.createLog("Edited product \"" + instance.getProductName()+ "\"");
                return true;
            }

            return false;

        } catch (Exception ex) {
            System.out.println("Update product khong thanh cong: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Xoa mot doi tuong (isActive=false)
     *
     * @param instance
     */
    @Override
    public boolean delete(Product instance) {
        try {
            instance.setIsActive(false);
            if (super.update(instance)) {
                DiaryEntityManager.createLog("Deleted product \"" + instance.getProductName()+ "\"");
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
