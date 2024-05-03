public class Categorie {

    private int id;
    private String typeL;

    public Categorie(String typeL){
        this.id = -1;
        this.typeL=typeL;
    }

    public Categorie(Categorie categorie){
        this.id=categorie.id;
        this.typeL=categorie.typeL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getTypeL() {
        return typeL;
    }

    public void updateTypeL(String up) {
        this.typeL = up;
    }

    @Override
    public String toString() {
        return "Categorie " + id + " : " + typeL;
    }
}
