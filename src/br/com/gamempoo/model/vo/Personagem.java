package br.com.gamempoo.model.vo;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;



public class Personagem extends Sprite implements IPersonagem {

	public Personagem(int aparencia, int width, int height, int columns, int rows, int x, int y, String endereco)
			throws IOException {
		super(aparencia, width, height, columns, rows, x, y, endereco);
		// TODO Auto-generated constructor stub
	}

	
	public void Animar(String direcao) {
		// TODO Auto-generated method stub
		setAparencia(getAparencia()+1);
		switch (direcao) {
		case "baixo":
			if(getAparencia() < 8 || getAparencia() > 11) {
				setAparencia(8);
			}
			
			break;
		case "cima":
			if(getAparencia() < 12 || getAparencia() > 15) {
				setAparencia(12);
			}


			break;
		case "esquerda":
			if(getAparencia() < 4 || getAparencia() > 7) {
				setAparencia(4);
			}


			break;
		case "direita":
			if(getAparencia() < 0 || getAparencia() > 3) {
				setAparencia(0);
			}

			break;

		default:
			break;
		}
		
	}

	
	public void Mover(String direcao) {
		// TODO Auto-generated method stub
		
		switch (direcao) {
		case "baixo":
//			if(getY() < 1410)
			setY(getY()+4);
			Animar(direcao);
			break;
		case "cima":
			if(getY() > 0)
			setY(getY()-4);
			Animar(direcao);
			break;
		case "esquerda":
			if(getX() > 0)
			setX(getX()-4);
			Animar(direcao);
			break;
		case "direita":
//			if(getX() < 1350)
			setX(getX()+4);
			Animar(direcao);
			break;

		default:
			break;
		}
	}

	
	public void Draw(Graphics2D g) {
		// TODO Auto-generated method stub
//		if()
		g.drawImage(getSprites()[getAparencia()], getX(), getY(), null);
	}

	public boolean collision(ArrayList<Rectangle> tmp, int x,int y) {
		Rectangle personagem=new Rectangle(getX()+x, getY()+y, getLarguraPersonagem(), getAlturaPersonagem());
		for (Rectangle rectangle : tmp) {
			if(rectangle.intersects(personagem)){
//				System.out.println("colidiu");
				return true;
			}
			
				
		}
		return false;

	}
	
	public  Rectangle getBounds() {
		return new Rectangle(x, y, getLarguraPersonagem(), getAlturaPersonagem());
	}
	
	@Override
	public void setX(int x) {
	if(!collision(FaseVO.colisao,x-this.x,0))
		this.x=x;
	}

	@Override
	public void setY(int y) {
		if(!collision(FaseVO.colisao,0,y-this.y))
			this.y=y;
	}
	
	
}
