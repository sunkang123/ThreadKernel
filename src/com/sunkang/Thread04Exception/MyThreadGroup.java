/**   
* @Title: MyThreadGroup.java 
* @Package com.sunkang.Thread04Exception 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月20日 下午5:11:04 
* @version V1.0   
*/
package com.sunkang.Thread04Exception;

/**   
 * @Title: MyThreadGroup.java 
 * @Package com.sunkang.Thread04Exception 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 孙康
 * @date 2017年8月20日 下午5:11:04 
 * @version V1.0   
 */
public class MyThreadGroup extends ThreadGroup{

	public MyThreadGroup(String name) {
		super(name);
	}

	//处理线程组的异常
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		super.uncaughtException(t, e);
		//打断线程的异常
		System.out.println("线程组的异常处理");
		e.printStackTrace();
	}

	
	
}
