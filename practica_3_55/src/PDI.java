public class PDI extends Usuaris{
    private String nomDept;
    private String campus;


    //Constructor
    public PDI(String alies, String correu, String nomDept, String campus) {
        super(alies, correu);
        this.nomDept=nomDept;
        this.campus=campus;
    }
    
    //getters i setters
    public String getNomDept() {
        return nomDept;
    }

    public void setNomDept(String nomDept) {
        this.nomDept = nomDept;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    



}
