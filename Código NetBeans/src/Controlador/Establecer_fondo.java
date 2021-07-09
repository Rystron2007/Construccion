package Controlador;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Establecer_fondo extends JPanel {

    
    private Image imagen;
    private String url;
    public Establecer_fondo(String url){
        this.url=url;
    }
    @Override
    //Metodo que permite establecer el fondo a las ventanas
    public void paint(Graphics g) {
        this.imagen = new ImageIcon(getClass().getResource(url)).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
