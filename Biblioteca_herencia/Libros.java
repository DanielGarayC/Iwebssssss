import java.util.ArrayList;

public class Libros {
    private String titulo;
    private String autor;
    private String isbn;
    private String[] coordenadas = new String[2];
    private static ArrayList<Libros> librosRegistrados = new ArrayList<>();
    public Libros(String titulo, String autor, String isbn, String[] coordenadas){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.coordenadas = coordenadas;
    }

    public static ArrayList<Libros> getLibrosRegistrados() {
        return librosRegistrados;
    }

    public static void setLibrosRegistrados(ArrayList<Libros> librosRegistrados) {
        Libros.librosRegistrados = librosRegistrados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public static boolean libroRegistro(String isbn, String[] coord ){
        for(Libros libro : librosRegistrados){
            String[] coord_libros = libro.getCoordenadas();
            if(libro.getIsbn().equals(isbn) || (coord_libros[0].equals(coord[0]) && coord_libros[1].equals(coord[1]))){
                return true;
            }
        }
        return false;
    }
    public void validLibro(String titulo, String autor, String isbn, String[] coord){
        if(libroRegistro(isbn,coord)){
            System.out.println("El isbn o posición en el estante ya se encuentran registrados owo");
        }else{
            librosRegistrados.add(new Libros(titulo, autor, isbn, coord));
            System.out.println("Libro registrado correctamente!");
        }
    }
}
