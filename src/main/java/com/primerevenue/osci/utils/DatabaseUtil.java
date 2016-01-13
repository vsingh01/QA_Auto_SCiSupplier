package com.primerevenue.osci.utils;

import com.primerevenue.osci.driver.PRBase;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author Sai Amuluru;
 *
 **/

public class DatabaseUtil extends PropertiesUtil {

	public static Logger logger = Logger.getLogger(DatabaseUtil.class);

	private static String MYSQL_HOST;
	private static String MYSQL_USER;
	private static String MYSQL_PASSWORD;
	private static String MYSQL_SCHEMA_ADMIN;
	private static String MYSQL_SCHEMA_CLIENT;
	private static String MYSQL_SCHEMA;
	private static String MYSQL_TABLE;
	private static String MYSQL_URL;

	static Connection connection = null;
	ResultSet resultSet = null;

	// oracle
	private static String ORACLE_HOST;
	private static String ORACLE_SID;
	private static String ORACLE_SCHEMA_ADMIN;
	private static String ORACLE_SCHEMA_CLIENT;
	private static String ORACLE_PORT;
	private static String ORACLE_USER;
	private static String ORACLE_PASSWORD;

	public String supplierID;
	public String fieldID;
	public String buyerProgramID;

	public static void initMySql() {
		Properties dbProp = PRBase.setupProp;

		// MySql
		setHost(dbProp.getProperty("sqlserver.host"));
		setUser(dbProp.getProperty("sqlserver.user"));
		setPassword(dbProp.getProperty("sqlserver.password"));
		setSchemaAdmin(dbProp.getProperty("sqlserver.schema.admin"));
		setSchemaClient(dbProp.getProperty("sqlserver.schema.client"));

		// MYSQL_URL = "jdbc:sqlserver://" + MYSQL_HOST + "?user=" + MYSQL_USER
		// + "&password=" + MYSQL_PASSWORD;
		MYSQL_URL = "jdbc:sqlserver://" + MYSQL_HOST + ";" + "username="
				+ MYSQL_USER + ";" + "password=" + MYSQL_PASSWORD;
		// MYSQL_URL = "jdbc:sqlserver://" + ";" + "servername" + "=" +
		// MYSQL_HOST + ";" + "integratedSecurity" + "=" + "true";
		// MYSQL_URL =
		// "jdbc:sqlserver://;servername=172.18.2.15;integratedSecurity=true";
	}

	public static Connection getMySqlConnection() {
		initMySql();
		String connectionUrl = getConnectionUrl();
		try {
			logger.debug("Attempting MySql connection: " + connectionUrl);
			connection = DriverManager.getConnection(connectionUrl);
			logger.debug("Successful MySql connection: " + connectionUrl);
			Thread.sleep(5000);
		} catch (SQLException e) {
			logger.error("Failed MySql connection: " + connectionUrl + "\n"
					+ e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return connection;

	}

	public ResultSet getResults() {

		// String sqlQuery = "select * from " + getSchema() + "." + getTable();
		String sqlQuery = "select referenceId from MagellanReporting.dbo.BuyOffer where buyerId =2";

		Statement stmt = null;

		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			logger.error("Failed MySql create statement: " + e.getMessage());
		}

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sqlQuery);
			// logger.info(rs.getObject("referenceId").toString());

		} catch (SQLException e) {
			logger.error("Failed MySql execute statement: " + e.getMessage());
		}

		setResultSet(rs);

		return rs;

	}

	public ResultSet getResultsWithLimit(int startRow, int maxRowsToFetch) {

		String sqlQuery = "select * from " + getSchema() + "." + getTable()
				+ " LIMIT " + startRow + "," + maxRowsToFetch;

		Statement stmt = null;

		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			logger.error("Failed MySql create statement: " + e.getMessage());
		}

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sqlQuery);
		} catch (SQLException e) {
			logger.error("Failed MySql execute statement: " + e.getMessage());
		}

		setResultSet(rs);

		return rs;

	}

	public void closeConnection() {

		try {
			if (connection != null)
				connection.close();
			logger.debug("Successful MySql connection closed.");
		} catch (SQLException e) {
			logger.error("Failed MySql connection close !!");
			e.printStackTrace();
		}

	}

	public void printResults(ResultSet rs) {

		try {
			while (rs.next()) {

				// String referenceId = rs.getString("referenceId");
				String supplierid = rs.getString("supplierid");
				// String username = rs.getString("username");
				logger.info("supplierid:::"+ supplierid);
				// logger.info(usergroup + ", " + username);
				this.supplierID = supplierid;
				
			}
		} catch (SQLException e) {
			logger.info("MySql print results," + e.getMessage());
		}

	}

	public int getColumnCount() {

		Integer columnCount = null;

		try {

			ResultSetMetaData rsmd = resultSet.getMetaData();

			columnCount = rsmd.getColumnCount();

		} catch (SQLException e) {

			logger.info("Failed MySql getting column count," + e.getMessage());

		}

		return columnCount;

	}

	public int getColumnCount(ResultSet rs) {
		Integer columnCount = null;

		try {

			ResultSetMetaData rsmd = resultSet.getMetaData();

			columnCount = rsmd.getColumnCount();

		} catch (SQLException e) {

			logger.info("Failed MySql getting column count," + e.getMessage());

		}

		return columnCount;
	}

	public int getRowCount() {

		Integer rowCount = null;

		try {

			resultSet.last();

			rowCount = resultSet.getRow();

			resultSet.beforeFirst();

		} catch (SQLException e) {

			logger.info("Failed MySql getting row count," + e.getMessage());

		}

		return rowCount;

	}

	public int getRowCount(ResultSet rs) {
		Integer rowCount = null;

		try {

			resultSet.last();

			rowCount = resultSet.getRow();

			resultSet.beforeFirst();

		} catch (SQLException e) {

			logger.info("Failed MySql getting row count," + e.getMessage());

		}

		return rowCount;
	}

	public Object getDataObject() {
		/***
		 * Multi-dimensional array for TestNG DataProvider
		 */

		int maxRow = getRowCount();

		int maxColumn = getColumnCount();

		Object[][][] objData = new Object[maxRow][1][maxColumn];

		try {
			this.resultSet.first();

			// Iterate throw the rows
			for (int row = 1; row <= maxRow; row++) {
				this.resultSet.absolute(row);

				String rValue = getDataValue(row);

				// Iterate through the columns
				for (int column = 1; column <= maxColumn; column++) {

					String cValue = getDataValue(column);

					objData[row - 1][0][column - 1] = cValue;

					logger.info("Row " + row + "| Column " + column + ", "
							+ rValue + " | " + cValue);

				}

			}
		} catch (Exception e) {
			logger.error("Failed MySql getting data object." + e.getMessage());
		}

		return objData;

	}

	public Object[][][] getDataForDataProvider() {
		Object[][][] data = null;

		try {
			ResultSet rs = getResults();
			int maxRow = getRowCount(rs);

			int maxColumn = getColumnCount(rs);
			data = new Object[maxRow][1][maxColumn];

			for (int row = 1; row <= maxRow; row++) {
				rs.absolute(row);

				String rValue = getDataValue(row);
				for (int column = 1; column <= maxColumn; column++) {

					String cValue = getDataValue(column);

					data[row - 1][0][column - 1] = cValue;

					logger.debug("Row " + row + "| Column " + column + ", "
							+ rValue + " | " + cValue);

				}
			}
		} catch (SQLException exception) {
			logger.info("Fail to get data for data provider");
		}

		return data;

	}

	public Object[][][] getDataForDataProvider1() throws SQLException {
		Object[][][] obj = null;

		try {
			ResultSet rs = getResults();
			int maxRow = getRowCount(rs);

			int maxColumn = getColumnCount(rs);
			obj = new Object[2][maxRow][maxColumn];
			for (int tableNo = 0; tableNo < 2; tableNo++) {
				for (int row = 1; row <= maxRow; row++) {
					rs.absolute(row);

					String rValue = getDataValue(row);
					for (int column = 1; column <= maxColumn; column++) {

						String cValue = getDataValue(column);

						obj[tableNo][row - 1][column - 1] = cValue;

						logger.debug("Row " + row + "| Column " + column + ", "
								+ rValue + " | " + cValue);

					}
				}
			}
		} catch (SQLException exception) {
			logger.info("Fail to get data for data provider");
		}

		return obj;

	}

	public HashMap dataObjectToDataMap(Object[] data, ResultSet rs) {

		HashMap dataMap = new HashMap();

		int columnCount = getColumnCount(rs);

		String[] columnNames = getColumnNames();

		for (int i = 0; i < columnCount; i++) {

			dataMap.put(columnNames[i], (String) data[i]);

		}

		return dataMap;

	}

	public String[] getColumnNames() {
		String[] colNames;

		int maxColumn = getColumnCount();
		colNames = new String[maxColumn];

		ResultSetMetaData rsMetaData = null;

		try {

			rsMetaData = resultSet.getMetaData();

		} catch (SQLException e) {

			logger.error("Failed getting result set meta data, "
					+ e.getMessage());

		}

		try {

			// get the column names; column indexes start from 1
			for (int i = 1; i < maxColumn + 1; i++) {

				String columnName = rsMetaData.getColumnName(i);
				colNames[i - 1] = columnName;

				// Get the name of the column's table name
				String tableName = rsMetaData.getTableName(i);
				logger.info("column name=" + columnName + " table=" + tableName
						+ "");

			}

			return colNames;

		} catch (Exception e) {

			logger.error("Failed getting the column names, " + e.getMessage());
			return null;

		}

	}

	public String getDataValue(String columnName) {
		String value = null;
		try {
			value = resultSet.getString(columnName).trim();
		} catch (Exception e) {
			logger.error("Missing data column: " + columnName + "\n"
					+ e.getMessage());
		}
		return value;
	}

	public String getDataValue(int columnIndex) {
		String value = null;
		try {
			value = resultSet.getString(columnIndex).trim();
		} catch (Exception e) {
			logger.error("Missing data column: " + columnIndex + "\n"
					+ e.getMessage());
		}
		return value;
	}

	public String getDataValue(int columnIndex, ResultSet rs) {
		String value = null;
		try {
			value = rs.getString(columnIndex).trim();
		} catch (Exception e) {
			logger.error("Missing data column: " + columnIndex + "\n"
					+ e.getMessage());
		}
		return value;
	}

	// Get

	public String getHost() {
		return MYSQL_HOST;
	}

	public String getUser() {
		return MYSQL_USER;
	}

	public String getPassword() {
		return MYSQL_USER;
	}

	public String getSchemaAdmin() {
		return MYSQL_SCHEMA_ADMIN;
	}

	public String getSchemaClient() {
		return MYSQL_SCHEMA_CLIENT;
	}

	public String getTable() {
		return MYSQL_TABLE;
	}

	public String getSchema() {
		return MYSQL_SCHEMA;
	}

	public static String getConnectionUrl() {
		return MYSQL_URL;
	}

	// Set

	public static void setHost(final String name) {
		MYSQL_HOST = name;
	}

	public static void setUser(final String name) {
		MYSQL_USER = name;
	}

	public static void setPassword(final String password) {
		MYSQL_PASSWORD = password;
	}

	public static void setSchemaAdmin(final String schema) {
		MYSQL_SCHEMA_ADMIN = schema;
	}

	public static void setSchemaClient(final String schema) {
		MYSQL_SCHEMA_CLIENT = schema;
	}

	public static void setTable(final String table) {
		MYSQL_TABLE = table;
	}

	public static void setSchema(final String schema) {
		MYSQL_SCHEMA = schema;
	}

	public void setConnectionUrl() {

		MYSQL_URL = "jdbc:mysql://" + MYSQL_HOST + "?user=" + MYSQL_USER
				+ "&password=" + MYSQL_PASSWORD;

	}

	public void setResultSet(ResultSet rs) {
		resultSet = rs;
	}

	public static void setOracleSID(String oracleSID) {
		ORACLE_SID = oracleSID;
	}

	public static String getOracleSID() {
		return ORACLE_SID;
	}

	public static void setOracleHost(String oracleHost) {
		ORACLE_HOST = oracleHost;
	}

	public static String getOracleHost() {
		return ORACLE_HOST;
	}

	public static void setOracleSchemaAdmin(String oracleSchemaAdmin) {
		ORACLE_SCHEMA_ADMIN = oracleSchemaAdmin;
	}

	public static String getOracleSchemaAdmin() {
		return ORACLE_SCHEMA_ADMIN;
	}

	public static void setOracleSchemaClient(String oracleSchemaClient) {
		ORACLE_SCHEMA_CLIENT = oracleSchemaClient;
	}

	public static String getOracleSchemaClient() {
		return ORACLE_SCHEMA_CLIENT;
	}

	public static void setOraclePort(String oraclePort) {
		ORACLE_PORT = oraclePort;
	}

	public static String getOraclePort() {
		return ORACLE_PORT;
	}

	public static void setOracleUser(String oracleUser) {
		ORACLE_USER = oracleUser;
	}

	public static String setOracleUser() {
		return ORACLE_USER;
	}

	public static void setOraclePassword(String oraclePassword) {
		ORACLE_PASSWORD = oraclePassword;
	}

	public static String getOraclePassword() {
		return ORACLE_PASSWORD;
	}

	private static void initOracleProperties() {
		Properties dbProp = PRBase.setupProp;
		// oracle
		setOracleHost(dbProp.getProperty("oracle.host"));
		setOracleSID(dbProp.getProperty("oracle.sid"));
		setOracleSchemaAdmin(dbProp.getProperty("oracle.schema.admin"));
		setOracleSchemaClient(dbProp.getProperty("oracle.schema.client"));
		setOraclePort(dbProp.getProperty("oracle.port"));
		setOracleUser(dbProp.getProperty("oracle.user"));
		setOraclePassword(dbProp.getProperty("oracle.password"));
	}

	public static Connection getOracleConnection() {
		initOracleProperties();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:"
					+ ORACLE_SCHEMA_CLIENT + "/" + ORACLE_PASSWORD + "@"
					+ ORACLE_HOST + ":" + ORACLE_PORT + ":" + ORACLE_SID);

		} catch (SQLException ex) {
			// handle any errors
			logger.error("SQLException: " + ex.getMessage() + "\n"
					+ "SQLState: " + ex.getSQLState() + "\n" + "VendorError: "
					+ ex.getErrorCode());

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlEx) {

				} // ignore
			}
		}
		// end try select
		return conn;
	}

	public static ResultSet getOracleResultSet(String sqlQuery) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsQuery = null;

		try {
			conn = getOracleConnection();
			stmt = conn.createStatement();
			rsQuery = stmt.executeQuery(sqlQuery);
		} catch (SQLException ex) {
			// handle any errors
			logger.error("SQLException: " + ex.getMessage() + "\n"
					+ "SQLState: " + ex.getSQLState() + "\n" + "VendorError: "
					+ ex.getErrorCode());

			if (rsQuery != null) {
				try {
					rsQuery.close();
				} catch (SQLException sqlEx) {
				} // ignore
			}
		}// end try select

		return rsQuery;
	}

	/*---------------------------------------------------------*/

	public ResultSet getSupIdResults() {

		// String sqlQuery = "select * from " + getSchema() + "." + getTable();
		String sqlQuery = "select supplierid from magellanrelations..supplier where companyName = 'AmulSupp'";

		Statement stmt = null;

		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			logger.error("Failed MySql create statement: " + e.getMessage());
		}

		ResultSet rs = null;

		try {
			rs = stmt.executeQuery(sqlQuery);
			printResults(rs);

			String sqlQuery1 = "delete from magellanrelations..Audit_Supplier where supplierid = '553'";

			rs = stmt.executeQuery(sqlQuery1);

		} catch (SQLException e) {
			logger.error("MySql execute statement: " + e.getMessage());
		}

		setResultSet(rs);

		return rs;

	}

	public void delSupId() {

		 //String sqlQuery = "select * from " + getSchema() + "." + getTable();
		String sqlQuery = "select supplierid from magellanrelations..supplier where companyName = 'AmulSupp'";

		Statement stmt = null;

		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			logger.error("Failed MySql create statement: " + e.getMessage());
		}

		ResultSet rs = null;

		try {
			rs = stmt.executeQuery(sqlQuery);
			printResults(rs);

			logger.info("Supplier username successfully deleted and its supplierID is ::" + supplierID);

			String sqlQuery1 = "delete from magellanrelations..SavedSearch where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..Audit_Supplier where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..AutoAdvanceDates where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..SupplierBuyerProgram where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..SupplierBuyerProgramHistory where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..SavedReport where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..supplier where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..TaxReport where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..CreditMemoTemporary where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..TempWorkSpaceMapping where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..TempWorkspaceBuyerProgramReserves where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..output_BuyOffer where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..output_CreditMemo where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..output_SellOffer where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..output_TaxReport where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..NotifyUploads where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..BuyOffer where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..SellOffer where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..CreditMemo where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..PaymentObligation where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..PaymentObligationTemporary where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from MagellanWarehouse..SellOfferNotify where supplierid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..ProblemHistory where departmentcode = '04' and entityid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..Users where departmentcode = '04' and entityid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..UsersView where departmentcode = '04' and entityid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..BankAccountView where departmentcode = '04' and entityid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..SavedReport where departmentcode = '04' and entityid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..TaskInstance where departmentcode = '04' and entityid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..SSRSScheduledReports where departmentcode = '04' and entityid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..taxProfile where departmentcode = '04' and entityid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..IPAssignment where departmentcode = '04' and entityid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..BankAccount where departmentcode = '04' and entityid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanrelations..Exchange where departmentcode = '04' and entityid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanwarehouse..EntityProcessStateTransition where departmentcode = '04' and entityid = '"
					+ supplierID
					+ "'"
					+ "delete from magellanwarehouse..Audit_EntityProcessStateTransition where departmentcode = '04' and EntityId = '"
					+ supplierID + "'";

			rs = stmt.executeQuery(sqlQuery1);

		} catch (SQLException e) {
			logger.error("MySql execute statement: " + e.getMessage());
		}

		setResultSet(rs);

		//return rs;

	}

	public ResultSet poTradedBQueries() {

		String sqlQuery = "select top 1 fileId from  magellanwarehouse.dbo.POUpload order by fileUploadDate desc";

		Statement stmt = null;

		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			logger.error("Failed MySql create statement: " + e.getMessage());
		}

		ResultSet rs = null;

		try {
			rs = stmt.executeQuery(sqlQuery);

			while (rs.next()) {

				String fieldId = rs.getString("fileId");
				logger.info("fileId::::" + fieldId);
				this.fieldID = fieldId;
			}

			// printResults(rs);

			logger.info("fieldID parameter value::" + fieldID);

			String sqlQuery1 = "SELECT top 1 processingStatus FROM [MagellanReporting].[dbo].[PaymentObligation] where fileId ='"
					+ fieldID + "' order by paymentobligationid desc";

						
			rs = stmt.executeQuery(sqlQuery1);

			while (rs.next()) {
			String processingStatus = rs.getString("processingStatus");
			logger.info("processingStatus::" + processingStatus);
			}
			
		} catch (SQLException e) {
			logger.error("Failed MySql execute statement: " + e.getMessage());
		}
	
		setResultSet(rs);

		return rs;

	}
	public void delBuyerPrograme() {

		 //String sqlQuery = "select * from " + getSchema() + "." + getTable();
		String sqlQuery = "select buyerProgramId from [MagellanRelations].[dbo].[BuyerProgram] where buyerProgramName = 'smokeTest_BP'";

		Statement stmt = null;

		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			logger.error("Failed MySql create statement: " + e.getMessage());
		}

		ResultSet rs = null;

		try {
			rs = stmt.executeQuery(sqlQuery);
			
			while (rs.next()) {

				String buyerProgramId = rs.getString("buyerProgramId");
				logger.info("buyerProgramId:::::" + buyerProgramId);
				this.buyerProgramID = buyerProgramId;
			}
			
			//printResults(rs);

			logger.info("Buyerprograme succesfully deleted and its buyerProgramID is ::" + buyerProgramID);

			String sqlQuery1 = "delete from magellanrelations..Audit_BuyerProgram where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..AutoAcceptLimit where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..AutoAdvanceDates where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..BPSpecificMatCal where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..BuyerProgramNetCommunityMargin where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..BuyerProgramRateHistory where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..BuyerProgramReserve where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..BuyerProgramRestrictedAutoAdvance where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..BuyerProgramSettlementConfig where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..FITier where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..MultipleFIsInSingleBuyerProgram where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..PricingTierCatalogue where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..RestrictedAutoAdvanceDates where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..SavedReport where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..SavedSearch where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..SpecificMatCal_MasterCal where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..SupplierBuyerProgram where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..SupplierBuyerProgramHistory where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..UserBuyerProgram where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..ValidMaturityDate where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..FiGroupHistory where groupid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..FIGroup where groupid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanrelations..BuyerProgram where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..Buyoffer where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..ClearingAccountTransactionLog where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..ClearingAccountTransactionLogView where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..CreditMemo where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..CreditMemoEffectiveDateValidation where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..CreditMemoTemporary where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..output_BuyOffer where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..output_CreditMemo where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..output_PaymentObligation where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..output_SellOffer where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..output_TaxReport where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..output_BuyOffer where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..PaymentObligation where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..PaymentObligationMaturityValidation where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..PaymentObligationTemporary where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..SellOffer where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..[Statement] where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..TransactionAuditTrail where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..TransactionAuditTrailView where buyerprogramid = '"
					+ buyerProgramID
					+ "'"
					+ "delete from magellanwarehouse..TaxReport where buyerprogramid = '"
					+ buyerProgramID + "'";

			rs = stmt.executeQuery(sqlQuery1);

		} catch (SQLException e) {
			logger.error("MySql execute statement: " + e.getMessage());
		}

		setResultSet(rs);

		//return rs;
}
}
