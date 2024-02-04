package co.com.carvajal.main;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import co.com.carvajal.transversal.constants.ApplicationConstants;
import co.com.carvajal.transversal.filter.AuthoritiesLoggingAfterFilter;
import co.com.carvajal.transversal.filter.AuthoritiesLoggingAtFilter;
import co.com.carvajal.transversal.filter.RequestValidationBeforeFilter;
import co.com.carvajal.transversal.security.JWTAuthorizationComponentFilter;

/**
 * WebSecurityConfig
 * 
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 * 
 */
@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    
	  http.csrf().disable()
      .addFilterAfter(new JWTAuthorizationComponentFilter(),
                      UsernamePasswordAuthenticationFilter.class)
      .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
      .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
      //.addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
      .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
      .authorizeRequests()
      .antMatchers(HttpMethod.GET, ApplicationConstants.TOKEN).permitAll()
      .antMatchers(HttpMethod.PUT, ApplicationConstants.UPDATE_PASSWORD).permitAll()
      .antMatchers(HttpMethod.POST, ApplicationConstants.LOGIN).permitAll()
      .antMatchers(HttpMethod.POST, ApplicationConstants.PROFILE).permitAll()
      .antMatchers(HttpMethod.POST, ApplicationConstants.REMEMBER_PASS).permitAll()
      .anyRequest()
      .authenticated();
  }
}
