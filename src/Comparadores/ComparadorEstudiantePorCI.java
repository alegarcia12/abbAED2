package Comparadores;

import domain.Estudiante;

import java.util.Comparator;

public class ComparadorEstudiantePorCI implements Comparator<Estudiante> {

    @Override
    public int compare(Estudiante o1, Estudiante o2) {
        return Integer.compare(o1.getCi(), o2.getCi());
    }
}
