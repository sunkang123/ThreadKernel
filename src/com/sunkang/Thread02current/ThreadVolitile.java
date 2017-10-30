/**   
* @Title: ThreadAutomic.java 
* @Package com.sunkang.Thread02current 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月12日 下午11:03:48 
* @version V1.0   
*/
package com.sunkang.Thread02current;
/**
 *@author sunkang
 *@date 创建时间：2017年8月12日下午11:03:48
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
/**   
 * @Title: ThreadAutomic.java 
 * @Package com.sunkang.Thread02current 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 孙康
 * @date 2017年8月12日 下午11:03:48 
 * @version V1.0   
 */
public class ThreadVolitile extends Thread{
	volatile private boolean isRunning=true;
	public boolean isRunning(){
		return isRunning;
	}
	public void setRunning (boolean isRunning){
		this.isRunning=isRunning;
	}
	
	public void run(){
		System.out.println("进入run了");
		while(isRunning==true){
			
		}
		System.out.println("线程被停止了");
	}
}

class run4{
	public static void main(String[] args) {
		try {
			ThreadVolitile thread=new ThreadVolitile();
			thread.start();
			Thread.sleep(1000);
			thread.setRunning(false);
			System.out.println("已经赋值为 false");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
