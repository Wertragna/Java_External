package com.Homework_15_11_18.ProductDao;

import com.Homework_15_11_18.DBCPDataSource;
import com.Homework_15_11_18.ProductModel.Laptop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.Homework_15_11_18.App.logger;

public class LaptopDao  implements Dao<Integer, Laptop> {
    @Override
    public List<Laptop> getAll() {
        List<Laptop> laptops = new ArrayList<>();
        try(Connection con= DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("select * from laptop order by price ASC;")){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                laptops.add(createLaptop(rs));
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        return laptops;
    }

    @Override
    public boolean update(Laptop laptop) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        int changeNumber = 0;
        try(Connection con=DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("delete from laptop where code=?")){
            statement.setInt(1, id);
            changeNumber = statement.executeUpdate();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        return changeNumber>0;
    }

    @Override
    public boolean create(Laptop laptop) {
        int changeNumber = 0;
        try(Connection con=DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("insert INTO laptop(model, speed, ram, hd, price, screen) VALUE (?,?,?,?,?,?)")){
            statement.setString(1,laptop.getModel());
            statement.setShort(2,laptop.getSpeed());
            statement.setShort(3, laptop.getRam());
            statement.setDouble(4, laptop.getHd());
            statement.setBigDecimal(5, laptop.getPrice());
            statement.setByte(6, laptop.getScreen());
            changeNumber = statement.executeUpdate();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        return changeNumber>0;
    }

    @Override
    public Laptop getById(Integer integer) {
        return null;
    }

    private Laptop createLaptop(ResultSet resultSet) throws SQLException {
        Laptop laptop = new Laptop();
        laptop.setCode(resultSet.getInt(1));
        laptop.setModel(resultSet.getString(2));
        laptop.setSpeed(resultSet.getShort(3));
        laptop.setRam(resultSet.getByte(4));
        laptop.setHd(resultSet.getInt(5));
        laptop.setPrice(resultSet.getBigDecimal(6));
        laptop.setScreen(resultSet.getByte(7));
        return laptop;
    }
}
