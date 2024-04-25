package com.projectiss.repository;

import com.projectiss.domain.Produs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.List;

public class ProduseRepository {

    private final JdbcUtils dbUtils;

    public ProduseRepository(Properties props) {
        this.dbUtils = new JdbcUtils(props);
    }

    public List<Produs> getAll(){
        List<Produs> produse = new ArrayList<>();
        Connection connection = dbUtils.getConnection();
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM Produse")) {
            ResultSet result = statement.executeQuery();
            while (result.next()){
                String name = result.getString("name");
                int stock = result.getInt("stock");
                float price = result.getFloat("price");
                int id = result.getInt("id");
                Produs produs = new Produs(name,price,stock);
                produs.setId(id);
                produse.add(produs);
            }
            return produse;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
