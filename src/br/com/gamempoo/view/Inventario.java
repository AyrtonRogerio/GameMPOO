package br.com.gamempoo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;

import br.com.gamempoo.model.vo.FaseVO;
import br.com.gamempoo.model.vo.Jogador;
import br.com.gamempoo.model.vo.Personagem;

public class Inventario extends PanelGenerico implements Observer {

	BufferedImage imagemInventario;
	private Jogador jogador;
	private Jogador jogador2;

	private ImageIcon imgIventario;
	private ImageIcon imgVida;
	private ImageIcon imgPontos;
	private boolean multiplayer;
	private Botoes voltarButton;
	
	public Inventario(Jogador jogador, Jogador jogador2) {

		
		setLayout(null);

		
		this.jogador = jogador;
		this.jogador2 = jogador2;


		voltarButton = new Botoes(100, 585, 5);
		
		add(voltarButton);
		imgIventario = new ImageIcon(getClass().getClassLoader().getResource("inventario.png"));
		imgVida = new ImageIcon(getClass().getClassLoader().getResource("vida.png"));
		imgPontos = new ImageIcon(getClass().getClassLoader().getResource("pontos.png"));
		setVisible(false);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub

		g.drawImage(imgIventario.getImage(), 0, 0, null);

		
		g.setFont(new Font("Arial", Font.BOLD, 17));
		g.setColor(Color.WHITE);
		g.drawString("Player: " + jogador.getNome(), 10, 70);
		g.drawString("Hits: " + jogador.getAcerto(), 10, 100);
		g.drawString("Error: " + jogador.getErro(), 10, 120);
		g.drawImage(imgPontos.getImage(), 160, 50, null);
		g.drawString("" + jogador.getScore(), 235, 85);

		if (multiplayer) {
			
		
			g.setFont(new Font("Arial", Font.BOLD, 17));
			g.setColor(Color.WHITE);
			g.drawString("Player 2: " + jogador2.getNome(), 10, 400);
			g.drawString("Hits: " + jogador2.getAcerto(), 10, 430);
			g.drawString("Error: " + jogador2.getErro(), 10, 450);
			g.drawImage(imgPontos.getImage(), 160, 380, null);
			g.drawString("" + jogador2.getScore(), 235, 415);
		}
		
		if (jogador.getVida() >= 50) {
			g.setColor(Color.GREEN);
		} else if ((jogador.getVida() < 50) && (jogador.getVida() > 30)) {
			g.setColor(Color.YELLOW);
		} else if ((jogador.getVida() <= 30) && (jogador.getVida() > 10)) {
			g.setColor(Color.ORANGE);
		} else if (jogador.getVida() <= 10) {
			g.setColor(Color.RED);
		}
		if (jogador.getVida() > 0) {
			g.drawImage(imgVida.getImage(), 15, 11, null);
			g.drawString(jogador.getVida() + "%", 180, 36);
														
		} else {
			g.drawString(0 + "%", 180, 36);
		}
		g.drawRect(70, 20, 100, 20);
		g.fillRect(70, 20, jogador.getVida(), 20);
		
		if(multiplayer) {
		if (jogador2.getVida() >= 50) {
			g.setColor(Color.GREEN);
		} else if ((jogador2.getVida() < 50) && (jogador2.getVida() > 30)) {
			g.setColor(Color.YELLOW);
		} else if ((jogador2.getVida() <= 30) && (jogador2.getVida() > 10)) {
			g.setColor(Color.ORANGE);
		} else if (jogador2.getVida() <= 10) {
			g.setColor(Color.RED);
		}
		if (jogador2.getVida() > 0) {
			g.drawImage(imgVida.getImage(), 15, 340, null);
			g.drawString(jogador2.getVida() + "%", 180, 366);
														
		} else {
			g.drawString(0 + "%", 180, 366);
		}
		g.drawRect(70, 350, 100, 20);
		g.fillRect(70, 350, jogador2.getVida(), 20);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof Boolean) {
			 multiplayer = (Boolean) arg;
		}
	}
	public BufferedImage getImagemInventario() {
		return imagemInventario;
	}

	public void setImagemInventario(BufferedImage imagemInventario) {
		this.imagemInventario = imagemInventario;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}



	public ImageIcon getImgIventario() {
		return imgIventario;
	}

	public void setImgIventario(ImageIcon imgIventario) {
		this.imgIventario = imgIventario;
	}

	public ImageIcon getImgVida() {
		return imgVida;
	}

	public void setImgVida(ImageIcon imgVida) {
		this.imgVida = imgVida;
	}

	public ImageIcon getImgPontos() {
		return imgPontos;
	}

	public void setImgPontos(ImageIcon imgPontos) {
		this.imgPontos = imgPontos;
	}

	public Botoes getVoltarButton() {
		return voltarButton;
	}

	public void setVoltarButton(Botoes voltarButton) {
		this.voltarButton = voltarButton;
	}


}
