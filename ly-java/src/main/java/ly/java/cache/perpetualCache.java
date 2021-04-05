package ly.java.cache;

import java.util.HashMap;
import java.util.Map;

public class perpetualCache implements Cache{

	private Map<Object, Object> cache = new HashMap<Object, Object>();
	
	@Override
	public void putObject(Object key, Object value) {
		cache.put(key, value);
	}

	@Override
	public Object getObject(Object key) {
		return cache.get(key);
	}

	@Override
	public Object removeObject(Object key) {
		return cache.remove(key);
	}

	@Override
	public String toString() {
		return "perpetualCache [cache=" + cache + "]";
	}
	
	

}
