package ly.java.cache;

public interface Cache {
	void putObject(Object key, Object value);
	Object getObject(Object key);
	Object removeObject(Object key);
}
