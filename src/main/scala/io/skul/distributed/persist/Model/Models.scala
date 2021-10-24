package io.skul.distributed.persist.Model

object Models {
  case class Book(id: Int, name: String, author: String, pubDate: String) {
    override def toString: String = s"$id,$name,$author,$pubDate"
  }
}
