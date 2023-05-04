package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

class Conexion {
	
    private Connection con = null;

    Conexion(){

        String db = "moduloPerfil";
        String url = "jdbc:mysql://localhost:3307/" + db;
        String user = "root";
        String pass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
                    //here sonoo is database name, root is username and password  
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from libros");
//			while (rs.next())
//				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//			con.close();
        } catch (Exception e) {
                System.out.println(e);
        }
    }
	public Connection getConnection() {
        return con;
    }
    
    public void cerrar() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error en cerrar : "+e);
        }
         
    } 
    
    public ResultSet consultar(String sql) {

        ResultSet resultado=null;
        try {
            Statement sentencia;
            sentencia = con.createStatement();
            resultado = sentencia.executeQuery(sql);
           
        } catch (SQLException error) {
            error.printStackTrace();
            System.out.println("Error en la consulta : "+error);
        }
        return resultado;
    }

    public boolean ejecutar(String sql) {
        boolean var;
        try {
            Statement sentencia;
            sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            if(sentencia.executeUpdate(sql)==0)
                var=false;
            else            
                var = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en ejecución : "+e);
            var = false;
        }
        return var;        
    }
}
