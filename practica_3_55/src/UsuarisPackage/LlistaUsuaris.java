package UsuarisPackage;

import ActivitatsPackage.Inscripcions;

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

    /**
     * Mètode que et dona la valoració d'un usuari que es troba dins d'una inscripció
     * Programadora: Aina Garcia Albesa
     * @param usuari
     * @param inscripcio
     * @return
     */
    public Integer getValoracioUsuari(Usuaris usuari, Inscripcions inscripcio) {
        Integer resultat = null;
        
        if (usuari != null && inscripcio != null && llistaUsuaris != null) {
            int i = 0;
            boolean trobat = false;
            
            // Buscar si l'usuari està a la llista
            while (i < nUsuaris && !trobat) {
                Usuaris u = llistaUsuaris[i];
                if (u != null && u.getAlies().equals(usuari.getAlies())) {
                    trobat = true;
                }
                i++;
            }
            
            // Si l'usuari està a la llista, obtenir la valoració de la inscripció
            if (trobat) {
                resultat = inscripcio.getValoracioUsuari(usuari);
            }
        }
        return resultat; 
    }

    public Usuaris buscarUsuariPerAlies(String alies) {
    Usuaris trobat = null;
    int i = 0;
    while (i < nUsuaris && trobat == null) {
        if (llistaUsuaris[i].getAlies().equalsIgnoreCase(alies)) {
            trobat = llistaUsuaris[i];
        }
        i++;
    }
        return trobat;
    }


}
