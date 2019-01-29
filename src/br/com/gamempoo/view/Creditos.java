package br.com.gamempoo.view;

import javax.swing.ImageIcon;

import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Creditos extends PanelGenerico {

	private Botoes voltarButton;
	private ImageIcon imgCredito;
	private Graphics g;
	public Creditos() {
		// TODO Auto-generated constructor stub
	
		
		imgCredito = new ImageIcon(getClass().getClassLoader().getResource("creditos.jpg"));
		voltarButton = new Botoes(1010, 585, 5);
		
		add(voltarButton);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
	
		g.drawImage(imgCredito.getImage(), 0, 0, null);
		
	}
	
	public Botoes getVoltarButton() {
		return voltarButton;
	}
	public void setVoltarButton(Botoes voltarButton) {
		this.voltarButton = voltarButton;
	}
	
	
}
