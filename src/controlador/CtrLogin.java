//package controlador;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import helpers.Validaciones;
//import modelo.MdlUsuario;
//
//public class CtrLogin {
//
//    VstLogin login;
//    MdlUsuario mdllogin;
//    Validaciones validar = new Validaciones();
//    Consultas consulta = new Consultas();
//
//    public CtrLogin(VstLogin login, MdlUsuario mdllogin) {
//            this.login = login;
//            this.mdllogin = mdllogin;
//            
//            listener();
//            iniciar();
//    }
//
//    private void listener() {
//        login.btnEnviar.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                String nombre = login.txtNombre.getText();
//                String correo = login.txtCorreo.getText();
//                char[] contrasenia = login.pwdContrasenia.getPassword();
//                char[]  confirmacion = login.pwdConfirmacion.getPassword();
//
//                if(validar.validarVacio(nombre) == true) {
//                    login.lblError.setText("Error! Debes colocar un nombre.");
//                } 
//                else if(validar.validarVacio(correo) == true){
//                    login.lblError.setText("Error! Necesitas un correo.");
//                }
//                else if(validar.validarArroba(correo) == true){
//                    login.lblError.setText("Error! El correo debe contener un arroba(@).");
//                }
//                else if(validar.validarVacio(String.valueOf(contrasenia))){
//                    login.lblError.setText("Error! Se requiere una contraseña.");
//                } 
//                else if(validar.cantidadCaracteres(String.valueOf(contrasenia))){
//                    login.lblError.setText("Error! Tu contraseña debe ser de mínimo 8 carácteres.");
//                }
//                else if(validar.confirmacion(String.valueOf(contrasenia), String.valueOf(confirmacion)) == false){
//                    login.lblError.setText("Error! La contraseña y la confirmación no son las mismas.");
//                }
//                else {
//                    mdllogin.setNombre(nombre);
//                    mdllogin.setCorreo(correo);
//                    mdllogin.setContrasenia(contrasenia);
//                    boolean logueado = consulta.ingreso(mdllogin);
//                    if (logueado) {
//                        new CtrMenu();
//                        login.dispose();
//                    } else {
//                        login.lblError.setVisible(true);
//                        login.lblError.setText("Datos Incorrectos");
//                    }
//                }
//            }
//        });
//    }
//    
//    public void iniciar(){
//        login.setTitle(null);
//        login.setLocationRelativeTo(null);
//        login.setVisible(true);
//    }
//}