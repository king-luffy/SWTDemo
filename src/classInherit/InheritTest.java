package classInherit;

public class InheritTest {

	
	public static void main(String[] args) {
	
		Class<?> parentClz = Parent.class;
		Class<?> childClz = Child.class;
		
		Boolean isFather = childClz.isAssignableFrom(parentClz);
		isFather = parentClz.isAssignableFrom(childClz);
		
		System.out.println(isFather);
	}
}

class Parent{
	
}

class Child extends Parent{
	
}
