package entities;

public class HashTag {
    public HashTag(int id, String hashtags , int cantidad_usos) {
        this.id = id;
        this.text = hashtags;
        this.cantidad_usos = cantidad_usos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCantidad_usos() {
        return cantidad_usos;
    }

    public void setCantidad_usos(int cantidad_usos) {
        this.cantidad_usos = cantidad_usos;
    }

    // atributos hashtag ok
    private String text;
    private int cantidad_usos;
    private long id;

}
