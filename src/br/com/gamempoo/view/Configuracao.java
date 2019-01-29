package br.com.gamempoo.view;

import javax.swing.JButton;

public class Configuracao extends PanelGenerico {

	
	private Botoes voltarButton;
	
	public Configuracao() {
		// TODO Auto-generated constructor stub
	
		voltarButton = new Botoes(1010, 585, 5);
		
		add(voltarButton);
		
		setVisible(false);
	}

	public Botoes getVoltarButton() {
		return voltarButton;
	}

	public void setVoltarButton(Botoes voltarButton) {
		this.voltarButton = voltarButton;
	}
	
	
}
