package gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelGestion extends JPanel{
	
	String nombre;
	ImageIcon imagen;
	
	public JPanelGestion(String nombre) {
		this.nombre=nombre;
	}
	
	public void paint(Graphics g) {
		Dimension dim=getSize();
		imagen=new ImageIcon("imagenes\\Gestion_de_Reservas.jpg");
		g.drawImage(imagen.getImage(), 0, 0, dim.width,dim.height,null);
		setOpaque(false);
		super.paint(g);
	}

}
