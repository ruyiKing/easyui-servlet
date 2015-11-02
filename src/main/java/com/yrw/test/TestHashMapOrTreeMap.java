
package com.yrw.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestHashMapOrTreeMap {
	
	public static void main(String[] args) {
		Map<String, Object> hashMap = new HashMap<>();
		Map<String, Object> treeMap = new TreeMap<>();
		
		hashMap.put("a", 1);
		hashMap.put("c", 2);
		hashMap.put("b", 4);
		hashMap.put("e", 3);
		hashMap.put("d", 5);
		
		treeMap.put("a", 6);
		treeMap.put("e", 4);
		treeMap.put("f", 2);
		treeMap.put("d", 5);
		treeMap.put("c", 1);
		treeMap.put("b", 3);
		
		System.out.println("----------hashMap:"+hashMap);
		System.out.println("----------treeMap(根据Key排序):"+treeMap);
		
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("d", 2);
		map.put("c", 1);
		map.put("b", 1);
		map.put("a", 3);

		List<Map.Entry<String, Integer>> infoIds =
		    new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

		//排序前
		for (int i = 0; i < infoIds.size(); i++) {
		    String id = infoIds.get(i).toString();
		    System.out.println(id);
		}
		//d 2
		//c 1
		//b 1
		//a 3

		//排序
		Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {   
		    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {      
		        //return (o2.getValue() - o1.getValue()); 
		        return (o1.getKey()).toString().compareTo(o2.getKey());
		    }
		}); 

		//排序后
		for (int i = 0; i < infoIds.size(); i++) {
		    String id = infoIds.get(i).toString();
		    System.out.println(id);
		}
		//根据key排序
		//a 3
		//b 1
		//c 1
		//d 2
		//根据value排序
		//a 3
		//d 2
		//b 1
		//c 1
		
	}

}
