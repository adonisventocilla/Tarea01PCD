
package Ejecuciones;

import Modelos.*;
import java.awt.Color;
import java.util.ArrayList;

public class Main {
    public static int Aleatorio(int Max, int Min)
    {
        return (int)(Math.random()*(Max-Min));
    }

    public static void main(String[] args) {
        
        Ventana nuestraventana = new Ventana("Juego de naves");
        ArrayList ArregloDeObjetos = new ArrayList();
        Coordenada cor1 = new Coordenada(250,250);
        //RectanguloGrafico rectangulo = new RectanguloGrafico(cor1, 80, 80, Color.red);
        //ArregloDeObjetos.add(rectangulo);
        
        
        Coordenada cor2= new Coordenada(500,250);//Está a la derecha y a la misma altura que
        //el rectangulo
        
        //nave
        Coordenada cor3= new Coordenada(475,500);   //la punta
        Coordenada cor4= new Coordenada(425,575);   //esquina izquierda
        Coordenada cor5= new Coordenada(525,575);   //esquina derecha
        
        NaveGrafico nave = new NaveGrafico(cor3, cor4, cor5, Color.black);
        //ArregloDeObjetos.add(nave);
        
        //CirculoGrafico circulo=new CirculoGrafico(cor2,50,Color.BLACK);
        
        TextoGrafico vidas = new TextoGrafico("Vidas", Color.BLACK, 1700, 50);
        vidas.setSize(35);
        ArregloDeObjetos.add(vidas);
        
        TextoGrafico score = new TextoGrafico("Puntos", Color.BLACK, 1700, 250);
        score.setSize(35);
        ArregloDeObjetos.add(score);
        
        //Texto de puntaje
        
        TextoGrafico puntaje = new TextoGrafico("0", Color.RED, 1700, 350);
        puntaje.setSize(40);
        ArregloDeObjetos.add(puntaje);
        
        //Texto de vidas
        TextoGrafico nrvidas = new TextoGrafico("3", Color.RED, 1700, 150);
        nrvidas.setSize(40);
        ArregloDeObjetos.add(nrvidas);
        
        
        TextoGrafico textofinal = new TextoGrafico("final asd", Color.RED, 900, 500);
        textofinal.setSize(100);
        
        
        int rango= Aleatorio(800,50);
        Coordenada Salida=new Coordenada(rango,0);
        RectanguloGrafico Asteroide=new RectanguloGrafico(Salida,25,25,Color.RED);
        int rango2= Aleatorio(800,50);
        Coordenada Salida2=new Coordenada(rango2,0);
        RectanguloGrafico Asteroide2=new RectanguloGrafico(Salida2,25,25,Color.RED);
        int rango3= Aleatorio(800,50);
        Coordenada Salida3=new Coordenada(rango3,0);
        RectanguloGrafico Asteroide3=new RectanguloGrafico(Salida3,25,25,Color.RED);
        int rango4= Aleatorio(800,50);
        Coordenada Salida4=new Coordenada(rango4,0);
        RectanguloGrafico Asteroide4=new RectanguloGrafico(Salida4,25,25,Color.RED);
        int rango5= Aleatorio(800,50);
        Coordenada Salida5=new Coordenada(rango5,0);
        RectanguloGrafico Asteroide5=new RectanguloGrafico(Salida5,25,25,Color.RED);
        ArregloDeObjetos.add(Asteroide);
        ArregloDeObjetos.add(Asteroide2);
        ArregloDeObjetos.add(Asteroide3);
        ArregloDeObjetos.add(Asteroide4);
        ArregloDeObjetos.add(Asteroide5);
        
        
        
        ArregloDeObjetos.add(nave);
        PanelFG nuestroPanel = new PanelFG(ArregloDeObjetos);
        
        
        nuestroPanel.refNave(nave);
        nuestroPanel.refAst(Asteroide, Asteroide2, Asteroide3, Asteroide4, Asteroide5);
        nuestroPanel.RefFinal(textofinal);
        nuestroPanel.RefPuntos(puntaje);
        nuestroPanel.Refvida(nrvidas);
        
        nuestraventana.add(nuestroPanel);
        nuestraventana.setSize(1000,600);
        nuestraventana.setVisible(true);
        nuestroPanel.Iniciar();
    }
    
}
