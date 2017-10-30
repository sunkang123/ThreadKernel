/**   
* @Title: ThreadDateFormat.java 
* @Package com.sunkang.Thread04Exception 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 孙康
* @date 2017年8月20日 下午4:18:39 
* @version V1.0   
*/
package com.sunkang.Thread04Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunkang.Thread01basics.MyThreadCont;
/**
 *@author sunkang
 *@date 创建时间：2017年8月20日下午4:18:39
 *@version 1.0
 *@parameter
 *@since
 *@return 
 */
/**   
 * @Title: ThreadDateFormat.java 
 * @Package com.sunkang.Thread04Exception 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 孙康
 * @date 2017年8月20日 下午4:18:39 
 * @version V1.0   
 */
public class ThreadDateFormat extends Thread {

	private SimpleDateFormat sdf;
	private String dateString;
	public ThreadDateFormat(SimpleDateFormat sdf, String dateString) {
		this.sdf = sdf;
		this.dateString = dateString;
	}
	@Override
	 public void run() {
		try {
			Date dateRef=sdf.parse(dateString);
			String newDateString=sdf.format(dateRef).toString();
			if(!newDateString.equals(dateString)){
				System.out.println("ThreadName: "+this.getName()+"报错了  日期字符串： "+dateString+"  转换成的日期为： "+newDateString);
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
	
}



class Test{
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String[] dateStringArray=new String[]{"2000-01-01","2000-01-02","2000-01-03"
		,"2000-01-04","2000-01-05","2000-01-06","2000-01-07","2000-01-08","2000-01-09","2000-01-10"		
		};
		ThreadDateFormat[] threadArray=new ThreadDateFormat[10];
		for(int i=0;i<10;i++){
			threadArray[i]=new ThreadDateFormat(sdf,dateStringArray[i]);
		}
		
		for(int i=0;i<10;i++){
			threadArray[i].start();
		}
		
		
	}
	
	
}
