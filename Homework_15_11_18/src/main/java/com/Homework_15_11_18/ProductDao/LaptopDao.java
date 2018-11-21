package com.Homework_15_11_18.ProductDao;

import com.Homework_15_11_18.ConnectionPool.DBCPDataSource;
import com.Homework_15_11_18.ProductModel.Laptop;
import com.Homework_15_11_18.ProductModel.Product;

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

    public boolean createAsNewProduct(Laptop laptop, Product product){
        int changeNumber = 0;
        try(Connection con=DBCPDataSource.getConnection();
            PreparedStatement productInsertStatement = con.prepareStatement("INSERT INTO product(maker, model, type) VALUE (?,?,?)");
            PreparedStatement laptopInsertStatement = con.prepareStatement("INSERT INTO laptop(model, speed,ram,hd,price,screen ) VALUE (?,?,?,?,?,?)")){

            if(!laptop.getModel().equals(product.getModel()) || !product.getType().equals("Laptop"))
                throw new IllegalArgumentException("Wrong data:product and printer consistency");

            con.setAutoCommit(false);

            productInsertStatement.setString(1, product.getMaker());
            productInsertStatement.setString(2, product.getModel());
            productInsertStatement.setString(3, product.getType());

            laptopInsertStatement.setString(1,laptop.getModel());
            laptopInsertStatement.setShort(2,laptop.getSpeed());
            laptopInsertStatement.setShort(3, laptop.getRam());
            laptopInsertStatement.setDouble(4, laptop.getHd());
            laptopInsertStatement.setBigDecimal(5, laptop.getPrice());
            laptopInsertStatement.setByte(6, laptop.getScreen());

            try {
                productInsertStatement.executeUpdate();
                changeNumber = laptopInsertStatement.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                con.rollback();
            }

            con.setAutoCommit(true);
        }catch (SQLException | IllegalArgumentException e){
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
