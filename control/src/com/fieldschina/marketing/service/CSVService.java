package com.fieldschina.marketing.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.fieldschina.marketing.util.Util;

/**
 * 生成CSV文件的逻辑类
 * 
 * @author  LAVEN  E-mail:lavenwl@gmail.com
 * @company FieldsChina.IT.BI
 * @version 创建时间：2014-9-26 下午5:26:49
 */
public class CSVService{
	static Logger log = Logger.getLogger(CSVService.class);
	/**
	 * 生成CSV文件
	 * 
	 * @param exportData
	 * @param rowMapper
	 * @param outPutPath
	 * @param filename
	 * @return
	 */
	 public static File createCSVFile(List exportData, LinkedHashMap rowMapper, String outPutPath, String filename) {
	        File csvFile = null;
	        BufferedWriter csvFileOutputStream = null;
	        try {
	            csvFile = new File(outPutPath + "/" + filename);
	            File parent = csvFile.getParentFile();
	            if (parent != null && !parent.exists()) {
	                parent.mkdirs();
	            }
	            csvFile.createNewFile();
	            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GB2312"), 1024);
	            for (Iterator propertyIterator = rowMapper.entrySet().iterator(); propertyIterator.hasNext();) {
	                java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
	                csvFileOutputStream.write("\"" + propertyEntry.getValue().toString() + "\"");
	                if (propertyIterator.hasNext()) {
	                    csvFileOutputStream.write(",");
	                }
	            }
	            csvFileOutputStream.newLine();
	            for (Iterator iterator = exportData.iterator(); iterator.hasNext();) { 
	            	LinkedHashMap row = (LinkedHashMap) iterator.next(); 
	                for (Iterator propertyIterator = row.entrySet().iterator(); propertyIterator.hasNext();) { 
	                    java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
	                    if(propertyEntry == null || propertyEntry.getValue() == null){
	                    	 csvFileOutputStream.write("\"\""); 
	                    }else{
	                    	 csvFileOutputStream.write("\"" +  propertyEntry.getValue().toString() + "\""); 
	                    }
	                   if (propertyIterator.hasNext()) { 
	                       csvFileOutputStream.write(","); 
	                    } 
	               } 
	                if (iterator.hasNext()) { 
	                   csvFileOutputStream.newLine(); 
	                } 
	           } 
	            csvFileOutputStream.flush(); 
	        } catch (Exception e) { 
	        	log.error(Util.getTrace(e));
	        } finally { 
	           try { 
	                csvFileOutputStream.close(); 
	            } catch (IOException e) { 
	            	log.error(Util.getTrace(e));
	           } 
	       } 
	        return csvFile;
	    }
}
