package org.example;


import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	public static void main(String[] args) {
		// Create a semaphore with 3 permits (3 resources available)
		Semaphore semaphore =new Semaphore(3);

		// Create and start some threads that want to access the resources

		for (int i=1; i<=5; i++){
			Thread thread = new Thread(new Worker(i,semaphore));
			thread.start();
		}
	}
}