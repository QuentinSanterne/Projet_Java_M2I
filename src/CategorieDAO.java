import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO implements DAO<Categorie>{

    private static int cpt_id=0;

    //Contient toutes les catégorie en base de données
    private List<Categorie> categories;
    private Connection conn;

    //Constructeur de classe
    //Vide la table en bdd à la création
    public CategorieDAO() {
        categories = new ArrayList<>();
        conn = ConnectionBDD.getConnection();
        try (PreparedStatement truncate = conn.prepareStatement("delete from categorie;")) {
            conn.setAutoCommit(false);
            truncate.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    System.err.print("Transaction has been rolled back");
                    conn.rollback();
                } catch (SQLException excep) {
                    excep.printStackTrace();
                }
            }
        }
    }

    //Ajout de la Categorie "elem"
    @Override
    public void create(Categorie elem) {
        if(elem == null)
            return;
        String insertStatement = "INSERT INTO Categorie(id,typeL) VALUES (?, ?);";
        try (PreparedStatement insertCat = conn.prepareStatement(insertStatement)) {
            conn.setAutoCommit(false);
            insertCat.setInt(1, categories.size());
            insertCat.setString(2,elem.getTypeL());

            insertCat.executeUpdate();
            conn.commit();
            elem.setId(categories.size());
            categories.add(elem);

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

    //Suppression du Categorie "elem"
    @Override
    public void delete(Categorie elem) {
        if(elem == null)
            return;
        String deleteStatement = "DELETE FROM Categorie WHERE id = ?;";
        try (PreparedStatement deleteCat = conn.prepareStatement(deleteStatement)) {
            conn.setAutoCommit(false);
            deleteCat.setInt(1, elem.getId());

            deleteCat.executeUpdate();
            conn.commit();
            categories.remove(elem);

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    System.err.print("Transaction has been rolled back");
                    conn.rollback();
                } catch (SQLException excep) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Mise à jour de la Categorie ayant l'id "id" avec les données de "elem"
    @Override
    public void update(Categorie elem, int id) {
        if(elem == null)
            return;
        String updateStatement = "UPDATE Categorie set typeL = ? WHERE id = ?;";
        try (PreparedStatement updateCat = conn.prepareStatement(updateStatement)) {
            conn.setAutoCommit(false);
            updateCat.setInt(2, id);
            updateCat.setString(1, elem.getTypeL());

            updateCat.executeUpdate();
            conn.commit();
            categories.get(id).updateTypeL(elem.getTypeL());

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    System.err.print("Transaction has been rolled back");
                    conn.rollback();
                } catch (SQLException excep) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Retourne toutes les catégories
    @Override
    public List<Categorie> getAll() {
        return this.categories;
    }

    //Retourne la catégorie ayant l'id indiqué
    @Override
    public Categorie getById(int id) {
        if (id > categories.size()-1) {
            System.err.println("Categorie hors de la liste");
            return null;
        }
        return categories.get(id);
    }
}
