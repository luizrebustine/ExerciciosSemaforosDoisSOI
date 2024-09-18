package controller;

import java.util.concurrent.Semaphore;

public class ThreadCaminhada extends Thread {

	private Semaphore semaforo;
	private int distanciaPercorrida;

	public ThreadCaminhada(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	public void run() {
		while (distanciaPercorrida < 200) {
			pessoaAndando();
			System.out.println("andou" + distanciaPercorrida);
		}
		try {
			semaforo.acquire();
			pessoaAbrindoPorta();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}
		System.out.println("Chegou!");
	}

	private void pessoaAndando() {
		int passo = (int) ((Math.random() * 7) + 4);
		try {
			sleep(1000);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		distanciaPercorrida += passo;
	}

	private void pessoaAbrindoPorta() {
		try {
			sleep((int) ((Math.random() * 1001) + 1000));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Abriu a porta!");
	}
}
