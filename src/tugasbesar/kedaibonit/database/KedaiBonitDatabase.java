/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import tugasbesar.kedaibonit.impl.CatatUtangDaoImpl;
import tugasbesar.kedaibonit.impl.PelangganDaoImpl;
import tugasbesar.kedaibonit.service.CatatUtangDao;
import tugasbesar.kedaibonit.service.PelangganDao;
/**
 *
 * @author CarakaMR
 */
public class KedaiBonitDatabase {
    
    private static Connection connection;
    private static PelangganDao pelangganDao;
    private static CatatUtangDao catatUtangDao;
    
    public static Connection getConnection() throws SQLException {
        if(connection==null) {
            
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/kedaibonit");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        
        
        return connection;
    }
    
    public static PelangganDao getPelangganDao() throws SQLException{
        
        if (pelangganDao==null) {
            pelangganDao = new PelangganDaoImpl(getConnection());
        }
        
        return pelangganDao;
    }
    
    public static CatatUtangDao getCatatUtangDao() throws SQLException {
        
        if (catatUtangDao==null) {
            catatUtangDao = new CatatUtangDaoImpl(getConnection());
        }
        return catatUtangDao;
    }
    
}
