package ly.java.singleton;
/**
 * 1.单例模式方案2:线程安全,有阻塞或少阻塞的单例设计
 * 2.适合大对象,稀少用(并发访问少)
 * @author liuya
 *
 */
public class Singleton02 {
	//构造方法私有化,不允许外界直接构建对象
	private Singleton02() {
		System.out.println("Singleton02()");
	}
	
	//volatile 关键字的作用(修饰类中属性)
	//1)保证线程的可见性
	//2)禁止指令重排序
	//3)但不能保证其原子性
	//记住:当多个线程对一个共享变量进行操作时,请使用volatile修饰
	private static volatile Singleton02 instance;
	
		//synchronized 保证代码的原子性(不能同时有多个线程对这个代码块进行访问)
		//synchronized 要让多个线程在这个代码块上顺序执行
		//此设计虽然保证了安全,但性能会被降低.
//		public synchronized static Singleton02 getInstance() {
//			if(instance==null) {
//				instance=new Singleton02();
//			}
//			return instance;
//		}
	
	//重构如上方法的设计,既要保证安全又要提高性能
	public static Singleton02 getInstance() {
		
		if (instance == null) {
			synchronized (Singleton02.class) {
				if (instance == null) {
					instance = new Singleton02();
				}
			}
			
		}
		
		return instance;
	}
}
