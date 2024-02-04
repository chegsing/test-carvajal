package co.com.carvajal.transversal.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * ApplicationConstants
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationConstants {

  public static final String ERROR_MSG = "An unknown error occured";
  public static final String SUCCESS_MSG = "Request Successfully processed";
  public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";
  public static final String SIMPLE_TIME_FORMAT = "HH:mm:ss";
  public static final String SIMPLE_DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
  public static final String SIMPLE_DATETIME_FORMAT_T = "yyyy-MM-dd'T'HH:mm:ss";
  public static final String ADMIN = "ADMIN";

  
  public static final String TOKEN = "/login/token";
  public static final String UPDATE_PASSWORD = "/login/update-pass";
  public static final String LOGIN = "/login";
  public static final String PROFILE = "/profile";
  public static final String REMEMBER_PASS = "/login/remember-pass";
  
}
