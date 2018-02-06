package com.yrw.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Client {
    //1.创建一个线程池
    //核心池初始化数量(10)
    private final static int THREAD_CORE_POOL_SIZE = 10;
    //可容纳线程数量(1分钟600线程, 最久3分钟, 600 * 3)
    private final static int THREAD_POOL_SIZE = 2000;
    //空闲线程销毁限时(最长3分钟)
    private final static int THREAD_KEEP_ALIVE_TIME = 3;
    //队列任务大小( LinkedBlockingQueue )
    private final static int THREAD_QUEUE_SIZE = Integer.MAX_VALUE;
    //线程池
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(THREAD_CORE_POOL_SIZE, THREAD_POOL_SIZE, THREAD_KEEP_ALIVE_TIME, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(THREAD_QUEUE_SIZE));

    //2.一个存放任务的队列
    private Map<Long, Integer> taskMap = new ConcurrentHashMap<Long, Integer>(600);

    /**
     * 读取任务
     */
    public void readTask() {
        //0-未开始 JDBC
        DemoTask demoTask = new DemoTask();
        synchronized (demoTask) {
            //1-进行中
            updateTask(demoTask, 1);
            //判断是否已经获取过
            if(taskMap.containsKey(demoTask.getId())) {
                Integer count = taskMap.get(demoTask.getId());
                taskMap.put(demoTask.getId(), ++count);
            }else {
                taskMap.put(demoTask.getId(), 1);
            }
        }

        //4.处理任务
        doTask(demoTask);
    }

    /**
     * 处理任务
     */
    public void doTask(DemoTask demoTask) {
        Integer count = taskMap.get(demoTask.getId());
        //4.判断是否已达到了最大重试次数
        if(count <= 3) {
            threadPoolExecutor.execute(new TaskThred(demoTask));
        }else {
            taskMap.remove(demoTask.getId());
        }

    }

    /**
     * 更新状态
     */
    public void updateTask(DemoTask demoTask, Integer status) {
        demoTask.setStatus(status);
    }

    /**
     * 任务处理线程
     */
    class TaskThred implements Runnable {

        private DemoTask demoTask;

        public TaskThred(DemoTask _demoTask) {
            this.demoTask = _demoTask;
        }

        //5.设置状态
        @Override
        public void run() {
            try {
                //6.处理业务逻辑
                Thread.sleep(60 * 1000);
                //1-已完成
                updateTask(demoTask, 2);
                //移除队列
                taskMap.remove(demoTask.getId());
            }catch (Exception e) {
                e.printStackTrace();
                //1-失败
                updateTask(demoTask, 3);
                Integer count = taskMap.get(demoTask.getId());
                taskMap.put(demoTask.getId(), ++count);
            }
        }
    }

    /**
     * 任务对象
     */
    class DemoTask {
        Long id;
        String name;
        Integer status; //0-未开始、1-进行中、2-已完成、3-失败
        String content;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
