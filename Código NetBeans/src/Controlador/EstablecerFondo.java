package Controlador;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EstablecerFondo extends JPanel {

    private Image imagen;
    private String url;

    public EstablecerFondo(String url) {
        this.url = url;
    }

    @Override
    //Método que permite establecer el fondo a las ventanas
    public void paint(Graphics g) {
        this.imagen = new ImageIcon(getClass().getResource(url)).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
