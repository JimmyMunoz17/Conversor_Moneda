
import api.api;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        menu();
    }

    public static void menu(){
        api api_conexion = new api();
        // Parsear el JSON
        JsonObject jsonObject = JsonParser.parseString(api_conexion.jsonResponse).getAsJsonObject();
        // Acceder al objeto de conversion_rates
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        DecimalFormat decimal = new DecimalFormat("#.000");
        int opcion = 0;
        while (opcion != 7){
            Scanner sc = new Scanner(System.in);
            double numero = 0;
            double resultado =0 ;
            System.out.println("************************************************");
            System.out.println("Bienvenidos al convertidor de monedas\n");
            System.out.println("Seleccione una opción:\n" +
                    "1) Dólar ==>> Peso Argentino\n" +
                    "2) Peso Argentino ==>> Dólar\n" +
                    "3) Dólar ==>> Real brasileño\n" +
                    "4) Real brasileño ==>> Dólar\n" +
                    "5) Dólar ==>> Peso colombiano\n" +
                    "6) Peso colombiano ==>> Dólar\n" +
                    "7) Salir\n" +
                    "Elija una opción valida: ");
            System.out.println("************************************************");
             try{
                 opcion = sc.nextInt();
                 if(opcion == 1){
                     try {
                         System.out.println("Ingrese el valor que desea convertir:");
                         numero = sc.nextFloat();
                         double arsValue = conversionRates.get("ARS").getAsDouble();
                         resultado = numero * arsValue;
                         System.out.println("El valor: " + numero + " [USD] corresponde al valor final de  ==>> " + decimal.format(resultado) + " [ARS]" );
                     }catch (InputMismatchException err){
                         System.out.println("Ingrese solo números");
                     }
                 } else if (opcion == 2) {
                     try {
                         System.out.println("Ingrese el valor que desea convertir:");
                         numero = sc.nextFloat();
                         double arsValue = conversionRates.get("ARS").getAsDouble();
                         resultado = numero * (1/arsValue);
                         System.out.println("El valor: " + numero + " [ARS] corresponde al valor final de  ==>> " + decimal.format(resultado) + " [USD]" );
                     }catch (InputMismatchException err){
                         System.out.println("Ingrese solo números");
                     }
                 } else if (opcion == 3) {
                     try {
                         System.out.println("Ingrese el valor que desea convertir:");
                         numero = sc.nextFloat();
                         double brlValue = conversionRates.get("BRL").getAsDouble();
                         resultado = numero * brlValue;
                         System.out.println("El valor: " + numero + " [USD] corresponde al valor final de  ==>> " + decimal.format(resultado) + " [BRL]" );
                     }catch (InputMismatchException err){
                         System.out.println("Ingrese solo números");
                     }
                 } else if (opcion == 4) {
                     try {
                         System.out.println("Ingrese el valor que desea convertir:");
                         numero = sc.nextFloat();
                         double brlValue = conversionRates.get("BRL").getAsDouble();
                         resultado = numero * (1/brlValue);
                         System.out.println("El valor: " + numero + " [BRL] corresponde al valor final de  ==>> " + decimal.format(resultado) + " [USD]" );
                     }catch (InputMismatchException err){
                         System.out.println("Ingrese solo números");
                     }

                 } else if (opcion == 5) {
                     try {
                         System.out.println("Ingrese el valor que desea convertir:");
                         numero = sc.nextFloat();
                         double copValue = conversionRates.get("COP").getAsDouble();
                         resultado = numero * copValue;
                         System.out.println("El valor: " + numero + " [USD] corresponde al valor final de  ==>> " + decimal.format(resultado) + " [COP]" );
                     }catch (InputMismatchException err){
                         System.out.println("Ingrese solo números");
                     }

                 }else if(opcion == 6){
                     try {
                         System.out.println("Ingrese el valor que desea convertir:");
                         numero = sc.nextFloat();
                         double copValue = conversionRates.get("COP").getAsDouble();
                         resultado = numero * (1/copValue);
                         System.out.println("El valor: " + numero + " [COP] corresponde al valor final de  ==>> " + decimal.format(resultado) + " [USD]" );
                     }catch (InputMismatchException err){
                         System.out.println("Ingrese solo números");
                     }

                 } else if (opcion == 7){
                     System.out.println("Hasta pronto!!!");
                 }else {
                     System.out.println("seleccione una opción correcta");
                 }
             }catch ( Exception e){
                 System.out.println("Seleccione una opción correcta");
                 opcion = 0;
             }
        }

    }
}