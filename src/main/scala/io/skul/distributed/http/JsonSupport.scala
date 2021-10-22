package io.skul.distributed.http

import io.skul.distributed.persist.Model.Models.Book
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

trait JsonSupport extends DefaultJsonProtocol {
  implicit lazy val BookResultFormat: RootJsonFormat[Book] = jsonFormat4(Book)
}
