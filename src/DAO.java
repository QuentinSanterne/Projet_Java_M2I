import java.util.List;

public interface DAO<T> {

    void create(T elem);
    void delete(T elem);
    void update(T elem, int id);
    List<T> getAll();
    T getById(int id);
}
