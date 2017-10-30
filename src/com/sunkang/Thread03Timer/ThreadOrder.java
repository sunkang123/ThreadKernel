/**   
* @Title: ThreadOrder.java 
* @Package com.sunkang.Thread03Timer 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月20日 下午3:28:22 
* @version V1.0   
*/
package com.sunkang.Thread03Timer;

/**   
 * @Title: ThreadOrder.java 
 * @Package com.sunkang.Thread03Timer 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 孙康
 * @date 2017年8月20日 下午3:28:22 
 * @version V1.0   
 */
public class ThreadOrder extends Thread {
	
	private Object lock;
	private String showChar;
	private int showNumPosition;
	private int printCount=0;
	
	volatile private static int addNumber=1;
	
	
	
	public ThreadOrder(Object lock, String showChar, int showNumPosition) {
		super();
		this.lock = lock;
		this.showChar = showChar;
		this.showNumPosition = showNumPosition;
	}



	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		synchronized (lock) {
			while(true){
				if(addNumber%3==showNumPosition){
					System.out.println("THreadName"+Thread.currentThread().getName()+" runcount "+addNumber+" "+showChar);
					
					lock.notifyAll();
					addNumber++;
					printCount++;
//					if(printCount==3){
//						break;
//					}
					
				}else{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}


class Run{
	public static void main(String[] args) {
		Object lock=new Object();
		ThreadOrder a=new ThreadOrder(lock,"A",1);
		ThreadOrder b=new ThreadOrder(lock,"B",2);
		ThreadOrder c=new ThreadOrder(lock,"C",0);
		a.start();
		b.start();
		c.start();
		
		
	}
}
