package io.skul.distributed.persist


import io.skul.distributed.persist.Tables.BookTable
import slick.basic.DatabaseConfig
import slick.jdbc.SQLiteProfile
import slick.jdbc.SQLiteProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps


trait Db {
  val config: Database
}

class Repository(val config: Database) extends Db with BookTable {

  import io.skul.distributed.persist.Model.Models.Book

  //  def insertBook(book: Book): Future[Either[BookInsertException, Book]] = {
  def insertBook(book: Book): Future[Int] = {
    config.run(books += book) // TODO => fix the return type and handle error
  }

  def getBook(id: Int): Future[Option[Book]] = {
    config.run(books.filter(book => book.id === id).result.headOption)
  }

  def getBooks(): Future[Seq[Book]] =
    config.run(books.result)

  def deleteBook(id: Int): Future[Boolean] =
    config.run(books.filter(book => book.id === id).delete) map {
      _ > 0
    }



  //  val books = TableQuery[Book]
  //  val db = Database.forConfig("database.db")
  //
  //  val setup = DBIO.seq(
  //    (books.schema).create,
  //    books += (1, "hava", "amir", "2.2.2"),
  //    books += (2, "talo", "ali", "2.2.2"),
  //    books += (3, "malo", "mehrdad", "2.2.2"),
  //    books += (4, "alo", "hosein", "2.2.2"),
  //  )
  //
  //  val setupFuture = Await.result(db.run(setup), 20 seconds)
  //
  //  val oo = db.run(books.result).map(_.foreach{
  //    case (id, name, author, pubdate) =>
  //      println (s"${id} ${name} ${author} ${pubdate} ")
  //  })
  //
  //  def get(id: Int): Future[Book] = {
  //    db.run(books.)
  //  }
  //
  //  def getAll(): List[Book] = {
  //
  //  }
  //
  //  def addBook(book: Book): Unit = {
  //
  //  }

}
