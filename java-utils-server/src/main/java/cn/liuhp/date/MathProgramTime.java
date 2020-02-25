package cn.liuhp.date;

import java.util.ArrayList;
import java.util.List;

/**
 * @author	hz16092620 
 * @date	2018年6月27日 下午2:53:48
 * @version      
 */
public class MathProgramTime {
    
    
    private static ThreadLocal<List<String>> threadLocal = new ThreadLocal<List<String>>();
    
    public static void main(String[] args) throws InterruptedException {
	MathProgramTime.start("批量发送消息");
	Thread.sleep(1200);
	MathProgramTime.end();
    }
    
    
    public static void start(String message) {
	Long start = System.currentTimeMillis();
	List<String> list = new ArrayList<String>();
	list.add(start.toString());
	list.add(message);
	
	threadLocal.set(list);
    }
    
    
    public static void end() {
	List<String> list = threadLocal.get();
	if (list != null) {
	    Long start = Long.valueOf(list.get(0));
	    Long end = System.currentTimeMillis();
	    System.out.println(list.get(1) + " 用时 : " + (end - start) + "毫秒！！！");
	}
    }

}
 