package ly.java.exercise;

public class Person {
	private String name;
	
//	private Vehicle vehicle;
	
	public Person(String name/* , Vehicle vehicle */) {
		this.name = name;
//		this.vehicle = vehicle;
	}
	
	public void goTo(Vehicle vehicle,String strPos) {
		if (vehicle instanceof Vehicle) {
			vehicle.transport(this.name, strPos);
		}else {
			System.out.println("需要传入交通工具");
		}
		
	}
	

}
