package com.Homework_22_11_18.DAO;

import com.Homework_22_11_18.connection.DBCPDataSource;
import com.Homework_22_11_18.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.Homework_22_11_18.App.logger;

public class UserDAO implements Dao<Integer, User> {

    public UserDAO() {
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean create(User user) {
        int changeNumber = 0;
        try(Connection con= DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("insert INTO user(us_login, us_password,us_role) VALUE (?,?)")){
            statement.setString(1,user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole());
            changeNumber = statement.executeUpdate();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        return changeNumber>0;
    }

    public static User checkByEmailAndPassword(String login, String password){
        User user = null;
        try{Connection con= DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("select * from user where us_password=? and us_login=?");
            statement.setString(1, password);
            statement.setString(2,login);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                user = createUser(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return user;
    }
    static User   createUser(ResultSet resultSet) throws SQLException {
        User user= new User();
        user.setId(resultSet.getInt("us_id"));
        user.setLogin(resultSet.getString("us_login"));
        user.setPassword(resultSet.getString("us_password"));
        user.setRole(resultSet.getInt("us_role"));
        return user;
    }

    @Override
    public User getById(Integer id) {
        User user = null;
        try(Connection con= DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("select * from users where us_id=?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                user = createUser(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return user;
    }
}
