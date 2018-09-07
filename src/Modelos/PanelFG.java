
package Modelos;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;
public class PanelFG extends JPanel{
    ArrayList v;
    public PanelFG(ArrayList asd)
    {
        this.v=asd;
    }
    public void paint(Graphics g)
    {
        Dibujable dib;
        for(int i=0;i<v.size();i++)
        {
            dib=(Dibujable)v.get(i);
            dib.dibujar(g);
        }
    }
}
