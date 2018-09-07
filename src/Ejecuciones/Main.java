
package Ejecuciones;

import Modelos.*;
import java.awt.Color;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        Ventana nuestraventana = new Ventana("Juego de naves");
        ArrayList ArregloDeObjetos = new ArrayList();
        
        
        Coordenada cor2= new Coordenada(350,350);
        
        CirculoGrafico circulo=new CirculoGrafico(cor2,50,Color.BLACK);
        
        ArregloDeObjetos.add(circulo);
        PanelFG nuestroPanel = new PanelFG(ArregloDeObjetos);
        
        nuestraventana.add(nuestroPanel);
        nuestraventana.setSize(500,400);
        nuestraventana.setVisible(true);
    }
    
}
