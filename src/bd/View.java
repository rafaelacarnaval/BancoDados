package bd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtProfissao;
	private JTextField txtIdade;
	private JTextField txtSexo;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastro de Profissionais");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTitulo.setBounds(131, 10, 229, 23);
		contentPane.add(lblTitulo);
		
		JPanel sectionCadastro = new JPanel();
		sectionCadastro.setBounds(10, 52, 441, 215);
		contentPane.add(sectionCadastro);
		sectionCadastro.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblId.setBounds(10, 10, 80, 13);
		sectionCadastro.add(lblId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNome.setBounds(10, 44, 80, 13);
		sectionCadastro.add(lblNome);
		
		JLabel lblProfissao = new JLabel("Profiss\u00E3o:");
		lblProfissao.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblProfissao.setBounds(10, 79, 80, 13);
		sectionCadastro.add(lblProfissao);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblIdade.setBounds(10, 116, 80, 13);
		sectionCadastro.add(lblIdade);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSexo.setBounds(10, 149, 80, 13);
		sectionCadastro.add(lblSexo);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtId.setBounds(100, 9, 96, 19);
		sectionCadastro.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtNome.setBounds(100, 43, 300, 19);
		sectionCadastro.add(txtNome);
		txtNome.setColumns(10);
		
		txtProfissao = new JTextField();
		txtProfissao.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtProfissao.setBounds(100, 78, 300, 19);
		sectionCadastro.add(txtProfissao);
		txtProfissao.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtIdade.setBounds(100, 110, 300, 19);
		sectionCadastro.add(txtIdade);
		txtIdade.setColumns(10);
		
		txtSexo = new JTextField();
		txtSexo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSexo.setBounds(100, 143, 300, 19);
		sectionCadastro.add(txtSexo);
		txtSexo.setColumns(10);
		
		JButton btnInserir = new JButton("Criar");
		btnInserir.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnInserir.setBounds(0, 194, 80, 21);
		sectionCadastro.add(btnInserir);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnVisualizar.setBounds(90, 194, 109, 21);
		sectionCadastro.add(btnVisualizar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAtualizar.setBounds(209, 194, 109, 21);
		sectionCadastro.add(btnAtualizar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnRemover.setBounds(328, 194, 113, 21);
		sectionCadastro.add(btnRemover);
		
		JPanel sectionResultados = new JPanel();
		sectionResultados.setBounds(10, 289, 444, 207);
		contentPane.add(sectionResultados);
		sectionResultados.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "PROFISSAO", "IDADE", "SEXO"
			}
		));
		
		table.setBounds(20, 10, 400, 172);
				sectionResultados.add(table);
		
		
		
		btnInserir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Profissional prof = new Profissional();
				prof.setId(Integer.parseInt(txtId.getText()));
				prof.setNome(txtNome.getText());
				prof.setProfissao(txtProfissao.getText());
				prof.setIdade(txtIdade.getText());
				prof.setSexo(txtSexo.getText());
				
				try {
					ConexaoDAO conexaodao = new ConexaoDAO();
					conexaodao.inserirRegistro(prof);
					
					//Limpando campos
					
					txtId.setText("");
					txtNome.setText("");
					txtProfissao.setText("");
					txtIdade.setText("");
					txtSexo.setText("");
				}
				catch (SQLException ex) {
					System.out.println(ex.getMessage());
					
				}
				
			}
		});
		
		btnVisualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel banco = (DefaultTableModel) table.getModel();
				banco.setNumRows(0);
				ConexaoDAO conexaodao = new ConexaoDAO();
				
				for(Profissional p: conexaodao.visualizarRegistro()) {
					banco.addRow(new Object[]{
							p.getId(),
							p.getNome(),
							p.getProfissao(),
							p.getIdade(),
							p.getSexo()			
					});
				} 
				
				
				
			}
		});
		
		btnAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Profissional prof = new Profissional();
				int row = table.getSelectedRow();
				int id = (int) table.getValueAt(table.getSelectedRow(), 0);
				String nome = (String) table.getValueAt(row, 1);
				String profissao = (String) table.getValueAt(row, 2);
				String idade = (String) table.getValueAt(row, 3);
				String sexo = (String) table.getValueAt(row, 4);
				prof.setId(id);
				prof.setNome(nome);
				prof.setProfissao(profissao);
				prof.setIdade(idade);
				prof.setSexo(sexo);
				
				try {
					ConexaoDAO conexaodao = new ConexaoDAO();
					conexaodao.atualizarRegistro(prof);
				}
				catch (SQLException ex) {
					System.out.println(ex.getMessage());
					
				}
				
				
			}
		});
		
		btnRemover.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					ConexaoDAO conexaodao = new ConexaoDAO();
					Profissional prof = new Profissional();
					
					int id = (int) table.getValueAt(table.getSelectedRow(), 0);
					prof.setId(id);
					conexaodao.removerRegistro(prof);
					
					((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
					
				}
				catch (SQLException ex) {
					System.out.println(ex.getMessage());
					
				}
				
				
			}
		});
		
		
	}
}
