package cn.liuhp.wheel.util;

import java.util.Random;

/**
 * <p>
 * 
 * 产生随机数
 * </p>
 * @author	hz16092620 
 * @date	2018年9月9日 上午10:13:06
 * @version      
 */
public class RandomUtils {
    
    private static Random random = null;
    
    
    static {
	random = new Random();
    }
    
    /**
     * 0到n随机的整型数
     * */
    public static int getRandomInt(int n) {
	return random.nextInt(n);
    }
    
    
    
    public static void main(String[] args) {
	/*for (int i = 0; i < 100; i++) {
	    System.out.println(getRandomInt(10));
	}*/
    }
    
    

}
 