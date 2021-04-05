package ly.java.singleton;
/**
 * 1.单例模式方案4:线程安全,无阻塞
 * 2.适合:大对象,频繁用(高并发,大量访问)
 * @author liuya
 *
 */
public class Singleton04 {
	private Singleton04() {
		
	}
	//通过内部类实现属性的延迟初始化(懒加载,延迟加载)
	static class inner{		
		private static Singleton04 instance = new Singleton04();
	}
	//类加载时对象创建且只创建一次
	public static Singleton04 getInstance() {
		return inner.instance;
	}
}
 