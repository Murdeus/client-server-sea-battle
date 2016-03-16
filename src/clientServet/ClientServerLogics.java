package clientServet;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import by.kozhevnikov.bsuir.ppvis.SeaBattle.Cell;
import by.kozhevnikov.bsuir.ppvis.SeaBattle.Playground;
import by.kozhevnikov.bsuir.ppvis.SeaBattle.Ship;

public class ClientServerLogics {
	private ObjectOutputStream os;
	private ObjectInputStream is;
	private Playground playground;
	private Socket socket;

	public ClientServerLogics(Playground playground, Socket socket) {
		this.playground = playground;
		this.socket = socket;
		try {
			os = new ObjectOutputStream(socket.getOutputStream());
			is = new ObjectInputStream(socket.getInputStream());
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void waitFor() {
		try {
			while (true) {
				playground.getMoveButt().setEnabled(false);
				String coor = (String) is.readObject();
				int devider = coor.indexOf(" ");
				int firstCoor = Integer.parseInt(coor.substring(0, devider));
				int secondCoor = Integer.parseInt(coor.substring(devider + 1));
				if (playground.getUField().getCellById(firstCoor, secondCoor)
						.getHasShip()) {
					Ship ship = playground.getUField()
							.getCellById(firstCoor, secondCoor).getShip();
					ship.remove(playground.getUField().getCellById(firstCoor,
							secondCoor));
					if (ship.isAlive()) {
						playground.getUField()
								.getCellById(firstCoor, secondCoor)
								.setBackground(Color.ORANGE);
						JOptionPane.showMessageDialog(null,
								"Капитан! Противник ранил наше судно!");
						os.writeObject("shot");
					} else {
						String shoted = "";
						ArrayList<Cell> copy = ship.getCopyList();
						for (int mark = 0; mark < copy.size(); mark++) {
							Cell cell = copy.get(mark);
							cell.setBackground(Color.RED);
							shoted += cell.getXId() + " " + cell.getYId() + ";";
						}
						playground.getUField().getShipManage().removeShip(ship);
						JOptionPane.showMessageDialog(null,
								"Противник потопил наш корабль!");
						if (playground.isGameEnded()) {
							os.writeObject("congrats");
							playground.loseMessage();
						} else {
							os.writeObject(shoted);
						}
					}
				} else {
					playground.getMoveButt().setEnabled(true);
					playground.getUField().getCellById(firstCoor, secondCoor)
							.setBackground(Color.CYAN);
					os.writeObject("nope");
					JOptionPane.showMessageDialog(null,
							"Противник промазал! Ваш ход, кэп.");
					break;
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Ваш противник вышел");
		}
	}

	public void waitOf() {
		try {
			while (true) {
				String strl = (String) is.readObject();
				if (strl.equals("shot")) {
					playground
							.getEnemyField()
							.getCellById(playground.getXCoord(),
									playground.getYCoord())
							.setBackground(Color.ORANGE);
					JOptionPane.showMessageDialog(null, "Отличный выстрел! Заряжай заново!");
					break;
				} else if (strl.equals("congrats")) {
					playground.getMoveButt().setEnabled(false);
					playground.victoryMessage();
					break;
				} else if (strl.equals("nope")) {
					waitFor();
					break;
				} else {
					while (strl.length() != 0) {
						int devider = strl.indexOf(" ");
						int end = strl.indexOf(";");
						int firstCoor = Integer.parseInt(strl.substring(0,
								devider));
						int secondCoor = Integer.parseInt(strl.substring(
								devider + 1, end));
						playground.getEnemyField()
								.getCellById(firstCoor, secondCoor)
								.setBackground(Color.RED);
						playground.getEnemyField().block(firstCoor, secondCoor);
						if (end != strl.length()) {
							strl = strl.substring(end + 1);
						} else {
							break;
						}
					}
					JOptionPane.showMessageDialog(null,
							"Корабль противника потоплен, капитан! Мы снова атакуем!");
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ObjectOutputStream getOS() {
		return this.os;
	}

	public ObjectInputStream getIS() {
		return this.is;
	}
}
