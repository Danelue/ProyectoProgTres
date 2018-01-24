package gui;

import java.awt.EventQueue;


import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Date;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

import clases.Reserva;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;

public class Reservas extends JInternalFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_cod_reserva;
	private JTextField textField_nick;
	protected static JTextField textField_cod_espacio;
	protected static JTextField textField_nom_espacio;
	private JTable tableReservas;
	private JButton btnGrabar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JButton btnNuevaReserva;
	private DefaultTableModel dftm;
	private Statement sentencia;
	private JDateChooser dateChooser;
	private Connection conexion;
	private Reservas r;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	
	
	public Reservas()  {
		inicializar();
		obtenerNick();
		llenar();
	}
	
	
	private void inicializar() {
		setTitle("RESERVAS");
		setBounds(100, 100, 650, 467);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 132, 610, 200);
		getContentPane().add(scrollPane);
		
		tableReservas = new JTable();
		tableReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton()==1) {
					int fila = tableReservas.getSelectedRow();
					try {
						String sql = "SELECT * FROM reservas";
						sentencia=conexion.createStatement();
						ResultSet rs = sentencia.executeQuery(sql);
						while(rs.next()) {
							textField_cod_reserva.setText(String.valueOf(rs.getInt("cod_reserva")));
							textField_nom_espacio.setText(rs.getString("nombre_espacio"));
							textField_cod_espacio.setText(String.valueOf(rs.getInt("cod_espacio")));
							dateChooser.setDate(rs.getDate("fecha"));
							comboBox.setSelectedItem(rs.getString("hora_ini"));
							comboBox_1.setSelectedItem(rs.getString("hora_fin"));
						}
					} catch (SQLException e1) {
					}
					
				}
			}
		});
		scrollPane.setViewportView(tableReservas);
		dftm = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
		};
		tableReservas.setModel(dftm);
		dftm.setColumnIdentifiers(new Object[] {"cod_reserva","nick","cod_espacio","nombre_espacio","fecha","hora-ini","hora_fin"});
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(180, 334, 97, 25);
		getContentPane().add(btnGrabar);
		btnGrabar.addActionListener(this);
		
		JLabel lblCodreserva = new JLabel("Cod_Reserva:");
		lblCodreserva.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCodreserva.setBounds(12, 13, 103, 25);
		getContentPane().add(lblCodreserva);
		
		textField_cod_reserva = new JTextField();
		textField_cod_reserva.setEditable(false);
		textField_cod_reserva.setBounds(127, 16, 116, 22);
		getContentPane().add(textField_cod_reserva);
		textField_cod_reserva.setColumns(10);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNick.setBounds(268, 19, 46, 16);
		getContentPane().add(lblNick);
		
		textField_nick = new JTextField();
		textField_nick.setEditable(false);
		textField_nick.setBounds(329, 16, 136, 22);
		getContentPane().add(textField_nick);
		textField_nick.setColumns(10);
		
		JLabel lblCodespacio = new JLabel("Cod_Espacio:");
		lblCodespacio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCodespacio.setBounds(12, 55, 103, 25);
		getContentPane().add(lblCodespacio);
		
		textField_cod_espacio = new JTextField();
		textField_cod_espacio.setBounds(127, 58, 116, 22);
		getContentPane().add(textField_cod_espacio);
		textField_cod_espacio.setColumns(10);
		
		JButton btnNewButton = new JButton(new ImageIcon("imagenes\\lupa.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Listar_Espacios lE = new Listar_Espacios();
				lE.setVisible(true);
			}
		});
		btnNewButton.setBounds(255, 57, 22, 25);
		getContentPane().add(btnNewButton);
		
		JLabel lblNombreespacio = new JLabel("Nombre_Espacio:");
		lblNombreespacio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombreespacio.setBounds(288, 61, 130, 21);
		getContentPane().add(lblNombreespacio);
		
		textField_nom_espacio = new JTextField();
		textField_nom_espacio.setBounds(430, 60, 155, 22);
		getContentPane().add(textField_nom_espacio);
		textField_nom_espacio.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFecha.setBounds(12, 103, 56, 16);
		getContentPane().add(lblFecha);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(80, 103, 105, 22);
		getContentPane().add(dateChooser);
		
		JLabel lblHoraini = new JLabel("Hora_Ini:");
		lblHoraini.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHoraini.setBounds(198, 99, 79, 25);
		getContentPane().add(lblHoraini);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15.00", "16:00", "17:00", "18:00", "19:00", "20:00"}));
		comboBox.setBounds(287, 100, 97, 22);
		getContentPane().add(comboBox);
		
		JLabel lblHorafin = new JLabel("Hora_Fin:");
		lblHorafin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHorafin.setBounds(396, 100, 79, 22);
		getContentPane().add(lblHorafin);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15.00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		comboBox_1.setBounds(474, 102, 97, 22);
		getContentPane().add(comboBox_1);
		
		btnNuevaReserva = new JButton("Nueva Reserva");
		btnNuevaReserva.addActionListener(this);
		btnNuevaReserva.setBounds(35, 334, 133, 25);
		getContentPane().add(btnNuevaReserva);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(287, 334, 97, 25);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(396, 334, 97, 25);
		getContentPane().add(btnEliminar);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()== btnGrabar) {
			btnGrabarActionPerformed(arg0);
		}
		if(arg0.getSource()==btnEliminar) {
			btnEliminarActionPerformed(arg0);
		}
		if(arg0.getSource()==btnCerrar) {
			btnCerrarActionPerformed(arg0);
		}
		if(arg0.getSource()==btnModificar) {
			btnModificarActionPerformed(arg0);
		}
		if(arg0.getSource()==btnNuevaReserva) {
			btnNuevaReservaActionPerformed(arg0);
		}
	}
	
	public void obtenerNick() {
		textField_nick.setText(VentanaLogin.getNickusuario());
	}
	
	public void limpiar() {
		textField_cod_espacio.setText("");
		textField_nom_espacio.setText("");
		textField_cod_reserva.setText("");
		dateChooser.setDate(null);
		comboBox.setSelectedIndex(-1);
		comboBox_1.setSelectedIndex(-1);
		
	}
	
	public void llenar() {
		
		try {
			conexion = VentanaLogin.getConexion();
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AlquilerdePistas", VentanaLogin.getUser(), VentanaLogin.getPassword());
			sentencia =  conexion.createStatement();
			ResultSet resultado =   ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM reservas WHERE nick='"+VentanaLogin.getNickusuario()+"'");
			while(resultado.next()) {
				dftm.addRow(new Object[] {resultado.getInt("cod_reserva"),resultado.getString("nick"),resultado.getInt("cod_espacio"),resultado.getString("nombre_espacio"), resultado.getString("fecha"),resultado.getString("hora_ini"),resultado.getString("hora_fin")});
			}
		}catch(SQLException s) {}
	}
	
	protected void btnEliminarActionPerformed(ActionEvent arg0) {
		try {
			conexion =VentanaLogin.getConexion();
			int filaseleccionada = tableReservas.getSelectedRow();
			String sql ="DELETE FROM reservas WHERE cod_reserva=?";
			int n = sentencia.executeUpdate(sql);
			if(n>0) {
				vaciarJTable();
				llenar();
			JOptionPane.showMessageDialog(null,"Datos eliminados correctamente");
			limpiar();
			}
		}catch(Exception ex) {
			
		}
	}
	
	protected void btnNuevaReservaActionPerformed(ActionEvent arg0) {
		limpiar();
	}
	
	public void vaciarJTable() {
		dftm.setRowCount(0);
		
	}
	
	protected void btnModificarActionPerformed(ActionEvent arg0) {		
		try {
			String sql = "UPDATE reservas SET cod_espacio=?,nombre_espacio=?,fecha=?,hora_ini=?,hora_fin=? WHERE cod_reserva=?";
			int fila = tableReservas.getSelectedRow();
			int codigo = (int) tableReservas.getValueAt(fila, 0);
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(textField_cod_espacio.getText()));
			ps.setString(2, textField_nom_espacio.getText());
			java.util.Date utilStartDate = dateChooser.getDate();
			java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
			ps.setDate(3, sqlStartDate);
			ps.setString(4,  (String) comboBox.getSelectedItem());
			ps.setString(5,  (String) comboBox_1.getSelectedItem());
			ps.setInt(6,codigo);
			int n = ps.executeUpdate();
			if(n>0) {
				limpiar();
				vaciarJTable();
				llenar();
				JOptionPane.showMessageDialog(null, "Datos Modificados correctamente");
			}
		} catch (SQLException e) {
			
		}
	}
	
	protected void btnCerrarActionPerformed(ActionEvent arg0) {
		
	}
	
	
	protected void btnGrabarActionPerformed(ActionEvent arg0) {
		try {
			String sql ="INSERT INTO reservas(nick,cod_espacio,nombre_espacio,fecha,hora_ini,hora_fin) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, textField_nick.getText());
			ps.setInt(2, Integer.parseInt(textField_cod_espacio.getText()));
			ps.setString(3, textField_nom_espacio.getText());
			java.util.Date utilStartDate = dateChooser.getDate();
			java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
			ps.setDate(4, sqlStartDate);
			ps.setString(5, (String) comboBox.getSelectedItem());
			ps.setString(6, (String) comboBox_1.getSelectedItem());
			int n=ps.executeUpdate();
			if(n>0) {
				JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
			}
		}catch(Exception e) {
			
		}
		vaciarJTable();
		llenar();
		limpiar();
	}
	


}
