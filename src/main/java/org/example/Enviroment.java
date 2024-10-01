package org.example;

/*
set /A num1=6
set /A num2=4
set /A suma=num1+num2
echo la suma es %suma%
la suma es 10
*/

import java.io.IOException;
import java.util.Arrays;

public class Enviroment {
    public static void main(String[] args) {

        if (args.length <= 0) {
            System.out.println("You must indicate the command to execute");
            System.exit(1);
        }

        String [] comando={"ping", "www.iessanclemente.net"};

        String [] comando2={"pin", "www.iessanclemente.net"};

        String [] comando3={"ping -n", "www.iessanclemente.net"};

        ProcessBuilder pb = new ProcessBuilder(comando3);
        pb.inheritIO();

        try {
            Process p = pb.start();
            int codRet = p.waitFor();
            System.out.println("The execution of " + Arrays.toString(args)
                    + " returns " + codRet
                    + " " + (codRet == 0 ? "(OK)" : "(ERROR)")
            );
        } catch (IOException e) {
            System.err.println("Error during the execution of the process");
            System.err.println("Detailed information");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("---------------------");
            System.exit(2);
        } catch (InterruptedException e) {
            System.err.println("Interrupted process");
            System.exit(3);
        }
    }
}
