package com.tik.reflect;

public class ClassDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello";
		int a = 5;
		boolean b = false;
//		ClassUtil.printClassNameMessage(s);
		ClassUtil.printClassFieldMessage(new A());
		ClassUtil.printClassMethodMessage(new A());
		ClassUtil.printClassConMessage(new Integer(1));
	}

}
class A{
	private int a;
	public String b;
	public double c;
	
	private void show(String name){
		
	}
	
	public void fly(int a){
		
	}
}
