package com.tik.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo1 {

	public static void main(String[] args) {
		//要获取print(int,int)方法 
		/*
		 * 1.要获取一个方法就是要获取类的信息，获取类的信息首先要获取类的类类型
		 */
		S a1 = new S();
		Class c = a1.getClass();
		/*
		 * 2.获取方法 由名称和参数列表决定
		 * getMethod获取的是所有public方法
		 * getDeclaredMethod 自己声明的方法
		 */
		try {
//			Method m = c.getMethod("print", new Class[]{int.class, int.class});
			//上下等效
			Method m = c.getMethod("print", int.class, int.class);
			Method m2 = c.getMethod("print", String.class, String.class);
			Method m3 = c.getDeclaredMethod("print", String.class);
			//方法的反射操作
			//a1.print(10,20);方法的反射操作使用m对象来进行方法调用
//			m.invoke(a1, new Object[]{10, 20});
			//上下等效
			m.invoke(a1, 10, 20);
			m2.invoke(a1, "hELlo", "WoRld");
			//要利用反射调用private方法，必须设置该方法setAccessible为true
			m3.setAccessible(true);
			m3.invoke(a1, "tik");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class S{
	
	private void print(String s){
		System.out.println("this is " + s);
	}
	public void print(int a, int b){
		System.out.println(a + b);
	}
	
	public void print(String a, String b){
		System.out.println(a.toUpperCase() + "," + b.toLowerCase());
	}
}
