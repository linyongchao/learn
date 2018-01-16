package my.learn.jdktest.methodreferences;

public class ComparisonProvider {
	public int compare(Person p1, Person p2) {
		return p1.age.compareTo(p2.age);
	}
}
