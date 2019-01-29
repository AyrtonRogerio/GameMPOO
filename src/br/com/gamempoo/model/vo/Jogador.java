package br.com.gamempoo.model.vo;

public class Jogador {

	private String nome;
	private int pontos, vida = 100, score, acerto, erro;
	
	
	
	public Jogador(String nome) {
		super();
		this.nome = nome;
	}


	public Jogador() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}


	public int getAcerto() {
		return acerto;
	}


	public void setAcerto(int acerto) {
		this.acerto = acerto;
	}


	public int getErro() {
		return erro;
	}


	public void setErro(int erro) {
		this.erro = erro;
	}
	
	
}
