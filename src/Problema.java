import java.io.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Problema {

    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("mensaje.txt"));
            bw = new BufferedWriter(new FileWriter("mensaje_cifrado.txt"));

            String linea = null;

            /* Lectura y validación  de clave */
            Scanner sc = new Scanner(System.in);
            boolean flag = false;
            String clave;
            String regex = "[A-z]";
            do {
                System.out.println("Introduce una clave (12 caracteres máximo)");
                clave = sc.nextLine();
                String car;
                if (clave.length() < 12){
                    System.out.println("la clave menor a 12");
                    for (int c=0; c<clave.length(); c++){
                        car = String.valueOf(clave.charAt(c));
                        if (car.matches(regex)){
                            flag = true;
                        }
                    }
                }
            }while (!flag);

            while ((linea = br.readLine()) != null) {
                StringBuilder sb = new StringBuilder(linea.length());


                /* Aquí vendría la lógica del programa */
                System.out.println(linea);
                linea = br.readLine();
                for (int c = 0; c<linea.length(); c++) {
                    String letra1= String.valueOf(linea.charAt(c));
                    if (letra1.matches(regex)){
                        if (c<clave.length()) {
                            int i = (linea.toUpperCase().charAt(c) + clave.toUpperCase().charAt(c)) % 26;
                            char caracter = (char) i;
                            System.out.println(caracter);
                            sb.append(caracter);
                        }
                    }
                }

                bw.write(sb.toString()); /* Escribe la cadena de caracteres en el fichero*/
                bw.newLine(); /* escribe nueva línea en el fichero */

            }
            bw.close();
            br.close();
            System.out.println("El mensaje ha sido cifrado correctamente");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}


