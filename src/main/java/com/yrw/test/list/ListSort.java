package com.yrw.test.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSort {

    public static void main(String[] args) {
        int num = 10;
        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            intList.add((int)(Math.random() * 1000));
        }

//        Collections.sort(intList);
        Collections.sort(intList,Collections.<Integer>reverseOrder());

        for (int i = 0; i < num; i++) {
            System.out.println(intList.get(i));
        }

    }

}
