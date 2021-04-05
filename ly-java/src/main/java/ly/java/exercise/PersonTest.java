package ly.java.exercise;

public class PersonTest {
	public static void main(String[] args) {
		Person p01 = new Person("老张");
		p01.goTo(new Car(), "东北");
		p01.goTo(new Airplane(), "海南");
	}
}
