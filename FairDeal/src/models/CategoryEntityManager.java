/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lehai
 */
public class CategoryEntityManager extends AbstractEntityManager<Category> {

    public CategoryEntityManager() {
        super(Category.class);
    }

    /**
     * Get all active categories
     *
     * @return the list
     */
    @Override
    public List<Category> getAll() {
        List<Category> list = super.getAll();

        List<Category> res = new ArrayList<>();

        for (Category ins : list) {
            if (ins.getIsActive()) {
                res.add(ins);
            }
        }
        return res;
    }

    public List<Category> getAllFromDB() {
        List<Category> list = super.getAll();
        return list;
    }

    /**
     * Find category by its name
     *
     * @param name
     * @return found instance
     */
    public Category find(String name) {
        for (Category ins : getAll()) {
            if (ins.getName().equalsIgnoreCase(name)) {
                return ins;
            }
        }

        System.err.println("Category \"" + name + "\" doesn't exists");
        return null;
    }

    /**
     * Add new category
     *
     * @param instance
     * @return true if succeeded, else false
     */
    public boolean addNew(Category instance) {
        if (instance.getName().isEmpty()) {
            return false;
        }
        try {
            if (find(instance.getName()) != null) {
                System.err.println("Category already exists!");
                return false;
            }

            super.insert(instance);
            DiaryEntityManager.createLog("Created category \"" + instance.getName() + "\"");
            return true;
        } catch (Exception ex) {
            System.out.println("Failed to add new category: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Update category's information. If the category doesn't exist, create a
     * new one.
     *
     * @param instance new information
     * @return
     */
    public boolean edit(Category instance) {
        if (instance.getName().isEmpty()) {
            return false;
        }

        try {
            Category search = find(instance.getName());
            //Neu doi ten thi phai bao dam la ten nay chua ton tai
            if (search == null || Objects.equals(search.getId(), instance.getId())) {
                super.update(instance);
                DiaryEntityManager.createLog("Edited category \"" + instance.getName() + "\"");
                return true;
            }

            return false;

        } catch (Exception ex) {
            System.out.println("Failed to update category: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Disable a category
     *
     * @param instance
     */
    @Override
    public boolean delete(Category instance) {
        try {
            instance.setIsActive(false);
            if (super.update(instance)) {
                DiaryEntityManager.createLog("Deleted category \"" + instance.getName() + "\"");
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Failed to disable category: " + ex.getMessage());
            return false;
        }
    }

}
