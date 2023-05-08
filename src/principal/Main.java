package principal;

import controlador.CtrLogin;
import modelo.MdlUsuario;
import vista.frm_main;

public class Main {

    public static void main(String[] args) {
        MdlUsuario mdllogin = new MdlUsuario();
        frm_main vista = new frm_main();
        CtrLogin controlador = new CtrLogin(vista, mdllogin);
    }
}
