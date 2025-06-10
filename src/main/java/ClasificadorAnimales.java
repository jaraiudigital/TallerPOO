// se cre a la clase ClasificadorAnimales y una lista de animales y un Map para clasificar los animales por tipo
public class ClasificadorAnimales {
    private Map<String, List<Animal>> clasificacion = new TreeMap<>();
    private List<Animal> animales = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
