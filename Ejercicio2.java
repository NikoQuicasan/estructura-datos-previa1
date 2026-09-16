import java.util.Scanner; // Importamos la clase Scanner
import java.util.InputMismatchException; // Importamos el manejador de excepciones de tipo de entrada

public class Ejercicio2 { // Declaramos la clase principal
    public static void main(String[] args) { // Método de ejecución principal
        Scanner scanner = new Scanner(System.in); // Instanciamos el objeto Scanner
        int[] numeros = new int[10]; // Creamos un arreglo de tamaño fijo 10 como pide el requerimiento

        try { // Iniciamos el manejo de excepciones
            System.out.println("Ingrese exactamente 10 números enteros:"); // Instrucción al usuario
            for (int i = 0; i < 10; i++) { // Bucle de 10 iteraciones
                System.out.print("Número " + (i + 1) + ": "); // Solicitamos el número correspondiente
                numeros[i] = scanner.nextInt(); // Leemos el número y lo guardamos
            }

            // Inicializamos las variables para buscar los dos mayores. Usamos el valor mínimo posible de un Integer.
            int maximo = Integer.MIN_VALUE; // Variable para el número más grande
            int segundoMaximo = Integer.MIN_VALUE; // Variable para el segundo más grande

            // Lógica de búsqueda en una sola pasada (O(n))
            for (int i = 0; i < 10; i++) { // Iteramos el arreglo de 10 posiciones
                if (numeros[i] > maximo) { // Si el número actual es mayor que nuestro máximo actual
                    segundoMaximo = maximo; // El antiguo máximo pasa a ser el segundo máximo
                    maximo = numeros[i]; // El número actual se convierte en el nuevo máximo
                } else if (numeros[i] > segundoMaximo && numeros[i] != maximo) { // Si no es mayor al máximo, pero sí al segundo máximo (evitando duplicados del máximo)
                    segundoMaximo = numeros[i]; // Actualizamos el segundo máximo
                }
            }

            if (segundoMaximo == Integer.MIN_VALUE) { // Verificamos si todos los números ingresados fueron exactamente iguales
                System.out.println("No hay un segundo número más grande (todos son iguales)."); // Mensaje de caso borde
            } else { // Si se encontró correctamente
                System.out.println("El segundo número más grande es: " + segundoMaximo); // Imprimimos el resultado
            }

        } catch (InputMismatchException e) { // Capturamos entradas no numéricas
            System.out.println("Error: Por favor, ingrese únicamente números enteros."); // Mensaje de error
        } finally { // Bloque de limpieza
            scanner.close(); // Cerramos el scanner
        }
    }
}