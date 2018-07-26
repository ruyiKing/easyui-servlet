package com.yrw.test.image;

import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SyntheticPicture {


    // 二维码尺寸
    private static final int QRCODE_SIZE = 176;
    //背景图片高度
    private static final int BG_HEIGHT = 900;
    //背景图片宽度
    private static final int BG_WIDTH = 600;

    private static final int X = 186;
    private static final int Y = 533;




    public static BufferedImage getSynPic(String ma_url, String beijing_url, String imgName) throws IOException {
        Picture1 tt = new Picture1();
        BufferedImage ma = tt.loadImageLocal(ma_url);
        BufferedImage beiJing = tt.loadImageLocal(beijing_url);

        BufferedImage synPic = SyntheticPicture.synthetic(ma, beiJing);
        return synPic;

    }

    private static BufferedImage synthetic( BufferedImage ma, BufferedImage beiJing) throws IOException {

        BufferedImage tag = new BufferedImage(BG_WIDTH, BG_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.createGraphics();
        g.drawImage(beiJing, 0, 0, BG_WIDTH, BG_HEIGHT, null);
        g.drawImage(ma, X, Y, QRCODE_SIZE , QRCODE_SIZE, null);
        g.dispose();
        return tag;

    }

    public static void main(String[] args) throws IOException {
        String ma_url="E://ma.jpg";
        String beijing_url="E://beijing.jpg";
        String imgName = "11New.jpg";
        String destPath = "E://";

        BufferedImage synPic = SyntheticPicture.getSynPic(ma_url,beijing_url,imgName);

        ImageIO.write(synPic, "JPG", new File(destPath + "/" + imgName));
        System.out.println("over.");
    }

}
