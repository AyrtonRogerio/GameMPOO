package br.com.gamempoo.model.vo;

import java.awt.Color;
import java.awt.Graphics;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias ("Questoes")

public class Questoes {

	private String tipoQuestao;
	private String pergunta;
	private String resposta;
	private String errada1;
	private String errada2;
	private String errada3;
	
	public Questoes(String tipoQuestao, String pergunta, String resposta, String errada1, String errada2, String errada3) {
		super();
		this.tipoQuestao = tipoQuestao;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.errada1 = errada1;
		this.errada2 = errada2;
		this.errada3 = errada3;
	}
	

	public void cadastrarQuestoes(int tipo) {
		
		
	}
	
	public void buscarQuestoes(int escolha) {
		
		
		
	}
	
	
	public String getPergunta() {
		return pergunta;
	}
	
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	
	public String getResposta() {
		return resposta;
	}
	
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	public String getErrada1() {
		return errada1;
	}
	
	public void setErrada1(String errada1) {
		this.errada1 = errada1;
	}
	
	public String getErrada2() {
		return errada2;
	}
	
	public void setErrada2(String errada2) {
		this.errada2 = errada2;
	}
	
	public String getErrada3() {
		return errada3;
	}
	
	public void setErrada3(String errada3) {
		this.errada3 = errada3;
	}


	public String getTipoQuestao() {
		return tipoQuestao;
	}


	public void setTipoQuestao(String tipoQuestao) {
		this.tipoQuestao = tipoQuestao;
	}

}
