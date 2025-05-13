package abb;

import lista.ILista;
import lista.Lista;

import java.util.Comparator;

public class ABB<T extends Comparable<T>> {

    private NodoABB<T> raiz;

    private final Comparator<T> comparador;

    public ABB() {
        this.comparador = null;
    }

    public ABB(Comparator<T> comparador) {
        this.comparador = comparador;
    }

    private int comparar(T dato1, T dato2) {
        if (this.comparador == null) {
            return dato1.compareTo(dato2);
        }
        return this.comparador.compare(dato1, dato2);
    }

    public void insertar(T dato) {
        if (raiz == null) {
            raiz = new NodoABB<>(dato);
        } else {
            insertar(raiz, dato);
        }
    }

    private void insertar(NodoABB<T> nodo, T dato) {
        if (comparar(dato,nodo.dato) < 0) {
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
            } else if (comparar(dato,nodo.dato) < 0) {
                return pertenece(nodo.izq, dato);
            } else {
                return pertenece(nodo.der, dato);
            }
        } else {
            return false;
        }
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(NodoABB<T> nodo) {
        if (nodo == null) {
            return -1;
        }
        if (nodo.der == null && nodo.izq == null) {
            return 0;
        }
        return 1 + Math.max(altura(nodo.izq), altura(nodo.der));
    }

    //EJERCICIO 6 PARTE A

    public int contarElemMayoresAK(T k) {
        return contarElemMayoresAK(raiz, k);
    }

    private int contarElemMayoresAK(NodoABB<T> nodo, T k) {
        if (nodo != null) {
            if (comparar(k,nodo.dato) >= 0) {
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
            if (comparar(k,nodo.dato) >= 0) {
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
            if (comparar(k, nodo.dato) >= 0) {
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
            } else if (comparar(nodo.dato, k) < 0) {
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
            if (nivel.equals(contador)) {
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

    public void ej6parteF() {
        int altura = altura();
        for (int nivel = 0; nivel <= altura; nivel++) {
            ej6parteF(raiz, nivel);
        }
    }

    private void ej6parteF(NodoABB<T> nodo, int nivel) {
        if (nodo == null) {
            return;
        }
        if (nivel == 0) {
            System.out.print(nodo.dato + " ");
        } else {
            ej6parteF(nodo.izq, nivel - 1);
            ej6parteF(nodo.der, nivel - 1);
        }
    }

    //EJERCICIO 6 PARTE G
    /*
    Desarrolle un algoritmo que retorne una lista de tuplas con
    todos los elementos del ABB y el número del nivel en el que se
    encuentra cada uno.
    */

    public ILista<String> ej6parteG() {
        ILista<String> lista = new Lista<>();
        listarConNivel(raiz, 0, lista);
        return lista;
    }

    private void listarConNivel(NodoABB<T> nodo, int nivel, ILista<String> lista) {
        if (nodo != null) {
            lista.insertar(nodo.dato + " en nivel " + nivel);
            listarConNivel(nodo.izq, nivel + 1, lista);
            listarConNivel(nodo.der, nivel + 1, lista);
        }
    }

    //EJERCICIO 6 PARTE H
    /*
    Desarrolle un algoritmo que, recibiendo un valor
    entero k, imprima la cantidad de elementos del nivel k.
    */

    public void ej6parteH(T nivel) {
        System.out.print(ej6parteH(raiz, nivel, 0));
    }

    private int ej6parteH(NodoABB<T> nodo, T nivel, int nivelActual) {
        if (nodo != null) {
            if (nivel.equals(nivelActual)) {
                return 1;
            } else {
                return ej6parteH(nodo.izq, nivel, nivelActual + 1) + ej6parteH(nodo.der, nivel, nivelActual + 1);
            }
        }
        {
            return 0;
        }
    }

    //EJERCICIO 6 PARTE I
    /*
    Desarrolle un algoritmo que, recibiendo un valor de tipo String, imprima el
    ABB en orden por niveles, separando los niveles con el valor pasado por parámetro.
    */

    public void ej6parteI(String valor) {
        int altura = altura();
        for (int nivel = 0; nivel <= altura; nivel++) {
            ej6parteI(raiz, nivel);
            System.out.println();
            if (nivel < altura) {
                System.out.println(valor);
            }
        }
    }

    private void ej6parteI(NodoABB<T> nodo, int nivel) {
        if (nodo == null) {
            return;
        }
        if (nivel == 0) {
            System.out.print(nodo.dato + " ");
        } else {
            ej6parteI(nodo.izq, nivel - 1);
            ej6parteI(nodo.der, nivel - 1);
        }
    }

    //PRACTICA PARCIAL
//    public void impElemsHastaNivelEnRango(int n, int rInicial, int
//            rFinal){
//        ej2parteB(n, rInicial, rFinal, raiz);
//    }
//
//    private void ej2parteB(int n, int rInicial, int rFinal, NodoABB<Integer> nodo){
//        if(nodo != null){
//            if(n >= 0){
//                if(nodo.dato >= rInicial && nodo.dato <= rFinal)
//                    System.out.print(nodo.dato);
//                ej2parteB(n-1,rInicial,rFinal,nodo.izq);
//                ej2parteB(n-1,rInicial,rFinal,nodo.der);
//            }
//        }
//    }


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



