import abb.ABB;
import abb.ABBenteros;

public class Main {
    public static void main(String[] args) {
        int[] nrosAInsertar = {4, 2, 3, 5, 1, 2, 5, 12};

        ABBenteros ABBenteros = new ABBenteros();
        for (int i : nrosAInsertar) {
            ABBenteros.insertar(i);
        }

        System.out.println("El elemento 3 pertenece? " + ABBenteros.pertenece(3));//true
        System.out.println("El elemento 11 pertenece? " + ABBenteros.pertenece(11));//false

        ABBenteros.listarAscendente();
        System.out.println("");
        ABBenteros.listarDescendente();
        System.out.println("");
        System.out.println(ABBenteros.listarAscendenteV2());


        System.out.println("Listar Ascendete: " + ABBenteros.listarAscendenteV2());
        System.out.println("Minimo Borrado: " + ABBenteros.borrarMinimo());
        System.out.println("Listar Ascendete: " + ABBenteros.listarAscendenteV2());



        ABB<Integer> abbGenericoConEnteros = new ABB<>();














    }
}
