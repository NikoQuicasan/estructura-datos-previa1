public import java.util.Scanner; // Importamos Scanner

public class Ejercicio3 { // Clase principal
    public static void main(String[] args) { // Método principal
        Scanner scanner = new Scanner(System.in); // Instanciamos Scanner

        try { // Iniciamos manejo de errores
            System.out.print("Ingrese la cantidad de cadenas de texto (Strings) que desea evaluar: "); // Solicitamos el tamaño
            int tamaño = Integer.parseInt(scanner.nextLine()); // Leemos como línea y convertimos a entero para evitar bugs del buffer de Scanner
            
            if (tamaño <= 0) { // Validamos que sea un tamaño positivo
                System.out.println("El tamaño del arreglo debe ser mayor que 0."); // Mensaje de error
                return; // Terminamos la ejecución si es inválido
            }

            String[] palabras = new String[tamaño]; // Inicializamos el arreglo de Strings
            System.out.println("Ingrese las cadenas de texto:"); // Instrucción
            
            for (int i = 0; i < tamaño; i++) { // Iteramos para pedir las palabras
                System.out.print("Cadena [" + i + "]: "); // Mostramos el índice actual
                palabras[i] = scanner.nextLine(); // Leemos la cadena completa (incluyendo espacios si los hay)
            }

            String cadenaMasLarga = ""; // Variable para guardar el String más largo
            int indiceMasLargo = -1; // Variable para guardar el índice, inicializada en -1 (estado inválido)

            // Lógica para encontrar el String más largo
            for (int i = 0; i < tamaño; i++) { // Iteramos sobre el arreglo
                if (palabras[i].length() > cadenaMasLarga.length()) { // Comparamos la longitud actual con la máxima registrada
                    cadenaMasLarga = palabras[i]; // Actualizamos la palabra más larga
                    indiceMasLargo = i; // Guardamos su índice
                }
            }

            // Impresión de resultados
            System.out.println("--- Resultados ---"); // Separador
            System.out.println("La cadena más larga es: '" + cadenaMasLarga + "'"); // Imprimimos la palabra
            System.out.println("Se encuentra en el índice: " + indiceMasLargo); // Imprimimos la posición

        } catch (NumberFormatException e) { // Capturamos si al pedir el tamaño ingresaron una letra
            System.out.println("Error: El tamaño debe ser un valor numérico entero."); // Mensaje
        } finally { // Bloque final
            scanner.close(); // Cerramos recurso
        }
    }
} {
    
}
