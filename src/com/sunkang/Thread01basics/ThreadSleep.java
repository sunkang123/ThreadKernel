/**
 * 
 */
package com.sunkang.Thread01basics;
/**
 *@author sunkang
 *@date 创建时间：2017年8月6日下午4:55:19
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
public class ThreadSleep extends Thread{
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
			super.run();
			System.out.println("run begin");
			Thread.sleep(2000000);
			System.out.println("run end");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("在沉睡中中被停止！进入catch!"+this.isInterrupted());
		}
	}

}
/**
 * 在sleep状态停止莫一线程，会进入catch语句，并且清除停止状态值，使之变成false 
 * 
 * 或者先停止线程，遇到sleep也会抛出异常   sleep  interrupted
 */
class run4{
	public static void main(String[] args) {
		try {
			ThreadSleep thread=new ThreadSleep();
			thread.start();
			Thread.sleep(200);
			thread.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end !");
	}	
}





