package ly.java.singleton;
/**
 * 1.单例模式方案3:线程安全,无阻塞
 * 2.适合:小对象,频繁用
 * 3.此单例的缺陷?可能占用资源比较多,尤其是大对象.
 * @author liuya
 *
 */
public class Singleton03 {
	private Singleton03() {
		
	}
	//类加载时对象创建且只创建一次
	private static Singleton03 instance = new Singleton03();
	//类加载时对象创建且只创建一次
	public static Singleton03 getInstance() {
		return instance;
	}
}
 