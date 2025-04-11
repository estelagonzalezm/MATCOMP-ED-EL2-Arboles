import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaEnterosTest {

    @Test
    void insertarBalanceadoYGetSuma() {
        ArbolBinarioDeBusquedaEnteros<Integer, String> arbol = new ArbolBinarioDeBusquedaEnteros<>();

        List<Integer> claves = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<String> valores = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        arbol.insertarBalanceado(claves, valores, 0, claves.size() - 1);
        int sumaEsperada = claves.stream().mapToInt(Integer::intValue).sum();
        assertEquals(sumaEsperada, arbol.getSuma());

    }

    @Test
    void insertarBalanceadoVacio() {
        ArbolBinarioDeBusquedaEnteros<Integer, String> arbol = new ArbolBinarioDeBusquedaEnteros<>();
        arbol.insertarBalanceado(List.of(), List.of(), 0, -1);
        assertEquals(0, arbol.getSuma());
    }


    @Test
    void getSubArbolIzquierdaDerecha() {
        ArbolBinarioDeBusquedaEnteros<Integer, String> arbol = new ArbolBinarioDeBusquedaEnteros<>();
        arbol.add(10, "A");
        arbol.add(5, "B");
        arbol.add(15, "C");

        ArbolBinarioDeBusquedaEnteros<Integer, String> subIzq = arbol.getSubArbolIzquierda();
        ArbolBinarioDeBusquedaEnteros<Integer, String> subDer = arbol.getSubArbolDerecha();

        assertNotNull(subIzq.getRaiz());
        assertEquals(5, subIzq.getRaiz().getClave());

        assertNotNull(subDer.getRaiz());
        assertEquals(15, subDer.getRaiz().getClave());
    }



    @Test
    void setRaiz() {
        ArbolBinarioDeBusquedaEnteros<Integer, String> arbol = new ArbolBinarioDeBusquedaEnteros<>();
        NodoABB<Integer, String> nodo = new NodoABB<>(100, "Z");
        arbol.setRaiz(nodo);

        assertEquals(100, arbol.getRaiz().getClave());
        assertEquals("Z", arbol.getRaiz().getValue());
    }
}