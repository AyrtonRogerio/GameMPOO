package br.com.gamempoo.model.vo;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;



public class Item {
	private int x = 0,y = 0;
	private int Altura, Largura;
	private boolean visibilidade;
	private BufferedImage itens;
	
	public Item(int x, int y, String endereco) {
		super();
		setX(x);
		setY(y);
		try {
			itens = ImageIO.read(getClass().getClassLoader().getResourceAsStream(endereco));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Altura = itens.getHeight();
		Largura = itens.getWidth();
		visibilidade = true;

	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, Largura, Altura);
	}
		
	public boolean collisionItem(ArrayList<Rectangle> tmp, int x,int y) {
		Rectangle itemRectangle=new Rectangle(getX()+x, getY()+y, getLargura(), getAltura());
		for (Rectangle rectangle : tmp) {
			if(rectangle.intersects(itemRectangle)){
//				System.out.println("colidiu item cert");
				return true;
			}
		}
//		System.out.println("nao colidiu item cert");
		return false;
	}
	

	
	public void setX(int x) {
	if(!collisionItem(FaseVO.colisao,x-this.x,0))
		this.x=x;
	else 
	{
		this.x=x;
		this.y = x+10;
//		System.out.println("colis item cert");
	}		
	}
	
	public void setY(int y) {
		if(!collisionItem(FaseVO.colisao,0,y-this.y))
			this.y=y;
		else
		{
			this.y=y;
			this.x = y+10;
//			System.out.println("colis item cert");
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAltura() {
		return Altura;
	}

	public int getLargura() {
		return Largura;
	}

	public BufferedImage getItens() {
		return itens;
	}

	public boolean isVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}	

}
