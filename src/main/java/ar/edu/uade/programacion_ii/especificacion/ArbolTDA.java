package ar.edu.uade.programacion_ii.especificacion;

public interface ArbolTDA {
    int valorRaiz();

    ArbolTDA hijoMayor();

    ArbolTDA hermanoSiguiente();

    boolean arbolVacio();

    void inicializarArbol();

    void eliminarHMConDesc(int valor);

    void eliminarHSConDesc(int valor);

    void crearArbol(int valorRaiz);

    void agregarHijoMayor(int valorPadre, int valorHijo);
}