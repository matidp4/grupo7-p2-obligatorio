package entities;

public class Driver {


    private long id;
    private String driverName;
    private int mentions;

    public Driver(Integer contadorDePilotos, String driver, Integer mentions){
        this.id = contadorDePilotos;
        this.driverName = driver;
        this.mentions = mentions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getMentions() {
        return mentions;
    }

    public void setMentions(int mentions) {
        this.mentions = mentions;
    }
    // atributos driver ok

}


