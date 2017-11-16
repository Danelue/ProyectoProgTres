package gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VenatanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	
	public VenatanaLogin() {
		
		inicializar();

		
	}
	public static void main(String[] args) {
		VenatanaLogin vL = new VenatanaLogin();
		vL.setSize(1150, 671);
		vL.setVisible(true);
	}

	private void inicializar() {
		// TODO Auto-generated method stub
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dlorente\\git\\ProyectoProgTres\\ProyectoProgTres\\imagenes\\instalacionesDeportivas.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(new Color(34, 139, 34));
		panelPrincipal.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImagenLogo = new JLabel("");
		lblImagenLogo.setIcon(new ImageIcon("C:\\Users\\Dlorente\\git\\ProyectoProgTres\\ProyectoProgTres\\imagenes\\logo.png"));
		lblImagenLogo.setHorizontalAlignment(SwingConstants.LEFT);
		panelNorte.add(lblImagenLogo, BorderLayout.CENTER);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setOpaque(false);
		panelNorte.add(panelLogin, BorderLayout.EAST);
		panelLogin.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("     ");
		panelLogin.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("        ");
		panelLogin.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_2 = new JLabel("                       ");
		panelLogin.add(lblNewLabel_2, BorderLayout.EAST);
		
		JPanel panelLoginLay = new JPanel();
		panelLoginLay.setPreferredSize(new Dimension(400, 160));
		panelLoginLay.setOpaque(false);
		panelLogin.add(panelLoginLay, BorderLayout.CENTER);
		panelLoginLay.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(40, 38, 77, 24);
		panelLoginLay.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(128, 40, 134, 22);
		panelLoginLay.add(textField);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(40, 122, 77, 24);
		panelLoginLay.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 124, 134, 22);
		panelLoginLay.add(passwordField);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnIniciarSesion.setBounds(279, 75, 121, 34);
		panelLoginLay.add(btnIniciarSesion);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(new Color(34, 139, 34));
		panelPrincipal.add(panelSur, BorderLayout.SOUTH);
		
		JLabel lblCreadoPorDanel = new JLabel("Creado por Danel Lorente y Alejandro Cano");
		lblCreadoPorDanel.setBackground(Color.WHITE);
		lblCreadoPorDanel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelSur.add(lblCreadoPorDanel);
		
		String nombre ="C:\\Users\\Dlorente\\git\\ProyectoProgTres\\ProyectoProgTres\\imagenes\\instalacionesDeportivas.png";
		JPanelFondo panelCentral = new JPanelFondo(nombre);
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JPanelUsuario panelRegistro = new JPanelUsuario();
		panelRegistro.setPreferredSize(new Dimension(500, 400));
		panelRegistro.setOpaque(false);
		panelCentral.add(panelRegistro,BorderLayout.EAST);
		
		
		
		
		
		
		
		
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
