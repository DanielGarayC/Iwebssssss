import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Menú de la Biblioteca ---");
        System.out.println("1. Agregar usuario");
        System.out.println("2. Agregar libro");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("5. Mostrar libros disponibles");
        System.out.println("6. Mostrar usuarios y libros prestados");
        System.out.println("7. Estante");
        Scanner sc = new Scanner(System.in);
        Estante estante = new Estante();
        try {
            while(true){
                System.out.print("Ingrese una opción: ");
                String opcion = sc.nextLine();
                int opcion_n = Integer.parseInt(opcion);
                switch (opcion_n) {
                    case 1:
                        System.out.print("Ingrese el nombre del usuario: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese el correo del usuario: ");
                        String correo = sc.nextLine();
                        System.out.print("Ingrese el código del usuario: ");
                        String codigo = sc.nextLine();
                        Usuario usuario = new Usuario(nombre, correo, codigo);
                        usuario.validUsuario(nombre, correo, codigo);
                        break;
                    case 2:
                        System.out.print("Ingrese el título del libro: ");
                        String nombre_libro = sc.nextLine();
                        System.out.print("Ingrese el autor del libro: ");
                        String autor = sc.nextLine();
                        System.out.print("Ingrese el ISBN (código numérico) del libro: ");
                        String isbn = sc.nextLine();
                        System.out.print("Ingrese la posición del libro en la biblioteca: ");
                        String pos = sc.nextLine();
                        pos = pos.replaceAll("[()]","");
                        String[] coord = pos.split(",");
                        try{
                            int x = Integer.parseInt(coord[0]);
                            int y = Integer.parseInt(coord[1]);
                            Libros libro = new Libros(nombre_libro,autor,isbn,coord);
                            libro.validLibro(nombre_libro, autor, isbn, coord);
                        }catch (NumberFormatException e) {
                            System.out.println("Pon bien las coordenadas crjo");
                        }

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    default:
                        System.out.println("Ingrese una opción disponible");
                        break;
                }
            }
        } catch (NumberFormatException e){
            System.out.println("Entrada inválida. Revisa denuevo porfa");
        }
    }
}