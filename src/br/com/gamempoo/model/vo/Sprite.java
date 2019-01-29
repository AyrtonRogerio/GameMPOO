package br.com.gamempoo.model.vo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public  class Sprite {

	BufferedImage personagem;
	
	private int largura, altura;
	private int rows, columns;
	protected int x;
	
	protected int y;
	private BufferedImage[] sprites;
	private int aparencia;
	private int larguraPersonagem;
	private int alturaPersonagem;
	
	public Sprite(int aparencia, int width, int height, int columns, int rows, int x, int y,String endereco){
		this.aparencia=aparencia;
		this.largura = width;
		this.altura = height;
		
		this.rows = columns;
		this.columns = rows;
		this.x=x;
		this.y=y;
		
		try {
			personagem = ImageIO.read(getClass().getClassLoader().getResourceAsStream(endereco) );
		} catch (IOException e) {
			System.out.println("Problema ao inicializar: "+endereco);
			e.printStackTrace();
		}
		sprites = new BufferedImage[columns * rows];
		
		for(int i = 0; i < columns; i++) {
			for(int j = 0; j < rows; j++) {
				sprites[(i * rows) + j] = personagem.getSubimage(i * width/columns, j * height/rows, width/columns, height/rows);
			}
		}
		alturaPersonagem = sprites[0].getHeight();
		larguraPersonagem = sprites[0].getWidth();
	}

	public BufferedImage getPersonagem() {
		return personagem;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage[] getSprites() {
		return sprites;
	}

	public int getAparencia() {
		return aparencia;
	}

	public void setAparencia(int aparencia) {
		this.aparencia = aparencia;
	}

	public int getLarguraPersonagem() {
		return larguraPersonagem;
	}

	public int getAlturaPersonagem() {
		return alturaPersonagem;
	}
	
	public void setSprites(BufferedImage[] sprites) {
		this.sprites = sprites;
	}
	

	
	
}
