public class Categorie {

    private static int cpt_id = 0;

    private int id;
    private String typeL;

    public Categorie(String typeL){
        this.id = cpt_id++;
        this.typeL=typeL;
    }
}
