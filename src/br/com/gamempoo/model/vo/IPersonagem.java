package br.com.gamempoo.model.vo;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public interface IPersonagem {

	public void Animar(String direcao);
	
	public void Mover(String direcao);
	
	public void Draw(Graphics2D g);
	
	public boolean collision(ArrayList<Rectangle> tmp, int x,int y);
	
}
