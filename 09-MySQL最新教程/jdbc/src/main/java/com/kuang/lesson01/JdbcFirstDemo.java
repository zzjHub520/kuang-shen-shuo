package com.kuang.lesson01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//我的第一个jdbc程序
public class JdbcFirstDemo {
    public static void main(String[] args) throws Exception {
        //1. 加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2. 用户信息和URL
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "123456";

        //3. 连接成功，数据库对象 connection 代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //4. 执行SQL的对象statement执行SQL的对象
        Statement statement = connection.createStatement();


        //5. 执行SQL的对象去执行SQL，可能存在结果，查看返回结果
        String sql = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(sql); //返回的结果集，结果集中封装了我们全部的查询出来的结果

        while (resultSet.next()){
            System.out.println(resultSet.getObject("id"));
        }

        //6. 释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}

























