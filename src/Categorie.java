public class Categorie {

    private static int cpt_id = 0;

    private int id;
    private String typeL;

    public Categorie(String typeL){
        this.id = cpt_id++;
        this.typeL=typeL;
    }

    public Categorie(Categorie categorie){
        this.id=categorie.id;
        this.typeL=categorie.typeL;
    }

    public int getId() {
        return id;
    }

    public String getTypeL() {
        return typeL;
    }

    public void updateTypeL(String up) {
        this.typeL = up;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", typeL='" + typeL + '\'' +
                '}';
    }
}
