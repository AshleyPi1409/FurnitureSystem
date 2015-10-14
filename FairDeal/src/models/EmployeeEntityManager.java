/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lehai
 */
/**
 * Employee data entity manager
 *
 * @author lehai
 */
public class EmployeeEntityManager extends AbstractEntityManager<Employee> {

    public EmployeeEntityManager() {
        super(Employee.class);
    }

    /**
     * Current logged in account
     */
    public static Employee currentEmployee = null;

    /**
     * Get all of the employees account which are still active
     *
     * @return list of active accounts
     */
    @Override
    public List<Employee> getAll() {
        List<Employee> list = super.getAll();
        List<Employee> res = new ArrayList<>();
        //Filter out those accounts that are not active
        for (Employee ins : list) {
            if (ins.getIsActive()) {
                res.add(ins);
            }
        }
        return res;
    }

    /**
     * Get all of employee accounts from the database
     *
     * @return list of all employee accounts
     */
    public List<Employee> getAccFromDB() {
        List<Employee> list = super.getAll();
        return list;
    }

    /**
     * Find account by username
     *
     * @param username
     * @return Employee object if found, else return null
     *
     */
    public Employee find(String username) {
        for (Employee i : getAll()) {
            if (i.getUsername().equalsIgnoreCase(username)) {
                return i;
            }
        }

        System.err.println("Cannot find account " + username);
        return null;
    }

    /**
     * Add a new employee to the database
     *
     * @param instance
     * @return true if succeeded, else false
     */
    public boolean addNew(Employee instance) {
        if (instance.getUsername().isEmpty()) {
            return false;
        }
        try {
            if (find(instance.getUsername()) != null) {
                System.err.println("Employee is already exists!");
                return false;
            }

            super.insert(instance);
            return true;
        } catch (Exception ex) {
            System.out.println("Failed attempt to add new instance: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Update employee's information
     * @param instance new information
     * @return true if succeeded, else false
     *
     */
    public boolean edit(Employee instance) {
        if (instance.getUsername().isEmpty()) {
            return false;
        }

        try {
            Employee search = find(instance.getUsername());

            if (search == null || Objects.equals(search.getId(), instance.getId())) {
                super.update(instance);
                return true;
            }

            return false;

        } catch (Exception ex) {
            System.out.println("Failed to update new information: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Deactivate an account
     *
     * @param instance
     * @return 
     */
    @Override
    public boolean delete(Employee instance) {
        try {
            instance.setIsActive(false);
            if (super.update(instance)) {
                DiaryEntityManager.createLog("Deleted employee \"" + instance.getName() + "\"");
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
     * Login and update login session to the system
     *
     * @param username
     * @param password
     * @return true if succeeded, else false
     */
    public boolean login(String username, String password) {
        for (Employee acc : getAll()) {
            if (username.equals(acc.getUsername()) && password.equals(acc.getPassword())) {
                currentEmployee = acc;
                DiaryEntityManager.createLog("Logged in to the system.");
                return true;
            }
        }
        return false;
    }
}
