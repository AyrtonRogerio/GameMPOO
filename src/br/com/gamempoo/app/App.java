/**
 * 
 */
package br.com.gamempoo.app;

import br.com.gamempoo.controller.Controller;
import br.com.gamempoo.controller.ControllerFase;
import br.com.gamempoo.model.vo.FaseVO;
import br.com.gamempoo.model.vo.Jogador;
import br.com.gamempoo.view.Ajuda;
import br.com.gamempoo.view.CadastrarPerguntas;
import br.com.gamempoo.view.Configuracao;
import br.com.gamempoo.view.Creditos;
import br.com.gamempoo.view.FaseView;
import br.com.gamempoo.view.Inventario;
import br.com.gamempoo.view.Missao;
import br.com.gamempoo.view.Tela;
import br.com.gamempoo.view.TelaPanel;

/**
 * @author Ayrton
 *
 */
public class App {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TelaPanel telaPanel = new TelaPanel();
		Ajuda ajudaPanel = new Ajuda();
		Configuracao configuracaoPanel = new Configuracao();
		Creditos creditosPanel = new Creditos();
		CadastrarPerguntas cadastrarPerguntas = new CadastrarPerguntas();
		Jogador jogador = new Jogador();
		Jogador jogador2 = new Jogador();
		
		
		FaseView faseView = new FaseView();
		
		FaseVO faseVO = new FaseVO(jogador, jogador2);
		Inventario inventario = new Inventario(jogador, jogador2);
		
		Tela tela = new Tela(telaPanel, ajudaPanel, configuracaoPanel, creditosPanel, faseView, inventario, cadastrarPerguntas);
		Missao missao = new Missao(tela);
		
//		System.out.println( faseVO.getItem());
		
		
		ControllerFase controllerFase = new ControllerFase(faseVO.getMapa_camada1(), 
				faseVO.getMapa_camada2(), faseVO.getMapa_camada3(), 
				faseVO.getMapa_camada4(), faseVO.getMapa_camada5(), faseVO.getPersonagem(),
				faseVO.getPersonagem2(), faseView, faseVO.getItem(), faseVO.getJogador(),faseVO.getJogador2(),  missao, inventario);
		
		controllerFase.addObserver(inventario);
		
		Controller controller = new Controller(tela, telaPanel, ajudaPanel, configuracaoPanel,
				creditosPanel, controllerFase, faseVO, faseView, jogador, jogador2, inventario, cadastrarPerguntas);
		
	}

}
