package de.htw.fp.assignment14

object Assignment14 {

  /**
   * Erweitere den Webserver von der Tafel um einige Funktionen:
   * Extraktion der URL aus der ersten Zeile des Requests
   * Laden einer URL aus einer entsprechenden Datei, die relativ zum 
   * aktuellen Verzeichnis aufgesucht wird, z.B. URL „/ab/cd.html“ → Datei „./ab/cd.html“
   * (schon drin) Fehlerbehandlung; wird eine Datei nicht gefunden bzw. 
   * ist nicht lesbar, soll eine geeignete Fehler-Response geliefert werden (HTTP-Code 404)
   * Sicherheitsfunktion: Wenn in der URL eine Pfadkomponente „..“ vorkommt
   *  (z.B. „/ab/../../xy.txt“), soll diese entfernt oder der Request 
   *  abgewiesen werden (Warum?)
   *  (schon drin) Unterscheiden der URL nach Typen, z.B. anhand des Suffix;
   *   passend zum Typ muss in der Response der Content-Type gesetzt werden
   *   Nach einem festzulegenden Kriterien (z.B. feste URL) soll statt einer 
   *   Datei ein dynamisch generierter Inhalt geliefert werden; optional können
   *   dazu auch weitere Parameter berücksichtigt werden, z.B.:
   *   GET /coins?sum=20&coins=1,2,5,10
   *   GET /coins?sum=20&currency=euro
   *   Um den dynamisch generierten Inhalt interaktiv zu testen, 
   *   ist eine einfache HTML-Seite zweckmäßig, die ein entsprechendes Formular enthält.
   *   Mit <form method=GET> wird dabei der einfacher zu parsende GET-Request anstelle 
   *   des per Default verwendeten POST-Requests abgesetzt.
   *
   */

  def main(args: Array[String]) = {

  }

}