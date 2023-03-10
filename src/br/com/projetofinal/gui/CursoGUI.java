package br.com.projetofinal.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import br.com.projetofinal.dao.CursoDAO;
import br.com.projetofinal.pojo.Curso;

public class CursoGUI extends JFrame implements ActionListener {
	private JButton btnCadastrar;
	private JButton btnPesquisar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JPanel pnlBotoes;
	private JPanel pnlComponentes;
	private JTextField txtCurso;
	private JTextField txtCargaHoraria;
	private JLabel lblCurso;
	private JLabel lblTempoMin;
	
	public CursoGUI() {
		// Tratar o evento do butão
		btnCadastrar = new JButton("Cadastrar");
		btnPesquisar = new JButton("Pesquisar");
		btnAlterar = new JButton("Alterar");
		btnExcluir = new JButton("Excluir");
		
		// Atributindo o botão ao container
		getContentPane().add(btnCadastrar);
		getContentPane().add(btnPesquisar);
		getContentPane().add(btnAlterar);
		getContentPane().add(btnExcluir);
		
		setLayout(new BorderLayout(1,4));
		
		setSize(800,600);
		pnlBotoes = new JPanel();
		pnlBotoes.setLayout(new GridLayout(1,4));
		
		btnCadastrar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnExcluir.addActionListener(this);
		
		pnlBotoes.add(btnCadastrar);
		pnlBotoes.add(btnPesquisar);
		pnlBotoes.add(btnAlterar);
		pnlBotoes.add(btnExcluir);
		

		pnlComponentes = new JPanel();
		pnlComponentes.setBackground(Color.CYAN);
		pnlComponentes.setLayout(new FlowLayout());
		
		txtCurso = new JTextField(40);
		txtCargaHoraria = new JTextField(20);
		lblCurso = new JLabel("Curso");
		lblTempoMin = new JLabel("Tempo Min..");

		pnlComponentes.add(lblCurso);
		pnlComponentes.add(txtCurso);
		pnlComponentes.add(lblTempoMin);
		pnlComponentes.add(txtCargaHoraria);
		
		
		
		getContentPane().add(pnlBotoes, BorderLayout.NORTH);
		getContentPane().add(pnlComponentes, BorderLayout.WEST);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCadastrar) {
			try {
				if((txtCurso.getText() .equals("")) && txtCargaHoraria.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campos obrigatórios");
				}else {
					String nome = txtCurso.getText();
					int cargaHoraria = Integer.parseInt(txtCargaHoraria.getText());
					new CursoDAO() .cadastrar(new Curso(nome,cargaHoraria));
					JOptionPane.showMessageDialog(null, "Cadastrou");
					txtCurso.setText("");
					txtCargaHoraria.setText("");
				}
				
				
				

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Alguma falha na conexão");

			}finally {

			}
		}else if(e.getSource() == btnPesquisar) {
			JOptionPane.showMessageDialog(null, "Pesquisou");
			
		}else if(e.getSource() == btnAlterar) {
			JOptionPane.showMessageDialog(null, "Alterou");
		
		}else {
			
		}
		
		
	}

}
