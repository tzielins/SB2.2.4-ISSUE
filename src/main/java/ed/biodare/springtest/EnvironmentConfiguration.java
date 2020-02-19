/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.biodare.springtest;

import java.security.GeneralSecurityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author Zielu
 */
@Configuration
@PropertySource(value={"classpath:security.properties"},ignoreResourceNotFound = true)
@PropertySource(value="file:security.properties",ignoreResourceNotFound = true)
public class EnvironmentConfiguration {
    
    final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    Environment env;
    
     
    @Bean
    public EnvironmentVariables environmentVariables(
                                @Value("${bd2.storage.dir}") String storageDirPath,
                                @Value("${bd2.backend.url}") String backendURL,
                                @Value("${bd2.jobcentre.wsdl}") String jobcentreURL,
                                @Value("${bd2.recaptcha.site-key}") String recaptchaSiteKey,
                                @Value("${bd2.recaptcha.secret-key}") String recaptchaSecretKey,
                                @Value("${spring.mail.host}") String mailHost,
                                @Value("${spring.mail.username}") String mailUser
                                
    ) {
        String mailPassword = mailPassword(env);
        if (mailPassword == null) {
            throw new BeanInstantiationException(EnvironmentVariables.class, 
                    "Cannot init environment missing email password");
        }
        
        log.warn("ENV STORAGE {}", storageDirPath);
        
        return new EnvironmentVariables(
                storageDirPath, 
                backendURL, 
                jobcentreURL, 
                recaptchaSiteKey, 
                recaptchaSecretKey,
                mailHost, 
                mailUser, 
                mailPassword);
    }
    
    
    String mailPassword(Environment env) {

        String mailPass = env.getProperty("bd2.mail.password");
        String encoderPass = env.getProperty("bd2.inner.encoder");
        if (encoderPass != null && mailPass != null) {
            mailPass = decodeSettings(encoderPass, mailPass);
        }
        return mailPass;
                
    }
            
    
    String decodeSettings(String pass, String value) {
        return value;
    }
    
    
    
    
  
    
    


     
}
