package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

import clases.Reserva;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.naming.CommunicationException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.JobAttributes;
import javax.swing.JTextField;

public class Listar_Espacios extends JFrame implements ActionListener, MouseInputListener{
	
	private JPanel contentPane;
	private JTable tableEspacios;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnCerrar;
	private JButton btnOk;
	private JButton btnListar;
	private DefaultTableModel dftm; 

	public Listar_Espacios() {
		inicializar();
		
	}
	
	public void seleccionarRegistro() {
		int fila = tableEspacios.getSelectedRow();
		tableEspacios.getModel();
		textField.setText(String.valueOf(tableEspacios.getValueAt(fila, 0)));
		textField_1.setText(String.valueOf(tableEspacios.getValueAt(fila, 1)));
			
	}
	
	public void listar() {
		try {
			Connection conexion = VentanaLogin.getConexion();
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AlquilerdePistas", VentanaLogin.getUser(), VentanaLogin.getPassword());
			Statement sentencia = conexion.createStatement();
			ResultSet resultado =sentencia.executeQuery("SELECT * FROM espacios");
			while(resultado.next()) {
				dftm.addRow(new Object[]{resultado.getInt("cod_espacio"), resultado.getString("nombre_espacio"), resultado.getDouble("precio_hora"), resultado.getString("descripcion")});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	private void inicializar() {
		setTitle("ESPACIOS");
		setBounds(100, 100, 850, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 79, 795, 313);
		contentPane.add(scrollPane);
		
		tableEspacios = new JTable();
		scrollPane.setViewportView(tableEspacios);
		tableEspacios.addMouseListener(this);
		dftm = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
		};
		tableEspacios.setModel(dftm);
		dftm.setColumnIdentifiers(new Object[] {"Cod_Espacio", "Nombre_Espacio", "Precio_Hora","Descripcion"});
		
		JLabel lblNewLabel = new JLabel("Espacios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(278, 13, 79, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblCodespacio = new JLabel("Cod_Espacio");
		lblCodespacio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCodespacio.setBounds(12, 41, 100, 25);
		contentPane.add(lblCodespacio);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(121, 44, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre_Espacio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(249, 41, 124, 25);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(382, 44, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(506, 43, 97, 25);
		contentPane.add(btnOk);
		btnOk.addActionListener(this);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(608, 43, 97, 25);
		contentPane.add(btnListar);
		btnListar.addActionListener(this);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(710, 43, 97, 25);
		contentPane.add(btnCerrar);
		btnCerrar.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getSource()==tableEspacios) {
			seleccionarRegistro();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCerrar) {
			do_btnCerrar_actionperformed(e);
		}
		if(e.getSource()==btnListar) {
			actionperformedBtnListar(e);
		}
		if(e.getSource()==btnOk) {
			actionperformedBtnOK(e);
		}
		
	}
	
	protected void do_btnCerrar_actionperformed(ActionEvent e) {
		dispose();
	}
	
	protected void actionperformedBtnListar(ActionEvent e) {
		listar();
	}
	
	protected void actionperformedBtnOK(ActionEvent e) {
		try {
			String codigo, nombre;
			codigo=textField.getText();
			nombre=textField_1.getText();
			if(codigo.length()!=0 && nombre.length()!=0) {
				Reservas.textField_cod_espacio.setText(codigo);
				Reservas.textField_nom_espacio.setText(nombre);
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila", "Ninguna fila seleccionada",JOptionPane.WARNING_MESSAGE);
			}
		}catch(Exception ex) {
			this.dispose();
		}
	}
}
