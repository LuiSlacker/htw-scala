package de.htw.fp.mitschriften

object seminar2 extends App {
  

/*
2. Vorlesung
*/
// performante Variante
def rev (l: List[Int]) : List[Int] = {
	def revPrep(alt:, neu:) = 
		// rev alt, prepared neu; 
		rev(l) = neu ::: rev(alt)
		if(alt == Nil)
			neu // rev(l) = neu
		else
			revPrep(alt.tail, alt.head::neu)

		revPrep(l, Nil)
}

// revPrep ist der letzte und der einzige rekursiver aufruf = Endrekursion / Tailrecursion bedeutet: compiler benutzt kein stack sondern loop


// Thema: Generische Funktionen
// Enthält explizit Typ eg: [Banana]
// Beispiele:
def append [T] (l: List[T], e: [T]): List[T] = 
	.....

	// kann aufgerufen werden:
	append(List(1,2,3,4) , 5) == {1,2,3,4,5}
	append[Float](List(1,2,3,4) , 5) == {1.0f,2.0f,3.0f,4.0f,5.0f}



// Thema Datenstruktur: Tupeö
val x: (String, Int) = ("String", 3)
val     			 = ("Hallo", 2)

// extrahieren
	x._1 == "hallo"
	x._2 == 3

val (s, i) = x
i == 3


def f(...): (String, Int) =...

val (s,i) = f(...)


// Tupel als funktionsparameter
def f(p: (String, Int)):(Int, String)
(p._2 + 1, p_1 + " asdas")
f(x) == (4, "Hallo asdas")

Ü Funktionen Zählzeichen (s: String):
	List[(char, Int)]
				Zweiter parameter ist anzahl der vorkommen in s (zahlzeichen("sdfs") == List(("h",1), ("l", 2), etc))


// Patternmatching
 val (s,i) = x
 val (s:Int, i) = x

 match expression
 	match x
 		case (s,i) = > 

 	match x {
 		case (s, 1) =>
 		case (s, i) => 
	 	}

	 val l1 = List(x,y,z)
	 match l1 {
	 	case Nil
	 	case a :: b => // passt; a == x, b == List(x,y)
	 }
	 mit extra fürs matching gebitdete tupeln:
	 natch (x,y){
	 	case (Nil, b) = ...
	 	case (a0::al, b0::bl) => ..
	 	case List(a,b,c) => ..
	 	 }

	 	 
}