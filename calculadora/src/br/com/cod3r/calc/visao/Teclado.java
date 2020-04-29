package br.com.cod3r.calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.cod3r.calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {
	public Teclado() {
		
		final Color COR_CINZA_ESCURO = new Color(68, 68, 68);
		final Color COR_CINZA_CLARO = new Color(99, 99, 99);
		final Color COR_LARANJA = new Color(240, 160, 60);
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(layout);
		
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		
		// LINHA 1:
		addBotao("C", COR_CINZA_ESCURO, c, 0, 0);
		addBotao("±", COR_CINZA_ESCURO, c, 1, 0);
		addBotao("%", COR_CINZA_ESCURO, c, 2, 0);
		addBotao(":", COR_LARANJA, c, 3, 0);
		
		// LINHA 2:
		addBotao("7", COR_CINZA_CLARO, c, 0, 1);
		addBotao("8", COR_CINZA_CLARO, c, 1, 1);
		addBotao("9", COR_CINZA_CLARO, c, 2, 1);
		addBotao("x", COR_LARANJA, c, 3, 1);
		
		// LINHA 3:
		addBotao("4", COR_CINZA_CLARO, c, 0, 2);
		addBotao("5", COR_CINZA_CLARO, c, 1, 2);
		addBotao("6", COR_CINZA_CLARO, c, 2, 2);
		addBotao("-", COR_LARANJA, c, 3, 2);
		
		// LINHA 4:
		addBotao("1", COR_CINZA_CLARO, c, 0, 3);
		addBotao("2", COR_CINZA_CLARO, c, 1, 3);
		addBotao("3", COR_CINZA_CLARO, c, 2, 3);
		addBotao("+", COR_LARANJA, c, 3, 3); 
		
		// LINHA 5:
		c.gridwidth = 2;
		addBotao("0", COR_CINZA_CLARO, c, 0, 4);
		c.gridwidth = 1;
		addBotao(".", COR_CINZA_CLARO, c, 2, 4);
		addBotao("=", COR_LARANJA, c, 3, 4);
	}

	private void addBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
		c.gridx = x;
		c.gridy = y;
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		add(botao, c);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			Memoria.getInstancia().processarComando(botao.getText());
		}
	}
}