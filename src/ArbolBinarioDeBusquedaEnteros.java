import java.util.List;

public class ArbolBinarioDeBusquedaEnteros<k,v> extends ArbolBinarioDeBusqueda<Integer,String> {
    public void insertarBalanceado(List<Integer> claves, List<String> valores, int inicio, int fin) {
        if (inicio > fin) {
            return;

        }
        int medio = (inicio + fin) / 2;
        add(claves.get(medio), valores.get(medio));
        insertarBalanceado(claves, valores, inicio, medio - 1);
        insertarBalanceado(claves, valores, medio + 1, fin);
    }
    public int getSuma(){
        return getSumaRecursiva(getRaiz());
    }
    public int getSumaRecursiva(NodoABB<Integer,String> nodo){
        if (nodo == null){
            return 0;
        }
        return nodo.getClave() + getSumaRecursiva(nodo.getMenor()) + getSumaRecursiva(nodo.getMayor());
    }
    public ArbolBinarioDeBusquedaEnteros getSubArbolIzquierda() {
        ArbolBinarioDeBusquedaEnteros subArbol = new ArbolBinarioDeBusquedaEnteros();
        subArbol.setRaiz(this.getRaiz().getMenor());
        return subArbol;
    }

    public ArbolBinarioDeBusquedaEnteros getSubArbolDerecha() {
        ArbolBinarioDeBusquedaEnteros subArbol = new ArbolBinarioDeBusquedaEnteros();
        subArbol.setRaiz(this.getRaiz().getMayor()); // Asignar correctamente la raíz del subárbol derecho
        return subArbol;
    }
    public void setRaiz(NodoABB<Integer, String> raiz) {
        super.setRaiz(raiz);
    }
}
