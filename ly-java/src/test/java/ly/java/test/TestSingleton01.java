package ly.java.test;

import ly.java.singleton.Singleton01;

public class TestSingleton01 {
	public static void main(String[] args) {
		doMethod01();
	}

	private static void doMethod01() {
		Singleton01 s1 = Singleton01.getInstance();
		Singleton01 s2 = Singleton01.getInstance();
		
		System.out.println(s1 == s2);
	}
}
