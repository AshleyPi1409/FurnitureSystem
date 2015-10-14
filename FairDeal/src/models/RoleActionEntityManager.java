/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.RoleAction;

/**
 *
 * @author lehai
 */
public class RoleActionEntityManager extends AbstractEntityManager<RoleAction>{

    public RoleActionEntityManager() {
        super(RoleAction.class);
    }
    
    /**
     * Tim moi quan he role - function
     * @param roleID
     * @param functionID
     * @return ket qua. Neu khong co tra ve null.
     */
    public RoleAction find(int roleID,int functionID){
        for(RoleAction rf:super.getAll()){
            if(rf.getAction().getId()==functionID&&rf.getRole().getId()==roleID){
                return rf;
            }
        }
        return null;
    }
    
}
