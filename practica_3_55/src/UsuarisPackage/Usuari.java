package UsuarisPackage;

/**
 * CLASSE PARE USUARIS
 * Conte l'informació comu dels usuaris:
 *      @alies = Identificador
 *      @correu = adreça electronica
 */
public class Usuari{
    protected String alies;
    private String correu;

    //Constructor
    public Usuari(String alies, String correu){
        this.alies = alies;
        this.correu = correu;
    }

    //Getter i setters
    //Programadora: Cristina Cozma
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
