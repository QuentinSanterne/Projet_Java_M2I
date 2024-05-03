import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO implements DAO<Categorie>{

    //Contient tous les logements en base de données
    private List<Categorie> categories;
    private Connection conn;

    //Constructeur de classe
    public CategorieDAO(){
        categories = new ArrayList<>();
        conn = ConnectionBDD.getConnection();
    }

    @Override
    public void create(Categorie elem) {
        String insertStatement = "INSERT INTO Categorie(id,typeL) VALUES (?, ?);";
        try (PreparedStatement insertCat = conn.prepareStatement(insertStatement)) {
            conn.setAutoCommit(false);
            insertCat.setInt(1, elem.getId());
            insertCat.setString(2,elem.getTypeL());

            insertCat.executeUpdate();
            conn.commit();
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

    @Override
    public void delete(Categorie elem) {
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

    @Override
    public void update(Categorie elem, int id) {
        String updateStatement = "UPDATE Categorie set typeL = ? WHERE id = ?;";
        try (PreparedStatement updateCat = conn.prepareStatement(updateStatement)) {
            conn.setAutoCommit(false);
            updateCat.setInt(2, id);
            updateCat.setString(1, elem.getTypeL());

            updateCat.executeUpdate();
            conn.commit();
            categories.get(elem.getId()).updateTypeL(elem.getTypeL());

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

    @Override
    public List<Categorie> getAll() {
        return this.categories;
    }

    @Override
    public Categorie getById(int id) {
        return categories.get(id);
    }
}
