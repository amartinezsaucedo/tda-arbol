package ar.edu.uade.programacion_ii.especificacion;

public interface ABBTDA {
    int valorRaiz();

    ABBTDA hijoIzquierdo();

    ABBTDA hijoDerecho();

    boolean arbolVacio();

    void inicializarArbol();

    void agregarElemento(int nuevoValor);

    void eliminarElemento(int valorAEliminar);
}