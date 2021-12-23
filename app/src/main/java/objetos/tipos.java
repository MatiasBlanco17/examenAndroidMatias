package objetos;

public class tipos {
    private int id;
    private String [] tipos = { "animal domestico", "animal salvaje", "otros"} ;
    private int [] precios = { 25000, 45000,18000};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getTipos() {
        return tipos;
    }

    public void setTipos(String[] tipos) {
        this.tipos = tipos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }
}
