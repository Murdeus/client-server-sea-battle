package by.kozhevnikov.bsuir.ppvis.SeaBattle;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clientServet.ClientListener;
import clientServet.ServerListener;
import shipManagment.FirstListener;
import shipManagment.ForthLenListener;
import shipManagment.ForthVertListener;
import shipManagment.SecondLenListener;
import shipManagment.SecondVerListener;
import shipManagment.ThirdLenListener;
import shipManagment.ThirdVerListener;

public class PreparationFrame extends JFrame {
	private Field uField;
	private ForthLenListener foLenLi;
	private ForthVertListener foVerLi;
	private ThirdLenListener thLenLi;
	private ThirdVerListener thVerLi;
	private SecondLenListener seLenLi;
	private SecondVerListener seVerLi;
	private FirstListener fiLi;
	private String name;

	public PreparationFrame(String name) {
		this.name = name;
		this.setSize(550, 500);
		this.setTitle("Prapare your ships");
		this.setLocation(440, 150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		JPanel uFieldPanel = new JPanel();
		uFieldPanel.setLayout(new GridLayout(10, 10));
		uField = new Field();
		uFieldPanel.setBounds(200, 80, 300, 300);
		for (int i = 0; i < uField.getList().size(); i++) {
			uFieldPanel.add(uField.getList().get(i));
		}
		this.add(uFieldPanel);
		JPanel prepButtons = new JPanel();
		prepButtons.setSize(150, 500);
		prepButtons.setLayout(null);
		JButton label = new JButton("Расстановка");
		label.setEnabled(false);
		label.setBounds(0, 10, 150, 30);
		prepButtons.add(label);
		JButton forthLenButt = new JButton("4 -");
		forthLenButt.setBounds(40, 60, 70, 30);
		prepButtons.add(forthLenButt);
		JButton forthVertButt = new JButton("4 |");
		forthVertButt.setBounds(40, 110, 70, 30);
		prepButtons.add(forthVertButt);
		JButton thirdLenButt = new JButton("3 -");
		thirdLenButt.setBounds(40, 160, 70, 30);
		prepButtons.add(thirdLenButt);
		JButton thirdVerButt = new JButton("3 |");
		thirdVerButt.setBounds(40, 210, 70, 30);
		prepButtons.add(thirdVerButt);
		JButton secondLenButt = new JButton("2 -");
		secondLenButt.setBounds(40, 260, 70, 30);
		prepButtons.add(secondLenButt);
		JButton secondVerButt = new JButton("2 |");
		secondVerButt.setBounds(40, 310, 70, 30);
		prepButtons.add(secondVerButt);
		JButton firstButt = new JButton("1");
		firstButt.setBounds(40, 360, 70, 30);
		prepButtons.add(firstButt);
		JButton delButt = new JButton("Отмена");
		delButt.setBounds(25, 420, 100, 30);
		prepButtons.add(delButt);
		this.add(prepButtons);
		JPanel playPanel = new JPanel();
		playPanel.setSize(100, 50);

		JButton playButt = new JButton();
		if (this.name.equals("server")) {
			playButt.setText("Создать игру");
		} else {
			playButt.setText("Присоединиться");
		}
		playPanel.add(playButt);
		playPanel.setBounds(300, 400, 100, 50);
		this.add(playPanel);
		this.setVisible(true);

		forthLenButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				foLenLi = new ForthLenListener(uField);
				for (int mark = 0; mark < uField.getList().size(); mark++) {
					uField.getList().get(mark).removeMouseListener(foVerLi);
					uField.getList().get(mark).removeMouseListener(thLenLi);
					uField.getList().get(mark).removeMouseListener(thVerLi);
					uField.getList().get(mark).removeMouseListener(seLenLi);
					uField.getList().get(mark).removeMouseListener(seVerLi);
					uField.getList().get(mark).removeMouseListener(fiLi);
					if (uField.getList().get(mark).getXId() < 8) {
						uField.getList().get(mark).addMouseListener(foLenLi);
					}
				}
			}
		});

		forthVertButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				foVerLi = new ForthVertListener(uField);
				for (int mark = 0; mark < uField.getList().size(); mark++) {
					uField.getList().get(mark).removeMouseListener(foLenLi);
					uField.getList().get(mark).removeMouseListener(thLenLi);
					uField.getList().get(mark).removeMouseListener(thVerLi);
					uField.getList().get(mark).removeMouseListener(seLenLi);
					uField.getList().get(mark).removeMouseListener(seVerLi);
					uField.getList().get(mark).removeMouseListener(fiLi);
					if (uField.getList().get(mark).getYId() < 8) {
						uField.getList().get(mark).addMouseListener(foVerLi);
					}
				}
			}
		});

		thirdLenButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thLenLi = new ThirdLenListener(uField);
				for (int mark = 0; mark < uField.getList().size(); mark++) {
					uField.getList().get(mark).removeMouseListener(foVerLi);
					uField.getList().get(mark).removeMouseListener(foLenLi);
					uField.getList().get(mark).removeMouseListener(thVerLi);
					uField.getList().get(mark).removeMouseListener(seLenLi);
					uField.getList().get(mark).removeMouseListener(seVerLi);
					uField.getList().get(mark).removeMouseListener(fiLi);
					if (uField.getList().get(mark).getXId() < 9) {
						uField.getList().get(mark).addMouseListener(thLenLi);
					}
				}
			}
		});

		thirdVerButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thVerLi = new ThirdVerListener(uField);
				for (int mark = 0; mark < uField.getList().size(); mark++) {
					uField.getList().get(mark).removeMouseListener(foVerLi);
					uField.getList().get(mark).removeMouseListener(foLenLi);
					uField.getList().get(mark).removeMouseListener(thLenLi);
					uField.getList().get(mark).removeMouseListener(seLenLi);
					uField.getList().get(mark).removeMouseListener(seVerLi);
					uField.getList().get(mark).removeMouseListener(fiLi);
					if (uField.getList().get(mark).getYId() < 9) {
						uField.getList().get(mark).addMouseListener(thVerLi);
					}
				}
			}
		});

		secondLenButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seLenLi = new SecondLenListener(uField);
				for (int mark = 0; mark < uField.getList().size(); mark++) {
					uField.getList().get(mark).removeMouseListener(foVerLi);
					uField.getList().get(mark).removeMouseListener(foLenLi);
					uField.getList().get(mark).removeMouseListener(thVerLi);
					uField.getList().get(mark).removeMouseListener(thLenLi);
					uField.getList().get(mark).removeMouseListener(seVerLi);
					uField.getList().get(mark).removeMouseListener(fiLi);
					if (uField.getList().get(mark).getXId() < 10) {
						uField.getList().get(mark).addMouseListener(seLenLi);
					}
				}
			}
		});

		secondVerButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seVerLi = new SecondVerListener(uField);
				for (int mark = 0; mark < uField.getList().size(); mark++) {
					uField.getList().get(mark).removeMouseListener(foVerLi);
					uField.getList().get(mark).removeMouseListener(foLenLi);
					uField.getList().get(mark).removeMouseListener(thVerLi);
					uField.getList().get(mark).removeMouseListener(thLenLi);
					uField.getList().get(mark).removeMouseListener(seLenLi);
					uField.getList().get(mark).removeMouseListener(fiLi);
					if (uField.getList().get(mark).getYId() < 10) {
						uField.getList().get(mark).addMouseListener(seVerLi);
					}
				}
			}
		});

		firstButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fiLi = new FirstListener(uField);
				for (int mark = 0; mark < uField.getList().size(); mark++) {
					uField.getList().get(mark).removeMouseListener(foVerLi);
					uField.getList().get(mark).removeMouseListener(foLenLi);
					uField.getList().get(mark).removeMouseListener(thVerLi);
					uField.getList().get(mark).removeMouseListener(thLenLi);
					uField.getList().get(mark).removeMouseListener(seLenLi);
					uField.getList().get(mark).removeMouseListener(seVerLi);
					uField.getList().get(mark).addMouseListener(fiLi);
				}
			}
		});

		delButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int mark = 0; mark < uField.getList().size(); mark++) {
					uField.getList().get(mark).removeMouseListener(foVerLi);
					uField.getList().get(mark).removeMouseListener(foLenLi);
					uField.getList().get(mark).removeMouseListener(thVerLi);
					uField.getList().get(mark).removeMouseListener(thLenLi);
					uField.getList().get(mark).removeMouseListener(seLenLi);
					uField.getList().get(mark).removeMouseListener(seVerLi);
					uField.getList().get(mark).removeMouseListener(fiLi);
					uField.getList().get(mark).setEnabled(true);
					uField.getList().get(mark).setBackground(null);
					uField.getList().get(mark).removeHasShip();
				}
				uField.getShipManage().backToNormal();
			}
		});

		if (this.name.equals("server")) {
			playButt.addActionListener(new ServerListener(this));
		} else {
			String hostName = JOptionPane.showInputDialog(null, "Введите адрес сервера");
			playButt.addActionListener(new ClientListener(this, hostName));
		}
	}
	
	public Field getUField(){
		return this.uField;
	}
}