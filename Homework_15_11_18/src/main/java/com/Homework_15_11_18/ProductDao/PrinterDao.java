package com.Homework_15_11_18.ProductDao;

import com.Homework_15_11_18.ConnectionPool.DBCPDataSource;
import com.Homework_15_11_18.ProductModel.Printer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.Homework_15_11_18.App.logger;

public class PrinterDao implements Dao<Integer, Printer> {



    @Override
    public List<Printer> getAll() {
        List<Printer> resultingItems = new ArrayList<>();
        try(Connection con= DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("select * from printer order by price ASC;")){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                resultingItems.add(createPrinter(resultSet));
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        return resultingItems;
    }

    @Override
    public boolean update(Printer printer) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        int changeNumber = 0;
        try(Connection con=DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("delete from printer where code=?")){
            statement.setInt(1, id);
            changeNumber = statement.executeUpdate();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        return changeNumber>0;
    }

    @Override
    public boolean create(Printer printer) {
        int changeNumber = 0;
        try(Connection con=DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("INSERT INTO printer(model, color, type, price) VALUE (?,?,?,?)")){
            statement.setString(1,printer.getModel());
            statement.setString(2,printer.getColor());
            statement.setString(3,printer.getType());
            statement.setBigDecimal(4, printer.getPrice());
            changeNumber = statement.executeUpdate();
        }catch (SQLException | IllegalArgumentException e){
            logger.error(e.getMessage());
        }
        return changeNumber>0;
    }

    @Override
    public Printer getById(Integer integer) {
        return null;
    }

    private Printer createPrinter(ResultSet resultSet) throws SQLException {
        Printer printer;
        printer = new Printer();
        printer.setCode(resultSet.getInt(1));
        printer.setModel(resultSet.getString(2));
        printer.setColor(resultSet.getString(3));
        printer.setType(resultSet.getString(4));
        printer.setPrice(resultSet.getBigDecimal(5));
        return printer;
    }
}
