package UsuarisPackage;
/**
 * CLASSE LLISTAUSUARIS
 * Conte una llista de dades Usuaris
 * Informació:
 *      @llistaUsuaris = llista d'els usuaris
 *      @nUsuaris = nº d'usuaris apuntats a la llista
 */
public class LlistaUsuaris {
    private Usuaris[] llistaUsuaris;
    private int nUsuaris;

    public LlistaUsuaris(int mida){
        nUsuaris=0;
        llistaUsuaris = new Usuaris[mida];

    }

    public void Afegir(Usuaris a ){
        llistaUsuaris[nUsuaris]=a;
        nUsuaris++;
    }

    public void Elimina(Usuaris a){
        boolean trobat=false;
        int i=0;
        while(!trobat){
            if(llistaUsuaris[i]==a){
                trobat=true;
                for(int j=i; j<nUsuaris; j++){
                    llistaUsuaris[j]=llistaUsuaris[j+1];
                }
                nUsuaris--;
            }
        }
    }
    //getter i setter
    public int getnUsuaris() {
        return nUsuaris;
    }

    public void setnUsuaris(int nUsuaris) {
        this.nUsuaris = nUsuaris;
    }
    public Usuaris getUsuarisPos(int i){
        return llistaUsuaris[i];
    }
    public String getUsuarisAliesPos(int i){
        return llistaUsuaris[i].getAlies();
    }
    
    public String getLlistaUsuaris() {
        return this.toString();
    }

    public void setLlistaUsuaris(Usuaris[] llistaUsuaris) {
        this.llistaUsuaris = llistaUsuaris;
    }
}
