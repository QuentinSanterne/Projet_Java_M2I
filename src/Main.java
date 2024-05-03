import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException{

        //Création des Gestionnaires DAO
        LogementDAO logeDao = new LogementDAO();
        CategorieDAO catDao = new CategorieDAO();

        //Création de données de départ
        catDao.create(new Categorie("Maison"));
        catDao.create(new Categorie("Appartement"));

        logeDao.create(new Logement("1 rue blabla", 90.4, 6, true,
                Chauffage.CH_ELECTRICITE_INDIVIDUEL, true, 2, 0));

        //Affichage de données de départ
        System.out.println("=============Inventaire==============");
        System.out.println("\nCatégories de logement : ");
        for (Categorie cat : catDao.getAll()) {
            System.out.println(cat);
        }
        System.out.println("\nListe des logements : ");
        for (Logement l : logeDao.getAll()) {
            System.out.println(l);
        }

        int choixMenu;
        String input;
        //Boucle pour l'affichage du menu de gestion de l'inventaire
        do {
            System.out.println("\n==========Gestion de l'inventaire==========");
            System.out.println("\nQue souhaitez vous faire ?");
            System.out.println("1. Voir les categories.");
            System.out.println("2. Ajouter une categorie.");
            System.out.println("3. Supprimer une categorie.");
            System.out.println("4. Modifier une categorie.");
            System.out.println("5. Voir les logements.");
            System.out.println("6. Ajouter un logement.");
            System.out.println("7. Supprimer un logement.");
            System.out.println("8. Modifier un logement.");
            System.out.println("9. Importer/exporter la base de données.");
            System.out.println("0 pour sortir.\n");

            choixMenu = sc.nextInt();
            sc.nextLine();
            switch (choixMenu) {
                case 1:
                    for (Categorie cat : catDao.getAll()) {
                        System.out.println(cat);
                    }
                    Thread.sleep(1500);
                    break;
                case 2:
                    System.out.println("Indiquez la nouvelle categorie de logement :");
                    input=sc.nextLine();
                    catDao.create(new Categorie(input));
                    break;
                case 3:
                    System.out.println("Indiquez le numero de la categorie à supprimer :");
                    input=sc.nextLine();
                    catDao.delete(catDao.getById(Integer.parseInt(input)));
                    break;
                case 4:
                    System.out.println("Indiquez le numéro de la categorie à modifier :");
                    String inputIndexCat=sc.nextLine();
                    System.out.println("Indiquez le nouveau nom de la categorie :");
                    input = sc.nextLine();
                    catDao.update(new Categorie(input),Integer.parseInt(inputIndexCat));
                    break;
                case 5:
                    for (Logement l : logeDao.getAll()) {
                        System.out.println(l);
                    }
                    Thread.sleep(1500);
                    break;
                case 6:
                    System.out.println("Indiquez l'adresse du nouveau logement:");
                    String input_addr=sc.nextLine();
                    System.out.println("Indiquez la surface du nouveau logement (en m²):");
                    String input_surf=sc.nextLine();
                    System.out.println("Indiquez le nombre de piece du nouveau logement:");
                    String input_pieces=sc.nextLine();
                    logeDao.create(new Logement(input_addr, Double.parseDouble(input_surf),
                            Integer.parseInt(input_pieces)));
                    break;
                case 7:
                    System.out.println("Indiquez le numero du logement a supprimer :");
                    input=sc.nextLine();
                    logeDao.delete(logeDao.getById(Integer.parseInt(input)));
                    break;
                case 8:
                    System.out.println("Indiquez le numéro du logement a modifier :");
                    String inputIndexLoge=sc.nextLine();
                    Logement newLoge = new Logement(logeDao.getById(Integer.parseInt(inputIndexLoge)));
                    System.out.println("Indiquez le champ a modifier :");
                    System.out.println("1. Adresse\n2. Surface\n3. #Piece\n4. Jardin (y/n)\n5. Chauffage" +
                            "\n6. Piscine (y/n) \n7. #Etages\n8. Categorie");
                    int inputModif = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Indiquez la nouvelle valeur :");
                    input = sc.nextLine();
                    newLoge.updateOnce(inputModif,input);
                    logeDao.update(newLoge,Integer.parseInt(inputIndexLoge));
                    break;
                case 9 :
                    System.out.println("Souhaitez-vous :");
                    System.out.println("1. Importer une table\n2. Exporter une table");
                    int inputIE = sc.nextInt();
                    System.out.println("Quel est le format utilisé ?");
                    System.out.println("1. JSON\n2. CSV");
                    int inputFormat = sc.nextInt();
                    input = sc.nextLine();
                    System.out.println("Entrez le nom du fichier : ");
                    String inputFileName = sc.nextLine();
                    if (inputIE == 2 && inputFormat==1) {
                        ExportJSON intoJSON = new ExportJSON();
                        intoJSON.exportTabletoJSON(inputFileName);
                        System.out.println("Fichier "+inputFileName+".json exporté avec succès. YEAY :D");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        }while (choixMenu != 0);
    }
}
