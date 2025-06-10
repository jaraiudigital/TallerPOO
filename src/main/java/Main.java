import java.util.Scanner;
//
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClasificadorAnimales clasificador = new ClasificadorAnimales();
        GestorPersonas gestor = new GestorPersonas();

        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Clasificar animales");
            System.out.println("2. Gestionar personas");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    clasificador.ejecutar();
                    break;
                case 2:
                    gestor.ejecutar();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}