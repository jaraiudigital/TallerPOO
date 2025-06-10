// clase persona y atributos
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String genero; // M o F
    private double sueldoHora;
    private String cargo;
//
    public Persona(String nombre, String apellido, int edad, String genero, double sueldoHora, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero.toUpperCase();
        this.sueldoHora = sueldoHora;
        this.cargo = cargo.toLowerCase();
    }