package ly.java.cache;

public class LogCache implements Cache{

	private Cache cache;
	private int request;
	private int hit;
	
	public LogCache(Cache cache) {
		this.cache = cache;
	}
	
	@Override
	public void putObject(Object key, Object value) {
		cache.putObject(key, value);
	}

	@Override
	public Object getObject(Object key) {
		this.request++;
		Object obj = cache.getObject(key);
		if (obj != null) {
			this.hit++;
		}
		System.err.println("request hit:" + getRequestHit());
		return obj;
	}

	private double getRequestHit() {

		return this.hit * 1.0 / this.request;
	}

	@Override
	public Object removeObject(Object key) {
		return cache.removeObject(key);
	}

}
