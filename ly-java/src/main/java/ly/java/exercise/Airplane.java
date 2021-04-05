package ly.java.exercise;

public class Airplane implements Vehicle{

	@Override
	public void transport(String name, String strPos) {
		System.out.println(name + "坐飞机去" + strPos);
	}

}
