package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;
import persistence.ConnectionManager;

import java.sql.*;

public class JdbcUserService implements UserService {

    ConnectionManager manager = new ConnectionManager();
    Connection dbConnection = manager.getConnection();

    @Override
    public boolean authenticate(String username, String password) {
        //int result = 0;
        boolean authentication = false;



        try {
            String query = "SELECT * FROM users WHERE password = ?  AND username = ?";
            PreparedStatement statement = dbConnection.prepareStatement(query);
            statement.setString(1,password);
            statement.setString(2,username);
            ResultSet resultSet = statement.executeQuery();

            authentication = resultSet.next();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    return authentication;
    }

    @Override
    public void addUser(User user) {

        try {

            String query = "INSERT INTO users(username, email, password) VALUES (?,?,?);";
            PreparedStatement statement = dbConnection.prepareStatement(query);

            statement.setString(1, user.getUsername());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPassword());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public User findByName(String username) {

        User user = null;
        ResultSet resultSet = null;
        // ... connection and statements....




        String query = "SELECT * FROM users WHERE username = ?;";
        // execute the query
        try {
            PreparedStatement statement = dbConnection.prepareStatement(query); //prepare compiles query

            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if(resultSet.next()) {

                String usernameValue = resultSet.getString("username");
                String passwordValue = resultSet.getString("password");
                String emailValue = resultSet.getString("email");

                user = new User(usernameValue, passwordValue, emailValue);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public int count() {
        int result = 0;

        // create a new statement
        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // create a query
        String query = "SELECT COUNT(*) FROM user";

        // execute the query
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // get the results
        try {
            if(resultSet.next())

            {
                result = resultSet.getInt(1);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //...

        return result;


    }






}
