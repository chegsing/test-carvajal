package co.com.carvajal.main;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import co.com.carvajal.transversal.constants.ConfigurationConstants;

import java.util.Properties;

/**
 * MailSenderConfig
 * 
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 * 
 */
@Configuration
public class MailSenderConfig {

  @Value(ConfigurationConstants.EMAIL_HOST)
  private String host;
  
  @Value(ConfigurationConstants.EMAIL_PORT)
  private int port;
  
  @Value(ConfigurationConstants.EMAIL_USER)
  private String user;
  
  @Value(ConfigurationConstants.EMAIL_PASS)
  private String pass;
  
    @Bean("javaMailSender")
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(user);
        sender.setPassword(pass);

        Properties props = sender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "false");

        return sender;
    }
}
