
package Modelos;
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
    }
    public void refNave(NaveGrafico n)
    {
        
        this.nave=n;
    }
    
    public void Iniciar()
    {
        while (true)
        {
            repaint();
        }
    }
}
