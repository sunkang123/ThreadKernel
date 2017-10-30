/**
 * 
 */
package com.sunkang.Thread01basics;
/**
 *@author sunkang
 *@date 创建时间：2017年8月6日下午10:43:32
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
public class ThreadDaemon extends Thread {
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
 * 守护线程 ：java线程有两种线程，一种是用户线程，另外一种就是守护线程 
 * 守护线程是一种特殊的线程，当进场不存在非守护线程了，则守护线程自动销毁
 * 典型的就是垃圾回收线程     
 * GC垃圾回收器
 */
class run9{
	public static void main(String[] args) {
		try {
			ThreadDaemon de=new ThreadDaemon();
			de.setDaemon(true);
			de.start();
			Thread.sleep(5000);
			System.out.println("守护线程"+de.getName());
			System.out.println("当前的线程"+Thread.currentThread().getName());
			System.out.println("我要离开了thread对象也不在打印了，也就是停止了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}