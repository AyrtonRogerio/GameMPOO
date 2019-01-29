package br.com.gamempoo.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import br.com.gamempoo.model.dao.Dao;
import br.com.gamempoo.model.vo.FaseVO;
import br.com.gamempoo.model.vo.Item;
import br.com.gamempoo.model.vo.Jogador;
import br.com.gamempoo.model.vo.Personagem;
import br.com.gamempoo.model.vo.Questoes;
import br.com.gamempoo.model.vo.TileMap;
//import br.com.gamempoo.view.Fase;
import br.com.gamempoo.view.FaseView;
import br.com.gamempoo.view.FrameGenerico;
import br.com.gamempoo.view.Inventario;
import br.com.gamempoo.view.Missao;

public class ControllerFase extends Jogo implements MouseListener {

	private FaseView faseView;

	private Inventario inventario;

	private Personagem personagem, personagem2;

	private TileMap mapa_camada1;
	private TileMap mapa_camada2;
	private TileMap mapa_camada3;
	private TileMap mapa_camada4;
	private TileMap mapa_camada5;

	private Item i;

	static int x = 0;
	static int y = 0;
	static int dx = 0;
	static int dy = 0;

	private boolean evento = true;

	BufferedImage tela;
	private Graphics2D graphicsMapa;

	private ArrayList<Item> itens;

	private Jogador jogador, jogador2;

	private ImageIcon imgGameOver;
	public boolean multiplayer, gameOver, ganhou;

	private Missao missao;

	int varTemp = 0;

	private Questoes questao;

	public ControllerFase(TileMap mapa_camada1, TileMap mapa_camada2, TileMap mapa_camada3, TileMap mapa_camada4,
			TileMap mapa_camada5, Personagem personagem, Personagem personagem2, FaseView faseView,
			ArrayList<Item> itens, Jogador jogador, Jogador jogador2, Missao missao, Inventario inventario) {

		super(faseView);

		multiplayer = false;
		gameOver = false;
		ganhou = false;

		this.personagem = personagem;
		this.personagem2 = personagem2;

		this.inventario = inventario;
		this.mapa_camada1 = mapa_camada1;
		this.mapa_camada2 = mapa_camada2;
		this.mapa_camada3 = mapa_camada3;
		this.mapa_camada4 = mapa_camada4;
		this.mapa_camada5 = mapa_camada5;

		this.jogador = jogador;
		this.jogador2 = jogador2;

		this.itens = itens;

		this.missao = missao;

		this.missao.getRespLabel().addMouseListener(this);
		this.missao.getErr1Label().addMouseListener(this);
		this.missao.getErr2Label().addMouseListener(this);
		this.missao.getErr3Label().addMouseListener(this);
		this.missao.getCancelarButton().addMouseListener(this);

		tela = new BufferedImage(mapa_camada1.getMapaLargura(), mapa_camada1.getMapaAltura(),
				BufferedImage.TYPE_4BYTE_ABGR);
		graphicsMapa = (Graphics2D) tela.getGraphics();

		imgGameOver = new ImageIcon("res/gameover.jpg");
	}

	@Override
	public void gameDraw(Graphics g) {
		// TODO Auto-generated method stub
		// if (personagem.getX() > FrameGenerico.Largura / 2)
		// if (personagem.getX() < (mapa_camada1.getMapaLargura() -
		// FrameGenerico.Largura / 2))
		// x = personagem.getX() - (FrameGenerico.Largura / 2);
		// if (personagem.getY() > FrameGenerico.Altura / 2)
		// if (personagem.getY() < (mapa_camada1.getMapaAltura() - FrameGenerico.Altura
		// / 2))
		// y = personagem.getY() - FrameGenerico.Altura / 2;

		if (personagem.getX() > 800 / 2)
			if (personagem.getX() < (mapa_camada1.getMapaLargura() - 800 / 2))
				x = personagem.getX() - (800 / 2);
		if (personagem.getY() > 700 / 2)
			if (personagem.getY() < (mapa_camada1.getMapaAltura() - 700 / 2))
				y = personagem.getY() - 700 / 2;

		g.drawImage(tela, -x, -y, null);

		if (multiplayer == true) {
			if (personagem2.getX() > 800 / 2)
				if (personagem2.getX() < (mapa_camada1.getMapaLargura() - 800 / 2))
					dx = personagem2.getX() - (800 / 2);
			if (personagem2.getY() > 700 / 2)
				if (personagem2.getY() < (mapa_camada1.getMapaAltura() - 700 / 2))
					dy = personagem2.getY() - 700 / 2;

			g.drawImage(tela, -dx, -dy, null);
		}

	}

	@Override
	public void gameRender() {
		// TODO Auto-generated method stub

		if (jogador.getVida() <= 0 || jogador2.getVida() <= 0) {

			setGameOver(true);
			// inventario.setVisible(false);
			// faseView.setVisible(false);
			// faseView.setBounds(0, 0, 1100, 700);
		}
		if (isGameOver()) {

			g.drawImage(imgGameOver.getImage(), 0, 0, null);

		} else if (!isGameOver()) {

			mapa_camada1.montarMapa();
			mapa_camada2.montarMapa();
			mapa_camada3.montarMapa();
			mapa_camada4.montarMapa();
			mapa_camada5.montarMapa();

			graphicsMapa.drawImage(mapa_camada1.getMapa(), 0, 0, null);

			personagem.Draw(graphicsMapa);
//			g.draw(personagem.getBounds());
			if (personagem2 != null && multiplayer == true) {
				personagem2.Draw(graphicsMapa);
			}
			for (Item item : itens) {

				graphicsMapa.drawImage(item.getItens(), item.getX(), item.getY(), null);

			}
			graphicsMapa.drawImage(mapa_camada2.getMapa(), 0, 0, null);
			graphicsMapa.drawImage(mapa_camada3.getMapa(), 0, 0, null);
			graphicsMapa.drawImage(mapa_camada4.getMapa(), 0, 0, null);
			graphicsMapa.drawImage(mapa_camada5.getMapa(), 0, 0, null);

			for (int i = 0; i < itens.size(); i++) {
				Item itemAtual = (Item) itens.get(i);
				if (itemAtual.isVisibilidade() == true) {
					if (itemAtual.getBounds().intersects(personagem.getBounds())) {
						itemAtual.setVisibilidade(false);

						itens.remove(i);
						ControllerPersonagens.moverPers = "stop";
						ControllerPersonagens.moverPers2 = "stop";

						evento = true;

						if (varTemp < Dao.questoes.size()) {
							questao = Dao.questoes.get(varTemp);
							varTemp++;
						} else {
							varTemp = 0;
						}

						missao.exibirMissao(questao.getPergunta(), questao.getResposta(), questao.getErrada1(),
								questao.getErrada2(), questao.getErrada3());

					}

					if (multiplayer) {

						if (itemAtual.getBounds().intersects(personagem2.getBounds())) {
							itemAtual.setVisibilidade(false);

							itens.remove(i);

							ControllerPersonagens.moverPers = "stop";
							ControllerPersonagens.moverPers2 = "stop";

							evento = false;


							if (varTemp < Dao.questoes.size()) {
								questao = Dao.questoes.get(varTemp);
								varTemp++;
							} else {
								varTemp = 0;
							}

							missao.exibirMissao(questao.getPergunta(), questao.getResposta(), questao.getErrada1(),
									questao.getErrada2(), questao.getErrada3());
							varTemp++;

						}
					}
				}
			}
		}

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == missao.getRespLabel()) {

			if (evento) {
				System.out.println("entrouu");
				inventario.getJogador().setAcerto(jogador.getAcerto() + 1);
				inventario.getJogador().setScore(jogador.getScore() + 10);
			}

			if (!evento) {
				inventario.getJogador2().setAcerto(jogador2.getAcerto() + 1);
				inventario.getJogador2().setScore(jogador2.getScore() + 10);
			}

			inventario.updateUI();
			missao.setVisible(false);

			// System.out.println(jogador.getScore());
		}

		if (e.getSource() == missao.getErr1Label()) {

			if (evento) {
				System.out.println("entrouu");
				inventario.getJogador().setErro(jogador.getErro() + 1);
				inventario.getJogador().setVida(jogador.getVida() - 10);
			}

			if (!evento) {
				inventario.getJogador2().setErro(jogador2.getErro() + 1);
				inventario.getJogador2().setVida(jogador2.getVida() - 10);
			}

			inventario.updateUI();
			missao.setVisible(false);
		}

		if (e.getSource() == missao.getErr2Label()) {

			if (evento) {
				System.out.println("entrouu");
				inventario.getJogador().setErro(jogador.getErro() + 1);
				inventario.getJogador().setVida(jogador.getVida() - 10);
			}

			if (!evento) {
				inventario.getJogador2().setErro(jogador2.getErro() + 1);
				inventario.getJogador2().setVida(jogador2.getVida() - 10);
			}

			inventario.updateUI();
			missao.setVisible(false);

		}

		if (e.getSource() == missao.getErr3Label()) {
			if (evento) {
				System.out.println("entrouu");
				inventario.getJogador().setErro(jogador.getErro() + 1);
				inventario.getJogador().setVida(jogador.getVida() - 10);
			}

			if (!evento) {
				inventario.getJogador2().setErro(jogador2.getErro() + 1);
				inventario.getJogador2().setVida(jogador2.getVida() - 10);
			}

			inventario.updateUI();
			missao.setVisible(false);
		}

		if (e.getSource() == missao.getCancelarButton()) {

			if (evento) {
				System.out.println("entrouu");
				inventario.getJogador().setErro(jogador.getErro() + 1);
				inventario.getJogador().setScore(jogador.getScore() - 10);
				inventario.getJogador().setVida(jogador.getVida() - 10);
			}

			if (!evento) {
				inventario.getJogador2().setErro(jogador2.getErro() + 1);
				inventario.getJogador().setScore(jogador.getScore() - 10);
				inventario.getJogador2().setVida(jogador2.getVida() - 10);
			}

			inventario.updateUI();
			missao.setVisible(false);
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

	public boolean isMultiplayer() {
		return multiplayer;
	}

	public void setMultiplayer(boolean multiplayer) {
		this.multiplayer = multiplayer;
		setChanged();
		notifyObservers(multiplayer);
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public boolean isGanhou() {
		return ganhou;
	}

	public void setGanhou(boolean ganhou) {
		this.ganhou = ganhou;
	}
}
