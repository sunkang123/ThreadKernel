/**   
* @Title: StateUncaughtExceptionHandler.java 
* @Package com.sunkang.Thread04Exception 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月20日 下午5:19:22 
* @version V1.0   
*/
package com.sunkang.Thread04Exception;

import java.lang.Thread.UncaughtExceptionHandler;

/**   
 * @Title: StateUncaughtExceptionHandler.java 
 * @Package com.sunkang.Thread04Exception 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 孙康
 * @date 2017年8月20日 下午5:19:22 
 * @version V1.0   
 */
public class StateUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		
		System.out.println("静态的异常处理");
		e.printStackTrace();
	}
}
