package com.yrw.test;

import java.util.ArrayList;
import java.util.List;



public class TestListAdd {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.setName("P1");
		p1.setSex("男");
		p1.setAge(20);
		
		Person p2 = new Person();
		p2.setName("p2");
		p2.setSex("男");
		p2.setAge(22);
		
		Person p3 = new Person();
		p3.setName("p3");
		p3.setSex("男");
		p3.setAge(23);
		
		Person p4 = new Person();
		p4.setName("p4");
		p4.setSex("男");
		p4.setAge(24);

		Person p5 = new Person();
		p5.setName("P5");
		p5.setSex("男");
		p5.setAge(20);
		
		Person p6 = new Person();
		p6.setName("p6");
		p6.setSex("男");
		p6.setAge(22);
		
		Person p7 = new Person();
		p7.setName("p7");
		p7.setSex("男");
		p7.setAge(23);
		
		Person p8 = new Person();
		p8.setName("p8");
		p8.setSex("男");
		p8.setAge(24);
		
		List<Person> per1List= new ArrayList<>();
		per1List.add(p1);
		per1List.add(p2);
		per1List.add(p3);
		per1List.add(p4);
		
		
		List<Person> per2List= new ArrayList<>();
		per2List.add(p5);
		per2List.add(p6);
		per2List.add(p7);
		per2List.add(p8);
		
		per1List.addAll(per2List);
		
		for(Person p:per1List){
			System.out.println(p.getName());
		}
		
	}
	
	

}
