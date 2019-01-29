package br.com.gamempoo.controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Observable;

import br.com.gamempoo.view.FaseView;




public abstract class Jogo extends Observable implements Runnable {

	private boolean loop = false;
	protected BufferedImage image;
	protected Graphics2D g;
	protected FaseView faseView;
	private Thread thread;
	public final int fps=5;
		
	 public Jogo(FaseView faseView) {
		this.faseView = faseView;
		
	}
	 
	 
	 
	@Override
	public void run() {
		
		g = (Graphics2D) faseView.getGraphics();
		faseView.requestFocus();
		
		while(true){
			
			if(loop) {
				
//				faseView.repaint();
				gameDraw(g);
				gameRender();				
			}
			
			try {
							
				Thread.sleep(30);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public abstract void gameDraw(Graphics g);
	public abstract void gameRender();
	public abstract void init();
	
	public void start() {
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
			
		}
		loop = true;
	}
	
	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	
}
