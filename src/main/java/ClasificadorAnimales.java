// se cre a la clase ClasificadorAnimales y una lista de animales y un Map para clasificar los animales por tipo
public class ClasificadorAnimales {
    private Map<String, List<Animal>> clasificacion = new TreeMap<>();
    private List<Animal> animales = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
// se crea el metodo ejecutar que solicita al usuario ingresar los datos de los animales y los clasifica
    public void ejecutar() {
        System.out.println("=== Clasificación de Animales ===");
        String continuar;

        do {
            System.out.print("Nombre del animal: ");
            String nombre = scanner.nextLine();
            System.out.print("Tipo (terrestre, aéreo, acuático): ");
            String tipo = scanner.nextLine().toLowerCase();
            System.out.print("Género (masculino/femenino): ");
            String genero = scanner.nextLine();

            Animal animal = new Animal(nombre, tipo, genero);
            animales.add(animal);

            clasificacion.computeIfAbsent(tipo, k -> new ArrayList<>()).add(animal);

            System.out.print("¿Desea ingresar otro animal? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        mostrarClasificacion();
    }
// se crea el metodo mostrarClasificacion que muestra la clasificación de los animales por tipo
    private void mostrarClasificacion() {
        System.out.println("\n--- Resultado de clasificación ---");
        clasificacion.forEach((tipo, lista) -> {
            System.out.println(tipo.substring(0, 1).toUpperCase() + tipo.substring(1) + ":");
            lista.forEach(a -> System.out.println("   " + a.getNombre()));
        });
    }
}
