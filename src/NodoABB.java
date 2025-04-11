public class NodoABB<k extends Comparable<k>, v> implements Comparable<NodoABB<k, v>> {
    k clave;
    v valor;
    NodoABB<k, v> menor;
    NodoABB<k, v> mayor;
    NodoABB(k clave, v valor) {
        this.clave = clave;
        this.valor = valor;
        this.menor = null;
        this.mayor = null;
    }

    public k getClave() {
        return clave;
    }

    public v getValue() {
        return valor;
    }

    public void setMenor(NodoABB<k, v> n) {
        this.menor = n;
    }

    public void setMayor(NodoABB<k, v> n) {
        this.mayor = n;
    }

    public NodoABB<k, v> getMenor() {
        return menor;
    }

    public NodoABB<k, v> getMayor() {
        return mayor;
    }
    public int compareTo(k clave) {
        return this.clave.compareTo(clave);
    }

    @Override
    public int compareTo(NodoABB<k, v> o) {
        return this.clave.compareTo(o.clave);
    }
}
