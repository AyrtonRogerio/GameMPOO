package br.com.gamempoo.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public abstract class PanelGenerico extends JPanel {

	

	public PanelGenerico() {
		// TODO Auto-generated constructor stub

		setSize(FrameGenerico.Largura, FrameGenerico.Altura);
		setLayout(null);
		setBackground(Color.GRAY);

	
		setVisible(false);
	}


 
}
