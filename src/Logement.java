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

    public Logement(String addr, double surface, int nbPieces) {
        this.id=-1;
        this.adresse=addr;
        this.surface=surface;
        this.nbPieces=nbPieces;
        this.hasGarden=false;
        this.chauffage=Chauffage.CH_ELECTRICITE_INDIVIDUEL;
        this.hasPool=false;
        this.etage=0;
        this.cat_id=0;
    }

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

    @Override
    public String toString() {
        return "Logement{" +
                "id=" + id +
                ", adresse='" + adresse + '\'' +
                ", surface=" + surface +
                ", nbPieces=" + nbPieces +
                ", hasGarden=" + hasGarden +
                ", chauffage=" + chauffage +
                ", hasPool=" + hasPool +
                ", etage=" + etage +
                ", cat_id=" + cat_id +
                '}';
    }
}
