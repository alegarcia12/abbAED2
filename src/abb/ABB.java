package abb;

public class ABB {

    private NodoABB raiz;

    public void insertar(int dato) {
        if (raiz == null) {
            raiz = new NodoABB(dato);
        } else {
            insertar(raiz, dato);
        }
    }

    private void insertar(NodoABB nodo, int dato) {
        if (dato < nodo.dato) {
            if (nodo.izq == null) {
                nodo.izq = new NodoABB(dato);
            } else {
                insertar(nodo.izq, dato);
            }
        } else {
            if (nodo.der == null) {
                nodo.der = new NodoABB(dato);
            } else {
                insertar(nodo.der, dato);
            }
        }
    }

    public boolean pertenece(int dato) {
        return pertenece(raiz, dato);
    }

    private boolean pertenece(NodoABB nodo, int dato) {
        if (nodo != null) {
            if (dato == nodo.dato) {
                return true;
            } else if (dato < nodo.dato) {
                return pertenece(nodo.izq, dato);
            } else {
                return pertenece(nodo.der, dato);
            }
        } else {
            return false;
        }
    }

    private class NodoABB {
        private int dato;
        private NodoABB izq;
        private NodoABB der;

        public NodoABB(int dato) {
            this.dato = dato;
        }


        @Override
        public String toString() {
            return "NodoABB{" +
                    "dato=" + dato +
                    '}';
        }
    }
}
