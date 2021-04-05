package ly.java.singleton;

/**
 * 1.单例模式方案一
 * 2.此方案存在线程不安全的问题
 * @author liuya
 *
 */

public class Singleton01 {
	
	//构造方法私有化,不允许外部构建对象
	private Singleton01() {
		
	}
	
	private static Singleton01 instance;
	
	public static Singleton01 getInstance() {
		
		if (instance == null) {
			instance = new Singleton01();
		}
		
		return instance;
	}
}
