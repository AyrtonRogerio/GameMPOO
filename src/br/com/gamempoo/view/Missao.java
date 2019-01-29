package br.com.gamempoo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Missao extends JDialog {

	private String pergunta = "", resp = "", err1 = "", err2 = "", err3 = "";

	private Botoes cancelarButton;

	private Random n;
	private JLabel pergLabel, respLabel, err1Label, err2Label, err3Label;
	private JPanel panel;
	private ImageIcon imgMissao;

	private Graphics g;

	public Missao(JFrame frame) {
		super(frame);

		setSize(500, 500);
		setLayout(null);
		setModal(true);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);

		n = new Random();

//		imgMissao = new ImageIcon(getClass().getClassLoader().getResource("yoda.jpg"));
		
		pergLabel = new JLabel();
		respLabel = new JLabel();
		err1Label = new JLabel();
		err2Label = new JLabel();
		err3Label = new JLabel();

		cancelarButton = new Botoes(240, 370, 11);

		panel = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub

//				g.setFont(new Font("Arial", Font.BOLD, 30));
//				g.drawString(pergunta, 200, 90);

				
				
//				g.drawImage(imgMissao.getImage(), 0, 0,getWidth(), getHeight(), null);
				cancelarButton.drawImageIcon(g);
			}

		};

		panel.setLayout(null);
		panel.setBounds(0, 0, getWidth(), getHeight());

		panel.add(pergLabel);
		pergLabel.setFont(new Font("Arial", Font.BOLD, 50));
		pergLabel.setBounds(200, 20, 300, 50);
		
		panel.add(respLabel);
		respLabel.setFont(new Font("Arial", Font.BOLD, 30));

		panel.add(err1Label);
		err1Label.setFont(new Font("Arial", Font.BOLD, 30));

		panel.add(err2Label);
		err2Label.setFont(new Font("Arial", Font.BOLD, 30));

		panel.add(err3Label);
		err3Label.setFont(new Font("Arial", Font.BOLD, 30));

		panel.add(cancelarButton);

		add(panel);

		requestFocus();
		setVisible(false);

	}

	public boolean exibirMissao(String pergunta, String resp, String err1, String err2, String err3) {

		int variavel;

		variavel = 1 + (n.nextInt(9));

		switch (variavel) {
		case 1:

			respLabel.setBounds(100, 200, 50, 50);
			err1Label.setBounds(200, 200, 50, 50);
			err2Label.setBounds(300, 200, 50, 50);
			err3Label.setBounds(400, 200, 50, 50);

			break;
		case 2:

			err1Label.setBounds(100, 200, 50, 50);
			respLabel.setBounds(200, 200, 50, 50);
			err2Label.setBounds(300, 200, 50, 50);
			err3Label.setBounds(400, 200, 50, 50);

			break;

		case 3:

			err1Label.setBounds(100, 200, 50, 50);
			err2Label.setBounds(200, 200, 50, 50);
			respLabel.setBounds(300, 200, 50, 50);
			err3Label.setBounds(400, 200, 50, 50);

			break;
		case 4:

			err1Label.setBounds(100, 200, 50, 50);
			err2Label.setBounds(200, 200, 50, 50);
			err3Label.setBounds(300, 200, 50, 50);
			respLabel.setBounds(400, 200, 50, 50);

			break;
		case 5:

			err2Label.setBounds(100, 200, 50, 50);
			err1Label.setBounds(200, 200, 50, 50);
			err3Label.setBounds(300, 200, 50, 50);
			respLabel.setBounds(400, 200, 50, 50);
			
			break;
		case 6:

			err2Label.setBounds(100, 200, 50, 50);
			err3Label.setBounds(200, 200, 50, 50);
			err1Label.setBounds(300, 200, 50, 50);
			respLabel.setBounds(400, 200, 50, 50);
			break;
		case 7:

			err2Label.setBounds(100, 200, 50, 50);
			err1Label.setBounds(200, 200, 50, 50);
			respLabel.setBounds(300, 200, 50, 50);
			err3Label.setBounds(400, 200, 50, 50);
			break;
		case 8:

			err2Label.setBounds(100, 200, 50, 50);
			err3Label.setBounds(200, 200, 50, 50);
			respLabel.setBounds(300, 200, 50, 50);
			err1Label.setBounds(400, 200, 50, 50);

			break;
		case 9:

			err2Label.setBounds(100, 200, 50, 50);
			respLabel.setBounds(200, 200, 50, 50);
			err3Label.setBounds(300, 200, 50, 50);
			err1Label.setBounds(400, 200, 50, 50);

			break;
		case 10:
			
			err3Label.setBounds(100, 200, 50, 50);
			respLabel.setBounds(200, 200, 50, 50);
			err2Label.setBounds(300, 200, 50, 50);
			err1Label.setBounds(400, 200, 50, 50);
			
			break;
		default:
			break;
		}

		panel.setVisible(true);

		pergLabel.setText(pergunta);
		respLabel.setText(resp);
		err1Label.setText(err1);
		err2Label.setText(err2);
		err3Label.setText(err3);

		setVisible(true);

		this.pergunta = pergunta;
		this.resp = resp;
		this.err1 = err1;
		this.err2 = err2;
		this.err3 = err3;
		panel.updateUI();
		return true;
	}

	public Botoes getCancelarButton() {
		return cancelarButton;
	}

	public void setCancelarButton(Botoes cancelarButton) {
		this.cancelarButton = cancelarButton;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getRespLabel() {
		return respLabel;
	}

	public void setRespLabel(JLabel respLabel) {
		this.respLabel = respLabel;
	}

	public JLabel getErr1Label() {
		return err1Label;
	}

	public void setErr1Label(JLabel err1Label) {
		this.err1Label = err1Label;
	}

	public JLabel getErr2Label() {
		return err2Label;
	}

	public void setErr2Label(JLabel err2Label) {
		this.err2Label = err2Label;
	}

	public JLabel getErr3Label() {
		return err3Label;
	}

	public void setErr3Label(JLabel err3Label) {
		this.err3Label = err3Label;
	}
	
}
