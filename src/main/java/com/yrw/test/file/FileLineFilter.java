package com.yrw.test.file;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjiong on 2016-6-2.
 *
 * 文件内容行过滤器，当遍历一个文件时可能要摘出其中满足某种条件的一些行
 *
 * 该过滤器只把满足条件的行收集起来，不影响该行被正常的迭代逻辑处理
 */
public abstract class FileLineFilter {

    private List<String> result = new ArrayList<String>();//过滤出的结果

    /**
     * 主调函数
     * @param line
     */
    public void filter(String line){
        if(accept(line)){
            result.add(line);
        }
    }

    /**
     * 返回过滤的结果
     * @return
     */
    public List<String> getResult() {
        return result;
    }

    /**
     * 判断该行是否满足条件
     * @param line
     * @return
     */
    public abstract boolean accept(String line);


}


