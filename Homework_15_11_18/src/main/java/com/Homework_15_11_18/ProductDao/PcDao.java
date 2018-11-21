package com.Homework_15_11_18.ProductDao;

import com.Homework_15_11_18.ConnectionPool.DBCPDataSource;
import com.Homework_15_11_18.ProductModel.Pc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.Homework_15_11_18.App.logger;

public class PcDao implements Dao<Integer, Pc> {

    @Override
    public List<Pc> getAll() {
        List<Pc> resultingItems = new ArrayList<>();
        try(Connection con=DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("select * from pc order by price ASC;")){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                resultingItems.add(createPc(rs));
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        return resultingItems;
    }

    @Override
    public boolean update(Pc pc) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        int changeNumber = 0;
        try(Connection con=DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("delete from pc where code=?")){
            statement.setInt(1, id);
            changeNumber = statement.executeUpdate();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        return changeNumber>0;
    }

    @Override
    public boolean create(Pc pc) {
        return false;
    }

    @Override
    public Pc getById(Integer id) {
        Pc pc = null;
        try(Connection con= DBCPDataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("select * from pc where code=?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                pc = createPc(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return pc;
    }

    Pc createPc(ResultSet resultSet) throws SQLException {
        Pc resultPc= new Pc();
        resultPc.setCode(resultSet.getInt(1));
        resultPc.setModel(resultSet.getString(2));
        resultPc.setSpeed(resultSet.getShort(3));
        resultPc.setRam(resultSet.getShort(4));
        resultPc.setHd(resultSet.getDouble(5));
        resultPc.setCd(resultSet.getString(6));
        resultPc.setPrice(resultSet.getBigDecimal(7));
        return resultPc;
    }
}
