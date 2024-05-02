import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBDD {

    private Connection conn;
    private final String URL = "";
    private final String LOGIN = "";
    private final String PASSWD = "";

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
    public static Connection getConnexion(){
        if(instance == null){
            instance = new ConnectionBDD();
        }
        return instance.conn;
    }
}
