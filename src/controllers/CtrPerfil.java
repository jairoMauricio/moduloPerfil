package controllers;

import configuration.DatabaseConnection;
import database.DbConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.MdlUsuario;
import utilities.Validaciones;
import views.PanPerfil;

public class CtrPerfil implements ActionListener{
    PanPerfil panPerfil = new PanPerfil();
    MdlUsuario mdlUsuario = new MdlUsuario();
    Validaciones validar = new Validaciones();
    DatabaseConnection consulta = new DatabaseConnection();
    DbConsulta dbConsulta = new DbConsulta();
    
    public CtrPerfil (PanPerfil panPerfil, MdlUsuario modeloUsuario)
    {
        this.panPerfil = panPerfil;
        this.mdlUsuario = modeloUsuario;
        this.panPerfil.tbtEdit.addActionListener(this);
        this.panPerfil.btnGuardar.addActionListener(this);
        dbConsulta.consulta(this.panPerfil);
        deshabilitar();
        this.panPerfil.btnGuardar.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object evt = e.getSource();
        
        if (evt.equals(panPerfil.tbtEdit))
        {
            if(panPerfil.tbtEdit.isSelected())
            {
                habilitar();
                panPerfil.btnGuardar.setEnabled(true);
                panPerfil.tbtEdit.setText("Cancelar");
            }
            else
            {
                panPerfil.btnGuardar.setEnabled(false);
                deshabilitar();
                panPerfil.tbtEdit.setText("Editar");
            }
        }
        else if(evt.equals(panPerfil.btnGuardar))
        {
            MdlUsuario mdlusuario2 = new MdlUsuario();
            mdlusuario2.setNombres(panPerfil.txtNombres.getText());
            mdlusuario2.setApellidos(panPerfil.txtApellidos.getText());
            mdlusuario2.setDireccion(panPerfil.txtDireccion.getText());
            mdlusuario2.setCiudad(panPerfil.txtCiudad.getText());
            mdlusuario2.setDepartamento(panPerfil.txtDepartamento.getText());
            mdlusuario2.setTelefono(panPerfil.txtTelefono.getText());
            mdlusuario2.setCorreo(panPerfil.txtCorreo.getText());
            
            if(validar.validarVacio(panPerfil.txtNombres.getText()) == true)
            {
                panPerfil.lblError.setText("Error! Debes colocar tu/s nombre/s.");
            }
            else if(validar.validarVacio(panPerfil.txtApellidos.getText()) == true)
            {
                panPerfil.lblError.setText("Error! Debes colocar tu/s apellido/s.");
            }
            else if(validar.validarVacio(panPerfil.txtDireccion.getText()) == true)
            {
                panPerfil.lblError.setText("Error! Debes colocar la dirección de residencia.");
            }
            else if(validar.validarVacio(panPerfil.txtCiudad.getText()))
            {
                panPerfil.lblError.setText("Error! Debes colocar la ciudad.");
            }
            else if(validar.validarVacio(panPerfil.txtDepartamento.getText()))
            {
                panPerfil.lblError.setText("Error! Debes colocar un departamento.");
            }
            else if (validar.validarVacio(panPerfil.txtTelefono.getText()))
            {
                panPerfil.lblError.setText("Error! Debes colocar tu telefono.");
            }
            else if (validar.validarVacio(panPerfil.txtCorreo.getText()))
            {
                panPerfil.lblError.setText("Error! Debes colocar tu correo.");
            }
            else if (validar.validarArroba(panPerfil.txtCorreo.getText()))
            {
                panPerfil.lblError.setText("Error! Tu correo debe contener un arroba(@).");
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
                    panPerfil.lblError.setText("Se ha registrado correctamente!");
                    deshabilitar();
                    panPerfil.btnGuardar.setEnabled(false);
                    if(panPerfil.tbtEdit.isSelected() == true)
                    {
                        panPerfil.btnGuardar.setEnabled(false);
                        deshabilitar();
                        panPerfil.tbtEdit.setText("Editar");
                        panPerfil.tbtEdit.setSelected(false);
                    }
                } 
                else 
                {
                    panPerfil.lblError.setText("Ha habido un error!");
                    deshabilitar();
                    panPerfil.btnGuardar.setEnabled(false);
                }
            }
        }
    }
    
    public void deshabilitar(){
        panPerfil.txtId.setEnabled(false);
        panPerfil.txtNombres.setEnabled(false);
        panPerfil.txtApellidos.setEnabled(false);
        panPerfil.txtDireccion.setEnabled(false);
        panPerfil.txtCiudad.setEnabled(false);
        panPerfil.txtDepartamento.setEnabled(false);
        panPerfil.txtTelefono.setEnabled(false);
        panPerfil.txtCorreo.setEnabled(false);
        panPerfil.txtFechaCreacion.setEnabled(false);
        panPerfil.txtFechaActualizacion.setEnabled(false);
    }
        
    public void habilitar(){
        panPerfil.txtId.setEnabled(false);
        panPerfil.txtNombres.setEnabled(true);
        panPerfil.txtApellidos.setEnabled(true);
        panPerfil.txtDireccion.setEnabled(true);
        panPerfil.txtCiudad.setEnabled(true);
        panPerfil.txtDepartamento.setEnabled(true);
        panPerfil.txtTelefono.setEnabled(true);
        panPerfil.txtCorreo.setEnabled(true);
        panPerfil.txtFechaCreacion.setEnabled(false);
        panPerfil.txtFechaActualizacion.setEnabled(false);
    }
}
