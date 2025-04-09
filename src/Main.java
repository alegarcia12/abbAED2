import abb.ABB;

public class Main {
    public static void main(String[] args) {
        int[] nrosAInsertar = {4, 2, 3, 5, 1, 2, 5, 12};

        ABB abb = new ABB();
        for (int i : nrosAInsertar) {
            abb.insertar(i);
        }

//        System.out.println("El elemento 3 pertenece? " + abb.pertenece(3));//true
//        System.out.println("El elemento 11 pertenece? " + abb.pertenece(11));//false

        abb.listarAscendente();
        System.out.println("");
        abb.listarDescendente();
        System.out.println("");
        System.out.println(abb.listarAscendenteV2());
    }
}
