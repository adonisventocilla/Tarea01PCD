
package Modelos;
import static Ejecuciones.Main.Aleatorio;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
public class PanelFG extends JPanel implements KeyListener{
    ArrayList v;
    ArrayList ast= new ArrayList();
    NaveGrafico nave;
    Coordenada movimientoIzq=new Coordenada(-25,0);
    Coordenada movimientoDer=new Coordenada(25,0);
    Coordenada movimientoNulo=new Coordenada(0,0);
    
    int ContadorAsteroides=5;
    
    
    
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
        ast.add(a);
        ast.add(b);
        ast.add(c);
        ast.add(d);
        ast.add(e);
    }
    public void Colision()
    {
        int i,j;
        for(i=0;i<nave.balas.size();i++)
        {
            CirculoGrafico bala=(CirculoGrafico)nave.balas.get(i);
            for(j=0;j<ast.size();j++)
            {
                RectanguloGrafico aste=(RectanguloGrafico)ast.get(j);
                
                Coordenada Corbala=new Coordenada(bala.getX(),bala.getY());
                
                Coordenada Derecha =new Coordenada(aste.getX()+30,aste.getY());
                Coordenada Izquierda=new Coordenada(aste.getX()-15,aste.getY());
                Coordenada Medio=new Coordenada(aste.getX(),aste.getY());
                
                if(Corbala.getX()>Izquierda.getX()&&Corbala.getX()<Derecha.getX()
                        && Corbala.getY()<Medio.getY())
                {
                    aste.pintar(Color.WHITE);
                    bala.pintar(Color.WHITE);
                    bala.setY(-100);
                    aste.setY(-100);
                    nave.balas.remove(bala);
                    ast.remove(aste);
                    ContadorAsteroides--;
                    
                }
                
            }   
            
            
        }
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
                int i;
                for(i=0;i<ast.size();i++)
                {
                   RectanguloGrafico rect=(RectanguloGrafico) ast.get(i);
                   rect.Ciclo();
                   if(rect.getY()>525)
                {
                    int rango=Aleatorio(800,50);
                    rect.setY(0);
                    rect.setX(rango);
                }
                }
                if(ContadorAsteroides<5)
                {
                    int rango = Aleatorio(800,50);
                    Coordenada Inicio=new Coordenada(rango,0);
                    RectanguloGrafico nuevo= new RectanguloGrafico(Inicio,25,25,Color.RED);
                    ast.add(nuevo);
                    v.add(nuevo);
                    nuevo.Ciclo();
                    ContadorAsteroides++;
                    
                            
                }
                Colision();
                Thread.sleep(50);
            }catch(InterruptedException err)
            {
                System.out.println(err);
            }
            repaint();
        }
    }
}
