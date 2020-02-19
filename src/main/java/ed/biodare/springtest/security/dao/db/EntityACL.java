/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and isOpen the template in the editor.
 */
package ed.biodare.springtest.security.dao.db;


import ed.biodare.springtest.security.BioDare2User;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author tzielins
 */
@Entity
@Table(indexes = {
    @Index(name="DBSystemInfo_ownerIX",columnList="owner_id", unique = false),
    @Index(name="DBSystemInfo_superOwnerIX",columnList="super_owner_id", unique = false)
})
public class EntityACL implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public EntityACL() {};
    
    public static EntityACL testInstance(Long id) {
        return new EntityACL(id);
    }
    
    /**
     * For testing only;
     * @param id 
     */
    private EntityACL(Long id) {
        this();
        this.id = id;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator="ACLGen")
    @TableGenerator(name="ACLGen",allocationSize = 10, initialValue = 1000,table = "hibernate_sequences")
    private Long id;
    @Version
    private long version;    

    @ManyToOne(targetEntity = UserAccount.class, fetch = FetchType.EAGER)
    protected BioDare2User creator;
    
    @ManyToOne(targetEntity = UserAccount.class, fetch = FetchType.EAGER)
    protected BioDare2User owner;

    @ManyToOne(targetEntity = UserAccount.class, fetch = FetchType.EAGER)
    protected BioDare2User superOwner;
    
    protected boolean isOpen;
    
    @CreationTimestamp
    LocalDateTime creationDate;
    
    @UpdateTimestamp
    LocalDateTime modificationDate;
    


    public Long getId() {
	return id;
    }
    
 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EntityACL other = (EntityACL) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


    public boolean isPublic() {
        return isOpen;
    }
    
    public void setPublic(boolean isPublic) {
        this.isOpen = isPublic;
    }


    @Override
    public String toString() {
	return "ACL[id=" + id + "]";
    }




    public BioDare2User getCreator() {
        return creator;
    }

    public void setCreator(BioDare2User creator) {
        this.creator = creator;
    }
    
    

    public BioDare2User getOwner() {
	return owner;
    }

    public void setOwner(BioDare2User owner) {
	this.owner = owner;
    }

    public BioDare2User getSuperOwner() {
	return superOwner;
    }

    public void setSuperOwner(BioDare2User superOwner) {
	this.superOwner = superOwner;
    }

    
}
