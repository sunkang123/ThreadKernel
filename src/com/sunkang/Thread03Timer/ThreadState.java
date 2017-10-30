/**   
* @Title: ThreadState.java 
* @Package com.sunkang.Thread03Timer 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月20日 上午10:17:32 
* @version V1.0   
*/
package com.sunkang.Thread03Timer;


/**
 * 线程的状态有：
 * 	new      新建一个线程的时候
 * 	RUNNABLE    线程运行的时候
 * 	TERMINATED   线程销毁的时候
 * 	BLOCKED     线程堵塞
 * 	WAITING    线程等待 
 * 	TIMED_WAITING    线程 时间的等待
 * 
 *  
 * @Title: ThreadState.java 
 * @Package com.sunkang.Thread03Timer 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 孙康
 * @date 2017年8月20日 上午10:17:32 
 * @version V1.0   
 */
public class ThreadState {
	
	
	public static void main(String[] args) {
		try {
			Thread thread1=new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("run 方法中的状态："+Thread.currentThread().getState());
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			System.out.println("main中的状态1："+thread1.getState());
			System.out.println("mian中的状态2："+Thread.currentThread().getState());
			thread1.start();
			Thread.sleep(1000);
			System.out.println("main中的状态3："+thread1.getState());
			System.out.println("mian中的状态4："+Thread.currentThread().getState());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


class ThreadWaiting{
	public static void main(String[] args) throws InterruptedException {
		Thread thread=new Thread(new Runnable() {
			Object lock=new Object();
			@Override
			public void run() {
				try {
					synchronized (lock) {
						lock.wait();
						//Thread.sleep(2000);
						//Thread.currentThread().wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		thread.start();
		
		Thread.sleep(1000);
		System.out.println("main方法的Thread的状态为："+thread.getState());
		
	}
}

