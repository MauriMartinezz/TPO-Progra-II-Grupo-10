# Distribución de Ejercicios - TPO Programación II

---

## @Lean
Ejercicios más fáciles, centrados en **uso de TDA**:

- **Ejercicio 6 (uso)**  
  Definir un método que reciba una `PilaTDA` y devuelva un `float` con el **porcentaje de elementos pares** de la pila.  
  → Recorre la pila, cuenta elementos y pares, calcula el porcentaje.

- **Ejercicio 8 (uso)**  
  Definir un método que reciba una `ColaTDA` y devuelva una **nueva cola sin elementos repetidos**.  
  → Mantener el primer representante y respetar el orden original.

- **Ejercicio 13 (uso)**  
  Definir un método que calcule la **cantidad de hojas con valor par** en un `ABB`.  
  → Recorrer el árbol y contar hojas que cumplan la condición.

- **Ejercicio 15 (uso)**  
  Definir un método que reciba un `GrafoTDA` y un vértice, devolviendo su **grado**.  
  → Grado = aristas que salen – aristas que llegan.

---

## @Mauri
Ejercicios de **uso de TDA**, nivel inicial-intermedio:

[x] **Ejercicio 7 (uso)**  
  Definir un método que reciba una `PilaTDA` y devuelva un `ConjuntoTDA` con los **elementos repetidos**.  
  → Detectar duplicados y agregarlos al conjunto.

- **Ejercicio 9 (uso)**  
  Definir un método que reciba una `PilaTDA` y una `ColaTDA`, devolviendo un `ConjuntoTDA` con los **elementos comunes**.  
  → Comparar y guardar intersección.

- **Ejercicio 12 (uso)**  
  Definir un método que calcule la **suma de los elementos impares** de un `ABB`.  
  → Recorrer árbol y acumular valores impares.

- **Ejercicio 11 (uso)**  
  Definir un método que reciba un `DiccionarioMultipleTDA` y devuelva una `ColaTDA` con todos los **valores sin repetición**.  
  → Recorrer claves, recopilar valores y eliminar duplicados.

---

## @Lucio
Ejercicios de **implementación de nuevos TDA** y problemas más avanzados:

- **Ejercicio 1 (implementación)**  
  Implementar `ConjuntoEspecialTDA`, basado en `ConjuntoTDA`.  
  → Algunos métodos devuelven un objeto `Respuesta` (booleano de éxito y entero de salida). Permite controlar la correctitud de las operaciones.

- **Ejercicio 3 (implementación)**  
  Implementar `MultiPilaTDA`, basada en `PilaTDA`.  
  → Permite apilar pilas enteras, desapilar si coinciden, y obtener un tope de varios elementos. Solo puede implementarse con `PilaTDA` o estructuras dinámicas.

- **Ejercicio 5 (implementación)**  
  Implementar `DiccionarioSimpleTDA` usando **únicamente una `ColaPrioridadTDA`**.  
  → Mantiene interfaz de diccionario, pero cambia la estructura interna.

- **Ejercicio 17 (uso con diagramación)**  
  Operaciones sobre un **AVL** vacío: insertar 30, 36, 10, 15, 12 y eliminar 30.  
  → Hacer cada operación paso a paso, indicando si hay rotaciones y diagramando el árbol.

---

## @Demian
Ejercicios de **implementación avanzada y estructuras complejas**:

- **Ejercicio 2 (implementación)**  
  Implementar `ConjuntoMamushkaTDA`, basado en `ConjuntoTDA`.  
  → Permite varias apariciones de un mismo elemento, con métodos para contar repeticiones.

- **Ejercicio 4 (implementación)**  
  Implementar `DiccionarioSimpleModTDA`, basado en `DiccionarioSimpleTDA`.  
  → Guarda la cantidad de veces que un valor fue modificado para una clave.

- **Ejercicio 10 (uso intermedio)**  
  Definir un método que reciba una `PilaTDA` y devuelva un `DiccionarioSimpleTDA`.  
  → Las claves son los elementos de la pila, y los valores son las cantidades de apariciones.

- **Ejercicio 14 (uso complejo)**  
  Definir un método que reciba un `GrafoTDA` y dos vértices, devolviendo los **vértices puente** entre ellos.  
  → Un vértice `p` es puente si existe arista `o → p` y `p → d`.

- **Ejercicio 16 (uso con diagramación)**  
  Operaciones sobre un **AVL**: insertar 20, 29, 21, 12, 7 y eliminar 20.  
  → Mostrar cada paso y las rotaciones.

- **Ejercicio 18 (uso con diagramación)**  
  Operaciones sobre un **AVL**: insertar 8, 5, 6, 3, 1 y eliminar 3.  
  → Indicar cada balanceo.

- **Ejercicio 19 (uso con diagramación)**  
  Operaciones sobre un **Árbol B de orden 4**: insertar 82, 12, 102, 36, 61; eliminar 82, 36, 102.  
  → Diagramar splits y merges.

- **Ejercicio 20 (uso con diagramación)**  
  Operaciones sobre un **Árbol B de orden 5**: insertar 53, 62, 31, 105, 85, 55; eliminar 105 y 62.  
  → Diagramar paso a paso.

---

# Resumen por tipo

- **Implementación de TDA**: 1, 2, 3, 4, 5  
- **Uso de TDA (métodos)**: 6, 7, 8, 9, 10, 11, 12, 13, 14, 15  
- **Árboles con diagramación**: 16, 17, 18, 19, 20
