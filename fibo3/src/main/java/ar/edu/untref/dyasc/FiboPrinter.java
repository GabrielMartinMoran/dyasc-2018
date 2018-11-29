package ar.edu.untref.dyasc;

import java.io.PrintWriter;

import ar.edu.untref.dyasc.enums.Orientation;
import ar.edu.untref.dyasc.enums.WorkingMode;

public class FiboPrinter {
    /*
     * Dado un array correspondiente a una sucesion, un separador de texto y un
     * modo de trabajo, genera una cadena de texto con formato generado a partir
     * de los parametro brindados
     */
    private String generateSucesionString(int[] sucesion, String separator,
            WorkingMode workingMode) {
        String result = "";
        if (workingMode.equals(WorkingMode.SUM)) {
            int sum = 0;
            for (int i = 0; i < sucesion.length; i++) {
                sum += sucesion[i];
            }
            result = String.format("fibo<%d>s:%s%d", sucesion.length,
                    separator, sum);
        } else {
            result = String.format("fibo<%d>:", sucesion.length);
            for (int i = 0; i < sucesion.length; i++) {
                result += String.format(separator + "%d", sucesion[i]);
            }
        }
        return result;
    }

    public void printSucesion(int[] sucesion, Arguments argumentsParseResult) {
        if (argumentsParseResult.fileOutput == null) {
            printSucesionOnScreen(sucesion, argumentsParseResult);
        } else {
            printSucesionToFile(sucesion, argumentsParseResult);
        }
    }

    /*
     * Dado un array correspondiente a una sucesion y un ArgumentsParseResult;
     * imprime en pantalla el resultado de transformar la sucesion a un string
     * aplicando el formato correspondiente a los parametros brindados
     */
    private void printSucesionOnScreen(int[] sucesion,
            Arguments argumentsParseResult) {
        Orientation orientation = argumentsParseResult.orientation;
        WorkingMode workingMode = argumentsParseResult.workingMode;
        String separator = getSeparator(orientation);
        String result = generateSucesionString(sucesion, separator, workingMode);
        System.out.println(result);
    }

    /*
     * Dado un array correspondiente a una sucesiony un ArgumentsParseResult;
     * guarda en el archivo el resultado de transformar la sucesion a un string
     * aplicando el formato correspondiente a los parametros brindados e imprime
     * en pantalla la informacion de que el archivo se guardo correctamente
     */
    public void printSucesionToFile(int[] sucesion,
            Arguments argumentsParseResult) {
        Orientation orientation = argumentsParseResult.orientation;
        WorkingMode workingMode = argumentsParseResult.workingMode;
        String fileOutput = argumentsParseResult.fileOutput;
        String separator = getSeparator(orientation);
        String fileContent = generateSucesionString(sucesion, separator,
                workingMode);
        try (PrintWriter out = new PrintWriter(fileOutput)) {
            out.println(fileContent);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al escribir el archivo");
            return;
        }
        String result = String.format("fibo<%d> guardado en %s",
                sucesion.length, fileOutput);
        System.out.println(result);
    }

    /*
     * Dado una orientacion, devuelve el separador correspondiente
     */
    private String getSeparator(Orientation orientation) {
        return orientation.equals(Orientation.VERTICAL) ? "\n" : " ";
    }

}
