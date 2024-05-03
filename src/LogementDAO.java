import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LogementDAO implements DAO<Logement> {

    private static int cpt_id=0;

    //Contient tous les logements en base de données
    private List<Logement> loges;
    private Connection conn;

    //Constructeur de classe
    public LogementDAO(){
        loges = new ArrayList<>();
        conn = ConnectionBDD.getConnection();
    }

    //Ajout du Logement "loge"
    @Override
    public void create(Logement elem) {
        String insertStatement = "INSERT INTO Logement(id, adresse, surface, nbPieces, hasGarden, chauffage," +
                "hasPool, etage, id_categorie) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement insertLoge = conn.prepareStatement(insertStatement)) {
            conn.setAutoCommit(false);
            insertLoge.setInt(1, cpt_id);
            insertLoge.setString(2,elem.getAdresse());
            insertLoge.setDouble(3,elem.getSurface());
            insertLoge.setInt(4,elem.getNbPieces());
            insertLoge.setBoolean(5,elem.hasGarden());
            insertLoge.setString(6,elem.getChauffage().name());
            insertLoge.setBoolean(7,elem.hasPool());
            insertLoge.setInt(8,elem.getEtage());
            insertLoge.setInt(9, elem.getCategorie());

            insertLoge.executeUpdate();
            conn.commit();
            elem.setId(cpt_id++);
            loges.add(elem);

        }catch (SQLException e){
            e.printStackTrace();
            if (conn != null) {
                try {
                    System.err.print("Transaction has been rolled back");
                    conn.rollback();
                }catch (SQLException excep){
                    e.printStackTrace();
                }
            }
        }
    }

    //Suppression du Logement "loge"
    @Override
    public void delete(Logement elem) {
        String deleteStatement = "DELETE FROM Logement WHERE id = ?;";
        try (PreparedStatement deleteLoge = conn.prepareStatement(deleteStatement)) {
            conn.setAutoCommit(false);
            deleteLoge.setInt(1, elem.getId());
            deleteLoge.setString(2,elem.getAdresse());
            deleteLoge.setDouble(3,elem.getSurface());
            deleteLoge.setInt(4,elem.getNbPieces());
            deleteLoge.setBoolean(5,elem.hasGarden());
            deleteLoge.setString(6,elem.getChauffage().name());
            deleteLoge.setBoolean(7,elem.hasPool());
            deleteLoge.setInt(8,elem.getEtage());
            deleteLoge.setInt(9, elem.getCategorie());

            deleteLoge.executeUpdate();
            conn.commit();
            loges.remove(elem);

        }catch (SQLException e){
            e.printStackTrace();
            if (conn != null) {
                try {
                    System.err.print("Transaction has been rolled back");
                    conn.rollback();
                }catch (SQLException excep){
                    e.printStackTrace();
                }
            }
        }
    }

    //Mise à jour du Logement ayant l'id "id" avec les données de "loge"
    @Override
    public void update(Logement elem, int id) {
        String updateStatement = "UPDATE Logement set adresse=?, surface=?, nbPieces=?, hasGarden=?, " +
                "chauffage=?, hasPool=?, etage=?, id_categorie=? WHERE id=?;";
        try (PreparedStatement updateLoge = conn.prepareStatement(updateStatement)) {
            conn.setAutoCommit(false);
            updateLoge.setInt(9, elem.getId());
            updateLoge.setString(1,elem.getAdresse());
            updateLoge.setDouble(2,elem.getSurface());
            updateLoge.setInt(3,elem.getNbPieces());
            updateLoge.setBoolean(4,elem.hasGarden());
            updateLoge.setString(5,elem.getChauffage().name());
            updateLoge.setBoolean(6,elem.hasPool());
            updateLoge.setInt(7,elem.getEtage());
            updateLoge.setInt(8, elem.getCategorie());

            updateLoge.executeUpdate();
            conn.commit();
            loges.remove(elem);

        }catch (SQLException e){
            e.printStackTrace();
            if (conn != null) {
                try {
                    System.err.print("Transaction has been rolled back");
                    conn.rollback();
                }catch (SQLException excep){
                    e.printStackTrace();
                }
            }
        }
    }

    //Retourne tous les logements
    @Override
    public List<Logement> getAll() {
        return loges;
    }

    //Retourne le logement correspondant ayant l'id indiqué
    @Override
    public Logement getById(int id) {
        return loges.get(id);
    }

    //Retourne les logements ayant l'adresse indiquée
    public List<Logement> getByAdresse(String addr) {
        List<Logement> loges_addr = loges.stream()
                .filter(l -> l.getAdresse().equals(addr))
                .sorted(Comparator.comparingInt(Logement::getId))
                .collect(Collectors.toList());
        return loges_addr;
    }
}
