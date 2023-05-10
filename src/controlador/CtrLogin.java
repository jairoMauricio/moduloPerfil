package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import helpers.Validaciones;
import modelo.MdlUsuario;
import vista.frm_main;
import conexion.DatabaseConnection;

public class CtrLogin implements ActionListener{

    frm_main login;
    Validaciones validar = new Validaciones();
    DatabaseConnection consulta = new DatabaseConnection();

    public CtrLogin(frm_main login, MdlUsuario mdllogin) {
            this.login = login;
            this.consulta.mdlusuario = mdllogin;
            this.login.btnPerfil.addActionListener(this);
//            listener();
            iniciar();
            consulta();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        
        if (evt.equals(login.btnPerfil)) {
            consulta();
        }
    }
    
    public void consulta(){
        String sql = "SELECT id, nombres, apellidos, direccion, ciudad, departamento, telefono, correo, contrasenia, fecha_creacion, fecha_actualizacion\n"
                + "FROM usuarios";
        consulta.consult(sql);
        login.txtId.setText(String.valueOf(consulta.mdlusuario.getId()));
        login.txtNombres.setText(consulta.mdlusuario.getNombres());
        login.txtApellidos.setText(consulta.mdlusuario.getApellidos());
        login.txtDireccion.setText(consulta.mdlusuario.getDireccion());
        login.txtCiudad.setText(consulta.mdlusuario.getCiudad());
        login.txtDepartamento.setText(consulta.mdlusuario.getDepartamento());
        login.txtTelefono.setText(consulta.mdlusuario.getTelefono());
        login.txtCorreo.setText(consulta.mdlusuario.getCorreo());
        login.txtFechaCreacion.setText(consulta.mdlusuario.getFecha_creacion());
        login.txtFechaActualizacion.setText(consulta.mdlusuario.getFecha_actualizacion());
        habilitar();
    }
    
    public void habilitar(){
        login.txtId.setEnabled(false);
        login.txtNombres.setEnabled(false);
        login.txtApellidos.setEnabled(false);
        login.txtDireccion.setEnabled(false);
        login.txtCiudad.setEnabled(false);
        login.txtDepartamento.setEnabled(false);
        login.txtTelefono.setEnabled(false);
        login.txtCorreo.setEnabled(false);
        login.txtFechaCreacion.setEnabled(false);
        login.txtFechaActualizacion.setEnabled(false);
    }
    
    public void iniciar(){
        login.setTitle(null);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}