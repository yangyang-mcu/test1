package ly.java.reflect;

import java.lang.reflect.Constructor;

public class ObjectFactory {
	
	public static <T>T newInstance(Class<T> cls, Class<?>[] paramTypes, Object[] args) throws Exception {
		
		Constructor<T> con = cls.getDeclaredConstructor(paramTypes);
		if(!con.isAccessible()) {
			con.setAccessible(true);
		}
		return con.newInstance(args);
	}
	
	public static <T>T newInstance(Class<T> cls) throws Exception{
		return newInstance(cls, null, null);
	}
}
