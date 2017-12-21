package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Gestion_Reservas extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmCerrarSesin; 

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Gestion_Reservas() {
		setResizable(false);
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
		mntmIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hacerReserva();
			}
		});
		
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dlorente\\git\\ProyectoProgTres\\ProyectoProgTres\\imagenes\\Gestion_de_Reservas.jpg"));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mntmCerrarSesin) {
			cerrarSesion(e);			
		}
		if(e.getSource() == mntmConsultar) {
			consultarReservas(e);			
		}
		
		
	}
	
	public void cerrarSesion(ActionEvent e) {
		dispose();
	}
	
	public void consultarReservas(ActionEvent e) {
		Consultar_Reservas cr = new Consultar_Reservas();
		cr.setVisible(true);
		setContentPane(cr);
	}
	
	public void hacerReserva() {
		Ingresar_Reserva ir = new Ingresar_Reserva();
		ir.setVisible(true);
		setContentPane(ir);
	}

}
