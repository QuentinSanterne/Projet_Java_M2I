public class Logement {

    private int id;
    private String adresse;
    private double surface;
    private int nbPieces;
    private boolean hasGarden;
    private Chauffage chauffage;
    private boolean hasPool;
    private int etage;
    private int cat_id;

    //Contructeur simple
    public Logement(String addr, double surface, int nbPieces) {
        this.id=-1;
        this.adresse=addr;
        this.surface=surface;
        this.nbPieces=nbPieces;
        this.hasGarden=false;
        this.chauffage=Chauffage.CH_ELECTRICITE_INDIVIDUEL;
        this.hasPool=false;
        this.etage=1;
        this.cat_id=0;
    }

    //Contructeur complet
    public Logement(String addr, double surface, int nbPieces, boolean garden, Chauffage chauffage,
                    boolean pool, int etage, int cat_id) {
        this.id=-1;
        this.adresse=addr;
        this.surface=surface;
        this.nbPieces=nbPieces;
        this.hasGarden=garden;
        this.chauffage=chauffage;
        this.hasPool=pool;
        this.etage=etage;
        this.cat_id=cat_id;
    }

    //Constructeur par copie
    public Logement(Logement loge) {
        this.id=loge.id;
        this.adresse=loge.adresse;
        this.surface=loge.surface;
        this.nbPieces=loge.nbPieces;
        this.hasGarden=loge.hasGarden;
        this.chauffage=loge.chauffage;
        this.hasPool=loge.hasPool;
        this.etage=loge.etage;
        this.cat_id=loge.cat_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public double getSurface() {
        return surface;
    }

    public int getNbPieces() {
        return nbPieces;
    }

    public boolean hasGarden() {
        return hasGarden;
    }

    public Chauffage getChauffage() {
        return chauffage;
    }

    public boolean hasPool() {
        return hasPool;
    }

    public int getEtage() {
        return etage;
    }

    public int getCategorie() {
        return cat_id;
    }

    public void updateOnce(int champ, String modif){
        switch (champ) {
            case 1:
                adresse=modif;
                break;
            case 2:
                surface=Double.parseDouble(modif);
                break;
            case 3:
                nbPieces=Integer.parseInt(modif);
                break;
            case 4:
                boolean oui = modif.equals("y") ? true : false;
                hasGarden=oui;
                break;
            case 5:
                if (Integer.parseInt(modif) > Chauffage.values().length+1) {
                    chauffage=Chauffage.AUTRE;
                    break;
                }
                chauffage=Chauffage.values()[Integer.parseInt(modif)];
                break;
            case 6:
                System.out.println(modif);
                boolean yes = modif.equals("y") ? true : false;
                System.out.println(yes);
                hasPool=yes;
                break;
            case 7:
                etage=Integer.parseInt(modif);
                break;
            case 8:
                cat_id=Integer.parseInt(modif);
                break;
        }
    }

    @Override
    public String toString() {
        String garden = hasGarden ? "Oui" : "Non";
        String pool = hasPool ? "Oui" : "Non";
        return "Logement " + id + " :" +
                " \n\tAdresse : " + adresse +
                " \n\tSurface :" + surface + "m²" +
                " \n\tNombre de pieces : " + nbPieces +
                " \n\tPossede un jardin : " + garden +
                " \n\tType de chauffage : " + chauffage +
                " \n\tPossede une piscine : " + pool +
                " \n\tNombre d'etage(s) : " + etage +
                " \n\tType de logement : " + cat_id ;
    }
}
