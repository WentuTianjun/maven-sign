package com.example.demo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liuchen25 on 2018/6/22.
 */

public class JDBCTest {
    @Test
    public void printHello() {
        String platform = "深圳";
        int query = queryCount(platform);
        System.out.println("数量= " + query);
    }

    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://47.96.152.91:3306/linux_test?useUnicode=true&characterEncoding=utf8&autoReconnect=true";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static int queryCount(String roomId) {
        Connection conn = getConn();
        int i = 0;
        String sql = "select COUNT(*) from student";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            i = resultSet.getMetaData().getColumnCount();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
