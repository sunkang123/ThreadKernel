package com.sunkang.Thread04Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    
    public static  String formatDate(Date date)throws ParseException{
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    
    public static Date parse(String strDate) throws ParseException{
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(strDate);
    }
}

 class DateTools {

	 //这种开销比较大     
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }

    public static String format(Date date) {
        return threadLocal.get().format(date);
    }
    
    
    //这种开销比较下   适合使用
    private static ThreadLocal<SimpleDateFormat> t1=new ThreadLocal<SimpleDateFormat>();
  synchronized  public static SimpleDateFormat getSimpleDateFormat(String datePattern){
    	SimpleDateFormat sdf=null;
    	sdf=t1.get();
    	System.out.println(Thread.currentThread().getName());
    	System.out.println(sdf);
    	if(sdf==null){
    		sdf=new  SimpleDateFormat(datePattern);
    		t1.set(sdf);
    	}
    	System.out.println(sdf);
    	return sdf;
    } 
}
 
 class test1{
		public static void main(String[] args) {
//			for(int i=0;i<10;i++){
//				new Thread(new Runnable() {
//					@Override
//					public void run() {
//						System.out.println(DateTools.getSimpleDateFormat("yyyy-MM-dd").hashCode());
//					}
//				}).start();
//			}
			
			for(int i=0;i<10;i++){
				System.out.println(new SimpleDateFormat("yyyy-MM-dd").toString());	
			}
			
			

		}
	} 
	 
 
 