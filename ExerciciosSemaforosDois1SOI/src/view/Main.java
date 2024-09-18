package view;

import java.util.concurrent.Semaphore;
import controller.ThreadCaminhada;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for (int i = 0; i < 4; i++) {
			Thread t = new ThreadCaminhada(semaforo);
			t.start();
		}
	}
}
