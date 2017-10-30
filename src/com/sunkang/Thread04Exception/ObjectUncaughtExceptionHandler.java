/**   
* @Title: ObjectUncaughtExceptionHandler.java 
* @Package com.sunkang.Thread04Exception 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月20日 下午5:16:38 
* @version V1.0   
*/
package com.sunkang.Thread04Exception;

import java.lang.Thread.UncaughtExceptionHandler;

/**   
 * @Title: ObjectUncaughtExceptionHandler.java 
 * @Package com.sunkang.Thread04Exception 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 孙康
 * @date 2017年8月20日 下午5:16:38 
 * @version V1.0   
 */
public class ObjectUncaughtExceptionHandler implements UncaughtExceptionHandler
{
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// 对异常对象的处理
		System.out.println("对象的异常的处理");
		e.printStackTrace();
	}

}
