/**
 * 
 */
package com.sunkang.Thread01basics;
/**
 *@author sunkang
 *@date 创建时间：2017年8月6日下午9:49:14
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
public class ThreadYield extends Thread{
	@Override
	public void run() {
		long beginTime=System.currentTimeMillis();
		int count=0;	
		for(int i=0;i<50000000;i++){
			//Thread.yield();  用时：6828毫秒！
			count =count +(i+1);
			
		}
		long endTime=System.currentTimeMillis();
		System.out.println("用时："+(endTime-beginTime)+"毫秒！");
	}
}

/**
 * yield()方法的作用是放弃当前cpu资源，让其他的任务去占用cpu执行的时间，但放弃的时间不确定，有可能刚刚泛起，马上又获得cpu时间片
 * 
 * 效率   Thread.yield();   用时：6828毫秒！    
 *  没有  Thread.yield()     用时：27毫秒！ 
 */
class run7{
	public static void main(String[] args) {
		ThreadYield thread=new ThreadYield();
		thread.start();
	}
	
}