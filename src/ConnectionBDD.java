import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBDD {

    private Connection conn;
    private final String URL = "jdbc:mysql://localhost:3306/logements?useSSL=false&serverTimezone=UTC";
    private final String LOGIN = "root";
    private final String PASSWD = "r00t";

    //Instance du singleton
    private static ConnectionBDD instance;

    //Contructeur de classe privé pour singleton
    private ConnectionBDD(){
        try {
            this.conn = DriverManager.getConnection(URL, LOGIN, PASSWD);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Retourne le singleton, le créant au passage s'il n'existe pas
    public static Connection getConnection(){
        if(instance == null){
            instance = new ConnectionBDD();
        }
        return instance.conn;
    }
}
