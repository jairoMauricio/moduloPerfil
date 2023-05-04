//package conexion;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import modelo.MdlUsuario;
//import helpers.Session;
//import helpers.Validaciones;
//
//public class Consultas {
//	
//    public boolean ingreso(MdlUsuario usuario) {
//        
//        Validaciones validar = new Validaciones();
//        String pass = String.valueOf(usuario.getContrasenia());
//        Conexion conectar = new Conexion();
//        String sql = "SELECT * FROM usuarios "
//                + " WHERE Correo = '" + usuario.getCorreo() + "'";
//        ResultSet rs;
//        boolean numero = false;
//        try {
//            rs = conectar.consultar(sql);
//            if(rs.next()){
//                if (validar.descifrarBcrypt(pass, rs.getString("contrasenia"))) {
//                    numero = true;
//                    usuario.setId(rs.getInt("Id_usuario"));
//                    usuario.setNombre(rs.getString("Nombre"));
//                    usuario.setCorreo(rs.getString("Correo"));
//                    new Session(usuario);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error en comparar clave(controlador user): " + e);
//        }
//        conectar.cerrar();
//        return numero;
//    }
//
//    public boolean insertarUsuario(MdlUsuario usuario) {
//        Validaciones validar = new Validaciones();
//        String pass = validar.cifrarBcrypt(String.valueOf(usuario.getContrasenia()));
//        System.out.println("Pass:" + pass);
//        Conexion conectar = new Conexion();
//        String sql = "INSERT INTO usuarios(Nombre, Correo, Contrasenia, Roles_Id_Roles) VALUES ("
//            + "'" +usuario.getNombre() + "',"
//            + "'" + usuario.getCorreo() + "',"
//            + "'" + pass + "',"
//            + "'" + usuario.getRol() + "');";
//        
//        boolean numero = false;
//        try {
//            if(conectar.ejecutar(sql)){
//                numero = true;
//            }
//        } catch (Exception e) {
//            System.out.println("Error al insertar(controlador user): " + e);
//        }
//        conectar.cerrar();
//        return numero;
//    }
//
//    public ArrayList<MdlUsuario> consultarUsuarios(){
//        ArrayList<MdlUsuario> listaUsuarios = new ArrayList();
//        Conexion conectar = new Conexion();
//        String sql = "SELECT usuarios.Id_usuario, usuarios.Nombre, usuarios.Correo, roles.nombre_Rol AS Rol\n"
//                + "FROM usuarios\n"
//                + "INNER JOIN roles\n"
//                + "ON usuarios.Roles_id_Roles = roles.id_Roles;";
//        ResultSet rs;
//        rs = conectar.consultar(sql);
//        try {
//            while (rs.next()) {
//                MdlUsuario usuario = new MdlUsuario();
//                usuario.setId(rs.getInt("Id_usuario"));
//                usuario.setNombre(rs.getString("Nombre"));
//                usuario.setCorreo(rs.getString("Correo"));
//                usuario.setRol(rs.getString("Rol"));
//                listaUsuarios.add(usuario);
//            }
//        } catch (SQLException e) {
//                e.printStackTrace();
//        }
//        conectar.cerrar();
//        return listaUsuarios;
//    }
//}
