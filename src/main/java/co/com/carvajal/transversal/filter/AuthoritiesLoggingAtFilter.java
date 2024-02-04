package co.com.carvajal.transversal.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * AuthoritiesLoggingAtFilter
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
public class AuthoritiesLoggingAtFilter implements Filter {

  private final Logger logValidacionAutentificacion =
      Logger.getLogger(AuthoritiesLoggingAtFilter.class.getName());

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    logValidacionAutentificacion.info("Authentication Validation is in progress");
    chain.doFilter(request, response);
  }
}
