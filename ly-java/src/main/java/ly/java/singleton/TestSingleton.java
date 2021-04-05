package ly.java.singleton;

public class TestSingleton {
	public static void main(String[] args) {
//		doTestSingleton01();
		doTestSingleton02();
	}
	
	public static void doTestSingleton02() {
		class Task implements Runnable{
			@Override
			public void run() {
				Singleton02.getInstance();
			}
		}
		
		Thread t1 = new Thread(new Task());
		Thread t2 = new Thread(new Task());
		Thread t3 = new Thread(new Task());
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	private static void doTestSingleton01() {
		Singleton01 s1 = Singleton01.getInstance();
		Singleton01 s2 = Singleton01.getInstance();
		
		System.out.println(s1 == s2);
	}
}
