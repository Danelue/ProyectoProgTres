package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Ejemplo de JPanel con fondo gráfico escalado
 * @author andoni
 */
public class JPanelFondo extends JPanel {

	String nombre;
	ImageIcon imagen;
	
	public JPanelFondo(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
	}
	
	public void paint(Graphics g) {
		Dimension dim=getSize();
		imagen=new ImageIcon("C:\\Users\\Dlorente\\workspace\\ProyectoProgTres\\imagenes\\instalacionesDeportivas.png");
		g.drawImage(imagen.getImage(), 0, 0, dim.width,dim.height,null);
		setOpaque(false);
		super.paint(g);
	
	}


}
