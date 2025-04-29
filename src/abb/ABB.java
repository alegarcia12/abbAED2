package abb;

import lista.ILista;
import lista.Lista;

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

    public int contarElemMayoresAK(T k) {
        return contarElemMayoresAK(raiz, k);
    }

    private int contarElemMayoresAK(NodoABB<T> nodo, T k) {
        if (nodo != null) {
            if (k.compareTo(nodo.dato) >= 0) {
                return contarElemMayoresAK(nodo.der, k);
            } else {
                return contarElemMayoresAK(nodo.izq, k) + 1 + contarElemMayoresAK(nodo.der, k);
            }
        } else {
            return 0;
        }
    }

    //EJERCICIO 6 PARTE A CON String
    public String listarElemMayoresAK(T k) {
        return listarElemMayoresAK(raiz, k);
    }

    private String listarElemMayoresAK(NodoABB<T> nodo, T k) {
        if (nodo != null) {
            if (k.compareTo(nodo.dato) >= 0) {
                return listarElemMayoresAK(nodo.der, k);
            } else {
                return listarElemMayoresAK(nodo.izq, k) + nodo.dato + " " + listarElemMayoresAK(nodo.der, k);
            }
        } else {
            return "";
        }
    }

    //EJERCICIO 6 PARTE B

    public ILista<T> listarElementosAsc() {
        ILista<T> elementosOrdenados = new Lista<>();
        listarAscendente(raiz, elementosOrdenados);
        return elementosOrdenados;
    }

    private void listarAscendente(NodoABB<T> nodo, ILista<T> elems) {
        if (nodo != null) {
            listarAscendente(nodo.der, elems);
            elems.insertar(nodo.dato);
            listarAscendente(nodo.izq, elems);
        }
    }

    //EJERCICIO 6 PARTE C
    /*
    Desarrolle un algoritmo que, recibiendo un valor entero k, retorne una
    lista con los elementos que son mayores a k.
    */
    public ILista<T> obtenerListaMayoresAK(T k) {
        ILista<T> elementosMayoresAK = new Lista<>();
        listarMayoresaKA(raiz, elementosMayoresAK, k);
        return elementosMayoresAK;
    }

    private void listarMayoresaKA(NodoABB<T> nodo, ILista<T> elementosMayoresAK, T k) {
        if (nodo != null) {
            if (k.compareTo(nodo.dato) >= 0) {
                listarMayoresaKA(nodo.der, elementosMayoresAK, k);
            } else {
                elementosMayoresAK.insertar(nodo.dato);
                listarMayoresaKA(nodo.izq, elementosMayoresAK, k);
                listarMayoresaKA(nodo.der, elementosMayoresAK, k);
            }
        }
    }

    //EJERCICIO 6 PARTE D
    /*
     * Desarrolle un algoritmo que, recibiendo un valor entero, retorne el
     * nivel en que se encuentra dicho valor o -1 si no se encuentra.
     * */

    public int obtenerNivelDe(T k) {
        return obtenerNivelDe(raiz, 0, k);
    }

    private int obtenerNivelDe(NodoABB<T> nodo, int nivel, T k) {
        if (nodo != null) {
            if (k.equals(nodo.dato)) {
                return nivel;
            } else if (k.compareTo(nodo.dato) < 0) {
                return obtenerNivelDe(nodo.izq, nivel + 1, k);
            } else {
                return obtenerNivelDe(nodo.der, nivel + 1, k);
            }
        } else {
            return -1;
        }
    }

    //EJERCICIO 6 PARTE E
    /*
    Desarrolle un algoritmo que, recibiendo un valor
    entero k, imprima los elementos del nivel k.
     * */

    public void ej6parteE(T k) {
        ej6parteE(raiz, k, 0);
    }

    public void ej6parteE(NodoABB<T> nodo, T nivel, int contador) {
        if (nodo != null) {
            if (contador == (Integer) nivel) {
                System.out.print(nodo.dato + " ");
            } else {
                ej6parteE(nodo.der, nivel, contador + 1);
                ej6parteE(nodo.izq, nivel, contador + 1);
            }
        }
    }

    //EJERCICIO 6 PARTE F
    /*
    Desarrolle un algoritmo que imprima
    el ABB en orden por niveles.
    */

    public void ej6parteF(){
        ej6parteF(raiz);
    }

    private void ej6parteF(NodoABB<T> nodo) {
        if (nodo != null){
            System.out.println(nodo.dato);
        }
    }


    //CLASE DE NODO
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



