package com.tik.reflect;

public class ClassDemo1 {

	public static void main(String[] args) {
		//Foo的实例对象如何表示
		Foo foo1 = new Foo();
		
		//第一种方式	任何一个类都有一个隐含的静态成员变量
		Class c1 = Foo.class;
		//第二种方式	通过类的实例对象调用getClass方法
		Class c2 = foo1.getClass();
		/* c1,c2表示了Foo类的类类型(class type)
		 * 万事万物皆对象，
		 * 类（这里指c1，c2）也是对象，是Class类的实例对象
		 * 这个对象（这里指c1，c2）称为类类型
		 */
		// c1，c2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
		System.out.println(c1 == c2);
		Class c3 = null;
		try {
			c3 = Class.forName("com.tik.reflect.Foo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated cat	ch block
			e.printStackTrace();
		}
		System.out.println(c1 == c3);
		/* 可以通过该类的类类型创建该类的实例对象
		 * 即：通过c1 or c2 or c3创建Foo类的实例对象
		 */
		try {
			Foo foo = (Foo) c1.newInstance();
			foo.print();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Foo{
	void print(){
		System.out.println("foo");
	}
}
