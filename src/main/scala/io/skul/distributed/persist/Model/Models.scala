package io.skul.distributed.persist.Model

object Models {
  case class Book(id: Option[Int], name: String, author: String, pubDate: String)
}
