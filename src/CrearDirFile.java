import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CrearDirFile {
    public static void main(String[] args) {
        String directorio = "src/directorio";
        String archivo = "archivo.txt";

        crearArchivo(directorio, archivo);
        //caso de que el archivo no exista
        buscarTexto("pedrito", "Gato");
        //caso de que el archivo exista
        buscarTexto(directorio + "/" + archivo, "Gato");

    }

    public static void crearArchivo(String directorio, String archivo) {
        File dir = new File(directorio);
        try {
            if (!dir.exists()) {
                dir.mkdir();
                System.out.println("Directorio creado");
            } else {
                System.out.println("El directorio ya existe");
            }
        } catch (Exception e) {
            System.out.println("Error al crear directorio");
            e.printStackTrace();
        }
        File archivoFile = new File(directorio + "/" + archivo);
        try {
            if (archivoFile.createNewFile()) {
                System.out.println("Archivo creado");
                FileWriter fw = new FileWriter(archivoFile);
                BufferedWriter bw = new BufferedWriter(fw);
                ArrayList<String> lista = obtenerLista();
                Iterator<String> iterator = lista.iterator();
                while (iterator.hasNext()) {
                    bw.write(iterator.next() + "\n");
                }
                bw.close();
            } else {
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
            e.printStackTrace();
        }

    }

    public static ArrayList<String> obtenerLista(){
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Perro");
        lista.add("Gato");
        lista.add("Juan");
        lista.add("Daniel");
        lista.add("Juan");
        lista.add("Camila");
        lista.add("Gato");
        lista.add("Perro");
        lista.add("Camila");
        lista.add("Daniel");
        lista.add("Camila");
        return lista;
    }

    public static void buscarTexto(String archivo, String texto){
        File archivoFile = new File(archivo);
        try {
            if (!archivoFile.exists()) {
                System.out.println("El archivo no existe");
            } else {
                FileReader fr = new FileReader(archivoFile);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                int contador = 0;
                while ((linea = br.readLine()) != null) {
                    if (linea.equals(texto)) {
                        contador++;
                    }
                }
                br.close();
                System.out.println("cantidad de repeticiones del texto -> " + contador);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

}
