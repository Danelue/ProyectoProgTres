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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Usuario;

import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class VentanaModificar extends JInternalFrame {
	private JTextField textField_Nick;
	private JPasswordField passwordField;
	private JTextField textField_Nombre;
	private JTextField textField_CP;
	private JTextField textField_Direccion;
	private JTextField textField_Telefono;
	private JTextField textField_Email;
	private JTextField textField_Fecha_Alta;
	private JTextField textField_Poblacion;
	private JTextField textField_Descripcion;
	
	
	
	
	public VentanaModificar() {
		inicializar();
		obtenerDatos();
	}
	
	private void inicializar() {
		setClosable(true);
		setTitle("MODIFICAR USUARIO");
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 467);
		getContentPane().setLayout(null);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNick.setBounds(37, 13, 56, 26);
		getContentPane().add(lblNick);
		
		textField_Nick = new JTextField();
		textField_Nick.setEditable(false);
		textField_Nick.setBounds(91, 17, 183, 22);
		getContentPane().add(textField_Nick);
		textField_Nick.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password*:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(286, 13, 84, 26);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(382, 17, 202, 22);
		getContentPane().add(passwordField);
		
		JLabel lblNombre = new JLabel("Nombre*:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombre.setBounds(37, 76, 84, 26);
		getContentPane().add(lblNombre);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(120, 80, 165, 22);
		getContentPane().add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		JLabel lblCp = new JLabel("CP*:");
		lblCp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCp.setBounds(295, 81, 43, 16);
		getContentPane().add(lblCp);
		
		textField_CP = new JTextField();
		textField_CP.setBounds(350, 80, 116, 22);
		getContentPane().add(textField_CP);
		textField_CP.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion*:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDireccion.setBounds(37, 146, 84, 26);
		getContentPane().add(lblDireccion);
		
		textField_Direccion = new JTextField();
		textField_Direccion.setBounds(133, 150, 248, 22);
		getContentPane().add(textField_Direccion);
		textField_Direccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono*:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefono.setBounds(382, 148, 88, 23);
		getContentPane().add(lblTelefono);
		
		textField_Telefono = new JTextField();
		textField_Telefono.setBounds(468, 150, 116, 22);
		getContentPane().add(textField_Telefono);
		textField_Telefono.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(37, 217, 56, 26);
		getContentPane().add(lblEmail);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(105, 221, 248, 22);
		getContentPane().add(textField_Email);
		textField_Email.setColumns(10);
		
		JLabel lblFechaalta = new JLabel("Fecha.Alta:");
		lblFechaalta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFechaalta.setBounds(365, 217, 89, 26);
		getContentPane().add(lblFechaalta);
		
		textField_Fecha_Alta = new JTextField();
		textField_Fecha_Alta.setEditable(false);
		textField_Fecha_Alta.setBounds(468, 221, 116, 22);
		getContentPane().add(textField_Fecha_Alta);
		textField_Fecha_Alta.setColumns(10);
		
		JLabel lblPoblacion = new JLabel("Poblacion*:");
		lblPoblacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPoblacion.setBounds(37, 284, 96, 26);
		getContentPane().add(lblPoblacion);
		
		textField_Poblacion = new JTextField();
		textField_Poblacion.setBounds(145, 288, 116, 22);
		getContentPane().add(textField_Poblacion);
		textField_Poblacion.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDescripcion.setBounds(270, 284, 100, 26);
		getContentPane().add(lblDescripcion);
		
		textField_Descripcion = new JTextField();
		textField_Descripcion.setBounds(377, 271, 229, 57);
		getContentPane().add(textField_Descripcion);
		textField_Descripcion.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarDatos();
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnModificar.setBounds(206, 342, 119, 25);
		getContentPane().add(btnModificar);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion_Reservas gR = new Gestion_Reservas();
				gR.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(360, 342, 97, 25);
		getContentPane().add(btnNewButton);
	}
	
	public void obtenerDatos() {
		String sql = "SELECT * FROM socios WHERE nick = '" + VentanaLogin.getNickusuario()  + "' AND password='"+VentanaLogin.getPass()+"'";
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexion = VentanaLogin.getConexion();
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AlquilerdePistas", VentanaLogin.getUser(), VentanaLogin.getPassword());
			Statement sentencia = conexion.createStatement();
			ResultSet resultado =sentencia.executeQuery(sql);
			while (resultado.next()) {
				textField_Nick.setText(resultado.getString("nick"));
				passwordField.setText(resultado.getString("password"));
				textField_Nombre.setText(resultado.getString("nom_usuario"));
				textField_CP.setText(resultado.getString("cp"));
				textField_Direccion.setText(resultado.getString("direccion"));
				textField_Telefono.setText(resultado.getString("telefono"));
				textField_Email.setText(resultado.getString("email"));
				textField_Fecha_Alta.setText(resultado.getString("fecha_alta"));
				textField_Poblacion.setText(resultado.getString("poblacion"));
				textField_Descripcion.setText(resultado.getString("descripcion"));
			}
			sentencia.close();
		}catch(SQLException e) {
			
		} catch (ClassNotFoundException e) {
		}
	}
	
	
	
	public void modificarDatos()  {
		String sql = "UPDATE socios SET password=?,nom_usuario =?,cp =?,direccion=?,telefono=?,email=?,poblacion=?,descripcion=? WHERE nick = '" + VentanaLogin.getNickusuario()  + "' AND password='"+VentanaLogin.getPass()+"'";
		Connection conexion = VentanaLogin.getConexion();
		try {
			if(passwordField.getText()==""||textField_Nombre.getText()==""||textField_CP.getText()==""||textField_Direccion.getText()==""||textField_Telefono.getText()==""||textField_Poblacion.getText()=="") {
				JOptionPane.showMessageDialog(null,"Por favor rellene los campos obligatorios marcados con(*)", "Rellenar Campos",JOptionPane.WARNING_MESSAGE);
			}else {
				conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AlquilerdePistas", VentanaLogin.getUser(), VentanaLogin.getPassword());
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setString(1, passwordField.getText());
				sentencia.setString(2, textField_Nombre.getText());
				sentencia.setInt(3, Integer.parseInt(textField_CP.getText()));
				sentencia.setString(4, textField_Direccion.getText());
				sentencia.setInt(5, Integer.parseInt(textField_Telefono.getText()));
				sentencia.setString(6, textField_Email.getText());
				sentencia.setString(7, textField_Poblacion.getText());
				sentencia.setString(8, textField_Descripcion.getText());
				sentencia.executeUpdate();
				JOptionPane.showMessageDialog(null, "Cambios realizados correctamente", "Modifcacion Realizada", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (SQLException e) {
			
		}
		
	}
}
