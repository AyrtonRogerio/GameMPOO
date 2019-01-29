package br.com.gamempoo.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class Tela extends FrameGenerico {

	private TelaPanel telaPanel;
	private Ajuda ajudaPanel;
	private Configuracao configuracaoPanel;
	private Creditos creditosPanel;
	private FaseView faseView;
	private CardLayout cardL;
	private Inventario inventario;
	private JPanel panelJogo;
	private CadastrarPerguntas cadastrarPerguntas;
	
	public Tela(TelaPanel telaPanel, Ajuda ajudaPanel, Configuracao configuracaoPanel,
			 Creditos creditosPanel, FaseView faseView, Inventario inventario, CadastrarPerguntas cadastrarPerguntas) {
		super();
		this.telaPanel = telaPanel;
		this.ajudaPanel = ajudaPanel;
		this.configuracaoPanel = configuracaoPanel;
		this.creditosPanel = creditosPanel;
		this.faseView = faseView;
		this.inventario = inventario;
		this.cadastrarPerguntas = cadastrarPerguntas;
		
		panelJogo = new JPanel();
		
		panelJogo.setLayout(null);
		panelJogo.setVisible(false);
		
		panelJogo.add(faseView).setBounds(0, 0, 800, 700);
		panelJogo.add(inventario).setBounds(800, 0, 300, 700);
		
		add(panelJogo);
		
		faseView.setVisible(true);
		inventario.setVisible(true);
		
		cardL = new CardLayout();
		
		setLayout(cardL);
		
		add(telaPanel, "m");
		add(ajudaPanel, "a");
		add(configuracaoPanel, "t");
		add(creditosPanel, "c");
		add(panelJogo,"p");
		add(cadastrarPerguntas, "cd");
		
		cardL.show(getContentPane(), "m");
	
		setVisible(true);
	}

	
	
	public TelaPanel getTelaPanel() {
		return telaPanel;
	}

	public void setTelaPanel(TelaPanel telaPanel) {
		this.telaPanel = telaPanel;
	}

	public Ajuda getAjudaPanel() {
		return ajudaPanel;
	}

	public void setAjudaPanel(Ajuda ajudaPanel) {
		this.ajudaPanel = ajudaPanel;
	}

	public Configuracao getConfiguracaoPanel() {
		return configuracaoPanel;
	}

	public void setConfiguracaoPanel(Configuracao configuracaoPanel) {
		this.configuracaoPanel = configuracaoPanel;
	}

	public Creditos getCreditosPanel() {
		return creditosPanel;
	}

	public void setCreditosPanel(Creditos creditosPanel) {
		this.creditosPanel = creditosPanel;
	}

	public FaseView getFaseView() {
		return faseView;
	}

	public void setFaseView(FaseView faseView) {
		this.faseView = faseView;
	}

	public CardLayout getCardL() {
		return cardL;
	}

	public void setCardL(CardLayout cardL) {
		this.cardL = cardL;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public JPanel getPanelJogo() {
		return panelJogo;
	}

	public void setPanelJogo(JPanel panelJogo) {
		this.panelJogo = panelJogo;
	}



	public CadastrarPerguntas getCadastrarPerguntas() {
		return cadastrarPerguntas;
	}



	public void setCadastrarPerguntas(CadastrarPerguntas cadastrarPerguntas) {
		this.cadastrarPerguntas = cadastrarPerguntas;
	}
	
}
