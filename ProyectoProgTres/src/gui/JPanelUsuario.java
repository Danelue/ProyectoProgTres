package gui;
import java.awt.Color;



import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import datos.Usuario;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;


public class JPanelUsuario extends JPanel{
	

		private JTextField textField_Nick;
		private JPasswordField passwordField;
		private JTextField textField_Nombre;
		private JTextField textField_CP;
		private JTextField textField_Direccion;
		private JTextField textField_Telefono;
		private JTextField textField_Email;
		private JTextField textField_Poblacion;
		private JTextField textField_descripcion;
		static Usuario usuario;
		private Connection con;
		static ResultSet rs = null;
		static Statement sentencia = null;
		
		
		
		public JPanelUsuario() {
			setSize(425, 425);
			setLayout(null);
			inicializar();
			
			
		}
		
		public void cerrarConexion() {
			con = null;
			if (rs!=null) {
				try {
					rs.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if (sentencia != null) {
				try {
					sentencia.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		}

		private void inicializar() {
			// TODO Auto-generated method stub
			JLabel lblRegistro = new JLabel("Registro");
			lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRegistro.setForeground(Color.YELLOW);
			lblRegistro.setBounds(12, 31, 76, 22);
			add(lblRegistro);
			
			JLabel lblNick = new JLabel("Nick");
			lblNick.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNick.setForeground(Color.YELLOW);
			lblNick.setBounds(22, 74, 38, 22);
			add(lblNick);
			
			textField_Nick = new JTextField();
			textField_Nick.setBounds(65, 75, 116, 22);
			add(textField_Nick);
			textField_Nick.setColumns(10);
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setForeground(Color.YELLOW);
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPassword.setBounds(193, 74, 76, 22);
			add(lblPassword);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(281, 75, 116, 22);
			add(passwordField);
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setForeground(Color.YELLOW);
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNombre.setBounds(22, 121, 66, 22);
			add(lblNombre);
			
			textField_Nombre = new JTextField();
			textField_Nombre.setBounds(86, 122, 116, 22);
			add(textField_Nombre);
			textField_Nombre.setColumns(10);
			
			JLabel lblCP = new JLabel("CP");
			lblCP.setHorizontalAlignment(SwingConstants.CENTER);
			lblCP.setForeground(Color.YELLOW);
			lblCP.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCP.setBounds(203, 121, 76, 22);
			add(lblCP);
			
			textField_CP = new JTextField();
			textField_CP.setBounds(284, 122, 113, 22);
			add(textField_CP);
			textField_CP.setColumns(10);
			
			JButton btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
						try {
							usuario = new Usuario();
							usuario.nick=textField_Nick.getText();
							usuario.password=passwordField.getText();
							usuario.nombre=textField_Nombre.getText();
							usuario.cp=Integer.parseInt(textField_CP.getText());
							usuario.direccion=textField_Direccion.getText();
							usuario.telefono=textField_Telefono.getText();
							usuario.email=textField_Email.getText();
							
							
							usuario.poblacion=textField_Poblacion.getText();
							usuario.descripcion=textField_descripcion.getText();
							
							String sentenciaSQL = new String();
							sentenciaSQL = "INSERT INTO socios (nick, password, nom_usuario, cp, direccion, telefono, email, poblacion, descripcion)";
							sentenciaSQL = sentenciaSQL +" VALUES ('"
									+ usuario.nick+ "','"  + usuario.password+ "','" + usuario.nombre + "'," + usuario.cp 
									+ ",'" + usuario.direccion + "'," + usuario.telefono+ ",'" + usuario.email+ "','"+usuario.poblacion
									+ "','"+usuario.descripcion+"');";
							
							String user ="postgres";
							String password ="dlorente";
							Class.forName("org.postgresql.Driver");
							Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AlquilerdePistas", user , password);
							Statement sentencia = con.createStatement();;
							sentencia.executeUpdate(sentenciaSQL);
							JOptionPane.showMessageDialog(null, "Guardado exitosamente");
							cerrarConexion();
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
						} catch(ClassNotFoundException e1) {
						}
						
						textField_Nick.setText("");
						passwordField.setText("");
						textField_Nombre.setText("");
						textField_CP.setText("");
						textField_Direccion.setText("");
						textField_Telefono.setText("");
						textField_Email.setText("");
						textField_Poblacion.setText("");
						textField_descripcion.setText("");
						
				}
			});
			btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnRegistrar.setBounds(165, 369, 97, 25);
			add(btnRegistrar);
			
			textField_Direccion = new JTextField();
			textField_Direccion.setBounds(96, 169, 150, 22);
			add(textField_Direccion);
			textField_Direccion.setColumns(10);
			
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setForeground(Color.YELLOW);
			lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
			lblDireccion.setBounds(22, 168, 66, 22);
			add(lblDireccion);
			
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setForeground(Color.YELLOW);
			lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTelefono.setBounds(253, 168, 66, 22);
			add(lblTelefono);
			
			textField_Telefono = new JTextField();
			textField_Telefono.setBounds(321, 169, 76, 22);
			add(textField_Telefono);
			textField_Telefono.setColumns(10);
			
			JLabel lblDescripcion = new JLabel("Descripcion \r\n");
			lblDescripcion.setForeground(Color.BLUE);
			lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDescripcion.setToolTipText("");
			lblDescripcion.setHorizontalAlignment(SwingConstants.TRAILING);
			lblDescripcion.setBounds(22, 292, 88, 25);
			add(lblDescripcion);
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setForeground(Color.YELLOW);
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblEmail.setBounds(22, 224, 44, 16);
			add(lblEmail);
			
			textField_Email = new JTextField();
			textField_Email.setBounds(65, 222, 137, 22);
			add(textField_Email);
			textField_Email.setColumns(10);
			
			JLabel lblPoblacion = new JLabel("Poblacion");
			lblPoblacion.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPoblacion.setForeground(Color.YELLOW);
			lblPoblacion.setBounds(213, 225, 66, 16);
			add(lblPoblacion);
			
			textField_Poblacion = new JTextField();
			textField_Poblacion.setBounds(284, 222, 113, 22);
			add(textField_Poblacion);
			textField_Poblacion.setColumns(10);
			
			textField_descripcion = new JTextField();
			textField_descripcion.setBounds(122, 278, 275, 54);
			add(textField_descripcion);
			textField_descripcion.setColumns(10);
			
		}
		
	
}

