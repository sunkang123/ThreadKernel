/**   
* @Title: MyThreadException.java 
* @Package com.sunkang.Thread04Exception 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月20日 下午5:21:23 
* @version V1.0   
*/
package com.sunkang.Thread04Exception;

/**   
 * @Title: MyThreadException.java 
 * @Package com.sunkang.Thread04Exception 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 孙康
 * @date 2017年8月20日 下午5:21:23 
 * @version V1.0   
 */
public class MyThreadException extends Thread {
	
	private String num ="a";

	public MyThreadException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyThreadException(ThreadGroup group, String name) {
		super(group, name);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void run() {
		int numInt=Integer.parseInt(num);
		System.out.println("在线程打印： "+numInt+1);
	}

}

//对象异常捕捉了 
class runtest1{
	public static void main(String[] args) {
		MyThreadException myThException=new MyThreadException();
		myThException.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
		MyThreadException.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
		
		
		myThException.start();
	}
}

//静态的异常处理 
class runtest2{
	public static void main(String[] args) {
		MyThreadException myThException=new MyThreadException();
		//myThException.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
		MyThreadException.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
		
		myThException.start();
	}
}

//对象的异常的处理 
class runtest3{
	public static void main(String[] args) {
		
		MyThreadGroup group=new MyThreadGroup("我的线程组");
		MyThreadException myThException=new MyThreadException(group,"我的线程");
		
		myThException.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
		MyThreadException.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
		
		myThException.start();
	}
}
// 静态的异常处理    线程组的异常处理 
class runtest4{
	public static void main(String[] args) {
		
		MyThreadGroup group=new MyThreadGroup("我的线程组");
		MyThreadException myThException=new MyThreadException(group,"我的线程");
		
		//myThException.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
		MyThreadException.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
		
		myThException.start();
	}
}

//线程组的异常处理
class runtest5{
	public static void main(String[] args) {
		
		MyThreadGroup group=new MyThreadGroup("我的线程组");
		MyThreadException myThException=new MyThreadException(group,"我的线程");
		
		//myThException.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
		//MyThreadException.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
		
		myThException.start();
	}
}


// 对象异常   ---》线程组异常----》静态异常

//线程组异常  向上抛异常被静态异常捕获