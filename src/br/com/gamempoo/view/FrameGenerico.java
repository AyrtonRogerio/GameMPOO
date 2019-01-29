package br.com.gamempoo.view;

import javax.swing.JFrame;

public abstract class FrameGenerico extends JFrame {

	public static final int Largura = 1100;
	public static final int Altura = 700;
	
	
	public FrameGenerico() {
		// TODO Auto-generated constructor stub
	
		setSize(Largura, Altura);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(false);
		setVisible(false);
		
		
	}
	
}
