package ly.java.cache;

import java.util.Deque;
import java.util.LinkedList;

public class FifoCache implements Cache{
	
	private Cache cache;
	private Deque<Object> keyList = new LinkedList<Object>();
	
	private int maxCap = 3;
	
	public FifoCache(Cache cache) {
		this.cache = cache;
	}
	
	@Override
	public void putObject(Object key, Object value) {
		keyList.addLast(key);
		
		if (keyList.size() > maxCap) {
			Object firstKey = keyList.removeFirst();
			cache.removeObject(firstKey);
		}
		
		cache.putObject(key, value);
	}

	@Override
	public Object getObject(Object key) {
		return cache.getObject(key);
	}

	@Override
	public Object removeObject(Object key) {
		return cache.removeObject(key);
	}

	@Override
	public String toString() {
		return "FifoCache [cache=" + cache + ", keyList=" + keyList + ", maxCap=" + maxCap + "]";
	}
	
	

}
