package jdbcveritabanı;
import java.sql.*;

public class DbHelper {
    private String userName ="root";
    private String password = "Esra.123";
    private String dbUrl = "jdbc:mysql://localhost:3306/";
    private String dbName;

    public DbHelper(String dbName) {
        this.dbName = dbName;
        dbUrl += dbName;
    }
    
    
    
    public Connection getConnection() throws SQLException {
        //Methodun Connection olmasının sebebi Connection tipinin JDBC API nın bir parçası olmasıdır.
        //Veritabanına bağlanmak için Connection tipinde bir nesne döndürmemiz gerekiyor.
        return DriverManager.getConnection(dbUrl,userName,password);
        
    }
    
    public void showErrorMessage(SQLException e){
        System.out.println("Error: " + e.getMessage());
        System.out.println("Error code : " + e.getErrorCode());
    }
}
