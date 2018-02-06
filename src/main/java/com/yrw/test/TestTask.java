package com.yrw.test;

import javax.sql.DataSource;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by frankie on 2017/8/31.
 *
 * //评测题目: //评测题目:+编写代码题：
 有一张任务表demo_task。有4个字段，分别是
 id（任务ID）、
 name（任务名）、
 status（任务状态，分别是未开始、进行中、已完成、失败）、
 content（任务内容）。

 业务逻辑是，每秒会至少新增10个任务，状态是末开始，进行中的任务一般要处理1分钟，有些任务会失败，因此需要重试3次。
 请用java多线程机制，实现一个任务处理的流程。
 任务处理部分请用伪代码即可。
 重点是从数据表读取任务、多线程处理任务、更新状态这三个部分。
 其余可省略。请随意发挥。

 1、	请编写伪代码，将任务处理的整个流程体现出来？
 2、	你觉得这个任务处理的核心问题是什么？为什么？
 3、  如何提升开发者的开发效率，请举一个你实践过的案例。

 */
public class TestTask {

    //核心池初始化数量
    private final static int THREAD_CORE_POOL_SIZE = 2;
    //可容纳线程数量
    private final static int THREAD_POOL_SIZE = 2;
    //空闲线程销毁限时
    private final static int THREAD_KEEP_ALIVE_TIME = 2;
    //队列任务大小
//    private final static int THREAD_QUEUE_SIZE = 2;
    //线程池
//    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(THREAD_CORE_POOL_SIZE, THREAD_POOL_SIZE, THREAD_KEEP_ALIVE_TIME, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(THREAD_QUEUE_SIZE));

   private static Map<Long ,Integer> taskMap = new ConcurrentHashMap<>();

    //数据源
    DataSource dataSource;

    //定义线程池，初始化10个线程
    final static int CORE_POOL_SIZE = 10;
//    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE);
//
//    //读取任务
//    public void readTask() {
//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//                while(true) {
//
//                    List<Future> futureList = new ArrayList<Future>();
//                    //读取新任务
//                    List<DemoTask> newTaskList = dataSource.execute("select * from demo_task where status = 0");
//                    for(DemoTask demoTask : newTaskList) {
//                        //任务线程处理
//                        futureList.add(threadPoolExecutor.submit(new TaskThred(demoTask)));
//                    }
//                    //等待所有任务处理完毕.
//                    for(Future future : futureList) {
//                        try {
//                            future.get();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        } catch (ExecutionException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    //跑批间隔
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }).start();
//
//    }
//
//    //任务处理线程
//    public class TaskThred implements Callable {
//        private DemoTask demoTask;
//
//        public TaskThred(DemoTask dt) {
//            this.demoTask = dt;
//        }
//
//        @Override
//        public Object call() throws Exception {
//            //更新状态：1-进行中
//            dataSource.execute("update demoTask set status = 1 where id = ?" , new Object[] { demoTask.getId() });
//            //处理任务，返回处理状态（重试次数）
//            int status = doTask(demoTask, 3);
//            //更新状态: 2-已完成、3-失败
//            dataSource.execute("update demoTask set status = ? where id = ?" , new Object[] { status, demoTask.getId() });
//            return null;
//        }
//
//        //处理任务，并且进行重试
//        private int doTask(DemoTask demoTask, int remain) throws InterruptedException {
//            int status = businessLogic(demoTask);
//            --remain;
//            //如果业务处理失败 && 重试次数 > 0
//            while(status == 3 && remain > 0) {
//                Thread.sleep(5000);
//                status = businessLogic(demoTask);
//                --remain;
//            }
//            return status;
//        }
//
//        //处理业务逻辑
//        public int businessLogic(DemoTask demoTask) {
//            //do something...
//            return status;
//        }
//    }



}







class DemoTask{
    Long id;
    String name;
    int status ; //0未开始、1进行中、2已完成、3失败
    String Content;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}