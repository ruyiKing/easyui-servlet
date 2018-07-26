package com.yrw.test.list;

import java.util.ArrayList;
import java.util.List;

public class TestRetainAll {
    public static void main(String[] args) {

        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();
        list1.add(11L);
        list1.add(12L);
        list1.add(13L);
        list1.add(14L);
        list2.add(13L);
        list2.add(14L);
        list2.add(15L);
        list2.add(16L);

        list1.retainAll(list2);

        for (Long str : list1){
            System.out.println(str);
        }
    }

}
