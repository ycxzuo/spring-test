package com.yczuoxin.springboot.test6.controller;

import com.yczuoxin.springboot.test6.domian.User;
import com.yczuoxin.springboot.test6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @GetMapping("/user/get")
    public Map<String, Object> getUser(@RequestParam(value = "id", defaultValue = "1") String id){
        Map<String, Object> data = new HashMap<>(3);
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            // 简单的 sql
            /*statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from user where id = " + id);*/
            // 防注入的 sql
            preparedStatement = connection.prepareStatement("select * from user where id = ?");
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ids = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                data.put("id", ids);
                data.put("name",name);
                data.put("age", age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {

                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {

                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {

                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }
        return data;
    }

    @PostMapping("/user/add")
    public Map<String, Object> addUser(@RequestBody User user){
        Map<String, Object> data = new HashMap<>(3);
        data.put("success", userService.save(user));
        return data;
    }
}
