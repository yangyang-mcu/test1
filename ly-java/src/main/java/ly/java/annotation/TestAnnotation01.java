package ly.java.annotation;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URL;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Component{
	String value() default "";
	boolean lazy();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ComponentScan{
	String value() default "";
}

@Component(value = "searchService", lazy = true)
class DefaultSearchService{}

@ComponentScan("ly.java.singleton")
class ServiceConfig{}


public class TestAnnotation01 {
	public static void main(String[] args) {
//		doMethod01();
		doMethod02();
	}
	
	public static void doMethod02() {
		Class<?> cls = ServiceConfig.class;
		ComponentScan cs = cls.getAnnotation(ComponentScan.class);
		String pkg = cs.value();
		String pkgPath = pkg.replace(".", "/");
		URL url = ClassLoader.getSystemResource(pkgPath);
		File file = new File(url.getPath());
		File[] clsFile = file.listFiles();
		
		for (File f : clsFile) {
			System.out.println(f.getName());
		}
	}
	
	
	public static void doMethod01() {
		Class<?> cls = DefaultSearchService.class;
		Component com = cls.getAnnotation(Component.class);
		boolean flag = com.lazy();
		System.out.println(flag);
	}
}
