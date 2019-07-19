package com.newlecture.web.entity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JSONParser {

	public static String toJSON(Object object) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
	//제이슨 객체 변환 라이브러리 만들어보기!!!종갓집!!!!
	//여기서 this는 파일객체
	//스프링에서는 객체가 가진 속성을 동적으로 알아낼 수 있다 --> 알아야 문자열로 만들 수 있다
	
	Class<?> clazz = object.getClass();
	
	Field[] fields = clazz.getDeclaredFields();
	//Method method = clazz.getDeclaredMethod(name, parameterTypes);
	Method[] methods = clazz.getDeclaredMethods();
		
	//getClass() --> 객체가 가진 속성, 어노테이션 등등 타입정보 얻어낼 수 있는  제공해주는 타입인포메이션객체 RTTI 라고 한다
	//Field[] fields = object.getClass().getDeclaredFields(); //this가 가진 class정보, 그 안의 속성 알아내기 --> getDeclaredFields()
	
	//for(int i=0; i<fields.length; i++)
	//System.out.println(fields[i].getName());
	
	StringBuilder json = new StringBuilder();
	json.append("{");
	for(Field field : fields) {
		
		//private이기 때문에 member에 접근할 수 없는 문제가 있어서
		//public한 getter를 통해 얻어오려고 한다
		//1. getter 를 다 뒤지는 방법(버그가 존재할 수 있다) 2.메소드 fields에 getter를 붙여주는 방법 
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
