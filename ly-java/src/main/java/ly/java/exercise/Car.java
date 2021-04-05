package ly.java.exercise;

public class Car implements Vehicle{

	@Override
	public void transport(String name ,String strPos) {
		System.out.println(name + "开车去" + strPos);
	}

}
