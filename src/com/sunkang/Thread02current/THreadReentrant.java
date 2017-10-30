/**   
* @Title: THreadReentrant.java 
* @Package com.sunkang.Thread02current 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月12日 下午1:41:51 
* @version V1.0   
*/
package com.sunkang.Thread02current;
/**   
 * 
 * 自己可以再次获得自己的内部锁
 * @Title: THreadReentrant.java 
 * @Package com.sunkang.Thread02current 
 * @Description: 可重入锁
 * @author 孙康
 * @date 2017年8月12日 下午1:41:51 
 * @version V1.0   
 */
public class THreadReentrant {
	synchronized public void service1(){
		System.out.println("service 1");
		service2();
	}
	
	synchronized public  void service2(){
		System.out.println("service 2");
		service3();
	}
	synchronized public  void service3(){
		System.out.println("service 3");
	}

}

class MyThread extends Thread{
	@Override
	public void run() {
		THreadReentrant service=new THreadReentrant();
		service.service1();
	}
}

class Run{
	public static void main(String[] args) {
		MyThread t=new MyThread();
		t.start();
	}
}


