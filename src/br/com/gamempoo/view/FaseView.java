package br.com.gamempoo.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import br.com.gamempoo.controller.Controller;

public class FaseView extends PanelGenerico{

	private BufferedImage imagemFundo;

	public FaseView() {
		super();

		this.imagemFundo = new BufferedImage(FrameGenerico.Largura-300, FrameGenerico.Altura, BufferedImage.TYPE_4BYTE_ABGR);
		
		setSize(Tela.Largura, Tela.Altura);
		setBounds(0, 0, FrameGenerico.Largura-300, FrameGenerico.Altura);
		requestFocus();
		
		setVisible(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
	
		g.drawImage(imagemFundo, 0, 0, null);
		
	}
	
	public BufferedImage getImagemFundo() {
		return imagemFundo;
	}
		
}
