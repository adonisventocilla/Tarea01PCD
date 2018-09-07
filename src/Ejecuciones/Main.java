
package Ejecuciones;

import Modelos.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        Ventana nuestraventana = new Ventana("Juego de naves");
        ArrayList ArregloDeObjetos = new ArrayList();
        
        PanelFG nuestroPanel = new PanelFG(ArregloDeObjetos);
        
        nuestraventana.add(nuestroPanel);
        nuestraventana.setSize(500,400);
        nuestraventana.setVisible(true);
    }
    
}
