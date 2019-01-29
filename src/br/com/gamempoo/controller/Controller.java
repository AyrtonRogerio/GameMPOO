package br.com.gamempoo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;

import br.com.gamempoo.model.dao.Dao;
import br.com.gamempoo.model.vo.FaseVO;
import br.com.gamempoo.model.vo.Jogador;
import br.com.gamempoo.model.vo.Personagem;
import br.com.gamempoo.view.Ajuda;
import br.com.gamempoo.view.CadastrarPerguntas;
import br.com.gamempoo.view.Configuracao;
import br.com.gamempoo.view.Creditos;
import br.com.gamempoo.view.FaseView;
import br.com.gamempoo.view.Inventario;
import br.com.gamempoo.view.Tela;
import br.com.gamempoo.view.TelaPanel;

public class Controller implements KeyListener, ActionListener, MouseListener {

	Tela tela;// Frame
	TelaPanel telaPanel;// Panel
	Ajuda ajuda;// Panel
	Configuracao configuracao;// Panel
	Creditos creditos;// Panel
	FaseView faseView;// Panel
	Inventario inventario;
	CadastrarPerguntas cadastrarPerguntas;
	
	FaseVO faseVO;// Model

	Personagem personagem;// Model

	Jogador jogador;// Model
	Jogador jogador2;// Model

	ControllerFase controllerFase;// Controle que pinta o tiled
	ControllerPersonagens controllerPers, controllerPers2;// Controle dos personagens

	public Controller(Tela tela, TelaPanel telaPanel, Ajuda ajuda, Configuracao configuracao, Creditos creditos,
			ControllerFase controllerFase, FaseVO faseVO, FaseView faseView, Jogador jogador, Jogador jogador2,
			Inventario inventario, CadastrarPerguntas cadastrarPerguntas) {
		super();

		this.tela = tela;
		this.telaPanel = telaPanel;
		this.ajuda = ajuda;
		this.configuracao = configuracao;
		this.creditos = creditos;
		this.jogador = jogador;
		this.jogador2 = jogador2;
		this.controllerFase = controllerFase;
		this.faseVO = faseVO;
		this.faseView = faseView;
		this.inventario = inventario;
		this.cadastrarPerguntas = cadastrarPerguntas;
		this.controllerFase = controllerFase;

		this.telaPanel.getSinglePlayerButton().addActionListener(this);
		this.telaPanel.getMultiPlayerButton().addActionListener(this);
		this.telaPanel.getAjudaButton().addActionListener(this);
		this.telaPanel.getConfigButton().addActionListener(this);
		this.telaPanel.getCreditosButton().addActionListener(this);
		this.telaPanel.getCadastrarButton().addActionListener(this);
		this.telaPanel.getSairButton().addActionListener(this);
		

		this.ajuda.getVoltarButton().addActionListener(this);

		this.configuracao.getVoltarButton().addActionListener(this);

		this.creditos.getVoltarButton().addActionListener(this);

		this.cadastrarPerguntas.getConfirmarButton().addActionListener(this);
		this.cadastrarPerguntas.getVoltarButton().addActionListener(this);
		
		this.inventario.getVoltarButton().addActionListener(this);
		
		faseView.addKeyListener(this);
		faseView.requestFocus();
		controllerPers = new ControllerPersonagens(faseVO.getPersonagem(), 1);
		controllerPers2 = new ControllerPersonagens(faseVO.getPersonagem2(), 2);

		System.out.println("constru controler");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == telaPanel.getSinglePlayerButton()) {

			tela.getCardL().show(tela.getContentPane(), "p");

			inventario.getJogador().setNome(telaPanel.getNome1Field().getText()); 
			controllerFase.start();
			Collections.shuffle(Dao.questoes);
			faseView.requestFocus();
			System.out.println("inicio");
		}

		if (e.getSource() == telaPanel.getMultiPlayerButton()) {

			inventario.getJogador().setNome(telaPanel.getNome1Field().getText());
			inventario.getJogador2().setNome(telaPanel.getNome2Field().getText());
			tela.getCardL().show(tela.getContentPane(), "p");

			controllerFase.start();
			controllerFase.setMultiplayer(true);
			Collections.shuffle(Dao.questoes);
			faseView.requestFocus();
		}

		if (e.getSource() == telaPanel.getAjudaButton()) {

			tela.getCardL().show(tela.getContentPane(), "a");
			
		}

		if(e.getSource() == ajuda.getVoltarButton()) {
			tela.getCardL().show(tela.getContentPane(), "m");
		}
		if (e.getSource() == telaPanel.getConfigButton()) {

		}

		if (e.getSource() == telaPanel.getCreditosButton()) {

			tela.getCardL().show(tela.getContentPane(), "c");
		}
		
		if(e.getSource() == telaPanel.getCadastrarButton()) {
			
			tela.getCardL().show(tela.getContentPane(), "cd");
		}
		
		if(e.getSource() == cadastrarPerguntas.getVoltarButton()) {
			
			tela.repaint();
			tela.getCardL().show(tela.getContentPane(),"m");
		}
		
		if(e.getSource() == cadastrarPerguntas.getConfirmarButton()) {
			
		}

		if (e.getSource() == telaPanel.getSairButton()) {

			System.exit(0);
		}

		
		if(e.getSource() == tela.getInventario().getVoltarButton()) {
			controllerFase.setLoop(false);
			tela.repaint();
			tela.getCardL().show(tela.getContentPane(), "m");
		}
		
		if(e.getSource() == creditos.getVoltarButton()) {
			
			tela.getCardL().show(tela.getContentPane(), "m");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		int codigo = e.getKeyCode();

		switch (codigo) {
		case KeyEvent.VK_UP: {

			ControllerPersonagens.moverPers = "cima";

			break;
		}
		case KeyEvent.VK_DOWN: {
			ControllerPersonagens.moverPers = "baixo";

			break;
		}
		case KeyEvent.VK_LEFT: {
			ControllerPersonagens.moverPers = "esquerda";

			break;
		}
		case KeyEvent.VK_RIGHT: {
			ControllerPersonagens.moverPers = "direita";
			System.out.println("personagem");
			break;
		}

		case KeyEvent.VK_W: {
			ControllerPersonagens.moverPers2 = "cima";

			break;
		}

		case KeyEvent.VK_S: {
			ControllerPersonagens.moverPers2 = "baixo";

			break;
		}

		case KeyEvent.VK_A: {
			ControllerPersonagens.moverPers2 = "esquerda";

			break;
		}

		case KeyEvent.VK_D: {
			ControllerPersonagens.moverPers2 = "direita";

			break;
		}
		// case KeyEvent.VK_ENTER:{
		// if(fase_inicial.isGameOVer() == true) {
		// System.exit(0);
		// }
		// }

		default: {

			break;
		}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		int codigo = e.getKeyCode();

		switch (codigo) {
		case KeyEvent.VK_UP: {

			ControllerPersonagens.moverPers = "stop";

			break;
		}
		case KeyEvent.VK_DOWN: {
			ControllerPersonagens.moverPers = "stop";
			break;
		}
		case KeyEvent.VK_LEFT: {
			ControllerPersonagens.moverPers = "stop";
			break;
		}
		case KeyEvent.VK_RIGHT: {
			ControllerPersonagens.moverPers = "stop";
			break;
		}

		case KeyEvent.VK_W: {
			ControllerPersonagens.moverPers2 = "stop";
			break;
		}
		case KeyEvent.VK_S: {
			ControllerPersonagens.moverPers2 = "stop";
			break;
		}
		case KeyEvent.VK_A: {
			ControllerPersonagens.moverPers2 = "stop";
			break;
		}
		case KeyEvent.VK_D: {
			ControllerPersonagens.moverPers2 = "stop";
			break;
		}

		default: {
			break;
		}

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == telaPanel.getSairButton()) {
			System.exit(0);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
