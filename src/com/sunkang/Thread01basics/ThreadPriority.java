/**
 * 
 */
package com.sunkang.Thread01basics;
/**
 *@author sunkang
 *@date 创建时间：2017年8月6日下午10:19:12
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
public class ThreadPriority  extends Thread{
	private int count=0;
	public int getCount(){
		return count;
	}
	public void run() {
		while(true){
			count++;
		}
	}
}

/**
 * 线程的优先级分为1-10级，
 *  public final static int MIN_PRIORITY = 1;
 
    public final static int NORM_PRIORITY = 5;

    public final static int MAX_PRIORITY = 10;
    
    特性1：线程优先级具有继承性，比如A线程启动B线程，则B线程的优先级与A是一样的  
   		优先级具有规则性，高优先级的线程总是先执行完，  不一定绝对
   		优先级具有随机性    比如由优先级为5和6  ，就不定谁先快了
   		优先级高的运行得快
   		
   		
    
 */
/**
 * 高优先级的次数运行得次数多
 * a=704777689  
 * b=777841855
 * 
 */
class run8{
	public static void main(String[] args) {
		try {
			ThreadPriority a=new ThreadPriority();
			a.setPriority(Thread.NORM_PRIORITY-3);
			a.start();
			ThreadPriority b=new ThreadPriority();
			b.setPriority(Thread.NORM_PRIORITY+3);
			b.start();
			Thread.sleep(2000);
			a.stop();
			b.stop();
			System.out.println("a="+a.getCount());
			System.out.println("b="+b.getCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
