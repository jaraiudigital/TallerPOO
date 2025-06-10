// se cre a la clase ClasificadorAnimales y una lista de animales y un Map para clasificar los animales por tipo
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import java.util.*;

public class ClasificadorAnimales {

    private Map<String, List<Animal>> clasificacion;
    private List<Animal> animales;

    public ClasificadorAnimales() {
        // Usamos TreeMap para que las categorías estén ordenadas alfabéticamente
        clasificacion = new TreeMap<>();
        animales = new ArrayList<>();
    }

    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        String continuar;

        do {
            System.out.print("Nombre del animal: ");
            String nombre = sc.nextLine();

            String tipo;
            while (true) {
                System.out.print("Tipo (terrestre, aéreo, acuático): ");
                tipo = sc.nextLine().toLowerCase();
                if (tipo.equals("terrestre") || tipo.equals("aéreo") || tipo.equals("acuático")) {
                    break;
                } else {
                    System.out.println("Tipo inválido. Intente nuevamente.");
                }
            }

            String genero;
            while (true) {
                System.out.print("Género (masculino/femenino): ");
                genero = sc.nextLine().toLowerCase();
                if (genero.equals("masculino") || genero.equals("femenino")) {
                    break;
                } else {
                    System.out.println("Género inválido. Intente nuevamente.");
                }
            }

            Animal animal = new Animal(nombre, tipo, genero);
            animales.add(animal);

            // Clasificar en el mapa
            clasificacion.putIfAbsent(tipo, new ArrayList<>());
            clasificacion.get(tipo).add(animal);

            System.out.print("¿Desea ingresar otro animal? (s/n): ");
            continuar = sc.nextLine().toLowerCase();

        } while (continuar.equals("s"));
    }

    public void mostrarClasificacion() {
        if (clasificacion.isEmpty()) {
            System.out.println("No hay animales clasificados.");
            return;
        }

        System.out.println("\n--- Resultado de clasificación ---");
        clasificacion.forEach((tipo, lista) -> {
            System.out.println(capitalizar(tipo) + ":");
            lista.forEach(a -> System.out.println("   " + a.getNombre()));
        });
    }

    public void mostrarAnimalesIngresados() {
        if (animales.isEmpty()) {
            System.out.println("No se han ingresado animales.");
            return;
        }

        System.out.println("\n--- Lista de animales ingresados ---");
        animales.forEach(a -> {
            System.out.println("- " + a.getNombre() + " (" + a.getTipo() + ", " + a.getGenero() + ")");
        });
    }

    private String capitalizar(String texto) {
        if (texto == null || texto.isEmpty()) return texto;
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}
