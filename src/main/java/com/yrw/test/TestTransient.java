package com.yrw.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 序列化（又叫串行化）就是一种用来处理对象流的机制，所谓对象流也就是将对象的内容进行流化。
 * 可以对流化后的对象进行读写操作，也可将流化后的对象传输于网络之间。
 * 序列化是为了解决在对对象流进行读写操作时所引发的问题。 
 * 序列化的实现：将需要被序列化的类实现Serializable接口，该接口没有需要实现的方法，
 * implements Serializable只是为了标注该对象是可被序列化的，
 * 然后使用一个输出流(如：FileOutputStream)来构造一个 ObjectOutputStream(对象流)对象，接着，使用ObjectOutputStream对象的writeObject(Object obj)方法就可以将参数为obj的对象写出(即保存其状态)，
 * 要恢复的话则用输入流。 
 *
 * @author fate
 *
 */
public class TestTransient {  
  
    private static ObjectInputStream ois;  
  
    /** 
     * @param args 
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws ClassNotFoundException 
     */  
    public static void main(String[] args) throws FileNotFoundException,  
            IOException, ClassNotFoundException {  
    	Avo a = new Avo(25, "张三");  
        System.out.println(a);  
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(  
                "d://mm.txt"));  
        oos.writeObject(a);  
        oos.close();  
        ois = new ObjectInputStream(new FileInputStream("d://mm.txt"));  
        a = (Avo) ois.readObject();  
        System.out.println(a);  
        //属性b前添加关键字transient，我们看到虽然我们序列化的对象a的属性值为“张三”，但是当我们反序列化之后发现这个属性为空，说明这个属性没有进行序列化。
  
    }  
  
}  
  
class Avo implements Serializable {  
    /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  
    int a;  
        //transien修饰符 反序列化变量b；  
    transient String b;  
  
    public Avo(int a, String b) {  
        this.a = a;  
        this.b = b;  
    }  
  
    public String toString() {  
        return "a = " + a + ",b = " + b;  
    }  
}  