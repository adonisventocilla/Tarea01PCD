/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author AUTONOMA
 */
public class Circulo extends Coordenada {
    private float radio;
    public Circulo()
    {
        super();
        this.radio=0;
    }
    public Circulo(Coordenada nvo, float r)
    {
        super(nvo);
        this.radio=r;
    }
    public Circulo(Circulo cir)
    {
        super(cir);
        this.radio=cir.radio;
        
    }
    public float getRadio()
    {
        return this.radio;
    }
    public void setRadio(float r)
    {
        this.radio=r;
    }
    public Coordenada getCentro()
    {
        Coordenada nva=new Coordenada(this.getX(),this.getY());
        return nva;
    }
}
