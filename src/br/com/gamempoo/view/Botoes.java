package br.com.gamempoo.view;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import br.com.gamempoo.model.vo.Sprite;

public class Botoes extends JButton {

	private Sprite imgButton = new Sprite(0, 149, 700, 2, 9, 0, 0, "botoesMenu2.jpg");
	
	private int x;
	private int y;
	private int icon;
	private int largura;
	private int altura;
	
	
	public Botoes(int x, int y, int icon) {
		
		this.x = x;
		this.y = y;
		this.icon = icon;
		
		largura = imgButton.getSprites()[icon].getWidth();
		altura = imgButton.getSprites()[icon].getHeight();
		
		
		// Transaformando a img do vetor em um imageIcon.
		setIcon(new ImageIcon(imgButton.getSprites()[icon]));
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		
		setBounds(x, y, largura, altura);
		
		
	}
	
	
	public void drawImageIcon(Graphics g) {
		
		// Pintando a img na tela, pegando a img e passando o indice do icone.
		g.drawImage(imgButton.getSprites()[icon], x, y, null);
	}
	
}
