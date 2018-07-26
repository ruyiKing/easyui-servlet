package com.yrw.test.array;

import net.sf.json.JSONArray;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.Collections;

import static com.yrw.test.array.RandomSort.SORT_ASC;
import static com.yrw.test.array.RandomSort.SORT_DESC;


public class RandomSortTest {
    @Test
    public void getRandomTest() throws Exception {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        int num = 10;
        Integer arr[] = new Integer[num];
        Integer arrAsc[] = new Integer[num];
        Integer arrDesc[] = new Integer[num];
        //随机获取

        arr = RandomSort.getRandomSort(arr,num,"");

        //正序
        arrAsc = RandomSort.getRandomSort(arrAsc,num,SORT_ASC);

        //倒序
        arrDesc = RandomSort.getRandomSort(arrDesc,num,SORT_DESC);

        //输出结果
        System.out.println("获取随机："+ JSONArray.fromObject(arr));
        System.out.println("获取正序："+ JSONArray.fromObject(arrAsc));
        System.out.println("获取倒序："+ JSONArray.fromObject(arrDesc));

    }



}

 class RandomSort {

    public static final String SORT_ASC = "ASC";
    public static final String SORT_DESC = "DESC";


    public static   Integer[] getRandomSort(Integer[] arr ,int num,  String sortAsc) {

        //随机获取1000以内的10个数
        for (int i = 0; i < num; i++) {
            arr[i] = (int)(Math.random() * 1000);
        }
        //排序
        switch (sortAsc){
            //正序
            case SORT_ASC :  Arrays.sort(arr); break;
            //倒序
            case SORT_DESC : Arrays.sort(arr, Collections.<Integer>reverseOrder()); break;

            default: break;
        }


        return arr;
    }


}