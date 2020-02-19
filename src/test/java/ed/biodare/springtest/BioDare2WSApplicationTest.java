/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.biodare.springtest;

import ed.biodare.springtest.security.dao.UserAccountRep;
import ed.biodare.springtest.security.dao.db.UserAccount;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @Import(SimpleRepoTestConfig.class)
public class BioDare2WSApplicationTest {

    
    @Autowired
    Environment env;
    
    @Autowired
    UserAccountRep accounts;    
    
    @Test
    public void contextLoads() {
    }
        
    @Test
    public void testConfigurationFileShouldBeLoaded() {
        assertNotNull(env);        
        assertTrue("Should end with test, got: "+env.getProperty("bd2.storage.dir", "MISSING"),env.getProperty("bd2.storage.dir", "MISSING").endsWith("test"));
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
