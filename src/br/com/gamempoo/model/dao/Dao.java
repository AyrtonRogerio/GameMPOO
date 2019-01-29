package br.com.gamempoo.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

import br.com.gamempoo.model.vo.Questoes;

public class Dao {

	private static XStream xStream = new XStream(new Dom4JDriver());
	private static File file = new File("res/Questoes.xml");
	public static ArrayList<Questoes> questoes = lerArquivo();

	private String perg, respC, respEr1,respEr2,respEr3;
	private Questoes questoes2;
	
	public void salvarPerguntas() {
		// Definido o que vai salvar
		xStream.alias("Questoes", Questoes.class);
		// Criando o caminho do arquivo

		// Para gravar no arquivo..

		try {
			// se o arquivo n existir, cria ele.
			if (!(file.exists())) {
				file.createNewFile();
			}
			// se ele ja existe, sobrescreve o arquivo.
			else {
				// Deleta o arquivo e o cria novamente, assim, sobrescrevendo.
				file.delete();
				file.createNewFile();
			}
			OutputStream outputStream = new FileOutputStream(file);
			// Passa o que sera salvo e o caminho. obs.: o outputStream sera usado pra
			// salvar o objeto(lista questoes).
			xStream.toXML(questoes, outputStream);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Questoes> lerArquivo() {
			
	
		try {
			if (!(file.exists())) {
				file.createNewFile();
			}

			else {
				xStream.alias("Questoes", Questoes.class);
				// Armazenando no array questoes os dados que tem no arquivo.
				questoes = (ArrayList<Questoes>) xStream.fromXML(file);
				
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return questoes;
	}

	public String getPerg() {
		return perg;
	}

	public void setPerg(String perg) {
		this.perg = perg;
	}

	public String getRespC() {
		return respC;
	}

	public void setRespC(String respC) {
		this.respC = respC;
	}

	public String getRespEr1() {
		return respEr1;
	}

	public void setRespEr1(String respEr1) {
		this.respEr1 = respEr1;
	}

	public String getRespEr2() {
		return respEr2;
	}

	public void setRespEr2(String respEr2) {
		this.respEr2 = respEr2;
	}

	public String getRespEr3() {
		return respEr3;
	}

	public void setRespEr3(String respEr3) {
		this.respEr3 = respEr3;
	}
	
}
