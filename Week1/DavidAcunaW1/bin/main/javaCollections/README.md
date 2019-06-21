A) ArrayList vs LinkedList
			--- ArrayList ---
		Add List Time (Miliseconds): 0
		Sort List Time (Miliseconds): 6055
		Remove from Middle List Time (Miliseconds): 3
		Add in Middle List Time (Miliseconds): 3
		Iterate List Time (Miliseconds): 145
		
		--- LinkedList ---
		Add LinkedList Time (Miliseconds): 0
		Sort LinkedList Time (Miliseconds): 4949
		Remove from Middle LinkedList Time (Miliseconds): 45
		Add in Middle LinkedList Time (Miliseconds): 44
		Iterate LinkedList Time (Miliseconds): 336

	i) Add a new Element
		Se observa que la accion ocurre muy rapido, por lo que en ambos casos no se nota diferencia.
		
	ii) Remove element from middle
		Se observa que es mas costoso eliminar un elemento usando LinkedList, debido a el tamaño en si de la lista, y que la referencia a los elementos anterior y siguiente se almacena por lo que el uso de memoria y el tiempo de las operaciones es mayor.

	iii) Insert in the middle a new element
		Se observa que es mas costoso eliminar un elemento usando LinkedList, debido a el tamaño en si de la lista, y que la referencia a los elementos anterior y siguiente se almacena por lo que el uso de memoria y el tiempo de las operaciones es mayor.
		Ademas, ArrayList permite un acceso de lectura aleatorio rápido
	
	iv) Iterate over the whole collection
		Se observa que es mas costoso eliminar un elemento usando LinkedList, debido a el tamaño en si de la lista, y que la referencia a los elementos anterior y siguiente se almacena por lo que el uso de memoria y el tiempo de las operaciones es mayor.

	v) Sorting the collection
		En la prueba se observa que LinkedList ordeno mas rapido, en este caso puede que el conocer la referencia de los datos permita hacer la accion de manera mas eficiente, debido a que se estan reutilizando referencias de los datos
		
A) HashMap vs TreeMap
		--- HashMap ---
		Put Map Time (Miliseconds): 0
		Find Map Time (Miliseconds): 0
		Remove Map Time (Miliseconds): 0
		Iterate Map Time (Miliseconds): 11
		
		--- TreeMap ---
		Put TreeMap Time (Miliseconds): 0
		Find TreeMap Time (Miliseconds): 0
		Remove TreeMap Time (Miliseconds): 0
		Iterate TreeMap Time (Miliseconds): 14
		
		i) Put a new element
			Se puede decir que toma lo mismo debido a lo simple de la accion.
			Pero al momento de añadir varios elemntos TreeMap tomara mas debido a su naturaleza ordenada por lo que neesita encontrar la ubicacion
			La teoria nos dice: HashMap -> O(1). TreeMap -> O(Log k)
		
		ii) Find an element by key
			Se puede decir que toma lo mismo debido a lo simple de la accion.
			Pero al momento de obtener entre varios elementos TreeMap tomara mas debido a su naturaleza ordenada por lo que neesita encontrar la ubicacion
			La teoria nos dice: HashMap -> O(1). TreeMap -> O(Log k)
			
		iii) Remove an element by key
			Se puede decir que toma lo mismo debido a lo simple de la accion.
			Pero al momento de eliminar varios elementos TreeMap tomara mas debido a su naturaleza ordenada por lo que neesita encontrar la ubicacion
			La teoria nos dice: HashMap -> O(1). TreeMap -> O(Log k)
			
		iv) Iterate over the whole entries
			En este aspecto su comportamiento es similar.