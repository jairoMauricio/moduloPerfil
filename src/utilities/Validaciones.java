package utilities;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
//import org.mindrot.jbcrypt.BCrypt;


public class Validaciones {
    
    public int key;
    
    public boolean validarVacio (String palabra) {

        if (palabra.isEmpty() || palabra == null) {
                return true;
        } else {
                return false;
        }
    }
    
    public boolean validarArroba(String correo){
        String letra;
        boolean bandera = true;
        for(int i = 0; i < correo.length(); i++){
            letra = correo.substring(i,i+1);
            if (letra.equals("@")) {
                bandera = false;
                break;
            }
        }
        return bandera;
    }
    
    public boolean cantidadCaracteres(String palabra){
        if(palabra.length() <= 7){
            return true;
        }
        else{
            return false;
        } 
    }
    
    public boolean confirmacion (String passUno, String passDos){
        if (passUno.equals(passDos)) {
            return true;
        } else {
            return false;
        }
    }
    
        //para validar entrada con teclado
    public void numeroSignos(java.awt.event.KeyEvent e){
        key = (int)e.getKeyChar();
        if(key >= 33 && key < 37 || key >= 38 && key < 40 || key >= 58 && key < 61 || key > 62 /*&& key < 97 || key >= 123 && key < 128*/){
            e.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar números\n", "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }   
        if(key == 43 || key == 45 || key == 42 || key == 120 || key == 88 || key == 47 || key == 37 || key == 61){
            e.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }
    
//    public String cifrarBcrypt (String password) {
//        String pass = BCrypt.hashpw(password, BCrypt.gensalt(10));
//        return pass;
//    }
//    
//    public boolean descifrarBcrypt (String password, String validar) {
//        boolean pass = BCrypt.checkpw(password, validar);
//        return pass;
//    }
}