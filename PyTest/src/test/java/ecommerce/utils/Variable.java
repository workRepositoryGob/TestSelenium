package ecommerce.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Variable {

  public static final String URL = "https://juice-shop.herokuapp.com/";
  public static final int TIME_OUT = 150;
  public static final String EMAIL = "abram.paucek@hotmail.com";
  public static final String PASS="h2psegqzn4nof";
  public static final String NOMBRE_TARGETA = "Jake Heaney I";
  public static final String EXPECTED_DELIVERY= "3 Days";
  public static final String NOMBRE_DIRECCION = "Jamaica";

  public static String fechaCreacion() {
    // Obtener la fecha y hora actual
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    String timestamp = dateTime.format(formatter);
    return timestamp;
  }

}
