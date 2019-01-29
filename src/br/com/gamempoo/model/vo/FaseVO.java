package br.com.gamempoo.model.vo;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class FaseVO {

	private TileMap mapa_camada1;
	private TileMap mapa_camada2;
	private TileMap mapa_camada3;
	private TileMap mapa_camada4;
	private TileMap mapa_camada5;
	
	private Personagem personagem;
	private Personagem personagem2;
	
	private Jogador jogador;
	private Jogador jogador2;
	
	private int tipoMissao;
	private int cont1=0,cont2 =0;
	
	private ArrayList<Item> item;
	private ArrayList<Integer> resposta;

	private ImageIcon imagemGameOver;
	
	
	
	public static ArrayList<Rectangle> colisao, colisaoPassagem;	
	
	private String endereco;	

	public FaseVO(Jogador jogador, Jogador jogador2) {
		// TODO Auto-generated constructor stub
	
		this.jogador = jogador;
		this.jogador2 = jogador2;
				
		
				
		try {
						
			personagem = new Personagem(0, 133, 231, 4, 4, 35, 35, "luke.png");
			personagem2 = new Personagem(0, 138, 193, 4, 4, 35, 35, "darth2.png");
			

			
			item = new ArrayList<>();
						
			mapa_camada1 = new TileMap("StarWarsTileset.png", "terraCamada.txt");
			mapa_camada2 = new TileMap("StarWarsTileset.png", "cenarioCamada.txt");
			mapa_camada3 = new TileMap("StarWarsTileset.png", "colisaoCamada.txt");
			mapa_camada4 = new TileMap("StarWarsTileset.png", "passagemCamada.txt");
			mapa_camada5 = new TileMap("StarWarsTileset.png", "faseCamada.txt");

			colisao = mapa_camada3.montarColi();			
			iniciItem();
			colisaoPassagem = mapa_camada4.montarColi();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Não iniciou as camadas ou personagens");
		}		
	}
	
	private void iniciItem() {
		for (int i = 0; i < 15; i++) {
			int x = (int) (Math.random() * mapa_camada3.getMapaLargura());
			int y = (int) (Math.random() * mapa_camada3.getMapaAltura());
			
			item.add(new Item(x, y, "imagemNumero.jpg"));	
						
		}				
	}
	
	

	public TileMap getMapa_camada1() {
		return mapa_camada1;
	}

	public void setMapa_camada1(TileMap mapa_camada1) {
		this.mapa_camada1 = mapa_camada1;
	}

	public TileMap getMapa_camada2() {
		return mapa_camada2;
	}

	public void setMapa_camada2(TileMap mapa_camada2) {
		this.mapa_camada2 = mapa_camada2;
	}

	public TileMap getMapa_camada3() {
		return mapa_camada3;
	}

	public void setMapa_camada3(TileMap mapa_camada3) {
		this.mapa_camada3 = mapa_camada3;
	}

	public TileMap getMapa_camada4() {
		return mapa_camada4;
	}

	public void setMapa_camada4(TileMap mapa_camada4) {
		this.mapa_camada4 = mapa_camada4;
	}

	public TileMap getMapa_camada5() {
		return mapa_camada5;
	}

	public void setMapa_camada5(TileMap mapa_camada5) {
		this.mapa_camada5 = mapa_camada5;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	public Personagem getPersonagem2() {
		return personagem2;
	}

	public void setPersonagem2(Personagem personagem2) {
		this.personagem2 = personagem2;
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

	public int getTipoMissao() {
		return tipoMissao;
	}

	public void setTipoMissao(int tipoMissao) {
		this.tipoMissao = tipoMissao;
	}

	public ArrayList<Item> getItem() {
		return item;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

	public ArrayList<Integer> getResposta() {
		return resposta;
	}

	public void setResposta(ArrayList<Integer> resposta) {
		this.resposta = resposta;
	}

	public ImageIcon getImagemGameOver() {
		return imagemGameOver;
	}

	public void setImagemGameOver(ImageIcon imagemGameOver) {
		this.imagemGameOver = imagemGameOver;
	}

	

	public int getCont1() {
		return cont1;
	}

	public void setCont1(int cont1) {
		this.cont1 = cont1;
	}

	public int getCont2() {
		return cont2;
	}

	public void setCont2(int cont2) {
		this.cont2 = cont2;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public static ArrayList<Rectangle> getColisao() {
		return colisao;
	}

	public static void setColisao(ArrayList<Rectangle> colisao) {
		FaseVO.colisao = colisao;
	}

	public static ArrayList<Rectangle> getColisaoPassagem() {
		return colisaoPassagem;
	}

	public static void setColisaoPassagem(ArrayList<Rectangle> colisaoPassagem) {
		FaseVO.colisaoPassagem = colisaoPassagem;
	}
	
}
