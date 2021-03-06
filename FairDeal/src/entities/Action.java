package entities;
// Generated Oct 14, 2015 9:28:16 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Action generated by hbm2java
 */
@Entity
@Table(name="Action"
    ,schema="dbo"
    ,catalog="FairDeal"
)
public class Action  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Boolean isActive;
     private Set<RoleAction> roleActions = new HashSet<RoleAction>(0);

    public Action() {
    }

    public Action(String name, Boolean isActive, Set<RoleAction> roleActions) {
       this.name = name;
       this.isActive = isActive;
       this.roleActions = roleActions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="Name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="IsActive")
    public Boolean getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="action")
    public Set<RoleAction> getRoleActions() {
        return this.roleActions;
    }
    
    public void setRoleActions(Set<RoleAction> roleActions) {
        this.roleActions = roleActions;
    }




}


