import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO implements DAO<Categorie>{

    //Contient tous les logements en base de données
    private List<Categorie> categories;
    private Connection conn;

    //Constructeur de classe
    public CategorieDAO(){
        categories = new ArrayList<>();
        conn = ConnectionBDD.getConnexion();
    }

    @Override
    public void create(Categorie elem) {
        categories.add(elem);
    }

    @Override
    public void delete(Categorie elem) {
        categories.remove(elem);
    }

    @Override
    public void update(Categorie elem, int id) {

    }

    @Override
    public List<Categorie> getAll() {
        return null;
    }

    @Override
    public Categorie getById(int id) {
        return categories.get(id);
    }
}
