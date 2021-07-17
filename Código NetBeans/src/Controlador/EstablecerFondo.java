package Controlador;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author John
 */
public class EstablecerFondo extends JPanel {

    private Image imagen;
    private String urlImagen;

    /**
     * Constructor Parametrizado
     *
     * @param urlImagen
     */
    public EstablecerFondo(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public void paint(Graphics g) {
        this.imagen = new ImageIcon(getClass().getResource(urlImagen)).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
