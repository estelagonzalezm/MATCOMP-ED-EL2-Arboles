import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainPrueba2 {
    public static void main(String[] args) {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i <= 128; i++) {
            numeros.add(i);
        }
        mezclarLista(numeros);
        for (Integer numero : numeros) {
            arbol.add(numero, "Valor" + numero);
        }
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


        ArbolBinarioDeBusquedaEnteros subArbolIzquierdo = arbol.getSubArbolIzquierda();
        ArbolBinarioDeBusquedaEnteros subArbolDerecho = arbol.getSubArbolDerecha();

        int sumaIzquierda = subArbolIzquierdo.getSuma();
        int sumaDerecha = subArbolDerecho.getSuma();
        int claveRaiz =(int) arbol.getRaiz().getClave();

        System.out.println("Suma del subárbol izquierdo: " + sumaIzquierda);
        System.out.println("Suma del subárbol derecho: " + sumaDerecha);
        System.out.println("Clave de la raíz: " + claveRaiz);
        if (sumaIzquierda + sumaDerecha + claveRaiz == sumaTotal) {
            System.out.println("La suma de los subárboles izquierdo y derecho, más la clave de la raíz, es igual a la suma total.");
        } else {
            System.out.println("La suma de los subárboles izquierdo y derecho, más la clave de la raíz, no es igual a la suma total.");
        }

        int altura = arbol.getAltura();
        System.out.println("Altura del árbol: " + altura);

        List<Integer> camino = arbol.getCamino(110);
        System.out.println("Camino para llegar al valor 110: " + camino);
        System.out.println("Longitud del camino para llegar al valor 110: " + camino.size());
    }

    private static void mezclarLista(List<Integer> lista) {
        Random random = new Random();
        for (int i = lista.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = lista.get(i);
            lista.set(i, lista.get(j));
            lista.set(j, temp);
        }
    }
    private static int sumarRecorrido(List<Integer> lista) {
            int suma = 0;
            for (Integer valor : lista) {
                suma += valor;
            }
            return suma;
    }
}
