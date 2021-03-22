package ar.edu.uade.programacion_ii;

import ar.edu.uade.programacion_ii.implementacion.ABB;
import ar.edu.uade.programacion_ii.implementacion.Recorrido;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        System.out.println("Arboles");
        ABB arbol = new ABB();
        arbol.inicializarArbol();
        arbol.agregarElemento(50);
        arbol.agregarElemento(17);
        arbol.agregarElemento(72);
        arbol.agregarElemento(76);
        arbol.agregarElemento(54);
        arbol.agregarElemento(67);
        arbol.agregarElemento(12);
        arbol.agregarElemento(23);
        arbol.agregarElemento(9);
        arbol.agregarElemento(19);
        arbol.agregarElemento(14);
        arbol.eliminarElemento(72);
        System.out.println("\nVisitar arbol pre-order");
        Recorrido.preOrder(arbol);
        System.out.println("\nVisitar arbol in-order");
        Recorrido.inOrder(arbol);
        System.out.println("\nVisitar arbol post-order");
        Recorrido.postOrder(arbol);
    }
}
