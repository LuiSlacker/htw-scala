//package de.htw.fp.mitschriften
//
//object seminar1 extends App {
//  
//
//def factorial(x: Int): Int =
//  if (x == 0)
//    1
//  else
//    x*factorial(x - 1)
//
//
//val liste1 = List(1,2 ,3)
//val a = 5
//
//val list1 = a :: liste1
//list1.head // 1
//list1.tail // (2,3)
//
//// liste auf ende testen
//list1.isEmpty // false
//list1 == Nil // false
//
//
//list1[1] // 2
//list1 ++ list2 // verknüpfen zweier listen
//list1 ::: list2  // auch verknüpfen
//
//list1.updated(1, 7) // neue liste: (1, 2, 7)
//
//list1.indexOf(x) // >= 0 ist index, -1 bedeutet nicht gefunden
//list1 indexof x // das gleiche wie zuvor
//
//list1.makeString(", ") // wie js .join(', ')
//list1.makeString('(', ', ', ')') // eg.: "(1, 2, 3)"
//
//
//val obst = List("Apfel", "Banane")
//val gemuese = "Gurke" :: "Zwiebel" :: Nil
//
//// operatoren mit :: enden sind rechtsassozitiv
//
//
//
//// funktionsdefinitionen
//
//// operation auf listen
//
//def append (l: List[String], s : String): List[String] =
//	if(l == Nil) List(s)
//	else l.head :: append(l.tail, s)
//
//def reverse (l: List[String]): List[String] =
//	if(l == Nil) l
//	else append(reverse(l.tail) , l.head
//}