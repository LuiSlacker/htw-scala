package de.htw.fp.mitschriften

object seminar2 extends App {
  

def factorial(x: Int): Int =
  if (x == 0)
    1
  else
    x*factorial(x - 1)


val liste1 = List(1,2 ,3)
val a = 5

val list1 = a :: list1
llist1.head // 1
list1.tail // (2,3)

// liste auf ende testen
list1.isEmpty() // false
list1 == Nil // false


list1[1] // 2
list1 ++ list2 // verknüpfen zweier listen
list1 ::: list2  // auch verknüpfen

list1.updated(1, 7) // neue liste: (1, 2, 7)

list1.indexOf(x) // >= 0 ist index, -1 bedeutet nicht gefunden
list1 indexof x // das gleiche wie zuvor

list1.makeString(", ") // wie js .join(', ')
list1.makeString('(', ', ', ')') // eg.: "(1, 2, 3)"


val obst = List("Apfel", "Banane")
val gemuese = "Gurke" :: "Zwiebel" :: Nil

// operatoren mit :: enden sind rechtsassozitiv



// funktionsdefinitionen

// operation auf listen

def append (l: List[String], s : String): List[String] =
	if(l == Nil) List(s)
	else l.head :: append(l.tail, s)

// naiver (langsamer) Ansatz
def reverse (l: List[String]): List[String] =
	if(l == Nil) l
	else append(reverse(l.tail) , l.head)

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