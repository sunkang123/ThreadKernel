/**   
* @Title: ThredDeadLock.java 
* @Package com.sunkang.Thread02current 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月12日 下午6:11:36 
* @version V1.0   
*/
package com.sunkang.Thread02current;
/**
 *@author sunkang
 *@date 创建时间：2017年8月12日下午6:11:36
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
/**   
 * @Title: ThredDeadLock.java 
 * @Package com.sunkang.Thread02current 
 * @Description:多线程死锁
 * @author 孙康
 * @date 2017年8月12日 下午6:11:36 
 * @version V1.0   
 */
public class ThredDeadLock implements Runnable{

	public String username;
	public Object lock1=new Object();
	public Object lock2=new Object();
	public void setFlag(String username){
		this.username=username;
	}
	
	public void run(){
		if(username.equals("a")){
			synchronized (lock1) {
				try {
					System.out.println("username="+username);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized(lock2){
					System.out.println("安装lock1-->lock2代码顺序执行了");
				}
			}
		}
		if(username.equals("b")){
			synchronized (lock2) {
				try {
					System.out.println("username="+username);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized(lock1){
					System.out.println("安装lock2-->lock代码顺序执行了");
				}
			}
		}
	}
	
}


class Run1{
	public static void main(String[] args) {
		try {
			ThredDeadLock t1=new ThredDeadLock();
			t1.setFlag("a");
			Thread thread1=new Thread(t1);
			thread1.start();
			Thread.sleep(100);
			t1.setFlag("b");
			Thread thread2=new Thread(t1);
			thread2.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}