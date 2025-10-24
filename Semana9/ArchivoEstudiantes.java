import java.io.*;
import java.util.ArrayList;

public class ArchivoEstudiantes {
    private static final String RUTA = "estudiantes.txt";

    public static void guardar(ArrayList<Estudiante> lista) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA))) {
            for (Estudiante e : lista) {
                writer.println(e.getDni() + ";" + e.getNombre());
            }
        } catch (IOException ex) {
            System.out.println("Error al guardar archivo");
        }
    }

    public static ArrayList<Estudiante> cargar() {
        ArrayList<Estudiante> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                lista.add(new Estudiante(datos[0], datos[1]));
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        return lista;
    }
}
