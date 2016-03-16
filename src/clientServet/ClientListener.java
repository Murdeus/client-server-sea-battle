package clientServet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JOptionPane;

import by.kozhevnikov.bsuir.ppvis.SeaBattle.Playground;
import by.kozhevnikov.bsuir.ppvis.SeaBattle.PreparationFrame;

public class ClientListener implements ActionListener {
	private PreparationFrame prepf;
	private String hostName;

	public ClientListener(PreparationFrame prepf, String hostName) {
		this.hostName = hostName;
		this.prepf = prepf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((prepf.getUField().getShipManage().getFirstShip() == 0)
				&& (prepf.getUField().getShipManage().getSecondShip() == 0)
				&& (prepf.getUField().getShipManage().getThirdShip() == 0)
				&& (prepf.getUField().getShipManage().getForthShip() == 0)) {
			try {
				Socket socket = new Socket(this.hostName, 5555);
				prepf.setVisible(false);
				Playground playg = new Playground(prepf.getUField(), socket, "Client");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
						"Отсутствует соединение с сервером");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Вам необходимо расставить все корабли, прежде чем начать");
		}
	}
}