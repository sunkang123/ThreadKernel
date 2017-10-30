/**
 * 
 */
package com.sunkang.Thread01basics;
/**
 *@author sunkang
 *@date 创建时间：2017年8月6日下午3:47:23
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
public class ThreadInterrupted {
	

}
class MyThtread extends Thread{
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		super.run();
		for(int i=0;i<500;i++){
			System.out.println("i="+(i+1));
		}
	}
}

class Run{
	public static void main(String[] args) throws InterruptedException {
		try {
			MyThtread my=new MyThtread();
			my.start();
			Thread.sleep(1000);
			my.interrupt();
			System.out.println("是否停止了1？"+Thread.interrupted());
			System.out.println("是否停止了2？"+my.interrupted());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("main catch");
		}
		System.out.println("end");
	}
}

class Run2{
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().interrupt();
		System.out.println("是否停止了1？"+Thread.interrupted());
		//在第一次调用已清除了其中断的状态
		System.out.println("是否停止了2？"+Thread.interrupted());
		System.out.println("end");
	}
}

class Run3{
	public static void main(String[] args) throws InterruptedException {
		try {
			MyThtread my=new MyThtread();
			my.start();
			Thread.sleep(10);
			my.interrupt();
			//测试线程是否中断的方法  
			System.out.println("是否停止了1？"+my.isInterrupted());
			System.out.println("是否停止了2？"+my.isInterrupted());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("main catch");
		}
		System.out.println("end");
	}
}



