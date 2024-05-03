import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExportJSON {

    private Connection conn;

    ExportJSON() {
        conn = ConnectionBDD.getConnection();
    }

    public void exportTabletoJSON(String fileName) {

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Categorie")) {
            ResultSet rs = stmt.executeQuery();
            // Convertir le ResultSet en une liste de maps
            List<Map<String, Object>> resultList = new ArrayList<>();
            System.out.println(rs.getRow());
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                int numCols = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= numCols; i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    Object value = rs.getObject(i);
                    row.put(columnName, value);
                }
                resultList.add(row);
            }
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(fileName+".json");

            while (rs.next()) {
                // Convertir chaque ligne de résultat en objet JSON
                String json = gson.toJson(rs);
                System.out.println("json : " + json);
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

