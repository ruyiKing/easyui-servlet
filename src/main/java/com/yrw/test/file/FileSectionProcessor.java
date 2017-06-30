package com.yrw.test.file;

import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件处理器，分块处理
 * Created by chenjiong on 2016-6-1.
 */
public class FileSectionProcessor {

    private static Logger log = LoggerFactory.getLogger(FileSectionProcessor.class);

    public static final int DEFAULT_SECTION_SIZE = 20000;//默认块尺寸

    private List<FileLineFilter> filterChain = new ArrayList<FileLineFilter>();

    private int sectionSize = DEFAULT_SECTION_SIZE;//块尺寸
    private int lineNum = 0;//文件行数量
    private int sectionNum = 0;//分块数量

    private SectionProcessor sectionProcessor;

    public FileSectionProcessor(SectionProcessor sectionProcessor){
        this.sectionProcessor = sectionProcessor;
    }


    /**
     * 分批次处理文件
     */
    public void processFile(File file,String charset) throws Exception {

        LineIterator it = null;
        try{
            it = org.apache.commons.io.FileUtils.lineIterator(file,charset);
        }catch(Exception e){
            e.printStackTrace();;
            throw new RuntimeException("读取文件发生异常",e);
        }

        List<String> rows = new ArrayList<String>();

        int tmpSectionSize = sectionSize-1;

        try {
            while (it.hasNext()) {
                String line = it.nextLine();

                if(filterChain.size()>0){
                    filterChainFiler(line);//过滤器链过滤行
                }
                if(line==null || line.trim().length()==0){
                    continue;
                }

                rows.add(line);
                lineNum++;

                if(rows.size() > tmpSectionSize  || !it.hasNext()){

                    sectionNum ++;//满批则批次号加1
//                    log.info("批次数量："+sectionNum);

                    //执行批次
                    sectionProcessor.processSection(rows);

                    //每批处理完要清空数组
                    rows.clear();
                }
            }
        } finally {
            LineIterator.closeQuietly(it);
        }
    }

    /**
     * 获得块尺寸
     * @return
     */
    public int getSectionSize() {
        return sectionSize;
    }

    /**
     * 设置块尺寸
     * @param sectionSize
     */
    public void setSectionSize(int sectionSize) {
        this.sectionSize = sectionSize;
    }


    /**
     * 获得文件行数量，执行完后才能计算出值
     * @return
     */
    public int getLineNum() {
        return lineNum;
    }

    /**
     * 获得块数量，执行完后才能计算出值
     * @return
     */
    public int getSectionNum() {
        return sectionNum;
    }


    //过滤器链过滤行
    private void filterChainFiler(String line){
        for(FileLineFilter filter : filterChain){
            filter.filter(line);
        }
    }

    public void addFilter(FileLineFilter filter){
        this.filterChain.add(filter);
    }

    public void removeFilter(FileLineFilter filter){
        this.filterChain.remove(filter);
    }

    public void removeAllFilter(){
        this.filterChain.clear();
    }


    public SectionProcessor getSectionProcessor() {
        return sectionProcessor;
    }

    public void setSectionProcessor(SectionProcessor sectionProcessor) {
        this.sectionProcessor = sectionProcessor;
    }

}
