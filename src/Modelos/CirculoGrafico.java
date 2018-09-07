package Modelos;

import java.awt.Color;
import java.awt.Graphics;

public class CirculoGrafico extends Circulo implements Dibujable {
    Color color;
    public CirculoGrafico(Coordenada cor, float radio, Color uncolor)
    {
        super(cor,radio);
        this.color=uncolor;
    }
    @Override
    public void dibujar(Graphics dw) 
    {
        dw.setColor(color);
        dw.fillOval((int)(this.getX()-this.getRadio()), (int)(this.getY()-this.getRadio()), (int)(2*this.getRadio()),(int)(2*this.getRadio()) );
    }
}
