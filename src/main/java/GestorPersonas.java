import java.util.*;
import java.util.stream.*;
// clase GestorPersonas que gestiona una lista de personas y permite realizar operaciones sobre ellas
public class GestorPersonas {
    private List<Persona> personas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);