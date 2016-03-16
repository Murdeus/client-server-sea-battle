package by.kozhevnikov.bsuir.ppvis.SeaBattle;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import clientServet.ClientListener;
import clientServet.ServerListener;

public class MainFrame extends JFrame {

	public MainFrame() {
		this.setTitle("SeaBattle");
		this.setSize(900, 600);
		this.setLocation(250, 90);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Игра");
		JMenuItem startItem = new JMenuItem("Создать игру");
		JMenuItem joinItem = new JMenuItem("Присоединиться");
		JMenuItem stopItem = new JMenuItem("Выход");
		gameMenu.add(startItem);
		gameMenu.add(joinItem);
		gameMenu.add(stopItem);
		JMenu helpMenu = new JMenu("Помощь");
		JMenuItem helpItem = new JMenuItem("Показать справку");
		helpMenu.add(helpItem);
		menuBar.add(gameMenu);
		menuBar.add(helpMenu);
		startItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,
				ActionEvent.ALT_MASK));
		joinItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,
				ActionEvent.ALT_MASK));
		this.setJMenuBar(menuBar);
		setIntro();
		startItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PreparationFrame pframe = new PreparationFrame("server");
				setVisible(false);
			}
		});
		joinItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PreparationFrame pframe = new PreparationFrame("client");
				setVisible(false);
			}
		});
	}

	public void setIntro() {
		Font font = new Font("Arial", Font.BOLD, 150);
		JLabel label = new JLabel("SEA");
		JLabel label2 = new JLabel("BATTLE");
		JLabel label3 = new JLabel("PRESS ALT+F1 TO CREATE, ALT+F2 TO JOIN");
		label.setFont(font);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setForeground(Color.RED);
		label2.setFont(font);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setForeground(Color.RED);
		label3.setFont(new Font("Arial", Font.BOLD, 35));
		label3.setHorizontalAlignment(JLabel.CENTER);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		panel.add(new JLabel(""));
		panel.add(label);
		panel.add(label2);
		panel.add(label3);
		panel.add(new JLabel(""));
		this.setContentPane(panel);
	}
}