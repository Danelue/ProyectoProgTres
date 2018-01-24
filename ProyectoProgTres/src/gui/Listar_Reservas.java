package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Listar_Reservas extends JInternalFrame implements ActionListener{
	private JTable tablelistado;
	private DefaultTableModel dftml;
	private JButton btnListar;
	private Connection conex;
	private Statement sentencia;
	private ResultSet rs;

	
	public Listar_Reservas() {
		setTitle("Listado de Reservas");
		setBounds(100, 100, 650, 467);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 69, 561, 290);
		getContentPane().add(scrollPane);
		
		tablelistado = new JTable();
		scrollPane.setViewportView(tablelistado);
		dftml = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
		};
		tablelistado.setModel(dftml);
		dftml.setColumnIdentifiers(new Object[] {"cod_reserva","cod_espacio","nombre_espacio","fecha","hora-ini","hora_fin"});
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(500, 31, 97, 25);
		btnListar.addActionListener(this);
		getContentPane().add(btnListar);
		
		JLabel lblTodasLasReservas = new JLabel("Todas las reservas:");
		lblTodasLasReservas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTodasLasReservas.setBounds(107, 13, 197, 43);
		getContentPane().add(lblTodasLasReservas);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnListar) {
			listar();
		}
		
		
	}
	
	protected void listar() {
		try {
			conex=VentanaLogin.getConexion();
			conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AlquilerdePistas", VentanaLogin.getUser(), VentanaLogin.getPassword());
			sentencia =  conex.createStatement();
			rs =sentencia.executeQuery("SELECT cod_reserva, cod_espacio, nombre_espacio,fecha,hora_ini,hora_fin FROM reservas");
			while(rs.next()) {
				dftml.addRow(new Object[] {rs.getInt("cod_reserva"),rs.getInt("cod_espacio"),rs.getString("nombre_espacio"), rs.getString("fecha"),rs.getString("hora_ini"),rs.getString("hora_fin")});
			}
		} catch (SQLException e) {
			
		}
		
		
		
	}
}
