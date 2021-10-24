package io.skul.distributed.persist

import io.skul.distributed.persist.Model.Models.Book

import java.io.{File, FileOutputStream, PrintWriter}
import scala.io.Source
import scala.language.postfixOps
import scala.util.{Failure, Success, Try}

object Repository {


  private lazy val distPath = new File("distributed.csv")
  private lazy val source = Source.fromFile(distPath)


  def insertBook(book: Book): Unit = {
    val nextId = Try {
      getBooks.last.id + 1
    }
    val pw = new PrintWriter(new FileOutputStream(distPath, true))
    nextId match {
      case Failure(_) => try {
        pw.write("Id,Name,Author,PubDate\n")
        pw.write(s"${book.toString}\n")
      } finally pw.close()
      case Success(id) =>
        val nextBook = book.copy(id)
        try pw.write(s"${nextBook.toString}\n") finally pw.close()
    }
  }

  def getBook(id: Int): Option[Book] = {
    getBooks.find(_.id == id)
  }

  def getBook(name: String): Option[Book] = {
    getBooks.find(_.name.toLowerCase.contains(name.toLowerCase))
  }

  def getBooks: List[Book] = {
    val res = source.getLines().drop(1).map(_.split(",").toList).toList.map(l => Book(l.head.toInt, l(1), l(2), l(3)))
    source.close()
    res
  }
}
