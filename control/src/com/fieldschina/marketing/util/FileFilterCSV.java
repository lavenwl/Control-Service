package com.fieldschina.marketing.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;  
import java.io.FileFilter;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
  /**
   * 文件过滤器类，过滤目录下特定的文件类型（用于FTP服务器上文件的拉取）
   * 
   * @author  LAVEN  E-mail:lavenwl@gmail.com
   * @company FieldsChina.IT.BI
   * @version 创建时间�?014-7-23 上午11:36:24
   */
public class FileFilterCSV implements FileFilter {  
	static Logger log = Logger.getLogger(FileFilterCSV.class);
    String condition = "";  
    public FileFilterCSV(String condition) {  
        this.condition = condition;  
    }  
  /**
   * 重写接口必要方法
   */
    @Override  
    public boolean accept(File pathname) {  
        String filename = pathname.getName();  
        if (filename.lastIndexOf(condition) != -1) {  
            return true;  
        } else  
            return false;  
    }  
  /**
   * 文件过滤器的测试方法
   * 
   * @param args
   */
    public static void main(String[] args) {  
        File root = new File("D:\\aaaaaa\\mmm");  
        if (!root.exists())  
            root.mkdir();  
        File[] files;  
        files = root.listFiles(new FileFilterCSV(".csv"));  
        if (files.length != 0)  
            for (int i = 0; i < files.length; i++){
                try {
					BufferedReader fileInputStream = new BufferedReader(new InputStreamReader(new FileInputStream(files[i]), "GB2312"), 1024);
					try {
						String s = fileInputStream.readLine();
						System.out.println(s);
						s = fileInputStream.readLine();
						System.out.println(s);
					} catch (IOException e) {
						log.error(Util.getTrace(e));
					}
				} catch (UnsupportedEncodingException e) {
					log.error(Util.getTrace(e));
				} catch (FileNotFoundException e) {
					log.error(Util.getTrace(e));
				}
            	 System.out.println(files[i].getAbsolutePath());  
            	 System.out.println(files[i].getName()); 
            	 System.out.println(files[i]); 
            } 
    }  
}  