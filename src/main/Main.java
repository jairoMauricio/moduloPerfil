package main;

import controllers.CtrMain;
import models.MdlUsuario;
import views.frmMain;

public class Main {

    public static void main(String[] args) {
        MdlUsuario mdllogin = new MdlUsuario();
        frmMain vista = new frmMain();
        CtrMain controlador = new CtrMain(vista, mdllogin);
    }
}
