/**   
* @Title: ThreadGroupTest.java 
* @Package com.sunkang.Thread03Timer 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月20日 上午10:47:57 
* @version V1.0   
*/
package com.sunkang.Thread03Timer;

/**  
 * 线程组测试 
 * @Title: ThreadGroupTest.java 
 * @Package com.sunkang.Thread03Timer 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 孙康
 * @date 2017年8月20日 上午10:47:57 
 * @version V1.0   
 */
public class ThreadGroupTest {
	public static void main(String[] args) {
		Runnable run1=new Runnable() {
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()){
					System.out.println("ThreadName"+Thread.currentThread().getName());	
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		Runnable run2=new Runnable() {
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()){
					System.out.println("ThreadName"+Thread.currentThread().getName());	
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		ThreadGroup group=new ThreadGroup("孙康的线程组");
		Thread aThread=new Thread(group, run1);
		Thread bThread=new Thread(group, run2);
		aThread.start();
		bThread.start();
		//获取线程组的活动线程
		System.out.println("活动的线程为："+group.activeCount());
		//获取活动的线程组
		System.out.println("活动的线程组为："+group.activeGroupCount());
		//获取线程组的名称
		System.out.println("线程组的名称为："+group.getName());
	}
}

//线程对象 关联线程组   ：多级关联
class Threadgroup{
	public static void main(String[] args) {
		ThreadGroup mainGroup=Thread.currentThread().getThreadGroup();
		
		System.out.println(mainGroup.getName());
		ThreadGroup group=new ThreadGroup(mainGroup,"A");
		Runnable run1=new Runnable() {
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()){
					System.out.println("ThreadName"+Thread.currentThread().getName());	
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		
		
		Thread newThread=new Thread(group,run1);
		newThread.setName("Z");
		newThread.start();  //线程必须启动才能回归a组
		
		ThreadGroup[] listGroup=new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(listGroup);
		
		System.out.println("main 线程的个数为"+listGroup.length+"名字为"+listGroup[0].getName());
		
		Thread[] listThread=new Thread[listGroup[0].activeCount()];
		
		listGroup[0].enumerate(listThread);
		
		System.out.println(listThread[0].getName());
		
		
		
		
	}
	
	
}

