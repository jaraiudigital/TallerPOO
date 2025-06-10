import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClasificadorAnimales clasificador = new ClasificadorAnimales();
        GestorPersonas gestor = new GestorPersonas();

        while (true) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Ingresar animales");
            System.out.println("2. Ingresar personas");
            System.out.println("3. Mostrar clasificación de animales");
            System.out.println("4. Mostrar animales ingresados");
            System.out.println("5. Mostrar personas ingresadas");

            // Opciones específicas para consultas con lambdas
            System.out.println("6. Cantidad de personas almacenadas");
            System.out.println("7. Promedio de edad de personas");
            System.out.println("8. Cantidad de personas mayores de edad");
            System.out.println("9. Personas cuyo nombre comienza con 'A'");
            System.out.println("10. Personas cuyo apellido contiene 'M'");

            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    clasificador.ejecutar();
                    break;
                case "2":
                    gestor.ejecutar();
                    break;
                case "3":
                    clasificador.mostrarClasificacion();
                    break;
                case "4":
                    clasificador.mostrarAnimalesIngresados();
                    break;
                case "5":
                    gestor.mostrarPersonasIngresadas();
                    break;
                case "6":
                    gestor.consultaCantidadPersonas();
                    break;
                case "7":
                    gestor.consultaPromedioEdad();
                    break;
                case "8":
                    gestor.consultaMayoresEdad();
                    break;
                case "9":
                    gestor.consultaNombresConA();
                    break;
                case "10":
                    gestor.consultaApellidosConM();
                    break;
                case "0":
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}
