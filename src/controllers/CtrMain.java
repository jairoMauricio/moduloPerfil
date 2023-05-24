package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.MdlUsuario;
import configuration.DatabaseConnection;
import database.DbConsulta;
import javax.swing.JPanel;
import views.PanPerfil;
import views.frmMain;

public class CtrMain implements ActionListener
{
    frmMain login;
    DatabaseConnection consulta = new DatabaseConnection();
    DbConsulta dbConsulta = new DbConsulta();

    public CtrMain(frmMain login, MdlUsuario mdllogin) 
    {
        this.login = login;
        this.consulta.mdlusuario = mdllogin;
        this.login.btnPerfil.addActionListener(this);
        iniciar();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object evt = e.getSource();
        
        if (evt.equals(login.btnPerfil))
        {
            PanPerfil panPerfil = new PanPerfil();
            MdlUsuario modeloUsuairo = new MdlUsuario();
            new CtrPerfil(panPerfil, modeloUsuairo);
            panel(panPerfil);
        }
    }
    
    public void iniciar(){
        login.setTitle(null);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
    public void panel (JPanel nuevoPanel){
        login.panMenu.removeAll();
        login.panMenu.add(nuevoPanel);
        login.panMenu.repaint();
        login.panMenu.revalidate();
    }
}