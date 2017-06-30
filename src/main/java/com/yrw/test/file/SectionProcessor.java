package com.yrw.test.file;

import java.util.List;

/**
 * Created by chenjiong on 2016-6-1.
 */
public interface SectionProcessor {

    /**
     * 处理文件内容块
     * @param rows
     * @throws Exception
     */
    public void processSection(List<String> rows) throws Exception;
}
