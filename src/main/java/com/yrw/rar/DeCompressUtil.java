package com.yrw.rar;


import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;

import java.io.*;


public class DeCompressUtil {    

   /**  
    * 解压rar格式压缩包。  
    * 对应的是java-unrar-0.3.jar，但是java-unrar-0.3.jar又会用到commons-logging-1.1.1.jar  
    */   
   private static void unrar(String sourceRar,String destDir) throws Exception{    
       Archive a = null;
       FileOutputStream fos = null;    
       try{
//           NativeStorage file = new NativeStorage(new File(sourceRar));
           InputStream stream = new FileInputStream(new File(sourceRar));
           a = new Archive(stream);
           FileHeader fh = a.nextFileHeader();
           while(fh!=null){    
               if(!fh.isDirectory()){    
                   //1 根据不同的操作系统拿到相应的 destDirName 和 destFileName    
                   String compressFileName = fh.getFileNameString().trim();    
                   String destFileName = "";    
                   String destDirName = "";    
                   //非windows系统    
                   if(File.separator.equals("/")){    
                       destFileName = destDir + compressFileName.replaceAll("\\\\", "/");    
                       destDirName = destFileName.substring(0, destFileName.lastIndexOf("/"));    
                   //windows系统     
                   }else{    
                       destFileName = destDir + compressFileName.replaceAll("/", "\\\\");    
                       destDirName = destFileName.substring(0, destFileName.lastIndexOf("\\"));    
                   }    
                   //2创建文件夹    
                   File dir = new File(destDirName);    
                   if(!dir.exists()||!dir.isDirectory()){    
                       dir.mkdirs();    
                   }    
                   //3解压缩文件    
                   fos = new FileOutputStream(new File(destFileName));    
                   a.extractFile(fh, fos);    
                   fos.close();    
                   fos = null;    
               }    
               fh = a.nextFileHeader();    
           }    
           a.close();    
           a = null;    
       }catch(Exception e){    
           throw e;    
       }finally{
           if (fos == null) {
           } else {
               try{fos.close();fos=null;}catch(Exception e){e.printStackTrace();}
           }
           if(a!=null){    
               try{a.close();a=null;}catch(Exception e){e.printStackTrace();}    
           }    
       }    
   }    
   /**  
    * 解压缩  
    */   
   public static void deCompress(String sourceFile,String destDir) throws Exception{    
       //保证文件夹路径最后是"/"或者"\"    
       char lastChar = destDir.charAt(destDir.length()-1);    
       if(lastChar!='/'&&lastChar!='\\'){    
           destDir += File.separator;    
       }    
       //根据类型，进行相应的解压缩    
       String type = sourceFile.substring(sourceFile.lastIndexOf(".")+1);    
        if(type.equals("rar")){
            DeCompressUtil.unrar(sourceFile, destDir);    
        }else{    
            throw new Exception("只支持rar格式的压缩包！");
        }    
    }

    public static void main(String[] args) throws Exception {
        String sourceFile="E:\\mnt\\mfsmount\\Product_POS\\bts\\merchant_pics\\201807\\02\\3370906\\specialFile.rar";
        String destDir="E:\\mnt\\mfsmount\\Product_POS\\bts\\merchant_pics\\201807\\02\\3370906";
        deCompress(sourceFile,destDir);

    }
}  