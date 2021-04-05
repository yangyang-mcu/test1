package ly.java.synlist;

import java.util.ArrayList;
import java.util.HashMap;

class SynArrayList<E> extends ArrayList<E>{

	private static final long serialVersionUID = 6276464961139765629L;
	
	@Override
	public synchronized boolean add(E e) {
		return super.add(e);
	}
	
	@Override
	public synchronized E get(int index) {
		return super.get(index);
	}
}


class SynHashMap<V> extends HashMap<String, V>{

	private static final long serialVersionUID = -7433414566387343597L;
	
	@Override
	public synchronized V put(String key, V value) {
		return super.put(key, value);
	}
	
	@Override
	public V get(Object key) {
		return super.get(key);
	}
}

public class TestSynList {

}
