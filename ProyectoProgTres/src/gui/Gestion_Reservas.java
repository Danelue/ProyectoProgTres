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
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Gestion_Reservas extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnSocio;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmCerrarSesin;
	private JPanel contentPane;
	private JMenu mnReservas;
	private JMenuItem mntmReservar;
	private JMenuItem mntmListar;
	private JMenu mnReporte;
	private JMenuItem mntmQueja;
	private JMenuItem mntmSugerencia;
	private Connection conexion;
	private VentanaLogin vL;
	private Gestion_Reservas gR;
	private JLabel lblNewLabel;
	
	
	

	
	public Gestion_Reservas() {
		inicializar();
		Dimension dim =getSize();
		int ancho = (int) dim.getWidth();
		int alto = (int) dim.getHeight();
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(100,100,ancho,alto);
		ImageIcon imagen = new ImageIcon("imagenes\\Gestion_de_Reservas.jpg");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono);
		this.repaint();
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
	}
	
	private void inicializar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GESTION DE RESERVAS");
		setBounds(100, 100, 650,467);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSocio = new JMenu("SOCIO");
		mnSocio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnSocio);
		
		mntmModificar = new JMenuItem("Modificar");
		mnSocio.add(mntmModificar);
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir_Modificar();
			}
		});
		
		mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(this);
		mnSocio.add(mntmEliminar);
		
		mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesin.addActionListener(this);
		mnSocio.add(mntmCerrarSesin);
		
		mnReservas = new JMenu("RESERVAS");
		mnReservas.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnReservas);
		
		mntmReservar = new JMenuItem("Crear Reserva");
		mnReservas.add(mntmReservar);
		mntmReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirReserva_Crear();
			}
		});
		
		JMenuItem mntmListar = new JMenuItem("Listar Reservas");
		mnReservas.add(mntmListar);
		
		mnReporte = new JMenu("ATENCI\u00D3N AL CLIENTE");
		mnReporte.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnReporte);
		
		mntmQueja = new JMenuItem("Queja");
		mnReporte.add(mntmQueja);
		
		mntmSugerencia = new JMenuItem("Sugerencia");
		mnReporte.add(mntmSugerencia);
		
		
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == mntmCerrarSesin) {
			cerrarSesion(arg0);
			VentanaLogin vL = new VentanaLogin();
			vL.setVisible(true);
			vL.setSize(1150, 671);
		}
		if(arg0.getSource() == mntmEliminar) {
			int seleccion = JOptionPane.showOptionDialog(mntmEliminar, "¿Está seguro de que desea eliminar este Usuario?", "Eliminar usuario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, "YES");
			if(seleccion ==0) {
				eliminarUsuario();
			}else if(seleccion==1) {
				JOptionPane.showMessageDialog(null, "Tu usuario sigue activo", "Usuario Activo",JOptionPane.INFORMATION_MESSAGE);
			}	
		}
	}
	
	public void cerrarSesion(ActionEvent arg0) {
		dispose();
		
	}
	
	public void eliminarUsuario() {
		String user ="postgres";
		String password ="dlorente";	
		String usuarioAEliminar = VentanaLogin.getU().getNick();
		try {
			Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AlquilerdePistas", user, password);
			Statement sentencia = conexion.createStatement();
			sentencia.execute("DELETE FROM socios WHERE nick = '"+usuarioAEliminar+"'");
			JOptionPane.showMessageDialog(null, "El usuario se ha borrado correctamente", "Usuario eliminado",JOptionPane.INFORMATION_MESSAGE);
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException s) {
			JOptionPane.showMessageDialog(null,s, "Error de conexion",JOptionPane.ERROR_MESSAGE);
		}

	

	}
	
	public void abrirReserva_Crear() {
		Reserva_Crear rC = new Reserva_Crear();
		rC.setVisible(true);
		setContentPane(rC);
	}
	
	public void abrir_Modificar() {
		VentanaModificar vM = new VentanaModificar();
		vM.setVisible(true);
		setContentPane(vM);
	}
}
