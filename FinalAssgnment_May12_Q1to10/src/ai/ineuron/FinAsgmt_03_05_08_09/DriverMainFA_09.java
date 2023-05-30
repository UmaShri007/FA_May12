package ai.ineuron.FinAsgmt_03_05_08_09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Problem-Solution:09
//Producer-Consumer Model that uses InterThread Communication

//Buffer or Queue from to which producer puts the number and consumer consumes ,should be synchronized
class Queue{
	
	private List<Integer> queueList;
	private  int capacity;
	
	Queue(int capacity){
		this.capacity = capacity;
		this.queueList = new ArrayList<Integer>();
	}
	
	public synchronized void put(int number) { //producing
		while(queueList.size()==capacity) {
			
			try {
				wait()	;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		queueList.add(number);
		System.out.println("Producer put: "+number);
		notifyAll();
	
	}
	
	public synchronized int get()	{ //consuming
		
		while(queueList.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		int number = queueList.remove(0);
		System.out.println("Consumer got: "+number);
		notifyAll();
		return number;
	}
}

class Producer extends Thread{

	private Queue que;
	private int max_numbers;
	Random random = new Random();
	
	Producer(Queue q,int max_num){
		que = q;
		max_numbers = max_num;
	}
	
	@Override
	public void run() {
		for(int i=0;i<=max_numbers;i++) {
			int number = random.nextInt(20);
			que.put(number);
		}
	}
	
}
//Consumer class that reads/consumes those numbers and calculate their sum
class Consumer extends Thread{
		
	private Queue que;
	private int max_numbers;
	private int sum;
	
	Consumer (Queue q,int max_num){
		que = q;
		max_numbers = max_num;
		this.sum=0;
		
	}
	
	@Override
	public void run() {
		
		for(int i=0;i<=max_numbers;i++) {
		sum = sum+que.get();
		
	}
		System.out.println("Sum of consumed/got numbers: "+sum);
	
}
}
public class DriverMainFA_09 {

	public static void main(String[] args) {

			Queue q = new Queue(10); //que capacity = 10
			
			Producer p = new Producer(q,20);//max_numbers=20
			Consumer c =new Consumer(q,20);
			
			p.start();
			c.start();
	}

}
