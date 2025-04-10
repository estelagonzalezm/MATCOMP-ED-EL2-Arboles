import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoABBTest {


    @Test
    void testCompareTo() {
        NodoABB<Integer, String> nodo1 = new NodoABB<>(10, "A");
        NodoABB<Integer, String> nodo2 = new NodoABB<>(20, "B");
        NodoABB<Integer, String> nodo3 = new NodoABB<>(10, "C");

        assertTrue(nodo1.compareTo(nodo2) < 0);
        assertTrue(nodo2.compareTo(nodo1) > 0);
        assertEquals(0, nodo1.compareTo(nodo3));
    }
}