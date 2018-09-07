
package Modelos;


public class Rectangulo extends Coordenada {
    
    private float lado1;
    private float lado2;
    
    public Rectangulo(){
        
        super();
        this.lado1 = 0;
        this.lado2 = 0;
        
    }
    
    public Rectangulo(Coordenada cor, float x, float y){
        
        super(cor);
        this.lado1 = x;
        this.lado2 = y;
    }
    
    public Rectangulo(Rectangulo nvo){
        
        super(nvo.getX(), nvo.getY());
        this.lado1 = nvo.lado1;
        this.lado2 = nvo.lado2;
    }
    
}
