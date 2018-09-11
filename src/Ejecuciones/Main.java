
package Ejecuciones;

import Modelos.*;
import java.awt.Color;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        Ventana nuestraventana = new Ventana("Juego de naves");
        ArrayList ArregloDeObjetos = new ArrayList();
        Coordenada cor1 = new Coordenada(250,250);
        RectanguloGrafico rectangulo = new RectanguloGrafico(cor1, 80, 80, Color.red);
        ArregloDeObjetos.add(rectangulo);
        
        
        Coordenada cor2= new Coordenada(500,250);//Está a la derecha y a la misma altura que
        //el rectangulo
        
        //nave
        Coordenada cor3= new Coordenada(475,500);   //la punta
        Coordenada cor4= new Coordenada(425,575);   //esquina izquierda
        Coordenada cor5= new Coordenada(525,575);   //esquina derecha
        
        NaveGrafico nave = new NaveGrafico(cor3, cor4, cor5, Color.red);
        ArregloDeObjetos.add(nave);
        
        CirculoGrafico circulo=new CirculoGrafico(cor2,50,Color.BLACK);
        
        ArregloDeObjetos.add(circulo);
        PanelFG nuestroPanel = new PanelFG(ArregloDeObjetos);
        
        
        nuestroPanel.refNave(nave);
        
        
        nuestraventana.add(nuestroPanel);
        nuestraventana.setSize(800,600);
        nuestraventana.setVisible(true);
    }
    
}
