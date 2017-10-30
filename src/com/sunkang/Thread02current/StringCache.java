/**   
* @Title: StringCache.java 
* @Package com.sunkang.Thread02current 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月12日 下午5:51:52 
* @version V1.0   
*/
package com.sunkang.Thread02current;
/**
 *@author sunkang
 *@date 创建时间：2017年8月12日下午5:51:52
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
/**   
 * @Title: StringCache.java 
 * @Package com.sunkang.Thread02current 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 孙康
 * @date 2017年8月12日 下午5:51:52 
 * @version V1.0   
 */
public class StringCache {
	public static void main(String[] args) {
		String a ="AA";
		String b="AA";
		String c=new String("AA");
		String d=new String("AA");
		System.out.println(a==b);
		System.out.println(b==c);
		System.out.println(c==d);
		StringCache str=new StringCache();
		str.test();
	}
	
	public void test(){
		String a ="AA";
		String b="AA";
		System.out.println(a==b);
	}

}
