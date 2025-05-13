package abb;

public class ABBenteros {

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

    public int altura() {
        return altura(raiz);
    }

    private int altura(NodoABB nodo) {
        if (nodo != null) {
            return -1;
        }
        if (nodo.der == null && nodo.izq == null) {
            return 0;
        }
        return 1 + Math.max(altura(nodo.izq), altura(nodo.der));
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

    public void listarAscendente() {
        listarAscendente(raiz);
    }

    private void listarAscendente(NodoABB nodo) {
        if (nodo != null) {
            listarAscendente(nodo.izq);
            System.out.print(nodo.dato + " ");
            listarAscendente(nodo.der);
        }
    }

    public String listarAscendenteV2() {
        return listarAscendenteV2(raiz);
    }

    private String listarAscendenteV2(NodoABB nodo) {
        if (nodo != null) {
            return listarAscendenteV2(nodo.izq) + nodo.dato + "" + listarAscendenteV2(nodo.der);
        } else {
            return " ";
        }
    }

    public void listarDescendente() {
        listarDescendente(raiz);
    }

    private void listarDescendente(NodoABB nodo) {
        if (nodo != null) {
            listarDescendente(nodo.der);
            System.out.print(nodo.dato + " ");
            listarDescendente(nodo.izq);
        }
    }

    //EJERCICIO 5 PARTE E
    public int borrarMinimo() {
        if (raiz.izq == null) {
            int borrado = raiz.dato;
            raiz = raiz.der;
            return borrado;
        } else {
            return borrarMinimo(raiz);
        }
    }

    private int borrarMinimo(NodoABB nodo) {
        if (nodo.izq.izq == null) {
            int borrado = nodo.izq.dato;
            nodo.izq = nodo.izq.der;
            return borrado;
        } else {
            return borrarMinimo(nodo.izq);
        }
    }

    /// PRACTICA PARCIAL

    public void impElemsHastaNivelEnRango(int n, int rInicial, int
            rFinal) {
        ej2parteB(n, rInicial, rFinal, raiz);
    }

    private void ej2parteB(int n, int rInicial, int rFinal, NodoABB nodo) {
        if (nodo != null) {
            if (n >= 0) {
                if (nodo.dato >= rInicial && nodo.dato <= rFinal) {
                    System.out.println(nodo.dato);
                }
                ej2parteB(n - 1, rInicial, rFinal, nodo.izq);
                ej2parteB(n - 1, rInicial, rFinal, nodo.der);
            }
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
