import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        LogementDAO logeDao = new LogementDAO();
        CategorieDAO catDao = new CategorieDAO();

        catDao.create(new Categorie("Maison"));
        catDao.create(new Categorie("Appartement"));

        logeDao.create(new Logement("1 rue blabla", 90.4, 6, true,
                Chauffage.CH_ELECTRICITE_INDIVIDUEL, true, 2, 0));

        System.out.println("=============Inventaire==============");
        System.out.println("Catégories de logement : ");
        for (Categorie cat : catDao.getAll()) {
            System.out.println(cat);
        }
        System.out.println("Liste des logements : ");
        for (Logement l : logeDao.getAll()) {
            System.out.println(l);
        }

        int choixMenu;
        String input;

        do {
            System.out.println("\nQue souhaitez vous faire ?");
            System.out.println("1. Voir les catégories.");
            System.out.println("2. Ajouter une catégorie.");
            System.out.println("3. Supprimer une catégorie.");
            System.out.println("4. Modifier une catégorie.");
            System.out.println("5. Voir les logements.");
            System.out.println("6. Ajouter un logement.");
            System.out.println("7. Supprimer un logement.");
            System.out.println("8. Modifier un logement.");
            System.out.println("0 pour sortir.\n");

            choixMenu = sc.nextInt();
            sc.nextLine();
            switch (choixMenu) {
                case 1:
                    for (Categorie cat : catDao.getAll()) {
                        System.out.println(cat);
                    }
                    break;
                case 2:
                    System.out.println("Indiquez la nouvelle catégorie de logement :");
                    input=sc.nextLine();
                    catDao.create(new Categorie(input));
                    break;
                case 3:
                    System.out.println("Indiquez le numéro de la catégorie à supprimer :");
                    input=sc.nextLine();
                    catDao.delete(catDao.getById(Integer.parseInt(input)));
                    break;
                case 4:
                    System.out.println("Indiquez le numéro de la catégorie à modifier :");
                    String inputIndexCat=sc.nextLine();
                    System.out.println("Indiquez le nouveau nom de la catégorie :");
                    input = sc.nextLine();
                    catDao.update(new Categorie(input),Integer.parseInt(inputIndexCat));
                    break;
                case 5:
                    for (Logement l : logeDao.getAll()) {
                        System.out.println(l);
                    }
                    break;
                case 6:
                    System.out.println("Indiquez l'adresse du nouveau logement:");
                    String input_addr=sc.nextLine();
                    System.out.println("Indiquez la surface du nouveau logement (en m²):");
                    String input_surf=sc.nextLine();
                    System.out.println("Indiquez le nombre de pièce du nouveau logement:");
                    String input_pieces=sc.nextLine();
                    logeDao.create(new Logement(input_addr, Double.parseDouble(input_surf),
                            Integer.parseInt(input_pieces)));
                    break;
                case 7:
                    System.out.println("Indiquez le numéro du logement à supprimer :");
                    input=sc.nextLine();
                    logeDao.delete(logeDao.getById(Integer.parseInt(input)));
                    break;
                case 8:
                    System.out.println("Indiquez le numéro du logement à modifier :");
                    String inputIndexLoge=sc.nextLine();
                    Logement newLoge = new Logement(logeDao.getById(Integer.parseInt(inputIndexLoge)));
                    System.out.println("Indiquez le champ à modifier :");
                    System.out.println("1. Adresse\n2. Surface\n3. #Piece\n4. Jardin (y/n)\n5. Chauffage" +
                            "\n6. Piscine (y/n) \n7. #Etages\n8. Categorie");
                    int inputModif = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Indiquez la nouvelle valeur :");
                    input = sc.nextLine();
                    newLoge.updateOnce(inputModif,input);
                    logeDao.update(newLoge,Integer.parseInt(inputIndexLoge));
                    break;
            }
        }while (choixMenu != 0);
    }
}
