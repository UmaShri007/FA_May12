package ai.ineuron.FinAsgmt_03_05_08_09;

//Problem:08
//To create two threads and one should print even number and other odd number

class Printer implements Runnable {

	static int counter = 1;
	int reminder;

	static Object lock = new Object();

	Printer(int reminder) {
		this.reminder = reminder;
	}

	void printer() {
		System.out.println(Thread.currentThread().getName() + ":" + counter++);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
		synchronized (lock) {
				
				while (counter % 2 != reminder)
					try {
						lock.wait();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				printer();
				lock.notifyAll();
				
			}

		}
	}
}

public class DriverMainFA_08 {

	public static void main(String[] args) {
		Printer runnableObjEven = new Printer(0);
		Printer runnableObjOdd = new Printer(1);

		Thread t1_even = new Thread(runnableObjEven, "T2_EvenThread");
		Thread t2_odd = new Thread(runnableObjOdd, "T1_OddThread");

		t1_even.start();
		t2_odd.start();

	}

}
