import abb.ABB;
import lista.ILista;

public class mainEj6 {
    public static void main(String[] args) {

        int[] enteros = {10, 6, 18, 4, 9, 15, 21, 16};

        //          10
        //        /    \
        //       6      18
        //      / \     / \
        //     4   9  15   21
        //              \
        //               16
        ABB<Integer> abbEnteros = new ABB<>();

        for (int i : enteros) {
            abbEnteros.insertar(i);
        }

        //System.out.println("Cantidad de elementos mayores a 10: " + abbEnteros.contarElemMayoresAK(10));
        //System.out.println("Cantidad de elementos mayores a 9: " + abbEnteros.contarElemMayoresAK(9));
        // System.out.println("Cantidad de elementos mayores a 8: " + abbEnteros.contarElemMayoresAK(8));
        //System.out.println("Lista de elementos mayores a 8: " + abbEnteros.listarElemMayoresAK(8));

//        ILista<Integer> elemsOrdenados = abbEnteros.listarElementosAsc();
//        System.out.println("Elementos de la lista elemsOrdenados: ");
//        elemsOrdenados.imprimirDatos();

//        ILista<Integer> elemsOrdenadosMayoresAK = abbEnteros.obtenerListaMayoresAK(10);
//        System.out.println("Elementos de la lista elemsOrdenados: ");
//        elemsOrdenadosMayoresAK.imprimirDatos();

        //System.out.println(abbEnteros.obtenerNivelDe(9));

        //abbEnteros.ej6parteE(3);
        //abbEnteros.ej6parteF();
//        ILista<String> tuplas = abbEnteros.ej6parteG();
//        tuplas.imprimirDatos();
        //abbEnteros.ej6parteH(3);
        //abbEnteros.ej6parteI("F");
        System.out.println(abbEnteros.altura());
    }
}
