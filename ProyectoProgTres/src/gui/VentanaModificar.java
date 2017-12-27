package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.Font;

public class VentanaModificar extends JInternalFrame {
	
	private JPanel contentPane;
	private JTextField textFieldNick;
	private JTextField textFieldNombre;
	private JTextField textFieldCP;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	private JTextField textFieldPoblacion;
	private JLabel lblDireccion;
	private JPasswordField passwordField;
	
	public VentanaModificar() {
		setClosable(true);
		setTitle("MODIFICAR USUARIO");
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 606);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnModificar = new JButton("Modificar");
		panel.add(btnModificar);
		
		JButton btnSalir = new JButton("Salir");
		panel.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNick = new JLabel("Nick");
		lblNick.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNick);
		
		textFieldNick = new JTextField();
		textFieldNick.setEditable(false);
		panel_1.add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblPass);
		
		passwordField = new JPasswordField();
		panel_1.add(passwordField);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panel_3.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblCP = new JLabel("CP");
		panel_3.add(lblCP);
		
		textFieldCP = new JTextField();
		panel_3.add(textFieldCP);
		textFieldCP.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(lblDireccion);
		
		textFieldDireccion = new JTextField();
		panel_5.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		panel_5.add(lblTelefono);
		
		textFieldTelefono = new JTextField();
		panel_5.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_7.add(lblEmail);
		
		textFieldEmail = new JTextField();
		panel_7.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblPoblacion = new JLabel("Poblacion");
		panel_7.add(lblPoblacion);
		
		textFieldPoblacion = new JTextField();
		panel_7.add(textFieldPoblacion);
		textFieldPoblacion.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		panel_8.add(lblDescripcion);
		
		JTextArea textAreaDescripcion = new JTextArea();
		panel_8.add(textAreaDescripcion);
		
		
		
		
		
		

	}

}
