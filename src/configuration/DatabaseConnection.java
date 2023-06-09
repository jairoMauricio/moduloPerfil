package configuration;

//import models.MdlEstatico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.MdlUsuario;

public class DatabaseConnection implements Configuration {

    private Connection connection = null;
    public MdlUsuario mdlusuario = new MdlUsuario();
//    MdlEstatico UsuarioEstatico = new MdlEstatico();

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println("Successful connection");
            } else {
                System.out.println("Failed connection");
            }
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Connection error: " + exception);
            exception.printStackTrace();
        }
        return connection;
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (Exception exception) {
            System.out.println("Disconnect error:" + exception);
            exception.printStackTrace();
        }
    }

    public boolean execute(String sql) {
        boolean execute;
        try {
            Statement statement;
            statement = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            if (statement.executeUpdate(sql) == 0) {
                execute = false;
            } else {
                execute = true;
            }
        } catch (SQLException exception) {
            System.out.println("Execution error: " + exception);
            execute = false;
        }
        return execute;
    }

    public ResultSet consult(String sql) {
        ResultSet result = null;
        try {
            Statement statement;
            statement = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            result = statement.executeQuery(sql);
            if(result.next()){
                mdlusuario.setId(result.getInt("id"));
                mdlusuario.setNombres(result.getString("nombres"));
                mdlusuario.setApellidos(result.getString("apellidos"));
                mdlusuario.setDireccion(result.getString("direccion"));
                mdlusuario.setCiudad(result.getString("ciudad"));
                mdlusuario.setDepartamento(result.getString("departamento"));
                mdlusuario.setTelefono(result.getString("telefono"));
                mdlusuario.setCorreo(result.getString("correo"));
                mdlusuario.setFecha_creacion(result.getString("fecha_creacion"));
                mdlusuario.setFecha_actualizacion(result.getString("fecha_actualizacion"));
                
            }
        } catch (SQLException exception) {
            System.out.println("Query failed: " + exception);
            exception.printStackTrace();
        }
        return result;
    }
}
