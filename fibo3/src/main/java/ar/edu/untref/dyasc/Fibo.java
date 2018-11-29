package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.enums.Direction;

public class Fibo {
    /*
     * Dado un numero devuelve el valor de la sucesion de Fibonacci
     * correspondiente a ese numero
     */
    private int fibo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    /*
     * Dada una cantidad numerica, devuelve una sucecion de Fibonacci ordenade
     * de manera directa
     */
    private int[] getDirectSucesion(int quantity) {
        int[] serieResult = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            serieResult[i] = fibo(i);
        }
        return serieResult;
    }

    /*
     * Dada una cantidad numerica, devuelve una sucecion de Fibonacci ordenade
     * de manera inversa
     */
    private int[] getInverseSucesion(int quantity) {
        int[] serieResult = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            serieResult[i] = fibo(quantity - i);
        }
        return serieResult;
    }

    /*
     * Dado una cantidad numerica, devuelve un array con los resultados de la
     * sucesion de Fibonnaci ordenada segun el parametro de direccion otorgado
     */
    public int[] getSucesion(int quantity, Direction direction) {
        if (direction.equals(Direction.DIRECT)) {
            return getDirectSucesion(quantity);
        } else {
            return getInverseSucesion(quantity);
        }
    }
}