package io.skul.distributed

import io.skul.distributed.persist.Model.Models.Book
import io.skul.distributed.persist.Repository
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcBackend.Database

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object Runner extends App {
  val booksRepo = new Repository(Database.forConfig("database.db"))

  val books = booksRepo.getBooks()

  val r  = Await.result(books, 10 seconds)

  r.foreach(println)

  println("insert new one")

  booksRepo.insertBook(Book(Some(0), "berme days2", "loren hardi", "2021-10-02"))
}
