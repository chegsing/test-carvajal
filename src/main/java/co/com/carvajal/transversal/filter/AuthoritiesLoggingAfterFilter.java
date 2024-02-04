package co.com.carvajal.transversal.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import lombok.extern.log4j.Log4j2;

/**
 * AuthoritiesLoggingAfterFilter
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@Log4j2
public class AuthoritiesLoggingAfterFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (null != authentication) {
      log.info("User: {}", authentication.getName());
      log.info(" is successfully authenticated and has the authorities: {} ",authentication.getAuthorities().toString());
    }
    chain.doFilter(request, response);
  }
}
