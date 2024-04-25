package com.projectiss.repository;

import com.projectiss.domain.AccessLevel;
import com.projectiss.domain.Angajat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

public class AngajatiRepository {
    private final JdbcUtils dbUtils;

    public AngajatiRepository(Properties props) {
        this.dbUtils = new JdbcUtils(props);
    }

    public Optional<Angajat> findAngajat(String username, String password){
        Connection connection = dbUtils.getConnection();
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM Angajati where username=? and password=?")){
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                AccessLevel accessLevel = AccessLevel.valueOf(result.getString("accesLevel"));
                Angajat angajat = new Angajat(username,password,accessLevel);
                int id = result.getInt("id");
                angajat.setId(id);
                return Optional.of(angajat);
            }else{
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
