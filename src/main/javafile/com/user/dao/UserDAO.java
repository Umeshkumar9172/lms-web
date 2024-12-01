package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.user.User;

public class UserDAO{
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User getUserById(int id) {
        User user = null;
        try {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean addUser(User user) {
        try {
            String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public class EnrollmentDao {
        private Connection connection;

        public EnrollmentDao(Connection connection) {
            this.connection = connection;
        }

        public boolean enrollStudent(int studentId, int courseId) {
            try {
                String query = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, studentId);
                statement.setInt(2, courseId);

                return statement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}