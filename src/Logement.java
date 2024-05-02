public class Logement {

    private static int cpt_id = 0;

    private int id;
    private String adresse;
    private double surface;
    private int nbPieces;
    private boolean hasGarden;
    private Chauffage chauffage;
    private Categorie cat;

    public Logement(String addr, double surface, int nbPieces){
        this.id=cpt_id++;
        this.adresse=addr;
        this.surface=surface;
        this.nbPieces=nbPieces;
        this.hasGarden=false;
        this.chauffage=Chauffage.CH_ELECTRICITE_INDIVIDUEL;
        this.cat=null;
    }

    public Logement(String addr, double surface, int nbPieces, boolean garden, Chauffage chauffage, Categorie cat){
        this.id=cpt_id++;
        this.adresse=addr;
        this.surface=surface;
        this.nbPieces=nbPieces;
        this.hasGarden=garden;
        this.chauffage=chauffage;
        this.cat=cat;
    }

    public int getId() {
        return id;
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

    public boolean HasGarden() {
        return hasGarden;
    }

    public Chauffage getChauffage() {
        return chauffage;
    }

    public Categorie getCategorie() {
        return cat;
    }
}
