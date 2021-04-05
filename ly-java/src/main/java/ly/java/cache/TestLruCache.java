package ly.java.cache;

public class TestLruCache {
	public static void main(String[] args) {
		LruCache cache = new LruCache(new perpetualCache());
		cache.putObject("a", 100);
		cache.putObject("b", 200);
		cache.putObject("c", 300);
		cache.getObject("a");
		cache.putObject("d", 400);
		cache.putObject("e", 500);
		
		
		System.out.println(cache);
	}
}
