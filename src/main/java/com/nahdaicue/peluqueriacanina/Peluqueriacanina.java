package com.nahdaicue.peluqueriacanina;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.nahdaicue.peluqueriacanina.igu.Principal;
import com.nahdaicue.peluqueriacanina.igu.VerDatos;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Peluqueriacanina {

    public static void main(String[] args) {
        
        //flatlaf(Themes: https://www.formdev.com/flatlaf/themes/)
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        Principal princ = new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);

        //Pruebas :)
        //VerDatos ver = new VerDatos();
        //ver.setVisible(true);
        //ver.setLocationRelativeTo(null);
    }
}
