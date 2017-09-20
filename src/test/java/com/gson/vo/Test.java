package com.gson.vo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gson.builder.MyGsonBuilder;

import junit.framework.TestCase;

public class Test extends TestCase{
	public void testPerson() {

		
		List<Person> list = new ArrayList<Person>();
		Student student = new Student();
		student.setName("张三");
		student.setAge(15);
		student.setSex("男");
		student.setSchoolName("XXX");
		student.setStudentId(123);
		
		Teacher teacher = new Teacher();
		teacher.setName("李四");
		teacher.setAge(50);
		teacher.setSchoolName("XXX");
		teacher.setSex("男");
		teacher.setTeacherId(789);
		
		
		list.add(teacher);
		list.add(student);
		
		Classroom cr = new Classroom();
		cr.setList(list);
		
		GsonBuilder gb = new GsonBuilder();
		Gson gson = gb.create();
		String msg = gson.toJson(cr);
		System.out.println(msg);
		
		GsonBuilder builder = MyGsonBuilder.getMyGsonBuilder();
		Gson gson2 = builder.create();
		Classroom cr2 = (Classroom)gson2.fromJson(msg, Classroom.class);
		
		assertEquals(cr.getList().get(0).getName(), cr2.getList().get(0).getName());
		assertEquals(cr.getList().get(1).getName(), cr2.getList().get(1).getName());
	}
}
