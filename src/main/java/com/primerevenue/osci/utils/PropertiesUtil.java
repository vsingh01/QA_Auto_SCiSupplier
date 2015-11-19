package com.primerevenue.osci.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * @author Sai Amuluru;
 *
 **/

public class PropertiesUtil {

    final static Logger logger = Logger.getLogger(PropertiesUtil.class);

    private String browser;
    private String url;


    public Properties getProperties(final String fileName) {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            // Get properties file
            input = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);

            // load properties file
            prop.load(input);
            logger.info("PROPERTIES FILE '" + fileName + "' LOADED SUCCESSFULLY");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return prop;

    }

    // SET
    public void setBrowser(String browser) {

        this.browser = browser;

    }

    public void setUrl(String url) {

        this.url = url;

    }


    // GET
    public String getBrowser() {

        return browser;

    }


    public String getUrl() {

        return url;

    }

}
