package com.primerevenue.osci.utils;

import com.primerevenue.osci.driver.PRBase;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by Sai Amuluru on 11/4/2015.
 */
public class FileUtils {
    final static Logger logger = Logger.getLogger(FileUtils.class);

    public static void saveExecutionTraceData(String file, Map theMap) {
        if (PRBase.ENABLE_EXECUTION_TRACE.equalsIgnoreCase("false")) {
            return;
        }
        try {
            Date now = new Date();
            if (PRBase.EXECUTION_TRACE_KEY_VALUE.equalsIgnoreCase("true")) {
                String lineText = theMap.values().toString();
                lineText = lineText.replace("[", "");
                lineText = lineText.replace("]", "");
                lineText = getKeyValuePair(theMap);
                logger.info("Payment Values: " + lineText);
                appendToTextFile(file, lineText);
            } else {
                String lineText = (now + ", " + theMap.values().toString());
                lineText = lineText.replace("[", "");
                lineText = lineText.replace("]", "");

                logger.info("Payment Values: " + lineText);
                appendToTextFile(file, lineText);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getKeyValuePair(Map<String, String> map) {
        String line = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            line = line + entry.getKey() + "=" + entry.getValue() + ",";
        }
        //remove comma from end of line
        return line.substring(0, line.length() - 1);
    }

    public static void appendToTextFile(String filePath, String text) {
        try {
            File file = new File(filePath);

            //if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            //true = append file
            FileWriter fileWritter = new FileWriter(filePath, true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(text + "\n");
            bufferWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
}
