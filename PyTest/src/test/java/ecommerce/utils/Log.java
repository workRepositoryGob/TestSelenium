package ecommerce.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Log {
  private static final Logger LOGGER = (Logger) LogManager.getLogger(Log.class);

  public static void info(String message) {
    LOGGER.info(message);
  }

  public static void error(String message) {
    LOGGER.error(message);
  }

  public static void debug(String message) {
    LOGGER.debug(message);
  }

  public static void warn(String message) {
    LOGGER.warn(message);
  }
}
