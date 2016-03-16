package clientServet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import by.kozhevnikov.bsuir.ppvis.SeaBattle.Playground;
import by.kozhevnikov.bsuir.ppvis.SeaBattle.PreparationFrame;

public class ServerListener implements ActionListener {
	private PreparationFrame prepf;

	public ServerListener(PreparationFrame prepf) {
		this.prepf = prepf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((prepf.getUField().getShipManage().getFirstShip() == 0)
				&& (prepf.getUField().getShipManage().getSecondShip() == 0)
				&& (prepf.getUField().getShipManage().getThirdShip() == 0)
				&& (prepf.getUField().getShipManage().getForthShip() == 0)) {
			try {
				ServerSocket serverSocket = new ServerSocket(5555);
				Socket socket = serverSocket.accept();
				prepf.setVisible(false);
				Playground playg = new Playground(prepf.getUField(), socket, "Server");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
						"Упс, возникла ошибка. Попробуйте еще раз");
				System.exit(0);
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Вам необходимо расставить все корабли, прежде чем начать");
		}
	}
}