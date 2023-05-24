package models;

public class MdlEstatico
{
    MdlUsuario mdlUsuario = new MdlUsuario();

    public MdlUsuario MdlEstatico(MdlUsuario mdlUsuario) {
        this.mdlUsuario = mdlUsuario;
        return this.mdlUsuario;
    }
}
