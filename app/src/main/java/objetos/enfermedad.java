package objetos;

public class enfermedad {
    private int id;
    private String [] enfermedad = { "brucelosis", "fiebre aftosa", "salmonella", "rabia","parvovirus"};
    private int [] precios = { 75000, 22500,35000,54000,58000};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String[] enfermedad) {
        this.enfermedad = enfermedad;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }
    public int Final (int precios , int preciosA)
    {

        int result = precios + preciosA;
        return result;
    }
}
