
package Modelos;
import static Ejecuciones.Main.Aleatorio;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
public class PanelFG extends JPanel implements KeyListener{
    ArrayList v;
    NaveGrafico nave;
    Coordenada movimientoIzq=new Coordenada(-25,0);
    Coordenada movimientoDer=new Coordenada(25,0);
    Coordenada movimientoNulo=new Coordenada(0,0);
    
    RectanguloGrafico Asteroide;
    RectanguloGrafico Asteroide2;
    RectanguloGrafico Asteroide3;
    RectanguloGrafico Asteroide4;
    RectanguloGrafico Asteroide5;
    public PanelFG(ArrayList VectordeO)
    {
        this.v=VectordeO;
        this.addKeyListener(this);
        setFocusable(true);
    }
    public void paint(Graphics g)
    {
        Dimension d= getSize();
        Image Imagen=createImage(d.width,d.height);
        Graphics buff=Imagen.getGraphics();
        
        Dibujable dib;
        for(int i=0;i<v.size();i++)
        {
            dib=(Dibujable)v.get(i);
            dib.dibujar(buff);
        }
        g.drawImage(Imagen, 0, 0, null);
    }

    @Override
    public void update(Graphics g)
    {
        paint(g);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla=e.getKeyCode();
        if(tecla==KeyEvent.VK_LEFT)
        {
            this.nave.mover(movimientoIzq);  
        }
        if(tecla==KeyEvent.VK_RIGHT)
        {
            this.nave.mover(movimientoDer);
        }
        if(tecla==KeyEvent.VK_Q)
        {
            CirculoGrafico bala =nave.Bala();
            nave.balas.add(bala);
            v.add(bala);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int tecla=e.getKeyCode();
        if(tecla==KeyEvent.VK_LEFT)
        {
            
            this.nave.mover(movimientoNulo);
            
           
        }
        if(tecla==KeyEvent.VK_RIGHT)
        {
            this.nave.mover(movimientoNulo);
        }
        if(tecla==KeyEvent.VK_Q)
        {
        }
    }
    public void refNave(NaveGrafico n)
    {
        
        this.nave=n;
    }
    public void refAst(RectanguloGrafico a,RectanguloGrafico b,
            RectanguloGrafico c,RectanguloGrafico d,RectanguloGrafico e)
    {
        Asteroide=a;
        Asteroide2=b;
        Asteroide3=c;
        Asteroide4=d;
        Asteroide5=e;
    }
    
    public void Iniciar()
    {
        while (true)
        {
            try{
                if(!nave.balas.isEmpty())
                {
                    nave.Ciclo();
                }
                Asteroide.Ciclo();
                Asteroide2.Ciclo();
                Asteroide3.Ciclo();
                Asteroide4.Ciclo();
                Asteroide5.Ciclo();
                if(Asteroide.getY()>525)
                {
                    int rango=Aleatorio(800,50);
                    Asteroide.setY(0);
                    Asteroide.setX(rango);
                }
                if(Asteroide2.getY()>525)
                {
                    int rango=Aleatorio(800,50);
                    Asteroide2.setY(0);
                    Asteroide2.setX(rango);
                }
                if(Asteroide3.getY()>525)
                {
                    int rango=Aleatorio(800,50);
                    Asteroide3.setY(0);
                    Asteroide3.setX(rango);
                }
                if(Asteroide4.getY()>525)
                {
                    int rango=Aleatorio(800,50);
                    Asteroide4.setY(0);
                    Asteroide4.setX(rango);
                }
                if(Asteroide5.getY()>525)
                {
                    int rango=Aleatorio(800,50);
                    Asteroide5.setY(0);
                    Asteroide5.setX(rango);
                }
                Thread.sleep(50);
            }catch(InterruptedException err)
            {
                System.out.println(err);
            }
            repaint();
        }
    }
}
