# EL2 - Parte de Árboles
Los árboles son estructuras de datos organizadas de manera jerárquica.
Se componen de una serie de nodos, conectados en una dirección "descendente", y estos nodos en su interior contienen los datos a almacenar. 

Existen tres tipos de nodos: 
* los nodos comunes, que son los que componen el interior del árbol, 
* los nodos hoja, que son los nodos que no tienen ningún nodo inferior conectados a ellos, 
* y el nodo raíz, que es el único nodo al que no conecta ningún otro.

Un árbol, dada su naturaleza recursiva, se compone de otros subárboles, los cuales a su vez se componen de otros subárboles, hasta que no existen más nodos.

Existen distintos tipos de árboles.
En esta parte de la práctica trabajaremos con los Árboles Binarios.

## Árboles Binarios
Un árbol binario, en su modalidad de búsqueda, que es la que vamos a implementar, tiene nodos de **grado 2**.

Pongamos sobre la mesa algunas definiciones para poder después referirnos con propiedad a distintas características de los árboles:
* El *grado* de un nodo, que generaliza al de un árbol en su grado máximo, indica el número máximo posible de nodos ***hijos*** a los que da acceso.

* La *altura* de un árbol indica cuántos niveles, como máximo, existe desde la raíz del árbol a su nodo hoja más alejado (también se calcula como *longitud del camino* máximo).

* Se llama *nivel* al conjunto de nodos que están a la misma distancia (altura) de la raíz del árbol.

* Se le llama *camino* a la secuencia de nodos que hay que recorrer hasta llegar a un nodo del árbol.

* Se le llama *longitud de un camino* al número de saltos de nodos que hay que recorrer hasta llegar a un nodo del árbol (numero de nodos recorridos - 1).

* Se dice que un árbol es *vacío* cuando no contiene ningún nodo.

* Se le llama *árbol homogéneo* a aquel árbol cuyos subárboles tienen todos ***n*** hijos, siendo n el grado del árbol.

* Se le llama *árbol completo* a aquel árbol cuyas hojas están todas a la misma pronfundidad.

* Se le llama *arbol casi completo* a aquel árbol cuyas hojas están en dos niveles, Y las hojas del nivel más alejado de la raiz son contiguas desde la izquierda del árbol.


Estas definiciones serán relevantes para referirnos a los árboles de distintos tipos.

## Objetivo
El objetivo del trabajo a realizar es construir el TAD ArbolBinarioDeBusqueda.
Este árbol binario trabajará con un tipo de datos PARAMETRIZABLE y podrá recibir (añadir) nuevos elementos.
Mantendrá los datos ordenados (usar interfaz "Comparable" de Java).

Responderá a las preguntas:
* getGrado():int
* getAltura():int
* getListaDatosNivel(nivel):Lista<TipoDato>
* isArbolHomogeneo():Boolean
* isArbolCompleto():Boolean
* isArbolCasiCompleto():Boolean
* getCamino(<TipoDato>):Lista<TipoDato>

Permitirá las operaciones:
* add(<TipoDato>):void
* getSubArbolIzquierda():ArbolBinarioDeBusqueda<TipoDato>
* getSubArbolDerecha():ArbolBinarioDeBusqueda<TipoDato>

Generará 3 tipos de listas de datos, representando los datos que contiene:
* getListaPreOrden():Lista<TipoDato>
* getListaPostOrden():Lista<TipoDato>
* getListaOrdenCentral:Lista<TipoDato>

Estas listas contendrán los datos de los elementos que tenga el árbol organizados según el tipo de recorrido que se indique (preorden, postorden u orden central).

Como ejemplo práctico:
1. Crea una subclase ArbolBinarioDeBusquedaEnteros.
2. Añade el método que calcule la suma de los números insertados en ese árbol (getSuma():int).
3. Crea un programa de prueba:
   1. Añadir los números de 0 a 128 en orden.
   2. Calcular la suma (getSuma())
   3. Verifica que la suma es la misma accediendo en los 3 tipos de recorridos posibles.
   4. Verifica que la suma es la misma cuando se suman los elementos de los subárboles izquierdo y derecho. ¿Por qué?
  La suma será la misma porque el árbol almacena los nodos, por lo que la suma total será la suma del subárbol izquierdo más la suma del subárbol derecho. 
   5. ¿Cuál es la altura del árbol? Como los elementos se insertan en orden, la altura es 128.
   6. ¿Cuál es el camino para llegar al valor 110? ¿Cuál es su longitud de camino? El camino es: 0,1,...,110. La longitud del camino es de 110. 
4. Crea un segundo programa de prueba.
   1. Añade los números de 0 a 128 PERO DE MANERA ALEATORIA y sin repetir.
   2. Calcula la suma (getSuma())
   3. Verifica que la suma es la misma accediendo en los 3 tipos de recorridos posibles.
   4. Verifica que la suma es la misma cuando se suman los elementos de los subárboles izquierdo y derecho. ¿Por qué? Ocurre lo mismo por la misma razón.
   5. ¿Cuál es la altura del árbol? ¿por qué? Dependerá del orden aleatorio. 
   6. ¿Cuál es el camino para llegar al valor 110? ¿Cuál es su longitud de camino? Dependerá del orden aleatorio otra vez. 

* Explique las diferencias (si las ha habido) de los resultados obtenidos entre los dos programas de prueba. Las diferencias son:
  1. En el programa 1 la altura será 128, y en el programa 2 dependerá del orden aleatorio.
  2. El camino también cambia dependiendo del orden aleatorio.
  3. La eficiencia y la forma de ambos programas será distinta.
* ¿Qué sucede con los resultados si ejecuta los programas de prueba varias veces?
En el programa 1, no cambia. En el programa 2 puede variar la altura y la longitud de los caminos.


