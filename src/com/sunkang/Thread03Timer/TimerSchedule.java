/**   
* @Title: TimerSchedule.java 
* @Package com.sunkang.Thread03Timer 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月19日 下午11:54:58 
* @version V1.0   
*/
package com.sunkang.Thread03Timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**   
 * @Title: TimerSchedule.java 
 * @Package com.sunkang.Thread03Timer 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 孙康
 * @date 2017年8月19日 下午11:54:58 
 * @version V1.0   
 */
public class TimerSchedule {
	
	public static void main(String[] args) throws InterruptedException {
		Timer task=new Timer();
		task.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("A任务的时间为："+new Date());
			}
		}, new Date(),4000);
		
		task.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("B任务执行的时间为："+new Date());
				//从任务队列中移除
				this.cancel();
				System.out.println("B 任务执行取消了："+new Date());
			}
		}, new Date(),3000);
		
		Thread.sleep(10000);
		//移除队列的所有任务，并且进程被销毁
		//task.cancel();
		
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)-20);
		
		task.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("begin timer "+new Date());
				System.out.println("end timer "+new Date());
			}
		}, calendar.getTime(), 1000);
		
	}
}





