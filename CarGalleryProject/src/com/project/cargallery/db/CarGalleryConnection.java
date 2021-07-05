package com.project.cargallery.db;

//Step 1: Use interfaces from java.sql package 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CarGalleryConnection {
  private static CarGalleryConnection instance = new CarGalleryConnection();
  public static final String URL = "jdbc:sqlite:/Users/fatihselimyakar/Desktop/cargallery_filled_3.db";
  public static final String DRIVER_CLASS = "org.sqlite.JDBC"; 
   
  private CarGalleryConnection() {
      try {
          Class.forName(DRIVER_CLASS);
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
          System.out.println(e);
      }
  }
   
  private Connection createConnection() {

      Connection connection = null;
      try {
          //Step 3: Establish Java MySQL connection
          connection = DriverManager.getConnection(URL);
      } catch (SQLException e) {
          System.out.println("ERROR: Unable to Connect to Database.");
          System.out.println(e);
      }
      return connection;
  }   
   
  public static Connection getConnection() {
      return instance.createConnection();
  }
}
