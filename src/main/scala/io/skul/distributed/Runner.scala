package io.skul.distributed

import io.skul.distributed.persist.Model.Models.Book
import io.skul.distributed.persist.Repository

import java.io.File
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.io.Source
import scala.language.postfixOps

object Runner extends App {


  val r = Repository(source, distPath)

  r.getBook("Good to Great").foreach(print)

//  Repository(source).getBooks()

  source.close()

}
