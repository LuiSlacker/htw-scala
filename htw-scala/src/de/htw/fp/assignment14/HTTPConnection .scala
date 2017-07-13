package de.htw.fp.assignment14

import java.net._

class HTTPConnection(s: Socket) extends Thread {
  import java.io._

  start

  val contentTypes = Map("jpg" → "image/jpeg",
    "jpeg" → "image/jpeg",
    "png" → "image/png",
    "gif" → "image/gif",
    "html" → "text/html; charset=utf-8",
    "txt" → "text/plain; charset=utf-8")

  def contentType(fn: String) = {
    val parts = fn.split('.')
    if (parts.size > 1) {
      if (contentTypes.contains(parts(parts.size - 1)))
        contentTypes(parts(parts.size - 1))
      else
        null
    } else
      null
  }

  def noFileResponse() =
    """HTTP/1.0 404 Not Found

""".getBytes

  def fileResponse(fn: String) = {
    val body = getFileBytes(fn)
    val ct = contentType(fn)
    if (body.size == 0 || ct == null || fn.contains("..")) {
      // 3: Sicherheitsfunktion: Wenn in der URL eine Pfadkomponente „..“ vorkommt
      // (z.B. „/ab/../../xy.txt“), soll diese entfernt oder der Request abgewiesen werden (Warum?)
      noFileResponse()
    } else {
      val out = new ByteArrayOutputStream
      out.write(("""HTTP/1.0 200 OK
Content-Type: """ + ct + """
Content-Length: """ + body.size + """

""").getBytes)
      out.write(body)
      out.close
      out.toByteArray
    }
  }

  def dynamicCoinsResponse(path: String) = {
    // 4. Nach einem festzulegenden Kriterien (z.B. feste URL) 
    // soll statt einer Datei ein dynamisch generierter Inhalt
    // geliefert werden; optional können dazu auch weitere Parameter
    // berücksichtigt werden, z.B.:
    val body = path.getBytes
    val ct = contentType("html")
    val out = new ByteArrayOutputStream
    out.write(("""HTTP/1.0 200 OK
Content-Type: """ + ct + """
Content-Length: """ + body.size + """

""").getBytes)
    out.write(body)
    out.close
    out.toByteArray
  }

  def respond(s: Socket) {
    try {
      val br = new BufferedReader(new InputStreamReader(s.getInputStream))
      val http = br.readLine

      val basePath = "F:/Dropbox/HTW/functional_programming/workspace/" +
        "htw-scala/htw-scala/src/de/htw/fp/assignment14/public"

      // 1: Extraktion der URL aus der ersten Zeile des Requests
      val headerSegments = http.split(' ')

      // 2: Laden einer URL aus einer entsprechenden Datei, 
      // die relativ zum aktuellen Verzeichnis aufgesucht wird,
      // z.B. URL „/ab/cd.html“ → Datei „./ab/cd.html“
      val response = headerSegments match {
        case Array("GET", path, _*) if path.startsWith("/coins?") => dynamicCoinsResponse(path)
        case Array("GET", path, _*) => fileResponse(basePath + path)
        case _ => noFileResponse()
      }

      s.getOutputStream.write(response)
      s.getOutputStream.flush
    } finally {
      s.close
    }
  }

  override def run {
    respond(s)
  }

  def getFileBytes(fn: String) = {
    val out = new ByteArrayOutputStream
    val f = new File(fn)
    try {
      val in = new FileInputStream(f)
      try {
        var c = 0
        while ({ c = in.read; c != -1 }) {
          out.write(c)
        }
        out.flush
      } finally {
        in.close
      }
    } catch {
      case _: FileNotFoundException ⇒
    }
    out.toByteArray
  }

}

object Webserver {

  def serve(ss: ServerSocket) {
    try {
      println("accepting")
      new HTTPConnection(ss.accept)
    } catch {
      case ie: InterruptedException ⇒ println("serve: interrupted")
    }
  }

  def server(ss: ServerSocket) {
    while (true) {
      serve(ss)
    }
  }

  val serverport = 8888

  def main(args: Array[String]) {
    val port =
      try {
        args(0).toInt
      } catch {
        case _: Throwable ⇒ serverport
      }
    println("serving port " + port)

    server(new ServerSocket(port))
  }

}