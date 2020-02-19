/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.biodare.springtest.security.dao.db;

import ed.biodare.springtest.security.BioDare2User;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author tzielins
 */
@Entity
@Table(indexes = {
    @Index(name="UserToken_expiring",columnList="expiring", unique = false)
})
public class UserToken implements Serializable {
    
    static final long serialVersionUID = 3L;
    
    @Id
    String token;
    
    @OneToOne(targetEntity = UserAccount.class)
    @NotNull
    BioDare2User user;
    
    @NotNull
    @Enumerated(EnumType.ORDINAL)            
    UserTokenKind kind;
    
    @CreationTimestamp
    LocalDateTime created;
    
    @NotNull
    LocalDateTime expiring;
    
    protected UserToken() {
        
    }
    
    public UserToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }


    public BioDare2User getUser() {
        return user;
    }

    public void setUser(BioDare2User user) {
        this.user = user;
    }

    public UserTokenKind getKind() {
        return kind;
    }

    public void setKind(UserTokenKind kind) {
        this.kind = kind;
    }



    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getExpiring() {
        return expiring;
    }

    public void setExpiring(LocalDateTime expiring) {
        this.expiring = expiring;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.token);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserToken other = (UserToken) obj;
        if (!Objects.equals(this.token, other.token)) {
            return false;
        }
        return true;
    }
    
    
    
}
