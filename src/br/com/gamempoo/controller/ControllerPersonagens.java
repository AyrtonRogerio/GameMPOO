package br.com.gamempoo.controller;

import br.com.gamempoo.model.vo.Personagem;

public class ControllerPersonagens extends Thread {

	private Personagem personagem;
	int x,y;
	public static String moverPers = "";
	public static  String moverPers2 = "";
	private int var;
	
	public ControllerPersonagens(Personagem personagem, int var) {
		super();
		this.personagem = personagem;
		this.var = var;
		start();
		
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
		try {
			if(var == 1) {
			movimentarPersonagem(moverPers);
			}else if (var == 2) {
			movimentarPersonagem(moverPers2);
			}
			sleep(20);
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
	}
	
	public void movimentarPersonagem(String mover) {
		
//		System.out.println(mover);
		
		switch (mover) {
		case "baixo":{
			personagem.Mover(mover);
			break;
		}
		case "cima":{
			personagem.Mover(mover);
			break;
		}
		case "esquerda":{
			personagem.Mover(mover);
			break;
		}
		case "direita":
			personagem.Mover(mover);
			break;

			
			
		default:
			break;
		}
		
	}



	public Personagem getPersonagem() {
		return personagem;
	}



	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
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



	public  String getMoverPers() {
		return moverPers;
	}



	public static void setMoverPers(String moverPers) {
		moverPers = moverPers;
	}



	public  String getMoverPers2() {
		return moverPers2;
	}



	public static void setMoverPers2(String moverPers2) {
		moverPers2 = moverPers2;
	}
	

}
