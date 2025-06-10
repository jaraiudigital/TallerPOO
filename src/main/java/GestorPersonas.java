import java.util.*;
import java.util.stream.*;
// clase GestorPersonas que gestiona una lista de personas y permite realizar operaciones sobre ellas
public class GestorPersonas {
    private List<Persona> personas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
// se crea el metodo ejecutar que solicita al usuario ingresar los datos de las personas y realiza consultas sobre ellas
    public void ejecutar() {
        System.out.println("=== Gestión de Personas ===");
        String continuar;

        do {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());
            System.out.print("Género (M/F): ");
            String genero = scanner.nextLine();
            System.out.print("Sueldo por hora: ");
            double sueldoHora = Double.parseDouble(scanner.nextLine());
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();

            personas.add(new Persona(nombre, apellido, edad, genero, sueldoHora, cargo));

            System.out.print("¿Desea ingresar otra persona? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        realizarConsultas();
    }

    private void realizarConsultas() {
        System.out.println("\n--- Consultas con Stream y Lambda ---");

        System.out.println("Cantidad total: " + personas.size());

        double promedioEdad = personas.stream()
                .mapToInt(Persona::getEdad)
                .average()
                .orElse(0);
        System.out.println("Promedio de edades: " + promedioEdad);

        long mayoresEdad = personas.stream()
                .filter(p -> p.getEdad() >= 18)
                .count();
        System.out.println("Personas mayores de edad: " + mayoresEdad);

        System.out.println("Nombres que inician con 'A':");
        personas.stream()
                .filter(p -> p.getNombre().startsWith("A"))
                .forEach(p -> System.out.println(p.getNombre()));

        System.out.println("Apellidos que contienen 'M':");
        personas.stream()
                .filter(p -> p.getApellido().toLowerCase().contains("m"))
                .forEach(p -> System.out.println(p.getApellido()));

        // Sueldo por 8h - Directores masculinos
        System.out.println("\nSueldo por 8 horas de directores masculinos:");
        personas.stream()
                .filter(p -> p.getCargo().equals("director") && p.getGenero().equals("M"))
                .peek(p -> System.out.println("Nombre: " + p.getNombre() + " " + p.getApellido() +
                        " Sueldo por 8 horas: $" + (p.getSueldoHora() * 8)))
                .collect(Collectors.toList());

        // Primera desarrolladora
        System.out.println("\nPrimera desarrolladora:");
        personas.stream()
                .filter(p -> p.getCargo().equals("desarrollador") && p.getGenero().equals("F"))
                .findFirst()
                .ifPresent(p -> System.out.println(p.getNombre() + " " + p.getApellido()));

        // Desarrollador que más gana
        Optional<Persona> masGana = personas.stream()
                .filter(p -> p.getCargo().equals("desarrollador"))
                .max(Comparator.comparing(Persona::getSueldoHora));

        if (masGana.isPresent()) {
            Persona p = masGana.get();
            System.out.println("\nDesarrollador que más gana:");
            System.out.println(p.getNombre() + " " + p.getApellido() + ", $" + p.getSueldoHora() + "/h");
        }

        // Mujeres ordenadas por nombre
        System.out.println("\nMujeres ordenadas por nombre:");
        personas.stream()
                .filter(p -> p.getGenero().equals("F"))
                .sorted(Comparator.comparing(Persona::getNombre))
                .forEach(p -> System.out.println(p.getNombre() + " " + p.getApellido()));
    }
}