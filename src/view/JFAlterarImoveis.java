package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Imoveis;
import model.dao.ImoveisDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFAlterarImoveis extends JFrame {

	private JPanel contentPane;
	private JTextField txtEndereco;
	private JTextField txtNbairro;
	private JTextField txtCidade;
	private JTextField txtCep;
	private JTextField txtValor;

	private static int id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAlterarImoveis frame = new JFAlterarImoveis(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param j 
	 */
	public JFAlterarImoveis(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar Im\u00F3veis");
		lblNewLabel.setBounds(168, 11, 115, 14);
		contentPane.add(lblNewLabel);
		
		ImoveisDAO idao = new ImoveisDAO();
		Imoveis i = idao.read(id);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 29, 46, 14);
		
		contentPane.add(lblNewLabel_1);
		
		JLabel lblID = new JLabel("0");
		lblID.setBounds(66, 29, 46, 14);
		contentPane.add(lblID);
		
		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o");
		lblNewLabel_2.setBounds(10, 54, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(76, 51, 86, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00B0 Bairro");
		lblNewLabel_3.setBounds(10, 79, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtNbairro = new JTextField();
		txtNbairro.setBounds(76, 82, 86, 20);
		contentPane.add(txtNbairro);
		txtNbairro.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Cidade");
		lblNewLabel_4.setBounds(10, 119, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(76, 113, 86, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("CEP");
		lblNewLabel_5.setBounds(207, 119, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtCep = new JTextField();
		txtCep.setBounds(263, 113, 86, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Estado");
		lblNewLabel_6.setBounds(10, 144, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JRadioButton rdbtnLocacao = new JRadioButton("Loca\u00E7\u00E3o");
		rdbtnLocacao.setBounds(3, 165, 109, 23);
		contentPane.add(rdbtnLocacao);
		
		JRadioButton rdbtnVenda = new JRadioButton("Venda");
		rdbtnVenda.setBounds(3, 191, 109, 23);
		contentPane.add(rdbtnVenda);
		
		ButtonGroup locavenda = new ButtonGroup();   
		locavenda.add(rdbtnLocacao);
		locavenda.add(rdbtnVenda);
		 
		JLabel lblNewLabel_7 = new JLabel("Valor");
		lblNewLabel_7.setBounds(207, 169, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		txtValor = new JTextField();
		txtValor.setBounds(263, 166, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		lblID.setText(String.valueOf(i.getIdImovel()));
		txtEndereco.setText(i.getEndereco());
		txtNbairro.setText(i.getNbairro());
		txtCidade.setText(i.getCidade());
		txtCep.setText(i.getCep());
		if(rdbtnLocacao.isSelected()) {
			i.setLocavenda(false);
		}else if (rdbtnVenda.isSelected()) {
			i.setLocavenda(true);
			
		}
		txtValor.setText(i.getValor());
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Imoveis i = new Imoveis();
				ImoveisDAO dao = new ImoveisDAO();
				
				i.setIdImovel(Integer.parseInt(lblID.getText()));
				i.setEndereco(txtEndereco.getText());
				i.setNbairro(txtNbairro.getText());
				i.setCidade(txtCidade.getText());
				i.setCep(txtCep.getText());
				
				if (rdbtnLocacao.isSelected()) {
					i.setLocavenda(false);
				} else if (rdbtnVenda.isSelected()) {
					i.setLocavenda(true);
				}
				
				i.setValor(txtValor.getText());				
				dao.create(i);
				dispose();
			}
		});
		
		btnAlterar.setBounds(23, 221, 109, 23);
		contentPane.add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEndereco.setText(null);
				txtNbairro.setText(null);
				txtCidade.setText(null);
				txtCep.setText(null);
				locavenda.clearSelection();
				txtValor.setText(null);
			}
		});
		
		btnLimpar.setBounds(164, 221, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(292, 221, 89, 23);
		contentPane.add(btnCancelar);
	}


	}

