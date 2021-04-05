package ly.java.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache implements Cache{
	
	private Cache cache;
	private Map<Object, Object> keyMap;
	private Object eldestKey;
	
	public LruCache(Cache cache) {
		this.cache = cache;
		setSize(3);
	}
	
	public void setSize(final int size) {
		keyMap = new LinkedHashMap<Object, Object>(size, 0.75f, true){

			private static final long serialVersionUID = 9038894216547487458L;
			
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<Object, Object> eldest) {
				boolean tooBig = size() > size;
				if (tooBig) {
					eldestKey = eldest.getKey();
				}
				return tooBig;
			}
		};
	}
	
	@Override
	public void putObject(Object key, Object value) {
		cache.putObject(key, value);
		cycleKeyList(key);
	}

	private void cycleKeyList(Object key) {
		keyMap.put(key, key);
		if (eldestKey != null) {
			cache.removeObject(eldestKey);
			eldestKey = null;
		}
	}

	@Override
	public Object getObject(Object key) {
		keyMap.get(key);
		return cache.getObject(key);
	}

	@Override
	public Object removeObject(Object key) {
		return cache.removeObject(key);
	}

	@Override
	public String toString() {
		return "LruCache [cache=" + cache + ", keyMap=" + keyMap + ", eldestKey=" + eldestKey + "]";
	}
	
	

}
