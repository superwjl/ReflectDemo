package com.tik.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassUtil {

	/**
	 * 获取类名信息
	 * getName()获取含包名的全称
	 * getSimpleName()获取简称（不含包名）
	 */
	public static void printClassNameMessage(Object obj){
		Class c = obj.getClass();
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
	}
	
	/**
	 * 获取成员变量信息
	 * getFields()获取所有的public的成员变量信息
	 * getDeclaredFields()获取该类自己声明的成员变量的信息
	 */
	public static void printClassFieldMessage(Object obj){
		Class c = obj.getClass();
//		Field[] fds = c.getFields();
		Field[] fds = c.getDeclaredFields();
		for (Field field : fds) {
			Class fieldType = field.getType();
			String modifier = Modifier.toString(field.getModifiers());
			String type = fieldType.getSimpleName();
			String name = field.getName();
			System.out.println(modifier + " " + type + " " + name);
		}
	}
	
	/**
	 * 获取方法信息
	 * getMethods()获取所有的public的方法信息
	 * getDeclaredMethods()获取该类自己声明的方法信息
	 */
	public static void printClassMethodMessage(Object obj){
		Class c = obj.getClass();
//		Method[] ms = c.getMethods();
		Method[] ms = c.getDeclaredMethods();
		for (int i = 0; i < ms.length; i++) {
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			System.out.print(ms[i].getName() + "(");
			Class[] paramTypes = ms[0].getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
		}
	}
	
	public static void printClassConMessage(Object obj){
		Class c = obj.getClass();
		Constructor[] cons = c.getDeclaredConstructors();
		for (Constructor constructor : cons) {
			System.out.print(constructor.getName() + "(");
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}
}

