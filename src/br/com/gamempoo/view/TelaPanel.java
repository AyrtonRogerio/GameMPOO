package br.com.gamempoo.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaPanel extends PanelGenerico {

	
	private Botoes  singlePlayerButton,multiPlayerButton,
					ajudaButton, configButton, creditosButton, sairButton, cadastrarButton;
	
	
	private JLabel nome1Lable, nome2Lable;
	
	private JTextField nome1Field, nome2Field;

	private BufferedImage imagemInicio;
	
	private Graphics2D graphicsTelaP;
	
	public TelaPanel() {
		super();
		
		imagemInicio = new BufferedImage(800, 600, BufferedImage.TYPE_4BYTE_ABGR);
		graphicsTelaP =  (Graphics2D) imagemInicio.getGraphics();
		
		try {
			imagemInicio = ImageIO.read(getClass().getClassLoader().getResourceAsStream("starwarsInicio.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Não carregou a imagem de inicio");
		}
		
		singlePlayerButton = new Botoes(45, 100, 1);
		multiPlayerButton = new Botoes(45, 180, 4);
		ajudaButton =  new Botoes(45, 260, 2);
		configButton = new Botoes(45, 340, 0);
		creditosButton = new Botoes(45, 420, 3);
		cadastrarButton = new Botoes(45, 500, 8);
		sairButton = new Botoes(45, 580, 10);
		
		nome1Lable = new JLabel("JOGADOR 1:");
		nome1Field = new JTextField(10);
		
		nome2Lable = new JLabel("JOGADOR 2:");
		nome2Field = new JTextField(10);
		
		
		add(singlePlayerButton);
		add(multiPlayerButton);
		add(ajudaButton);
		add(configButton);
		add(creditosButton);
		add(cadastrarButton);
		add(sairButton);
		
		add(nome1Lable).setBounds(240, 100, 150, 30);
		nome1Lable.setFont(new Font("Arial", Font.BOLD, 20));
		add(nome1Field).setBounds(370, 100, 150, 30);
		
		add(nome2Lable).setBounds(580, 100, 150, 30);
		nome2Lable.setFont(new Font("Arial", Font.BOLD, 20));
		add(nome2Field).setBounds(710, 100, 150, 30);
						
		setVisible(false);
	}


	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub

	g.drawImage(imagemInicio, 0, 0, null);
	}
	
	public JButton getSinglePlayerButton() {
		return singlePlayerButton;
	}

	public void setSinglePlayerButton(Botoes singlePlayerButton) {
		this.singlePlayerButton = singlePlayerButton;
	}

	public Botoes getMultiPlayerButton() {
		return multiPlayerButton;
	}

	public void setMultiPlayerButton(Botoes multiPlayerButton) {
		this.multiPlayerButton = multiPlayerButton;
	}

	public Botoes getAjudaButton() {
		return ajudaButton;
	}

	public void setAjudaButton(Botoes ajudaButton) {
		this.ajudaButton = ajudaButton;
	}

	public Botoes getConfigButton() {
		return configButton;
	}

	public void setConfigButton(Botoes configButton) {
		this.configButton = configButton;
	}

	public Botoes getCreditosButton() {
		return creditosButton;
	}

	public void setCreditosButton(Botoes creditosButton) {
		this.creditosButton = creditosButton;
	}

	public Botoes getSairButton() {
		return sairButton;
	}

	public void setSairButton(Botoes sairButton) {
		this.sairButton = sairButton;
	}

	public JLabel getNome1Lable() {
		return nome1Lable;
	}

	public void setNome1Lable(JLabel nome1Lable) {
		this.nome1Lable = nome1Lable;
	}

	public JLabel getNome2Lable() {
		return nome2Lable;
	}

	public void setNome2Lable(JLabel nome2Lable) {
		this.nome2Lable = nome2Lable;
	}

	public JTextField getNome1Field() {
		return nome1Field;
	}

	public void setNome1Field(JTextField nome1Field) {
		this.nome1Field = nome1Field;
	}

	public JTextField getNome2Field() {
		return nome2Field;
	}

	public void setNome2Field(JTextField nome2Field) {
		this.nome2Field = nome2Field;
	}

	public BufferedImage getImagemInicio() {
		return imagemInicio;
	}

	public void setImagemInicio(BufferedImage imagemInicio) {
		this.imagemInicio = imagemInicio;
	}

	public Graphics2D getGraphicsTelaP() {
		return graphicsTelaP;
	}

	public void setGraphicsTelaP(Graphics2D graphicsTelaP) {
		this.graphicsTelaP = graphicsTelaP;
	}


	public Botoes getCadastrarButton() {
		return cadastrarButton;
	}


	public void setCadastrarButton(Botoes cadastrarButton) {
		this.cadastrarButton = cadastrarButton;
	}
	
}