package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;  


import model.bean.Imoveis;
import model.dao.ImoveisDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarImoveis extends JFrame {

	private JPanel contentPane;
	private JTable JTImoveis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarImoveis frame = new JFListarImoveis();
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
	public JFListarImoveis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 
		contentPane.setLayout(null);
		 
		JLabel lblNewLabel = new JLabel("Listar Im\u00F3veis");
		lblNewLabel.setBounds(10, 11, 135, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 383, 150);
		contentPane.add(scrollPane);
		
		JTImoveis = new JTable();
		JTImoveis.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"IdImovel", "Endereco", "Nbairro", "Cidade", "Cep", "Valor"
			} 
		));
		scrollPane.setViewportView(JTImoveis);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFCadastrarImoveis ci = new JFCadastrarImoveis();
				ci.setVisible(true);
			}
		});
		btnCadastrar.setBounds(28, 215, 117, 23);
		contentPane.add(btnCadastrar);
		
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JTImoveis.getSelectedRow()!= -1) {
					JFAlterarImoveis af = new JFAlterarImoveis(
							(int)JTImoveis.getValueAt(JTImoveis.getSelectedRow(), 0));
					af.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um imovel!");
				}
				readJTable();
			}
			
		});
		
		btnAlterar.setBounds(153, 215, 109, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(JTImoveis.getSelectedRow() != -1) {

						int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o imovel selecionado?"
								,"Exclusão",JOptionPane.YES_NO_OPTION);
						if (opcao == 0) {
							ImoveisDAO dao = new ImoveisDAO();
							Imoveis i = new Imoveis();
							i.setIdImovel((int) JTImoveis.getValueAt(JTImoveis.getSelectedRow(), 0));
							dao.delete(i);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um imovel!");
					}
					readJTable();

			}
		});
		btnExcluir.setBounds(272, 215, 117, 23);
		contentPane.add(btnExcluir);
		
		readJTable();
		
		}
		
		public void readJTable() {
			DefaultTableModel modelo = (DefaultTableModel) JTImoveis.getModel();
			modelo.setNumRows(0);
			ImoveisDAO idao = new ImoveisDAO();
			for(Imoveis i :idao.read()) {
				modelo.addRow(new Object[] {
						i.getIdImovel(),
						i.getEndereco(),
						i.getNbairro(),
						i.getCidade(),
						i.getValor()
				});
	
			}
			}
		}
