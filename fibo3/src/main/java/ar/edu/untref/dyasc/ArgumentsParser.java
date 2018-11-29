package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.enums.Direction;
import ar.edu.untref.dyasc.enums.Orientation;
import ar.edu.untref.dyasc.enums.WorkingMode;

public class ArgumentsParser {

    private String[] arguments;

    public ArgumentsParser(String[] arguments) {
        this.arguments = arguments;
    }

    /*
     * Dado el nombre de un argumento, devuelve el valor que posee ese argumento
     * si es que se encuentra en el array de argumentos dentro del atributo
     * 'arguments'. Si no se encuentra el argumento devuelve null
     */
    private String getArgumentValue(String argumentName) {
        String argumentFormat = String.format("-%s=", argumentName);
        for (int i = 0; i < this.arguments.length; i++) {
            if (this.arguments[i].length() > argumentFormat.length()
                    && this.arguments[i].substring(0, 3).equals(argumentFormat)) {
                return this.arguments[i].substring(3);
            }
        }
        return null;
    }

    /*
     * Devuelve del array de argumentos el primer argumento que encuentre de
     * tipo entero
     */
    private int getNumberArgument() {
        int result = -1;
        for (int i = 0; i < this.arguments.length; i++) {
            try {
                result = Integer.parseInt(this.arguments[i]);
                break;
            } catch (NumberFormatException e) {
                continue;
            }
        }
        return result;
    }

    private String getOptionArgument() throws IllegalArgumentException {
        String value = getArgumentValue("o");
        if (value == null) {
            return "hd";
        }
        if (value.length() != 2) {
            throw new IllegalArgumentException(
                    "El argumento opcion no es valido");
        }
        return value;
    }

    private Direction parseDirection() throws IllegalArgumentException {
        String optionArg = getOptionArgument();
        String directionValue = optionArg.substring(1, 2);
        switch (directionValue) {
        case "d":
            return Direction.DIRECT;
        case "i":
            return Direction.INVERSE;
        default:
            throw new IllegalArgumentException(
                    "El argumento opcion no es valido");
        }
    }

    private Orientation parseOrientation() throws IllegalArgumentException {
        String optionArg = getOptionArgument();
        String orientationValue = optionArg.substring(0, 1);
        switch (orientationValue) {
        case "v":
            return Orientation.VERTICAL;
        case "h":
            return Orientation.HORIZONTAL;
        default:
            throw new IllegalArgumentException(
                    "El argumento opcion no es valido");
        }
    }

    private WorkingMode parseWorkingMode() throws IllegalArgumentException {
        String exceptionMessage = "El argumento modo de funcionamiento no es valido";
        String value = getArgumentValue("m");
        if (value == null) {
            return WorkingMode.LIST;
        }
        switch (value) {
        case "l":
            return WorkingMode.LIST;
        case "s":
            return WorkingMode.SUM;
        default:
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    /*
     * Devuelve el resultado de parsear todos los argumentos en un objeto de
     * tipo ArgumentsParseResult
     */
    public Arguments parseArguments() throws IllegalArgumentException {
        Arguments parseResult = new Arguments();
        parseResult.direction = parseDirection();
        parseResult.orientation = parseOrientation();
        parseResult.workingMode = parseWorkingMode();
        parseResult.fileOutput = getArgumentValue("f");
        parseResult.number = getNumberArgument();
        return parseResult;
    }
}
