package utilities;

import models.MdlUsuario;

public class Session {
    
    public static MdlUsuario sessionUsuario;

    public Session(MdlUsuario sessionUsuario) {
        Session.sessionUsuario = sessionUsuario;
    }
}
