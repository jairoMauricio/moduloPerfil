package database;

import configuration.DatabaseConnection;
import models.MdlUsuario;
import views.PanPerfil;

public class DbConsulta {
    
    DatabaseConnection consulta = new DatabaseConnection();
    
    public void consulta(PanPerfil panPerfil){
        String sql = "SELECT id, nombres, apellidos, direccion, ciudad, departamento, telefono, correo, contrasenia, fecha_creacion, fecha_actualizacion\n"
                + "FROM usuarios";
        consulta.consult(sql);
        panPerfil.txtId.setText(String.valueOf(consulta.mdlusuario.getId()));
        panPerfil.txtNombres.setText(consulta.mdlusuario.getNombres());
        panPerfil.txtApellidos.setText(consulta.mdlusuario.getApellidos());
        panPerfil.txtDireccion.setText(consulta.mdlusuario.getDireccion());
        panPerfil.txtCiudad.setText(consulta.mdlusuario.getCiudad());
        panPerfil.txtDepartamento.setText(consulta.mdlusuario.getDepartamento());
        panPerfil.txtTelefono.setText(consulta.mdlusuario.getTelefono());
        panPerfil.txtCorreo.setText(consulta.mdlusuario.getCorreo());
        panPerfil.txtFechaCreacion.setText(consulta.mdlusuario.getFecha_creacion());
        panPerfil.txtFechaActualizacion.setText(consulta.mdlusuario.getFecha_actualizacion());
    }
}
