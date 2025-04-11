import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioDeBusqueda<k extends Comparable<k>,v> {
    protected NodoABB<k, v> raiz;


    boolean addNodoRaiz(k clave, v valor) {
        NodoABB<k, v> n = new NodoABB(clave, valor);
        this.raiz = n;
        return true;
    }

    boolean addOtrosNodos(k clave, v valor) {
        NodoABB candidato = buscarNodoAInsertar(clave, this.raiz);
        if (candidato == null){
            return false;
        }
        NodoABB<k, v> n = new NodoABB(clave, valor);
        if (candidato.compareTo(clave) > 0)
            candidato.setMenor(n);
        else
            candidato.setMayor(n);
        return true;
    }

    public void add(k clave, v valor) {
        if (this.raiz == null)
            addNodoRaiz(clave, valor);
        else
            addOtrosNodos(clave, valor);
    }

    NodoABB<k, v> buscarNodoAInsertar(k cbusqueda, NodoABB<k, v> nodo) {
        if (nodo.getValue() == cbusqueda) {
            return null;
        }
        int comparacion = nodo.compareTo(cbusqueda);
        if (comparacion==0){
            return null;
        }
        if (comparacion >0) {
            if (nodo.getMenor() != null) {
                return buscarNodoAInsertar(cbusqueda, nodo.getMenor());
            } else {
                return nodo;
            }
        }
        else {
            if (nodo.getMayor() != null)
                return buscarNodoAInsertar(cbusqueda, nodo.getMayor());
            else {
                return nodo;
            }
        }
    }
    public int getAltura(){
        return getAlturaRecursiva(raiz);
    }
    public int getAlturaRecursiva(NodoABB<k,v> nodo){
        if (nodo == null){
            return 0;
        }
        int alturaIzq = getAlturaRecursiva(nodo.getMenor());
        int alturaDer = getAlturaRecursiva(nodo.getMayor());
        return Math.max(alturaIzq, alturaDer) + 1;
    }
    public List<k> getListaOrdenCentral(){
        List<k> lista = new ArrayList<>();
        getListaOrdenCentralRecursiva(raiz,lista);
        return lista;
    }
    public void getListaOrdenCentralRecursiva(NodoABB<k,v> nodo, List<k> lista){
        if (nodo == null) {
            return;
        }
        getListaOrdenCentralRecursiva(nodo.menor,lista);
        lista.add(nodo.getClave());
        getListaOrdenCentralRecursiva(nodo.mayor,lista);
    }
    public List<k> getListaPreOrden(){
        List<k> lista = new ArrayList<>();
        getListaPreOrdenRecursiva(raiz, lista);
        return lista;
    }
    public void getListaPreOrdenRecursiva(NodoABB<k,v> nodo, List<k> lista){
        if (nodo == null) {
            return;
        }
        lista.add(nodo.getClave());
        getListaPreOrdenRecursiva(nodo.menor, lista);
        getListaPreOrdenRecursiva(nodo.mayor, lista);
    }
    public List<k> getListaPostOrden() {
        List<k> lista = new ArrayList<>();
        getListaPostOrdenRecursiva(raiz, lista);
        return lista;
    }
    public void getListaPostOrdenRecursiva(NodoABB<k,v> nodo, List<k> lista) {
        if (nodo == null) {
            return;
        }
        getListaPostOrdenRecursiva(nodo.menor, lista);
        getListaPostOrdenRecursiva(nodo.mayor, lista);
        lista.add(nodo.getClave());
    }
    public List<k> getListaDatosNivel(int nivel) {
        List<k> lista = new ArrayList<k>();
        getListaDatosNivelRecursiva(raiz, nivel, lista);
        return lista;
    }

    public void getListaDatosNivelRecursiva(NodoABB<k,v> nodo, int nivel, List<k> lista) {
        if (nivel == 0) {
            lista.add(nodo.getClave());
        } else {
            getListaDatosNivelRecursiva(nodo.menor, nivel - 1, lista);
            getListaDatosNivelRecursiva(nodo.mayor, nivel - 1, lista);
        }
    }
    public int getGrado(){
        return getGradoRecursivo(raiz);
    }
    public int getGradoRecursivo(NodoABB<k,v> nodo){
        if (nodo == null){
            return 0;
        }
        int grado = 0 ;
        if (nodo.menor != null){
            grado++;
        }
        if (nodo.mayor != null){
            grado++;
        }
        return grado + getGradoRecursivo(nodo.menor) + getGradoRecursivo(nodo.mayor);
    }
    public boolean isArbolHomogeneo() {
        return isArbolHomogeneoRecursivo(raiz);
    }

    public boolean isArbolHomogeneoRecursivo(NodoABB<k,v> nodo) {
        if (nodo == null) {
            return true;
        }
        if ((nodo.menor != null && nodo.mayor == null) || (nodo.menor == null && nodo.mayor != null)) {
            return false;
        }
        return isArbolHomogeneoRecursivo(nodo.menor) && isArbolHomogeneoRecursivo(nodo.mayor);
    }
    public boolean isArbolCompleto() {
        return isArbolCompletoRecursivo(raiz, 0, getAltura() - 1);
    }

    public boolean isArbolCompletoRecursivo(NodoABB<k,v> nodo, int nivelActual, int altura) {
        if (nodo == null) {
            return true;
        }
        if (nodo.menor == null && nodo.mayor == null) {
            return nivelActual == altura; // El último nivel debe estar lleno
        }
        if (nodo.menor != null && nodo.mayor == null) {
            return nivelActual == altura; // Si solo tiene hijo izquierdo, debe ser el último nivel
        }
        return isArbolCompletoRecursivo(nodo.menor, nivelActual + 1, altura) && isArbolCompletoRecursivo(nodo.mayor, nivelActual + 1, altura);
    }
    public boolean isArbolCasiCompleto() {
        return isArbolCasiCompletoRecursivo(raiz, 0, getAltura() - 1);
    }

    public boolean isArbolCasiCompletoRecursivo(NodoABB<k,v> nodo, int nivelActual, int altura) {
        if (nodo == null) {
            return true;
        }
        if (nodo.menor == null && nodo.mayor == null) {
            return nivelActual == altura;
        }
        if (nodo.menor != null && nodo.mayor == null) {
            return nivelActual == altura;
        }
        return isArbolCasiCompletoRecursivo(nodo.menor, nivelActual + 1, altura) && isArbolCasiCompletoRecursivo(nodo.mayor, nivelActual + 1, altura);
    }
    public List<k> getCamino(k clave) {
        List<k> camino = new ArrayList<>();
        getCaminoRecursivo(raiz, clave, camino);
        return camino;
    }

    public boolean getCaminoRecursivo(NodoABB<k,v> nodo, k clave, List<k> camino) {
        if (nodo == null) {
            return false;
        }
        camino.add(nodo.getClave());
        if (nodo.getClave().compareTo(clave) == 0) {
            return true;
        } else if (clave.compareTo(nodo.clave) < 0) {
            return getCaminoRecursivo(nodo.menor, clave, camino);
        } else {
            return getCaminoRecursivo(nodo.mayor, clave, camino);
        }
    }
    public ArbolBinarioDeBusqueda<k,v> getSubArbolIzquierda() {
        ArbolBinarioDeBusqueda<k,v> subArbol = new ArbolBinarioDeBusqueda<>();
        subArbol.raiz = raiz.menor;
        return subArbol;
    }

    public ArbolBinarioDeBusqueda<k,v> getSubArbolDerecha() {
        ArbolBinarioDeBusqueda<k,v> subArbol = new ArbolBinarioDeBusqueda<>();
        subArbol.raiz = raiz.mayor;
        return subArbol;
    }
    public NodoABB<k,v> getRaiz(){
        return raiz;
    }
    protected void setRaiz(NodoABB<k, v> raiz) {
        this.raiz = raiz;
    }
    public void insertarBalanceado(List<k> claves, List<v> valores, int inicio, int fin) {
        if (inicio > fin) {
            return;
        }
        int medio = (inicio + fin) / 2;
        add(claves.get(medio), valores.get(medio));
        insertarBalanceado(claves, valores, inicio, medio - 1);
        insertarBalanceado(claves, valores, medio + 1, fin);
    }
}

