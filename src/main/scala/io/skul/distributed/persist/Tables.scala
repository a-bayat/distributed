package io.skul.distributed.persist


import io.skul.distributed.persist.Model.Models.Book
import slick.jdbc.SQLiteProfile.api._

object Tables {
  trait BookTable {
    this: Db =>
    class Books(tag: Tag) extends Table[Book](tag, "Books") {
      def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

      def name = column[String]("name")

      def author = column[String]("author")

      def pubDate = column[String]("pubDate")

      def * = (id.?, name, author, pubDate) <> (Book.tupled, Book.unapply)
    }

    val books = TableQuery[Books]
  }
}