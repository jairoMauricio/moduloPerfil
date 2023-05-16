package main;

import controllers.CtrLogin;
import models.MdlUsuario;
import views.frm_main;

public class Main {

    public static void main(String[] args) {
        MdlUsuario mdllogin = new MdlUsuario();
        frm_main vista = new frm_main();
        CtrLogin controlador = new CtrLogin(vista, mdllogin);
    }
}
