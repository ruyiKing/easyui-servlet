package com.yrw.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

	private static Set<String> linkedHashSet = new LinkedHashSet<String>();
	private static Set<String> hashSet = new HashSet<String>();
	private static Set<String> treeSet = new TreeSet<>();
	private static List<String> arrayList = new ArrayList<>();
	
	public static void main(String[] args) {
		linkedHashSet.add("c");
		linkedHashSet.add("1");
		linkedHashSet.add("2");
		linkedHashSet.add("2");
		linkedHashSet.add("3");
		linkedHashSet.add("4");
		linkedHashSet.add("a");
		linkedHashSet.add("b");
		linkedHashSet.add("a");
		
		arrayList.add("5");
		arrayList.add("1");
		arrayList.add("6");
		arrayList.add("2");
		arrayList.add("3");
		arrayList.add("4");
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("a");
		
		hashSet.addAll(arrayList);
		
		System.out.println("-------------linkedHashSet");
		for(String s:linkedHashSet){
			System.out.println(s);
		}
		
		System.out.println("-------------ArrayList");
		for(String sl:arrayList){
			System.out.println(sl);
		}
		
		System.out.println("-------------hashSet");
		for(String s:hashSet){
			System.out.println(s);
		}
		
		treeSet.addAll(hashSet);
		System.out.println("---------------treeSet:"+treeSet);
		
		Collections.sort(arrayList);//对list进行排序
		System.out.println("Collections.sort(arrayList):"+arrayList);
		
		System.out.println("-------------set.iterator");
		Iterator<String> iset = linkedHashSet.iterator();
		while(iset.hasNext()){
			String sn = iset.next();
			if ("a".equals(sn)) {
				iset.remove();
			}
		}
		System.out.println(linkedHashSet);
		
		

	}

}
