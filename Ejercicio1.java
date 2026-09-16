import java.util.Scanner; // Importamos la clase Scanner para leer datos por consola
import java.util.InputMismatchException; // Importamos la excepción para manejar errores de tipo de dato

public class Ejercicio1 { // Declaramos la clase principal
    public static void main(String[] args) { // Método de entrada principal del programa
        Scanner scanner = new Scanner(System.in); // Instanciamos Scanner para la entrada estándar (teclado)

        try { // Iniciamos un bloque try-catch para manejar posibles errores en la entrada de datos del usuario
            System.print("Ingrese el tamaño del primer arreglo (a): "); // Solicitamos el tamaño del arreglo 'a'
            int sizeA = scanner.nextInt(); // Leemos el tamaño ingresado por el usuario
            if (sizeA <= 0) throw new IllegalArgumentException("El tamaño debe ser mayor a 0"); // Validamos que el tamaño sea positivo

            int[] a = new int[sizeA]; // Inicializamos el arreglo 'a' con el tamaño especificado
            System.out.println("Ingrese los valores del arreglo 'a':"); // Indicamos al usuario que ingrese los valores
            for (int i = 0; i < sizeA; i++) { // Iteramos desde 0 hasta el tamaño del arreglo
                System.out.print("Valor " + (i + 1) + ": "); // Solicitamos el valor para la posición actual
                a[i] = scanner.nextInt(); // Guardamos el valor ingresado en el arreglo 'a'
            }

            System.out.print("Ingrese el tamaño del segundo arreglo (b): "); // Solicitamos el tamaño del arreglo 'b'
            int sizeB = scanner.nextInt(); // Leemos el tamaño de 'b'
            if (sizeB <= 0) throw new IllegalArgumentException("El tamaño debe ser mayor a 0"); // Validamos el tamaño de 'b'

            int[] b = new int[sizeB]; // Inicializamos el arreglo 'b'
            System.out.println("Ingrese los valores del arreglo 'b':"); // Solicitamos los valores para 'b'
            for (int i = 0; i < sizeB; i++) { // Iteramos para llenar el arreglo 'b'
                System.out.print("Valor " + (i + 1) + ": "); // Solicitamos el valor actual
                b[i] = scanner.nextInt(); // Guardamos el valor en el arreglo 'b'
            }

            System.out.print("Intersección: "); // Imprimimos el encabezado del resultado
            boolean hayInterseccion = false; // Bandera para saber si encontramos al menos un elemento en común
            
            // Lógica para encontrar la intersección
            for (int i = 0; i < sizeA; i++) { // Iteramos sobre cada elemento del arreglo 'a'
                for (int j = 0; j < sizeB; j++) { // Iteramos sobre cada elemento del arreglo 'b'
                    if (a[i] == b[j]) { // Comparamos si el elemento actual de 'a' es igual al de 'b'
                        System.out.print(a[i] + " "); // Si son iguales, lo imprimimos
                        hayInterseccion = true; // Cambiamos la bandera indicando que sí hubo intersección
                        break; // Rompemos el ciclo interno para evitar imprimir duplicados si el número se repite en 'b'
                    }
                }
            }

            if (!hayInterseccion) { // Si la bandera sigue en false después de revisar todo
                System.out.print("No existe intersección entre los arreglos."); // Informamos que no hay elementos comunes
            }
            System.out.println(); // Imprimimos un salto de línea por estética
            
        } catch (InputMismatchException e) { // Capturamos si el usuario ingresa letras en lugar de números
            System.out.println("Error: Debe ingresar valores numéricos enteros válidos."); // Mensaje de error
        } catch (IllegalArgumentException e) { // Capturamos si el tamaño es inválido (negativo o cero)
            System.out.println("Error: " + e.getMessage()); // Imprimimos el mensaje de la excepción lanzada
        } finally { // Bloque que siempre se ejecuta al final
            scanner.close(); // Cerramos el scanner para liberar el recurso de memoria
        }
    }
}