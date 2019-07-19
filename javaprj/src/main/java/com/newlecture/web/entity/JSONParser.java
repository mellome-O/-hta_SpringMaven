package com.newlecture.web.entity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JSONParser {

	public static String toJSON(Object object) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
	//���̽� ��ü ��ȯ ���̺귯�� ������!!!������!!!!
	//���⼭ this�� ���ϰ�ü
	//������������ ��ü�� ���� �Ӽ��� �������� �˾Ƴ� �� �ִ� --> �˾ƾ� ���ڿ��� ���� �� �ִ�
	
	Class<?> clazz = object.getClass();
	
	Field[] fields = clazz.getDeclaredFields();
	//Method method = clazz.getDeclaredMethod(name, parameterTypes);
	Method[] methods = clazz.getDeclaredMethods();
		
	//getClass() --> ��ü�� ���� �Ӽ�, ������̼� ��� Ÿ������ �� �� �ִ�  �������ִ� Ÿ���������̼ǰ�ü RTTI ��� �Ѵ�
	//Field[] fields = object.getClass().getDeclaredFields(); //this�� ���� class����, �� ���� �Ӽ� �˾Ƴ��� --> getDeclaredFields()
	
	//for(int i=0; i<fields.length; i++)
	//System.out.println(fields[i].getName());
	
	StringBuilder json = new StringBuilder();
	json.append("{");
	for(Field field : fields) {
		
		//private�̱� ������ member�� ������ �� ���� ������ �־
		//public�� getter�� ���� �������� �Ѵ�
		//1. getter �� �� ������ ���(���װ� ������ �� �ִ�) 2.�޼ҵ� fields�� getter�� �ٿ��ִ� ��� 
		String name = field.getName();
		String getterName = "get"
								+Character.toUpperCase(name.charAt(0))
								+name.substring(1);
		
		Method method = clazz.getDeclaredMethod(getterName, new Class[] {});
		String value = String.valueOf(method.invoke(object));
		
		json.append(String.format("\"%s\":\"%s\"", name, value));
		
	}
	json.append("}");
	return json.toString();	
//	return String.format("{\"name\":\"%s\", \"type\":\"%s\", \"size\":\"%d\",\"createdDate\":\"%s\"}"
//					,name ,type, size, createdDate);				
	}

}
