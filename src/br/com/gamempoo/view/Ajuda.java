package br.com.gamempoo.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ajuda extends PanelGenerico  {

	private Botoes voltarButton;
	private ImageIcon imgAjuda;
	private Graphics g;

	public Ajuda() {
		
		imgAjuda = new ImageIcon(getClass().getClassLoader().getResource("ajuda.jpg"));
		voltarButton = new Botoes(1010, 585, 5);
		

		
		add(voltarButton);
//		.setBounds(200, 200, 50, 50);
		setVisible(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(imgAjuda.getImage(), 0, 0, null);
	}
	
	public JButton getVoltarButton() {
		return voltarButton;
	}

	public void setVoltarButton(Botoes voltarButton) {
		this.voltarButton = voltarButton;
	}
	
	
}
