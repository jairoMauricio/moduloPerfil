package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import helpers.Validaciones;
import modelo.MdlUsuario;
import vista.frm_main;
import conexion.DatabaseConnection;
//import javax.swing.JPanel;

public class CtrLogin implements ActionListener
{
    frm_main login;
    Validaciones validar = new Validaciones();
    DatabaseConnection consulta = new DatabaseConnection();

    public CtrLogin(frm_main login, MdlUsuario mdllogin) 
    {
        this.login = login;
        this.consulta.mdlusuario = mdllogin;
        this.login.btnPerfil.addActionListener(this);
        this.login.btnEditar.addActionListener(this);
        this.login.btnGuardar.addActionListener(this);
//            listener();
        iniciar();
        consulta();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object evt = e.getSource();
        
        if (evt.equals(login.btnPerfil))
        {
            consulta();
        }
        else if (evt.equals(login.btnEditar))
        {
            habilitar();
            login.btnGuardar.setEnabled(true);
        } 
        else if(evt.equals(login.btnGuardar))
        {
            MdlUsuario mdlusuario2 = new MdlUsuario();
            mdlusuario2.setNombres(login.txtNombres.getText());
            mdlusuario2.setApellidos(login.txtApellidos.getText());
            mdlusuario2.setDireccion(login.txtDireccion.getText());
            mdlusuario2.setCiudad(login.txtCiudad.getText());
            mdlusuario2.setDepartamento(login.txtDepartamento.getText());
            mdlusuario2.setTelefono(login.txtTelefono.getText());
            mdlusuario2.setCorreo(login.txtCorreo.getText());
            
            if(validar.validarVacio(login.txtNombres.getText()) == true)
            {
                login.lblError.setText("Error! Debes colocar tu/s nombre/s.");
            }
            else if(validar.validarVacio(login.txtApellidos.getText()) == true)
            {
                login.lblError.setText("Error! Debes colocar tu/s apellido/s.");
            }
            else if(validar.validarVacio(login.txtDireccion.getText()) == true)
            {
                login.lblError.setText("Error! Debes colocar la dirección de residencia.");
            }
            else if(validar.validarVacio(login.txtCiudad.getText()))
            {
                login.lblError.setText("Error! Debes colocar la ciudad.");
            }
            else if(validar.validarVacio(login.txtDepartamento.getText()))
            {
                login.lblError.setText("Error! Debes colocar un departamento.");
            }
            else if (validar.validarVacio(login.txtTelefono.getText()))
            {
                login.lblError.setText("Error! Debes colocar tu telefono.");
            }
            else if (validar.validarVacio(login.txtCorreo.getText()))
            {
                login.lblError.setText("Error! Debes colocar tu correo.");
            }
            else if (validar.validarArroba(login.txtCorreo.getText()))
            {
                login.lblError.setText("Error! Tu correo debe contener un arroba(@).");
            }
            else{
                String sql = "UPDATE usuarios\n"
                    + "SET nombres ='" + mdlusuario2.getNombres() + "',\n"
                    + "apellidos = '" + mdlusuario2.getApellidos() + "',\n"
                    + "direccion = '" + mdlusuario2.getDireccion() + "',\n"
                    + "ciudad = '" + mdlusuario2.getCiudad() + "',\n"
                    + "departamento = '" + mdlusuario2.getDepartamento()+ "',\n"
                    + "telefono = '" + mdlusuario2.getTelefono()+ "',\n"
                    + "correo = '" + mdlusuario2.getCorreo()+ "'\n"
                    + "WHERE id = 1";
                if (consulta.execute(sql) == true)
                {
                    login.lblError.setText("Se ha registrado correctamente!");
                    deshabilitar();
                    login.btnGuardar.setEnabled(false);
                } 
                else 
                {
                    login.lblError.setText("Ha habido un error!");
                }
            }
        }
    }
    
    public void consulta(){
        login.btnGuardar.setEnabled(false);
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
        deshabilitar();
    }
    
    public void deshabilitar(){
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
        
    public void habilitar(){
        login.txtId.setEnabled(false);
        login.txtNombres.setEnabled(true);
        login.txtApellidos.setEnabled(true);
        login.txtDireccion.setEnabled(true);
        login.txtCiudad.setEnabled(true);
        login.txtDepartamento.setEnabled(true);
        login.txtTelefono.setEnabled(true);
        login.txtCorreo.setEnabled(true);
        login.txtFechaCreacion.setEnabled(false);
        login.txtFechaActualizacion.setEnabled(false);
    }
    
    public void iniciar(){
        login.setTitle(null);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
//    public void panel (JPanel nuevoPanel){
//        login.panMenu.removeAll();
//        login.panMenu.add(nuevoPanel);
//        login.panMenu.repaint();
//        login.panMenu.revalidate();
//    }
}