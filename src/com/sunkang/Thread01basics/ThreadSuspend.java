/**
 * 
 */
package com.sunkang.Thread01basics;
/**
 *@author sunkang
 *@date 创建时间：2017年8月6日下午9:30:27
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
public class ThreadSuspend extends Thread{
	private long i=0;
	@Override
	public void run() {
		while(true){
			i++;
			System.out.println(i);
		}
		
	}
}
/**
 * 当程序运行到了println() 方法内部停止时，同步锁未被释放，
 * susped() 方法是过期的方法    独自占锁  而不让其他的对象运行
 * 
 * suspend 和rusume方法容易出现线程的暂停而导致数据不同步的情况
 * 
 */
class run6{
	public static void main(String[] args) {
		try {
			ThreadSuspend su=new ThreadSuspend();
			su.start();
			Thread.sleep(1000);
			su.suspend();
			System.out.println("main end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
