package by.kozhevnikov.bsuir.ppvis.SeaBattle;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clientServet.ClientServerLogics;

public class Playground extends JFrame {
	private Field uField;
	private Field enemyField;
	private Socket socket;
	private ClientServerLogics csl;
	private JButton moveButt;
	private int xCoord;
	private int yCoord;
	private String name;

	public Playground(Field uField, Socket socket, String name) {
		this.uField = uField;
		this.socket = socket;
		this.name = name;
		csl = new ClientServerLogics(this, this.socket);
		this.setSize(1000, 500);
		if (this.name.equals("Client")) {
			this.setTitle("Client");
		} else {
			this.setTitle("Server");
		}
		this.setLocation(190, 150);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowActivated(WindowEvent arg0) {

			}

			@Override
			public void windowClosed(WindowEvent arg0) {

			}

			@Override
			public void windowClosing(WindowEvent event) {
				Object[] options = { "Да", "Нет" };
				int closeParam = JOptionPane.showOptionDialog(event.getWindow(),
						"Закрыть окно?", "Подтверждение",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (closeParam == 0) {
					event.getWindow().setVisible(false);
					closeOper();
				}
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {

			}

			@Override
			public void windowIconified(WindowEvent arg0) {

			}

			@Override
			public void windowOpened(WindowEvent arg0) {

			}
		});
		JPanel uFieldPanel = new JPanel();
		uFieldPanel.setLayout(new GridLayout(10, 10));
		uFieldPanel.setBounds(100, 80, 300, 300);
		for (int mark = 0; mark < uField.getList().size(); mark++) {
			uField.getList().get(mark).setEnabled(false);
			uFieldPanel.add(uField.getList().get(mark));
		}
		this.add(uFieldPanel);
		JPanel enemyFieldPanel = new JPanel();
		enemyField = new Field();
		enemyFieldPanel.setLayout(new GridLayout(10, 10));
		enemyFieldPanel.setBounds(600, 80, 300, 300);
		for (int counter = 0; counter < enemyField.getList().size(); counter++) {
			enemyFieldPanel.add(enemyField.getList().get(counter));
			enemyField.getList().get(counter)
					.addMouseListener(new FireListener(this));
		}
		this.add(enemyFieldPanel);
		moveButt = new JButton("Выстрел");
		moveButt.setBounds(450, 210, 100, 40);
		moveButt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (FireListener.cell != null) {
					send();
					FireListener.cell = null;
					csl.waitOf();
				}
			}
		});
		this.add(moveButt);
		this.setVisible(true);
		if (this.name.equals("Client")) {
			csl.waitFor();
		}
	}

	public void closeOper(){
		try {
			socket.close();
		} catch (Exception ex) {
		}
		System.exit(0);
	}
	
	public void send() {
		try {
			String coor = xCoord + " " + yCoord;
			csl.getOS().writeObject(coor);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getXCoord() {
		return this.xCoord;
	}

	public int getYCoord() {
		return this.yCoord;
	}

	public void setCoord(int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public boolean isGameEnded() {
		if (this.uField.getShipManage().getShipAliveCount() != 0) {
			return false;
		} else {
			return true;
		}
	}

	public void victoryMessage() {
		JOptionPane.showMessageDialog(null, "ПОБЕДА! Прекрасная работа!");
	}

	public void loseMessage() {
		JOptionPane.showMessageDialog(null, "Поражение.");
	}

	public Field getUField() {
		return this.uField;
	}

	public Field getEnemyField() {
		return this.enemyField;
	}

	public JButton getMoveButt() {
		return this.moveButt;
	}
}
