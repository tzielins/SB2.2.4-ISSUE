/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.biodare.springtest.security;

import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author tzielins
 */
public interface BioDare2User extends UserDetails {

    String getEmail();
    
    String getInitialEmail();

    String getFirstName();

    Long getId();

    String getLastName();

    String getLogin();

    String getName();
    
    String getORCID();
    
    String getInstitution();
    
    boolean isPI();
    
    boolean isAdmin();
    

    boolean isAnonymous();

    boolean isBackendOnly();

    boolean isLocked();

    boolean isSystem();
    
    boolean isReadOnly();
    
    boolean hasDirtySession();
    void setDirtySession(boolean dirty);


    
    BioDare2User getSupervisor();
    
    

}
