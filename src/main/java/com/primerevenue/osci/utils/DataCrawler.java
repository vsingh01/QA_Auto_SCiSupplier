package com.primerevenue.osci.utils;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Sai Amuluru on 11/1/2015.
 */
public final class DataCrawler {

    final static Logger logger = Logger.getLogger(DataCrawler.class);

    public static Iterator<Object> fetchTableData(DatabaseUtil mySql, String schemaName, String tableName) {
        mySql.setSchema(schemaName);
        mySql.setTable(tableName);
        ResultSet rs = mySql.getResults();
        String columnName[] = null;
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int count = metaData.getColumnCount();
            columnName = new String[count];

            for (int i = 1; i <= count; i++) {
                columnName[i - 1] = metaData.getColumnLabel(i);
                logger.debug(metaData.getColumnLabel(i));
            }
        } catch (Exception ee) {
        }
        List<Object> data = new ArrayList<Object>();
        String str = null;
        try {

            while (rs.next()) {

                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < columnName.length; i++) {
                    try {
                        str = rs.getString(i + 1);
                    } catch (Exception e) {
                        str = "";
                    }

                    map.put(columnName[i], str);
                }

                data.add(new Object[]{map});


            }

        } catch (SQLException e) {

            logger.error("Failed to read data from table " + tableName + ", " + e.getMessage());

        }

        return data.iterator();
    }


    public static Iterator<Object> fetchVerticalTableData(DatabaseUtil mySql, String schemaName, String tableName) {
        mySql.setSchema(schemaName);
        mySql.setTable(tableName);
        ResultSet rs = mySql.getResults();
        List<Object> data = new ArrayList<Object>();
        Map<String, String> map = null;
        String key = null;
        String value = null;
        int colCount = 0;
        try {

            ResultSetMetaData metaData = rs.getMetaData();
            colCount = metaData.getColumnCount();
            for (int col = 3; col < colCount; col++) {
                rs.beforeFirst();
                map = new HashMap<>();
                while (rs.next()) {
                    //get column name and set as key
                    try {
                        //column containing columns labels
                        key = rs.getString("C2");
                    } catch (Exception e) {
                        key = "";
                    }
                    try {
                        value = rs.getString("C" + col);
                    } catch (Exception e) {
                        value = "";
                    }
                    logger.debug("Iteration" + col);
                    logger.debug("key=" + key + "value=" + value);
                    map.put(key, value);
                }
                data.add(new Object[]{map});
            }

        } catch (SQLException e) {

            logger.error("Failed to read data from table " + tableName + ", " + e.getMessage());

        }


        return data.iterator();
    }

}
