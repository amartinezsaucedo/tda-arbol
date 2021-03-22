package ar.edu.uade.programacion_ii.implementacion;

import ar.edu.uade.programacion_ii.especificacion.ABBTDA;

public class Recorrido {
    public static void preOrder(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            System.out.print(arbol.valorRaiz() + " ");
            preOrder(arbol.hijoIzquierdo());
            preOrder(arbol.hijoDerecho());
        }
    }

    public static void inOrder(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            inOrder(arbol.hijoIzquierdo());
            System.out.print(arbol.valorRaiz() + " ");
            inOrder(arbol.hijoDerecho());
        }
    }

    public static void postOrder(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            postOrder(arbol.hijoIzquierdo());
            postOrder(arbol.hijoDerecho());
            System.out.print(arbol.valorRaiz() + " ");
        }
    }
}