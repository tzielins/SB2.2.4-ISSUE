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
    public void hasStoragePath() {
        
        assertNotNull(instance.storageDir);
        //assertEquals(Paths.get("D:/Temp/biodare2/storage"),instance.storageDir);
    }
    
    @Test
    public void hasBackendURL() {
        
        assertNotNull(instance.backendURL);
    }    
    
    @Test
    public void hasJobcentreURL() {
        
        assertNotNull(instance.jobcentreURL);
    }    
    
    @Test
    public void hasReCaptchaKeys() {
        
        assertNotNull(instance.recaptchaSiteKey);
        assertNotNull(instance.recaptchaSecretKey);
    }        
    
    @Test
    public void hasMailProperties() {
        
        assertNotNull(instance.mailHost);
        assertNotNull(instance.mailUser);
        assertNotNull(instance.mailPassword);
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
        // acc.addGroup(fixtures.otherGroup);
        
        acc = accounts.save(acc);         
        assertNotNull(acc);
    }
}
