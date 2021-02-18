package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class JFCadastrarImoveis extends JFrame {


	private JPanel contentPane;
	private JTextField txtEndereco;
	private JTextField txtNbairro;
	private JTextField txtCidade;
	private JTextField txtCep;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarImoveis frame = new JFCadastrarImoveis();
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
	public JFCadastrarImoveis() {  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);     
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		   
		JLabel lblNewLabel = new JLabel("Cadastro de Im\u00F3veis");
		lblNewLabel.setBounds(161, 11, 107, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o");
		lblNewLabel_1.setBounds(20, 36, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(100, 36, 86, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00B0 Bairro");
		lblNewLabel_2.setBounds(20, 71, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNbairro = new JTextField();
		txtNbairro.setBounds(85, 67, 86, 20);
		contentPane.add(txtNbairro);
		txtNbairro.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cidade");
		lblNewLabel_3.setBounds(20, 105, 70, 14);
		contentPane.add(lblNewLabel_3);
		
		txtCidade = new JTextField();
		txtCidade.setText("");
		txtCidade.setBounds(75, 102, 86, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CEP");
		lblNewLabel_4.setBounds(222, 105, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtCep = new JTextField();
		txtCep.setText("");
		txtCep.setBounds(269, 102, 86, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Estado");
		lblNewLabel_5.setBounds(20, 130, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton rdbtnLocacao = new JRadioButton("Loca\u00E7\u00E3o");
		rdbtnLocacao.setBounds(20, 150, 109, 23);
		contentPane.add(rdbtnLocacao);
		
		JRadioButton rdbtnVenda = new JRadioButton("Venda");
		rdbtnVenda.setBounds(20, 176, 109, 23);
		contentPane.add(rdbtnVenda);
		
		ButtonGroup locavenda = new ButtonGroup();
		locavenda.add(rdbtnLocacao);
		locavenda.add(rdbtnVenda);
		
		JLabel lblNewLabel_6 = new JLabel("Valor do Im\u00F3vel");
		lblNewLabel_6.setBounds(186, 154, 135, 14);
		contentPane.add(lblNewLabel_6);
		
		txtValor = new JTextField();
		txtValor.setText("");
		txtValor.setBounds(282, 151, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(279, 216, 107, 23);
		contentPane.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Imoveis i = new Imoveis();
				ImoveisDAO dao = new ImoveisDAO();
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
		btnCadastrar.setBounds(29, 216, 107, 23);
		contentPane.add(btnCadastrar);
	
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
		btnLimpar.setBounds(146, 216, 122, 23);
		contentPane.add(btnLimpar);
		
		
		};
		
	}