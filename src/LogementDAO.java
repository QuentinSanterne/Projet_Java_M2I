import java.sql.Connection;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LogementDAO implements DAO<Logement> {

    //Contient tous les logements en base de données
    private List<Logement> loges;
    private Connection conn;

    //Constructeur de classe
    public LogementDAO(){
        loges = new ArrayList<>();
        conn = ConnectionBDD.getConnexion();
    }

    //Ajout du Logement "loge"
    @Override
    public void create(Logement loge) {
        loges.add(loge);

    }

    //Suppression du Logement "loge"
    @Override
    public void delete(Logement loge) {
        loges.remove(loge);
    }

    //Mise à jour du Logement ayant l'id "id" avec les données de "loge"
    @Override
    public void update(Logement loge, int id) {
        Logement loge_old = loges.get(id);
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
