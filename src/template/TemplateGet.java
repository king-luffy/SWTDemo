package template;

public class TemplateGet<T> {

	@SuppressWarnings("unchecked")
	public T getObj(Object obj){
		return (T)obj;
	}

	public static void main(String[] args) {
		TemplateGet<Student> tg = new TemplateGet<Student>();

		tg.getObj(new Student()).HelloWorld();

	}
}

class Student{
	public void HelloWorld(){
		System.out.println("Hello world!");
	}
}