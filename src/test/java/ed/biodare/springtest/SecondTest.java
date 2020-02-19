/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.biodare.springtest;

import ed.biodare.springtest.security.dao.UserAccountRep;
import ed.biodare.springtest.security.dao.db.UserAccount;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author tzielins
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BioDare2WSApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SecondTest {

    
    @Autowired
    EnvironmentVariables instance;
    
    @Autowired
    UserAccountRep accounts;
    
    public SecondTest() {
    }
    
    @Test
    public void canAddFirstUser() {
        UserAccount acc = UserAccount.testInstance(1L);
        acc.setLogin("user1");
        acc.setPassword("user1");
        acc.setFirstName("First");
        acc.setLastName("User");
        acc.setEmail("biodare6@ed.ac.uk");
        acc.setSupervisor(acc);
        acc.setInstitution("University of Edinburgh");
        
        acc = accounts.save(acc);         
        assertNotNull(acc);
    }
  

    @Test
    public void hasBackendURL() {
        
        assertNotNull(instance.backendURL);
    }      
     
}
