/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.biodare.springtest;

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
    private TestRestTemplate template;
    
    @Test
    public void contextLoads() {
    }
        
    @Test
    public void testConfigurationFileShouldBeLoaded() {
        assertNotNull(env);        
        assertTrue("Should end with test, got: "+env.getProperty("bd2.storage.dir", "MISSING"),env.getProperty("bd2.storage.dir", "MISSING").endsWith("test"));
    }    
    
    @Test
    @Ignore
    public void CORSWorks() throws IOException {
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Origin", "http://localhost:3000");
        
        HttpEntity<String> request = new HttpEntity<>(headers);
        
        ResponseEntity<String> response = template.exchange("/", HttpMethod.OPTIONS, request, String.class);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
    
}
