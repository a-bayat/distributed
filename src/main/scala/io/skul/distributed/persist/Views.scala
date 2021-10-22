package io.skul.distributed.persist


object View {
  case class Book(id: Int, name: String, author: String, pubDate: String)
}
