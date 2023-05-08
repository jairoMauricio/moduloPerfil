package conexion;

public interface Configuration {

    String DRIVER = "com.mysql.cj.jdbc.Driver";
    String DATABASE_NAME = "moduloPerfil";
    String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    String USERNAME = "root";
    String PASSWORD = "";

}
