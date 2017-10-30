/**   
* @Title: ThreadLockChange.java 
* @Package com.sunkang.Thread02current 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月12日 下午9:13:20 
* @version V1.0   
*/
package com.sunkang.Thread02current;
/**
 *@author sunkang
 *@date 创建时间：2017年8月12日下午9:13:20
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
/**   
 * @Title: ThreadLockChange.java 
 * @Package com.sunkang.Thread02current 
 * @Description:锁对象改变
 * @author 孙康
 * @date 2017年8月12日 下午9:13:20 
 * @version V1.0   
 */
public class ThreadLockChange {

	private String lock="123";
	public void testMethod(){
		synchronized (lock) {
			try {
				System.out.println(Thread.currentThread().getName()+"begin"+System.currentTimeMillis());
				lock="456";
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName()+"end "+System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class run3{
	public static void main(String[] args) throws InterruptedException {
		final ThreadLockChange servi=new ThreadLockChange();
		Thread  a=new Thread(new Runnable() {
			public void run() {
				servi.testMethod();
			}
		});
		
		Thread  b=new Thread(new Runnable() {
			public void run() {
				servi.testMethod();
			}
		});
		a.start();
		//这个对象在改变，如果对象的属性被改变，运行的结果还是同步，如果没有设置延迟的时间，就是一同去争取锁，通过争取锁是123
		//Thread.sleep(50);
		b.start();
	}
}
