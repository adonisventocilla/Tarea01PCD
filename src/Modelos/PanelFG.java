
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
    
    Boolean FinDeJuego = true;
    
    int ContadorAsteroides=5;
    int Score;
    int Vidas = 3;
    
    int Mov = 5;
    int MAXAST = 5;
    
    TextoGrafico puntos;
    TextoGrafico vidas;
    TextoGrafico Final;
    
    
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
    
    public void RefPuntos(TextoGrafico a){
        this.puntos = a;
    }
    
    public void Refvida(TextoGrafico b){
        this.vidas = b;
    }
    
    public void RefFinal(TextoGrafico c){
        this.Final = c;
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
                        && Corbala.getY()<Medio.getY() && Corbala.getY()+25 > Medio.getY())
                {
                    aste.pintar(Color.WHITE);
                    bala.pintar(Color.WHITE);
                    bala.setY(-100);
                    aste.setY(-100);
                    nave.balas.remove(bala);
                    ast.remove(aste);
                    ContadorAsteroides--;
                    Score+=5;
                    puntos.SetColor(Color.WHITE);
                    String NuevoScore = ""+Score;
                    TextoGrafico NrPuntos = new TextoGrafico(NuevoScore, Color.RED, 1700, 350);
                    NrPuntos.setSize(40);
                    puntos =NrPuntos;
                    v.add(puntos);
                    
                    
                }
                
                if ((Medio.getY() > 475 && Medio.getY() < 550) && (nave.cor1.getX() < Medio.getX()) && nave.cor2.getX() > Medio.getX()) {
                    Score = Score-5;
                    Vidas--;
                    String NuevoScore = ""+Score;
                    String NuevasVidas = ""+Vidas;
                    vidas.SetColor(Color.WHITE);
                    puntos.SetColor(Color.WHITE);
                    TextoGrafico Nrvidas = new TextoGrafico(NuevasVidas, Color.RED, 1700, 150);
                    Nrvidas.setSize(40);
                    vidas = Nrvidas;
                    
                    TextoGrafico NrPuntos = new TextoGrafico(NuevoScore, Color.RED, 1700, 350);
                    NrPuntos.setSize(40);
                    puntos = NrPuntos;
                    
                    v.add(vidas);
                    v.add(puntos);
                    
                    ast.remove(aste);
                    aste.setY(2000);
                    ContadorAsteroides--;
                }
                
            }   
            
            
        }
    }
    
    public void Iniciar()
    {
        while (FinDeJuego)
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
                   rect.Ciclo(Mov);
                   if(rect.getY()>525)
                {
                    int rango=Aleatorio(800,50);
                    rect.setY(0);
                    rect.setX(rango);
                }
                }
                if(ContadorAsteroides< MAXAST)
                {
                    int rango = Aleatorio(800,50);
                    Coordenada Inicio=new Coordenada(rango,0);
                    RectanguloGrafico nuevo= new RectanguloGrafico(Inicio,25,25,Color.RED);
                    ast.add(nuevo);
                    v.add(nuevo);
                    nuevo.Ciclo(Mov);
                    ContadorAsteroides++;
                    
                            
                }
                
                
                String Niveles = "1";
                
                TextoGrafico TextoNivel = new TextoGrafico("NIVEL", Color.BLACK, 1700, 500);
                TextoNivel.setSize(50);
                
                TextoGrafico TextoNrNivel = new TextoGrafico(Niveles, Color.RED, 1700, 600);
                TextoNrNivel.setSize(50);
                    
                v.add(TextoNivel);
                v.add(TextoNrNivel);
                
                if (Score >=50 && Score <100) {
                    
                    String NuevoNivel = "2";
                    TextoNrNivel.SetColor(Color.WHITE);
                    v.add(TextoNrNivel);
                    TextoGrafico Nrnivel1 = new TextoGrafico(NuevoNivel, Color.RED, 1700, 600);
                    Nrnivel1.setSize(40);
                    TextoNrNivel = Nrnivel1;
                    v.add(TextoNrNivel);
                    Mov = 7;
                    MAXAST = 6;
                    
                    for(i=0;i<ast.size();i++){
                    RectanguloGrafico rect=(RectanguloGrafico) ast.get(i);
                    rect.pintar(Color.GREEN);
                    }
                }
                
                if (Score >=100 && Score <150) {
                    
                    String NuevoNive = "3";
                    TextoNrNivel.SetColor(Color.WHITE);
                    v.add(TextoNrNivel);
                    TextoGrafico Nrnivel3 = new TextoGrafico(NuevoNive, Color.RED, 1700, 600);
                    Nrnivel3.setSize(40);
                    TextoNrNivel = Nrnivel3;
                    v.add(TextoNrNivel);
                    Mov = 9;
                    MAXAST = 7;
                    
                    for(i=0;i<ast.size();i++){
                    RectanguloGrafico rect=(RectanguloGrafico) ast.get(i);
                    rect.pintar(Color.BLUE);
                    }
                }
                
                if (Vidas <= 0) {
                    FinDeJuego = false;
                    v.add(Final);
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
