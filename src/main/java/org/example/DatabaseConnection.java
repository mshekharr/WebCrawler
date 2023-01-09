package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {     //singleton class
    static Connection connection = null;       // connection obj
    public static Connection getConnection(){
        if(connection!=null){
            return connection;
        }
        String db = "searchaccio";
        String user = "root";
        String pwd = "somu";
        return getConnection(db,user,pwd);
    }
    private static Connection getConnection(String db,String user,String pwd){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");    // forname throws excptn class not found so use try catch
                          // this class extract the added library in project Structure
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+db+"?user="+user+"&password="+pwd);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return connection;
    }
}
