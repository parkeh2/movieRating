package com.movierating.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    public static Connection dbConnect(String path) {
        Connection conn = null;
        String url, id, pass;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
/*
            Properties pro = new Properties();
            path = path + "../WebContent/WEB-INF/dbinfo.properties";
            pro.load(new FileReader(path));
            url = pro.getProperty("url");
            id = pro.getProperty("userid");
            pass = pro.getProperty("password");
            */

            url = "jdbc:oracle:thin:@cometdb1_medium?TNS_ADMIN=/Users/jungcomet/comet/lib/Wallet_cometdb1";
            id = "admin";
            pass = "Kosta226kosta";
            conn = DriverManager.getConnection(url, id, pass);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public static void dbClose(Connection conn, Statement st, ResultSet rs) {
        try {
            if(rs!=null) rs.close();
            if(st!=null) st.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
    final String DB_URL = "jdbc:oracle:thin:@cometdb1_medium?TNS_ADMIN=/Users/jungcomet/comet/lib/Wallet_cometdb1";
    final String DB_USER = "admin";
    final String DB_PASSWORD = "Kosta226kosta";
    public void test() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        System.out.println(conn);
        String sql = "select * from test";
        Statement st = null;
        ResultSet rs = null;
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getInt(3));
        }
        rs.close();
        st.close();
        conn.close();
    }
    */
}
