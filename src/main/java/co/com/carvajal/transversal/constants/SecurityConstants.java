package co.com.carvajal.transversal.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * SecurityConstants
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityConstants {

  public static final String JWT_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
  public static final String JWT_HEADER = "Authorization";
  public static final String USERNAME = "username";
  public static final String AUTHORITIES = "authorities";
  public static final String ACCESS_KEY_ROL = "accessKeyRole";
  public static final String ID_COMPANY = "idCompany";
  public static final String JWT_TOKEN = "JWT Token";
  public static final Integer EXPIRATION = 30000000;
  public static final String PERMISSIONS = "permissions";
}
