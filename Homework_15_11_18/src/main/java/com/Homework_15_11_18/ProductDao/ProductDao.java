package com.Homework_15_11_18.ProductDao;

import com.Homework_15_11_18.ConnectionPool.DBCPDataSource;
import com.Homework_15_11_18.ProductModel.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.Homework_15_11_18.App.logger;

public class ProductDao implements Dao<String, Product> {

    @Override
    public List<Product> getAll() {
        List<Product> resultingItems = new ArrayList<>();
        try(Connection con= DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("select * from printer order by price ASC;")){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                resultingItems.add(createProduct(resultSet));
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        return resultingItems;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        int changeNumber = 0;
        try(Connection con=DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("delete from product where model=?")){
            statement.setString(1,s);
            changeNumber = statement.executeUpdate();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        return changeNumber>0;
    }

    @Override
    public boolean create(Product product) {
        int changeNumber = 0;
        try(Connection con=DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("INSERT INTO product(maker, model, type) VALUE (?,?,?)")){
            statement.setString(2,product.getMaker());
            statement.setString(1,product.getModel());
            statement.setString(3,product.getType());
            changeNumber = statement.executeUpdate();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        return changeNumber>0;
    }

    @Override
    public Product getById(String s) {
        Product product = null;
        try(Connection con= DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("select * from pc where model=?")) {
            statement.setString(1, s);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                product = createProduct(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return product;
    }
    private Product createProduct(ResultSet rs) throws SQLException {
        Product product;
        product = new Product();
        product.setMaker(rs.getString(1));
        product.setModel(rs.getString(2));
        product.setType(rs.getString(3));
        return product;
    }
}
