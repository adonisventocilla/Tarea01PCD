package Modelos;

public class Coordenada {
    
    private float x;
    private float y;
    //todos los constructores son publicos
    public Coordenada()
    {
        this.x=0;
        this.y=0;
    }
    public Coordenada(float x,float y)
    {
        this.x=x;
        this.y=y;
    }
    public Coordenada(Coordenada nva)
    {
        this.x=nva.x;
        this.y=nva.y;
    }
    public float getX()
    {
        return this.x;
    }
    public float getY()
    {
        return this.y;
    }
    public void setX(float x)
    {
        this.x=x;
    }
    public void setY(float y)
    {
        this.y=y;
    }
}
