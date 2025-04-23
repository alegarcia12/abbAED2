package abb;

public class ABB<T extends Comparable<T>> {

    private NodoABB<T> raiz;

    public void insertar(T dato) {
        if (raiz == null) {
            raiz = new NodoABB<>(dato);
        } else {
            insertar(raiz, dato);
        }
    }

    private void insertar(NodoABB<T> nodo, T dato) {
        if (dato.compareTo(nodo.dato) < 0) {
            if (nodo.izq == null) {
                nodo.izq = new NodoABB<>(dato);
            } else {
                insertar(nodo.izq, dato);
            }
        } else {
            if (nodo.der == null) {
                nodo.der = new NodoABB<>(dato);
            } else {
                insertar(nodo.der, dato);
            }
        }
    }


    public boolean pertenece(T dato) {
        return pertenece(raiz, dato);
    }

    private boolean pertenece(NodoABB<T> nodo, T dato) {
        if (nodo != null) {
            if (dato.equals(nodo.dato)) {
                return true;
            } else if (dato.compareTo(nodo.dato) < 0) {
                return pertenece(nodo.izq, dato);
            } else {
                return pertenece(nodo.der, dato);
            }
        } else {
            return false;
        }
    }

    //EJERCICIO 6 PARTE A

    public int contarElemMayoresAK(T k){
        return contarElemMayoresAK(raiz, k);
    }

    private int contarElemMayoresAK(NodoABB<T> nodo, T k){
        if (nodo != null){
            if (k.compareTo(nodo.dato) >= 0){
                return contarElemMayoresAK(nodo.der,k);
            }else{
                return contarElemMayoresAK(nodo.izq,k) + 1 + contarElemMayoresAK(nodo.der,k);
            }
        }else{
            return 0;
        }
    }


    private class NodoABB<Q> {
        private Q dato;
        private NodoABB izq;
        private NodoABB der;

        public NodoABB(Q dato) {
            this.dato = dato;
        }


        @Override
        public String toString() {
            return "{" + dato +
                    '}';
        }
    }
}



