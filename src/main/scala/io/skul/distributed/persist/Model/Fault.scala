package io.skul.distributed.persist.Model

sealed trait Fault

case class BookInsertException(book: String) extends Fault
