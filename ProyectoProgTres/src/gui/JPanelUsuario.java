package gui;
import java.awt.Color;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
public class JPanelUsuario extends JPanel{
	

		private JTextField textField;
		private JPasswordField passwordField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		
		public JPanelUsuario() {
			setLayout(null);
			inicializar();
		}

		private void inicializar() {
			// TODO Auto-generated method stub
			JLabel lblRegistro = new JLabel("Registro");
			lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRegistro.setForeground(Color.YELLOW);
			lblRegistro.setBounds(23, 31, 76, 22);
			add(lblRegistro);
			
			JLabel lblUsuario = new JLabel("Usuario");
			lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblUsuario.setForeground(Color.YELLOW);
			lblUsuario.setBounds(33, 74, 56, 22);
			add(lblUsuario);
			
			textField = new JTextField();
			textField.setBounds(101, 75, 116, 22);
			add(textField);
			textField.setColumns(10);
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setForeground(Color.YELLOW);
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPassword.setBounds(234, 74, 76, 22);
			add(lblPassword);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(322, 75, 116, 22);
			add(passwordField);
			
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setForeground(Color.YELLOW);
			lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTelefono.setBounds(33, 121, 66, 22);
			add(lblTelefono);
			
			textField_1 = new JTextField();
			textField_1.setBounds(101, 122, 116, 22);
			add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
			lblDireccion.setForeground(Color.YELLOW);
			lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDireccion.setBounds(214, 121, 76, 22);
			add(lblDireccion);
			
			textField_2 = new JTextField();
			textField_2.setBounds(284, 122, 154, 22);
			add(textField_2);
			textField_2.setColumns(10);
			
			JButton btnRegistrar = new JButton("Registrar");
			btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnRegistrar.setBounds(178, 271, 97, 25);
			add(btnRegistrar);
			
			textField_3 = new JTextField();
			textField_3.setBounds(101, 166, 61, 22);
			add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblCp = new JLabel("CP");
			lblCp.setForeground(Color.YELLOW);
			lblCp.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCp.setHorizontalAlignment(SwingConstants.CENTER);
			lblCp.setBounds(33, 168, 56, 16);
			add(lblCp);
			
			JLabel lblNewLabel = new JLabel("email");
			lblNewLabel.setForeground(Color.YELLOW);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(188, 164, 43, 22);
			add(lblNewLabel);
			
			textField_4 = new JTextField();
			textField_4.setBounds(234, 165, 205, 22);
			add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblDescripcionAdicional = new JLabel("Descripcion \r\n");
			lblDescripcionAdicional.setForeground(Color.YELLOW);
			lblDescripcionAdicional.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDescripcionAdicional.setToolTipText("");
			lblDescripcionAdicional.setHorizontalAlignment(SwingConstants.TRAILING);
			lblDescripcionAdicional.setBounds(43, 209, 88, 38);
			add(lblDescripcionAdicional);
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(134, 209, 289, 49);
			add(textArea);
		}
}
