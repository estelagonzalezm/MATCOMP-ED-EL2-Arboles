import java.util.ArrayList;
import java.util.List;

public class MainPrueba {
    public static void main(String[] args){
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        List<Integer> claves = new ArrayList<>();
        List<String> valores = new ArrayList<>();

        for (int i = 0; i <= 128; i++) {
            claves.add(i);
            valores.add("Valor" + i);
        }

        arbol.insertarBalanceado(claves, valores, 0, claves.size() - 1);
        int sumaTotal = arbol.getSuma();
        System.out.println("Suma total de los elementos: " + sumaTotal);

        int sumaInorden = sumarRecorrido(arbol.getListaOrdenCentral());
        int sumaPreorden = sumarRecorrido(arbol.getListaPreOrden());
        int sumaPostorden = sumarRecorrido(arbol.getListaPostOrden());

        System.out.println("Suma usando recorrido Inorden: " + sumaInorden);
        System.out.println("Suma usando recorrido Preorden: " + sumaPreorden);
        System.out.println("Suma usando recorrido Postorden: " + sumaPostorden);

        if (sumaTotal == sumaInorden && sumaTotal == sumaPreorden && sumaTotal == sumaPostorden) {
            System.out.println("Las sumas son iguales en los tres tipos de recorrido.");
        } else {
            System.out.println("Las sumas no son iguales.");
        }
        ArbolBinarioDeBusquedaEnteros subArbolIzq = arbol.getSubArbolIzquierda();
        ArbolBinarioDeBusquedaEnteros subArbolDer = arbol.getSubArbolDerecha();

        int sumaIzquierda = arbol.getSubArbolIzquierda().getSuma();
        int sumaDerecha = arbol.getSubArbolDerecha().getSuma();
        System.out.println("Suma del subárbol izquierdo: " + sumaIzquierda);
        System.out.println("Suma del subárbol derecho: " + sumaDerecha);

        if (sumaIzquierda + sumaDerecha == sumaTotal) {
            System.out.println("La suma de los subárboles izquierdo y derecho es igual a la suma total.");
        } else {
            System.out.println("La suma de los subárboles izquierdo y derecho no es igual a la suma total.");
        }

        int altura = arbol.getAltura();
        System.out.println("Altura del árbol: " + altura);

        List<Integer> camino = arbol.getCamino(110);
        System.out.println("Camino para llegar al valor 110: " + camino);

        System.out.println("Longitud del camino para llegar al valor 110: " + camino.size());
    }

    private static int sumarRecorrido(List<Integer> lista) {
        int suma = 0;
        for (Integer valor : lista) {
            suma += valor;
        }
        return suma;
    }
}
