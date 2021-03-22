package ar.edu.uade.programacion_ii.implementacion;

import ar.edu.uade.programacion_ii.especificacion.ABBTDA;

public class ABB implements ABBTDA {
  NodoABB raiz;

  public int valorRaiz() {
    return raiz.valor;
  }

  public boolean arbolVacio() {
    return raiz == null;
  }

  public void inicializarArbol() {
    raiz = null;
  }

  public ABBTDA hijoDerecho() {
    return raiz.hijoDerecho;
  }

  public ABBTDA hijoIzquierdo() {
    return raiz.hijoIzquierdo;
  }

  public void agregarElemento(int nuevoValor) {
    /*
     * Primero validamos que el árbol esté vacío. De ser así, lo inicializamos y
     * establecemos el valor en la raíz
     */
    if (this.arbolVacio()) {
      raiz = new NodoABB();
      raiz.valor = nuevoValor;
      raiz.hijoIzquierdo = new ABB();
      raiz.hijoIzquierdo.inicializarArbol();
      raiz.hijoDerecho = new ABB();
      raiz.hijoDerecho.inicializarArbol();
    }
    /*
     * Como los valores de un ABB tienen que estar ordenados, evaluamos
     * recursivamente la ubicación en donde el valor debe ser agregado
     */
    else if (raiz.valor > nuevoValor) {
      raiz.hijoIzquierdo.agregarElemento(nuevoValor);
    } else if (raiz.valor < nuevoValor) {
      raiz.hijoDerecho.agregarElemento(nuevoValor);
    }
    /* Si el elemento ya está presente en el árbol, lo ignoramos */
  }

  public void eliminarElemento(int valorAEliminar) {
    if (!this.arbolVacio()) {
      /*
       * Si el nodo que contiene el valor a eliminar es una hoja (no tiene hijos),
       * simplemente lo eliminamos
       */
      if (raiz.valor == valorAEliminar && raiz.hijoIzquierdo.arbolVacio() && raiz.hijoDerecho.arbolVacio()) {
        raiz = null;
      }
      /*
       * Si el nodo a eliminar tiene un hijo izquierdo no vacío, buscamos el nodo de
       * mayor valor en el subárbol izquierdo y lo reemplazamos en el lugar del nodo a
       * eliminar. El nodo a eliminar ahora es movido a una hoja del subárbol
       * izquierdo, por lo que recursivamente buscamos y eliminamos dicha hoja
       */
      else if (raiz.valor == valorAEliminar && !raiz.hijoIzquierdo.arbolVacio()) {
        raiz.valor = this.mayor(raiz.hijoIzquierdo);
        raiz.hijoIzquierdo.eliminarElemento(raiz.valor);
      }
      /*
       * Si el nodo a eliminar tiene un hijo izquierdo vacío, buscamos el nodo de
       * menor valor en el subárbol derecho y lo reemplazamos en el lugar del nodo a
       * eliminar. El nodo a eliminar ahora es movido a una hoja del subárbol derecho,
       * por lo que recursivamente buscamos y eliminamos dicha hoja
       */
      else if (raiz.valor == valorAEliminar && raiz.hijoIzquierdo.arbolVacio()) {
        raiz.valor = this.menor(raiz.hijoDerecho);
        raiz.hijoDerecho.eliminarElemento(raiz.valor);
      }
      /*
       * El elemento del nodo actual no es el que queremos eliminar: buscamos en el
       * subárbol derecho o izquierdo dependiendo de si el valor del nodo a
       * eliminar es mayor o menor al del nodo actual respectivamente
       */
      else if (raiz.valor < valorAEliminar) {
        raiz.hijoDerecho.eliminarElemento(valorAEliminar);
      } else {
        raiz.hijoIzquierdo.eliminarElemento(valorAEliminar);
      }
    }
  }

  /*
   * Buscamos recursivamente el mayor valor de un árbol, siempre explorando los
   * hijos a la derecha
   */
  private int mayor(ABBTDA arbol) {
    if (arbol.hijoDerecho().arbolVacio()) {
      return arbol.valorRaiz();
    } else {
      return mayor(arbol.hijoDerecho());
    }
  }

  /*
   * Buscamos recursivamente el menor valor de un árbol, siempre explorando los
   * hijos a la izquierda
   */
  private int menor(ABBTDA arbol) {
    if (arbol.hijoIzquierdo().arbolVacio()) {
      return arbol.valorRaiz();
    } else {
      return menor(arbol.hijoIzquierdo());
    }
  }
}