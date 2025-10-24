import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlAsistencias {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asistencia> asistencias;
    private Scanner sc;

    public ControlAsistencias() {
        estudiantes = ArchivoEstudiantes.cargar();
        asistencias = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    // Registrar estudiante
    public void registrarEstudiante() {
        System.out.print("Ingrese DNI: ");
        String dni = sc.nextLine();
        for (Estudiante e : estudiantes) {
            if (e.getDni().equals(dni)) {
                System.out.println("DNI ya registrado.");
                return;
            }
        }
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        estudiantes.add(new Estudiante(dni, nombre));
        ArchivoEstudiantes.guardar(estudiantes);
        System.out.println("Estudiante registrado correctamente.");
    }

    // Registrar asistencia
    public void registrarAsistencia() {
        System.out.print("Ingrese DNI del estudiante: ");
        String dni = sc.nextLine();
        Estudiante est = null;
        for (Estudiante e : estudiantes) {
            if (e.getDni().equals(dni)) {
                est = e;
                break;
            }
        }
        if (est == null) {
            System.out.println("DNI no encontrado.");
            return;
        }
        System.out.print("Ingrese estado (Presente/Ausente/Tardanza): ");
        String estado = sc.nextLine();
        Asistencia asistencia = new Asistencia(dni, estado);
        asistencias.add(asistencia);
        System.out.println("Asistencia registrada.");
    }

    // Mostrar historial por estudiante
    public void mostrarHistorial() {
        System.out.print("Ingrese DNI del estudiante: ");
        String dni = sc.nextLine();
        for (Asistencia a : asistencias) {
            if (a.getDni().equals(dni)) {
                System.out.println(a);
            }
        }
    }

    // Menú principal
    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- CONTROL DE ASISTENCIAS ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar asistencia");
            System.out.println("3. Mostrar historial por estudiante");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1: registrarEstudiante(); break;
                case 2: registrarAsistencia(); break;
                case 3: mostrarHistorial(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        new ControlAsistencias().menu();
    }
}
