package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;

public final class DataBaseConnectionForFvrt {
 private Connection conn;
 public DataBaseConnectionForFvrt(){
  conn = null;
  try{
   String userName = "root";
   String password = "";
   String url = "jdbc:mysql://localhost/shop";
   Class.forName ("com.mysql.jdbc.Driver").newInstance ();
   conn = DriverManager.getConnection(url, userName, password);
  }
  catch(Exception e){
   System.out.println("Exception found");
  }
 }
 public Connection getConnection(){
  return conn;
 }
 public void closeConnection(){
  try{
   conn.close ();
  }catch (Exception e) {
   System.out.println ("Connection close error");
  }
 }
}