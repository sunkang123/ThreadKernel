package com.sunkang.Thread01basics;

/**
 *@author sunkang
 *@date 创建时间：2017年8月6日下午2:11:11
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
public class MyThreadCont extends Thread{
	
	private int count=5;
	public MyThreadCont(String name){
		super();
		this.setName(name);
	}
	
  synchronized	public void run(){
		super.run();
		while(count>0){
			count--;
			System.out.println("由"+this.currentThread().getName()+"计算，count="+count);
		}
	}
}
class run0{
	public static void main(String[] args) {
		MyThreadCont a=new MyThreadCont("A");
		MyThreadCont b=new MyThreadCont("B");
		MyThreadCont c=new MyThreadCont("C");
		a.start();
		b.start();
		c.start();
		
	}
}

class run1{
	public static void main(String[] args) {
		MyThreadCont mythread=new MyThreadCont("");
		Thread a=new Thread(mythread, "A");
		Thread b=new Thread(mythread, "B");
		Thread c=new Thread(mythread, "C");
		Thread d=new Thread(mythread, "D");
		Thread e=new Thread(mythread, "E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
}

