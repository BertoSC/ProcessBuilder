package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Enviroment {
    public static void main(String[] args) {

        // El comando ahora tiene dos partes: primero calculamos la suma, luego mostramos la variable
        String[] comando = {"CMD", "/C", "set /A suma=%num1%+%num2%"};

        // Construimos el proceso
        ProcessBuilder pb = new ProcessBuilder(comando);

        // Configuramos las variables de entorno
        Map<String, String> entorno = pb.environment();
        entorno.put("num1", "6");
        entorno.put("num2", "4");

        try {
            // Ejecutamos el comando
            Process p = pb.start();

            // Leemos la salida del proceso (el resultado de la suma)
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line); // Mostrar cada línea de la salida
            }

            // Esperamos que el proceso termine correctamente
            int exitCode = p.waitFor();
            System.out.println("El comando terminó con el código: " + exitCode);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error durante la ejecución del proceso");
            e.printStackTrace();
            System.exit(2);
        }
    }
}
