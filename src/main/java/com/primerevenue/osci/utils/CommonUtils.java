package com.primerevenue.osci.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class CommonUtils {
	
	 /**
     * @return Generate specified length character string
     */
    public static String templateName(int length) {
        String s;
        String name = "";

        for (int i = 0; i < length; i++) {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            int character = (int) (Math.random() * 26);
            s = alphabet.substring(character, character + 1);
            name = name + s;
        }

        return name;
    }

    public static void killWindowsProcess(String processName) throws Exception {
        if (isRunning(processName)) {
            getRuntime().exec("taskkill /F /IM " + processName);
        }


    }
    private static boolean isRunning(String processName) throws Exception
    {
        Process listTasksProcess = getRuntime().exec("tasklist");
        BufferedReader tasksListReader = new BufferedReader(
                new InputStreamReader(listTasksProcess.getInputStream()));

        String tasksLine;

        while ((tasksLine = tasksListReader.readLine()) != null)
        {
            if (tasksLine.contains(processName))
            {
                return true;
            }
        }

        return false;
    }
    private static Runtime getRuntime()
    {
        return Runtime.getRuntime();
    }

    public static String getRandomNo(){
        String n=null;
        n=String.valueOf(new Random().nextInt(1000));
        return n;
    }

}
