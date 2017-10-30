/**   
* @Title: ThreadConsumer.java 
* @Package com.sunkang.Thread02current 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月13日 下午4:53:34 
* @version V1.0   
*/
package com.sunkang.Thread02current;

import java.util.ArrayList;
import java.util.List;

/**   
 * @Title: ThreadConsumer.java 
 * @Package com.sunkang.Thread02current 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 孙康
 * @date 2017年8月13日 下午4:53:34 
 * @version V1.0   
 */
public class ThreadPool {
	private List<Object> list=new ArrayList<Object>();
	synchronized public void push(){
		try {
			while(list.size()==1){
				this.wait();
			}
			list.add("anyString ="+Math.random());
			this.notifyAll();
			System.out.println("push"+list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	synchronized public Object pop(){
		Object str="";
		try {
			while(list.size()==0){
				System.out.println("pop 操作中："+Thread.currentThread().getName()+"线程呈wait状态");
				this.wait();
			}
			str=list.get(0);
			list.remove(0);
			this.notifyAll();
			System.out.println("pop="+ list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return str;
	}
}

class Product extends Thread{
	private ThreadPool pool;
	public Product(ThreadPool pool) {
		this.pool = pool;
	}
	@Override
	public void run() {
		while (true) {
			pool.push();
		}
	}
}
class Consumer extends Thread{
	private ThreadPool pool;
	public Consumer(ThreadPool pool) {
		this.pool = pool;
	}
	@Override
	public void run() {
		while (true) {
			Object o=pool.pop();
			System.out.println(o);
		}
	}
}
//一对一生产消费问题    没有问题
class run5{
	public static void main(String[] args) {
		ThreadPool pool=new ThreadPool();
		Product p=new Product(pool);
		Consumer c=new Consumer(pool);
		p.start();
		c.start();
	}
}
//一个生产多个消费者的问题
class run6{
	public static void main(String[] args) {
		ThreadPool pool=new ThreadPool();
		Product p=new Product(pool);
		p.start();
		Consumer c1=new Consumer(pool);
		Consumer c2=new Consumer(pool);
		Consumer c3=new Consumer(pool);
		Consumer c4=new Consumer(pool);
		c1.start();
		c2.start();
		c3.start();
		c4.start();
	}
}
//一个消费多个生产的问题：
class run7{
	public static void main(String[] args) {
		ThreadPool pool=new ThreadPool();
		Product p1=new Product(pool);
		Product p2=new Product(pool);
		Product p3=new Product(pool);
		Product p4=new Product(pool);
		Product p5=new Product(pool);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		Consumer c1=new Consumer(pool);
		c1.start();
	}
}
//多生产和多消费问题
class run8{
	public static void main(String[] args) {
		ThreadPool pool=new ThreadPool();
		Product p1=new Product(pool);
		Product p2=new Product(pool);
		p1.start();
		p2.start();
		Consumer c1=new Consumer(pool);
		Consumer c2=new Consumer(pool);
		c1.start();
		c2.start();
	}
}
