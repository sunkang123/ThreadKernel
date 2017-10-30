/**
 * 
 */
package com.sunkang.Thread01basics;
/**
 *@author sunkang
 *@date 创建时间：2017年8月6日下午7:23:45
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
public class ThreadStop extends Thread{
	private int i=0;
	public void run(){
		try {
			while(true){
				i++;
				System.out.println("i="+i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

/**
 * stop() 方法已经作废，但是stop()会释放锁
 *  
 */
class run5{
	public static void main(String[] args) throws InterruptedException {
		ThreadStop my=new ThreadStop();
		my.start();
		Thread.sleep(4000);
		my.stop();
		Mythread stop=new Mythread();
		stop.start();
	}

	
}

class Mythread extends Thread{
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
			this.stop();
	}
}

