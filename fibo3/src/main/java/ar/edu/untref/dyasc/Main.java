package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.enums.Direction;
import ar.edu.untref.dyasc.enums.Orientation;

public class Main {

    private ArgumentsParser argsParser;
    private Arguments argumentsParseResult;
    private FiboPrinter printer;
    private Fibo fibo;

    public Main(String args[]) {
        this.argsParser = new ArgumentsParser(args);
        this.printer = new FiboPrinter();
        this.fibo = new Fibo();
    }

    public Boolean tryParseArguments() {
        try {
            argumentsParseResult = argsParser.parseArguments();
        } catch (IllegalArgumentException e) {
            System.out.println("Opciones no validas.");
            return false;
        }
        // Corroboramos que se haya ingresado un numero dentro de los argumentos
        if (argumentsParseResult.number == -1) {
            System.out.println("No se ingreso un numero valido");
            return false;
        }
        return true;
    }

    public void runFibo() {
        int[] fiboResult = fibo.getSucesion(argumentsParseResult.number,
                argumentsParseResult.direction);
        printer.printSucesion(fiboResult, argumentsParseResult);
    }

    public static void main(String args[]) {

        Main main = new Main(args);
        Boolean couldParse = main.tryParseArguments();
        if (couldParse) {
            main.runFibo();
        }
    }
}