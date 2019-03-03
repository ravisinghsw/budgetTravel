package com.ravi.travel.budget_travel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostGreSQLTest {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://driftersdiaries-instance.cvjxt4jsmbmq.us-east-1.rds.amazonaws.com:5432/driftersdiariesdb", "aws_driftersdiaries", "drifters9211");
                System.out.print("Connection Success");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
