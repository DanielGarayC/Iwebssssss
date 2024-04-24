import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private String[][] biblioteca;
    private ArrayList<Libro> listaLibros = new ArrayList<>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public void setBiblioteca(String[][] biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void initBiblioteca(){
        String[][] biblioteca = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8; j++) {
                biblioteca[i][j] = "| Vacío |";
            }
        }
        this.biblioteca = biblioteca;
    }
    public String[][] getBiblioteca() {
        return biblioteca;
    }

    public void agregarLibro() throws CoordenadasExc {
        Scanner sc = new Scanner(System.in);
        Libro libro = new Libro();
        String[][] bib = getBiblioteca();
        System.out.printf("Ingrese el título del libro: ");
        libro.setTitulo(sc.nextLine());
        System.out.printf("Ingrese el autor del libro: ");
        libro.setAutor(sc.nextLine());
        System.out.printf("Ingrese el ISBN: ");
        int ISBNin = Integer.parseInt(sc.nextLine());
        for (Libro li : listaLibros) {
            if (li.getISBN() == ISBNin) {
                System.out.printf("Ingrese de nuevo el ISBN: ");
                ISBNin = Integer.parseInt(sc.nextLine());
            }
        }
        libro.setISBN(ISBNin);
        System.out.printf("Ingrese las posición en  la biblioteca: ");
        String posLibro = sc.nextLine();
        String[] posArr = posLibro.split(" ");
        //Validar antes de agregar que sean numeros las opciones ingresadas
        try {
            libro.setPosX(Integer.parseInt(posArr[0]));
            libro.setPosY(Integer.parseInt(posArr[1]));
        }catch(NumberFormatException e){
            System.out.println("Error");
            throw new CoordenadasExc();
        }

        listaLibros.add(libro);
        bib[Integer.parseInt(posArr[0])][Integer.parseInt(posArr[1])] ="| " +  libro.getTitulo()+ " " + libro.getStatus() + " |";
        setBiblioteca(bib);
        //verificar que bib se actualiza correctamente (si lo hae pero en el imprimirMatriz no se actualiza)
        imprimirMatriz(bib);
    }

    public void agregarUsuario(){
        Scanner sc = new Scanner(System.in);
        Usuario usuario = new Usuario();
        System.out.printf("Ingrese el nombre del usuario: ");
        System.out.printf("Ingrese el correo del usuario: ");
        String correoIn = sc.nextLine();
        for (Usuario u : listaUsuarios) {
            if (u.getCorreo().equals(correoIn)) {
                System.out.printf("Ingrese de nuevo el correo: ");
                correoIn = sc.nextLine();
            }
        }
        usuario.setCorreo(correoIn);
        System.out.printf("Ingrese el codigo del usuario: ");
        int codigoIn = Integer.parseInt(sc.nextLine());
        for (Usuario u : listaUsuarios) {
            if (u.getCodigo() == codigoIn) {
                System.out.printf("Ingrese de nuevo el correo: ");
                codigoIn = Integer.parseInt(sc.nextLine());
            }
        }
        usuario.setCodigo(codigoIn);
        listaUsuarios.add(usuario);
    }
    public void prestarLibro(){
        //Falta historial de prestamos
        Scanner sc = new Scanner(System.in);
        System.out.printf("Ingrese el nombre del libro a prestar: ");
        String libroIn = sc.nextLine();
        for (Libro li : listaLibros) {
            //Verificar que el libro ignresado se encuentre en la lista
            if (li.getTitulo().equals(libroIn)) {
                //Verificar que no este en prestamo
                if(li.getStatus().equals("Disponible")) {
                    System.out.printf("Ingrese el nombre del usuario que desea el libro: ");
                    String usuarioIn = sc.nextLine();
                    for (Usuario u : listaUsuarios) {
                        if (u.getNombre().equals(usuarioIn)) {
                            System.out.printf("Registre la fecha del prestamo");
                            String fecha = sc.nextLine();
                            for (Libro lib : listaLibros) {
                                if (lib.getTitulo().equals(libroIn)) {
                                    lib.setStatus("No disponible");
                                }
                            }
                        } else {
                            System.out.printf("Ingrese de nuevo el nombre del usuario: ");
                            usuarioIn = sc.nextLine();
                        }
                    }
                }
                else{
                    System.out.printf("El libro no se encuentra disponible");
                    break;
                }
            }
            else{
                System.out.printf("Ingrese de nuevo el título: ");
                libroIn = sc.nextLine();
            }
        }

    }
    public void imprimirMatriz(String[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <matriz[i].length ; j++) {
                System.out.printf(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
