package ly.java.exercise.singleton;


class Singleton01{
	private Singleton01() {
		System.out.println("Singleton01..");
	}
	
	private static Singleton01 instance;
	
	public static Singleton01 getInstance() {
		if (instance == null) {
			instance = new Singleton01();
		}
		return instance;
	}
}

class Singleton02{
	private Singleton02(){
		System.out.println("Singleton02");
	}
	
	private static volatile Singleton02 instance;
	
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

class Singleton03{
	private Singleton03() {}
	private static Singleton03 instance = new Singleton03();
	
	public static Singleton03 getInstance() {
		return instance;
	}
}

class Singleton04{
	private Singleton04() {}
	static class inner{
		private static Singleton04 instance = new Singleton04();
	}
	
	public static Singleton04 getInstance() {
		return inner.instance;
	}
}

public class TestSingleton {
	public static void main(String[] args) {
//		doTestSingleton01();
		doTestSingleton02();
	}
	
	private static void doTestSingleton02() {
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
		Singleton02 s1 = Singleton02.getInstance();
		Singleton02 s2 = Singleton02.getInstance();
		
		System.out.println(s1 == s2);
	}
}
