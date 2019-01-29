package br.com.gamempoo.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastrarPerguntas extends PanelGenerico {

	private JLabel perguntaLabel, respLabel, err1Label, err2Label, err3Label, assuntoLabel;
	
	private JTextField perguntaField, respField, err1Field, err2Field, err3Field;
	
	private JComboBox<String> tipoDeAssunto;
	
	private Botoes voltarButton, confirmarButton;
	
	public CadastrarPerguntas() {
		// TODO Auto-generated constructor stub
	
		
		perguntaLabel = new JLabel("Pergunta:");
		respLabel = new JLabel("Resposta:");
		err1Label = new JLabel("Erro 1:");
		err2Label = new JLabel("Erro 2:");
		err3Label = new JLabel("Erro 3:");
		assuntoLabel = new JLabel("Assunto:");
		
		perguntaField = new JTextField(10);
		respField = new JTextField(10);
		err1Field = new JTextField(10);
		err2Field = new JTextField(10);
		err3Field = new JTextField(10);
		
		tipoDeAssunto = new JComboBox<>();
		
		tipoDeAssunto.addItem("Matematica");
		tipoDeAssunto.addItem("Portugues");
		tipoDeAssunto.addItem("Historia");
		tipoDeAssunto.addItem("Quimica");
		
		confirmarButton = new Botoes(540, 360, 11);
		
		voltarButton = new Botoes(1010, 585, 5);
		
		
		perguntaLabel.setFont(new Font("Arial", Font.BOLD, 20));
		assuntoLabel.setFont(new Font("Arial", Font.BOLD, 20));
		respLabel.setFont(new Font("Arial", Font.BOLD, 20));
		err1Label.setFont(new Font("Arial", Font.BOLD, 20));
		err2Label.setFont(new Font("Arial", Font.BOLD, 20));
		err3Label.setFont(new Font("Arial", Font.BOLD, 20));
		
		
		add(assuntoLabel).setBounds(450, 60, 100, 25);
		add(tipoDeAssunto).setBounds(550, 60, 120, 30);
		
		add(perguntaLabel).setBounds(450, 100, 120, 50);
		add(perguntaField).setBounds(550, 110, 120, 30);
		
		add(respLabel).setBounds(450, 150, 120, 50);
		add(respField).setBounds(550, 160, 120, 30);
		
		add(err1Label).setBounds(450, 200, 120, 50);
		add(err1Field).setBounds(520, 210, 150, 30);
		
		add(err2Label).setBounds(450, 250, 120, 50);
		add(err2Field).setBounds(520, 260, 150, 30);
		
		add(err3Label).setBounds(450, 300, 150, 30);
		add(err3Field).setBounds(520, 310, 150, 30);
		
		add(confirmarButton);
		add(voltarButton);
		
		setForeground(new Color(65, 65, 65));
		
	}

	public JLabel getPerguntaLabel() {
		return perguntaLabel;
	}

	public JLabel getRespLabel() {
		return respLabel;
	}

	public JLabel getErr1Label() {
		return err1Label;
	}

	public JLabel getErr2Label() {
		return err2Label;
	}

	public JLabel getErr3Label() {
		return err3Label;
	}

	public JLabel getAssuntoLabel() {
		return assuntoLabel;
	}

	public JTextField getPerguntaField() {
		return perguntaField;
	}

	public JTextField getRespField() {
		return respField;
	}

	public JTextField getErr1Field() {
		return err1Field;
	}

	public JTextField getErr2Field() {
		return err2Field;
	}

	public JTextField getErr3Field() {
		return err3Field;
	}

	public JComboBox<String> getTipoDeAssunto() {
		return tipoDeAssunto;
	}

	public Botoes getVoltarButton() {
		return voltarButton;
	}

	public Botoes getConfirmarButton() {
		return confirmarButton;
	}
	
}
