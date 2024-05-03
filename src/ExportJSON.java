import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ExportJSON {

    private Connection conn;

    ExportJSON() {
        conn = ConnectionBDD.getConnection();
    }

    public void exportTabletoJSON() {


    try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM ma_table";
            ResultSet rs = stmt.executeQuery(sql);

            Gson gson = new Gson();
            FileWriter writer = new FileWriter("export.json");

            while (rs.next()) {
                // Convertir chaque ligne de résultat en objet JSON
                String json = gson.toJson(rs);
                // Écrire l'objet JSON dans le fichier
                writer.write(json);
            }

            writer.close();
            System.out.println("Exportation vers JSON réussie.");

    } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

