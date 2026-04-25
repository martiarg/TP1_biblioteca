package unlar.edu.ar.objects;

public class Libro {
    private String titulo;
    private String isbn;
    private String autor;
    private int anio;
    private boolean disponible;

    public Libro() {}

    public Libro(String titulo, String isbn, String autor, int anio) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.anio = anio;
        this.disponible = true;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

        @Override
public String toString() {
    return "ISBN: " + isbn +
           " | Título: " + titulo +
           " | Autor: " + autor +
           " | Año: " + anio +
           " | Disponible: " + (disponible ? "Sí" : "No");
}
}