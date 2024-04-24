import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        boolean menu = true;
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.initBiblioteca();
        while (menu){

            System.out.println("----Menu de la Biblioteca----");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Agregar libro");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Mostrar libros disponibles");
            System.out.println("6. Mostrar usuarios y libros prestados");
            System.out.println("7. Estante");
            System.out.println("8. Salir");
            System.out.printf("Seleccione una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){
                case 1:
                    biblioteca.agregarUsuario();
                    break;
                case 2:
                    try {
                        biblioteca.agregarLibro();
                    }
                    catch (CoordenadasExc e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    biblioteca.prestarLibro();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    biblioteca.imprimirMatriz(biblioteca.getBiblioteca());
                    break;
                case 8:
                    System.out.println("Saliendo de la biblioteca...");
                    menu = false;
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        }
    }
}