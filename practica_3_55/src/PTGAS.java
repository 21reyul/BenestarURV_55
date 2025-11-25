public class PTGAS extends Usuaris{
    private String campus;

    //Constructor
    public PTGAS(String alies, String correu, String campus) {
        super(alies, correu);
        this.campus=campus;
    }

    //getters i setters
    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
    
    
    


}
