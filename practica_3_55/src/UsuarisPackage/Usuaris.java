package UsuarisPackage;

/**
 * CLASSE PARE USUARIS
 * Conte l'informació comu dels usuaris:
 *      @alies = Identificador
 *      @correu = adreça electronica
 */
public abstract class Usuaris {
    private String alies;
    private String correu;

    //Constructor
    public Usuaris(String alies, String correu){
        this.alies = alies;
        this.correu = correu;
    }

    //Getter i setters
    public String getAlies(){
        return alies;
    }
        
    public String getCorreu(){
        return correu;
    }
        
    public void setAlies(String alies){
        this.alies = alies;
    }
    
    public void setCorreu(String correu){
        this.correu = correu;
    }

    
}
