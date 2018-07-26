package com.yrw.test.image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 把两张图片合并
 * @version 2018-2-27 上午11:12:09
 *
 */
public class Picture1
{
     private Graphics2D g        = null;  
      
    /**  
     * 导入本地图片到缓冲区  
     */  
    public BufferedImage loadImageLocal(String imgName) {  
        try {  
            return ImageIO.read(new File(imgName));  
        } catch (IOException e) {  
            System.out.println("异常1"+e.getMessage());
        }  
        return null;  
    } 
    
    public BufferedImage modifyImagetogeter(BufferedImage ma, BufferedImage beiJing) {
        
        try {  
//            int w = ma.getWidth();
//            int h = ma.getHeight();
            int w = 176;
            int h = 176;
            int x = 186;
            int y = 533;

  
//            g = beiJing.createGraphics();
////            g.drawImage(b, 100, -200, w, h, null);
////            g.drawImage(ma, x, y, w, h, null);
//            g.drawImage( ma.getScaledInstance(w, h, Image.SCALE_SMOOTH), x, y, null);
//            g.dispose();

            Graphics g = beiJing.createGraphics();
//            g.drawImage(beiJing, 0, 0, beiJing.getWidth(), beiJing.getHeight(), null);
//            g.drawImage(ma, x, y, 176 , 176, null);
            g.drawImage( ma.getScaledInstance(w, h, Image.SCALE_SMOOTH), x, y, null);
            g.dispose();


        } catch (Exception e) {
            System.out.println("异常2"+e.getMessage());
        }  
  
        return beiJing;
    } 
    
    /**  
     * 生成新图片到本地  
     */  
    public void writeImageLocal(String newImage, BufferedImage img) {  
        if (newImage != null && img != null) {  
            try {  
                File outputfile = new File(newImage);  
                ImageIO.write(img, "jpg", outputfile);  
            } catch (IOException e) {
                System.out.println("异常3"+e.getMessage());
            }  
        }  
    } 
        
    public static void main(String[] args) {  
        
        Picture1 tt = new Picture1();  
  
        BufferedImage ma = tt.loadImageLocal("E:/ma.jpg");
        BufferedImage beiJing = tt.loadImageLocal("E:/beijing.jpg");
        
        tt.writeImageLocal("E:/new10.jpg", tt.modifyImagetogeter(ma, beiJing));
        //将多张图片合在一起    
        System.out.println("success");  
    } 
}