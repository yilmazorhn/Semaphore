package org.example;

import java.util.concurrent.Semaphore;

class Worker implements Runnable {
	private final int id;
	private final Semaphore semaphore;

	public Worker(int id, Semaphore semaphore) {
		this.id = id;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			System.out.println("Worker " + id + " is trying to acquire a resource.");

			// Acquire a permit from the semaphore
			semaphore.acquire();

			System.out.println("Worker " + id + " has acquired a resource and is now working.");

			// Simulate some work
			Thread.sleep(2000);

			System.out.println("Worker " + id + " has finished working and is releasing the resource.");

			// Release the permit back to the semaphore
			semaphore.release();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}}