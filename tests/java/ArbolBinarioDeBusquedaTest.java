import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaTest {
    ArbolBinarioDeBusqueda<Integer, String> arbol;
    @BeforeEach
    void setUp() {
        arbol = new ArbolBinarioDeBusqueda<>();
    }
    @org.junit.jupiter.api.Test
    void addNodoRaiz() {
        assertTrue(arbol.addNodoRaiz(10, "A"));
        assertEquals(10, arbol.getRaiz().getClave());
    }
    @org.junit.jupiter.api.Test
    void addOtrosNodos() {
        arbol.add(10, "A");
        assertTrue(arbol.addOtrosNodos(5, "B"));
        assertTrue(arbol.addOtrosNodos(15, "C"));
        assertFalse(arbol.addOtrosNodos(10, "D"));
    }

    @org.junit.jupiter.api.Test
    void add() {
        arbol.add(10, "A");
        arbol.add(5, "B");
        arbol.add(15, "C");
        assertEquals(10, arbol.getRaiz().getClave());
        assertEquals(5, arbol.getRaiz().getMenor().getClave());
        assertEquals(15, arbol.getRaiz().getMayor().getClave());
    }

    @org.junit.jupiter.api.Test
    void buscarNodoAInsertar_Null() {
        ArbolBinarioDeBusqueda<String, String> arbol = new ArbolBinarioDeBusqueda<>();

        String dato = "X";
        arbol.add(dato, dato);
        var nodo = arbol.buscarNodoAInsertar(dato, arbol.getRaiz());
        assertNull(nodo);

    }
    @org.junit.jupiter.api.Test
    void buscarNodoAInsertar_NotNull() {
        arbol.add(10, "A");
        NodoABB<Integer, String> nodo = arbol.buscarNodoAInsertar(5, arbol.getRaiz());
        assertNotNull(nodo);
        assertEquals(10, nodo.getClave());

        assertNull(arbol.buscarNodoAInsertar(10, arbol.getRaiz()));
    }

    @org.junit.jupiter.api.Test
    void getAltura() {
        assertEquals(0, arbol.getAltura());
        arbol.add(10, "A");
        arbol.add(5, "B");
        arbol.add(3, "C");
        assertEquals(3, arbol.getAltura());
    }

    @org.junit.jupiter.api.Test
    void getListaOrdenCentral() {
        arbol.add(10, "A");
        arbol.add(5, "B");
        arbol.add(15, "C");
        List<Integer> esperada = Arrays.asList(5, 10, 15);
        assertEquals(esperada, arbol.getListaOrdenCentral());
    }


    @org.junit.jupiter.api.Test
    void getListaPreOrden() {
        arbol.add(10, "A");
        arbol.add(5, "B");
        arbol.add(15, "C");
        List<Integer> esperada = Arrays.asList(10, 5, 15);
        assertEquals(esperada, arbol.getListaPreOrden());
    }


    @org.junit.jupiter.api.Test
    void getListaPostOrden() {
        arbol.add(10, "A");
        arbol.add(5, "B");
        arbol.add(15, "C");
        List<Integer> esperada = Arrays.asList(5, 15, 10);
        assertEquals(esperada, arbol.getListaPostOrden());
    }


    @org.junit.jupiter.api.Test
    void getListaDatosNivel() {
        arbol.add(10, "A");
        arbol.add(5, "B");
        arbol.add(15, "C");
        List<Integer> nivel0 = List.of(10);
        List<Integer> nivel1 = Arrays.asList(5, 15);
        assertEquals(nivel0, arbol.getListaDatosNivel(0));
        assertEquals(nivel1, arbol.getListaDatosNivel(1));
    }


    @org.junit.jupiter.api.Test
    void getGrado() {
        assertEquals(0, arbol.getGrado());
        arbol.add(10, "A");
        arbol.add(5, "B");
        arbol.add(15, "C");
        assertEquals(2, arbol.getGrado());
    }

    @org.junit.jupiter.api.Test
    void isArbolHomogeneo() {
        assertTrue(arbol.isArbolHomogeneo());
        arbol.add(10, "A");
        arbol.add(5, "B");
        arbol.add(15, "C");
        assertTrue(arbol.isArbolHomogeneo());

        arbol = new ArbolBinarioDeBusqueda<>();
        arbol.add(10, "A");
        arbol.add(5, "B"); // solo tiene un hijo
        assertFalse(arbol.isArbolHomogeneo());
    }


    @org.junit.jupiter.api.Test
    void isArbolCompleto() {
        assertTrue(arbol.isArbolCompleto());
        arbol.add(10, "A");
        arbol.add(5, "B");
        arbol.add(15, "C");
        assertTrue(arbol.isArbolCompleto());

        arbol.add(3, "D");
        assertFalse(arbol.isArbolCompleto());
    }


    @org.junit.jupiter.api.Test
    void isArbolCasiCompleto() {
        assertTrue(arbol.isArbolCasiCompleto());
        arbol.add(10, "A");
        assertTrue(arbol.isArbolCasiCompleto());
        arbol.add(1, "E");
        assertFalse(arbol.isArbolCasiCompleto());
    }


    @org.junit.jupiter.api.Test
    void getCamino() {
        arbol.add(10, "A");
        arbol.add(5, "B");
        arbol.add(2, "C");
        arbol.add(8, "D");
        List<Integer> esperado = Arrays.asList(10, 5, 2);
        assertEquals(esperado, arbol.getCamino(2));

        List<Integer> noEncontrado = arbol.getCamino(99);
        assertTrue(noEncontrado.contains(10));
    }


    @org.junit.jupiter.api.Test
    void getSubArbolIzquierda() {
        arbol.add(10, "A");
        arbol.add(5, "B");
        ArbolBinarioDeBusqueda<Integer, String> sub = arbol.getSubArbolIzquierda();
        assertEquals(5, sub.getRaiz().getClave());
    }

    @org.junit.jupiter.api.Test
    void getSubArbolDerecha() {
        arbol.add(10, "A");
        arbol.add(15, "B");
        ArbolBinarioDeBusqueda<Integer, String> sub = arbol.getSubArbolDerecha();
        assertEquals(15, sub.getRaiz().getClave());
    }

    @org.junit.jupiter.api.Test
    void getRaiz() {
        assertNull(arbol.getRaiz());
        arbol.add(10, "A");
        assertNotNull(arbol.getRaiz());
    }

    @org.junit.jupiter.api.Test
    void setRaiz() {
        NodoABB<Integer, String> nodo = new NodoABB<>(42, "Z");
        arbol.setRaiz(nodo);
        assertEquals(42, arbol.getRaiz().getClave());
    }

    @org.junit.jupiter.api.Test
    void insertarBalanceado() {
        List<Integer> claves = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<String> valores = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
        arbol.insertarBalanceado(claves, valores, 0, claves.size() - 1);
        assertEquals(4, arbol.getRaiz().getClave());
        assertTrue(arbol.isArbolCasiCompleto());
    }
}