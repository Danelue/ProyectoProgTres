package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Gestion_Reservas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Gestion_Reservas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 467);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSocio = new JMenu("SOCIO");
		mnSocio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnSocio);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mnSocio.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mnSocio.add(mntmEliminar);
		
		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mnSocio.add(mntmCerrarSesin);
		
		JMenu mnReservas = new JMenu("RESERVAS");
		mnReservas.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnReservas);
		
		JMenuItem mntmIngresar = new JMenuItem("Ingresar");
		mnReservas.add(mntmIngresar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnReservas.add(mntmConsultar);
		
		JMenu mnReporte = new JMenu("ATENCI\u00D3N AL CLIENTE");
		mnReporte.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnReporte);
		
		JMenuItem mntmQueja = new JMenuItem("Queja");
		mnReporte.add(mntmQueja);
		
		JMenuItem mntmSugerencia = new JMenuItem("Sugerencia");
		mnReporte.add(mntmSugerencia);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

}
