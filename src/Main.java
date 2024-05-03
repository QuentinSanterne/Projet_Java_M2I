import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CategorieDAO catDao = new CategorieDAO();
        LogementDAO logeDao = new LogementDAO();

        catDao.create(new Categorie("Maison"));
        catDao.create(new Categorie("Appartement"));

        logeDao.create(new Logement("1 rue blabla", 90.4, 6, true,
                Chauffage.CH_ELECTRICITE_INDIVIDUEL, true, 2, 0));

        System.out.println(catDao.getAll());
        System.out.println(logeDao.getAll());

    }
}
