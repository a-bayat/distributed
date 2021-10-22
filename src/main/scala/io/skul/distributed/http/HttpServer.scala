package io.skul.distributed.http

import akka.actor.typed.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding

import scala.concurrent.{ExecutionContext, Future}

class HttpServer private(routes: Routes)(
  implicit
  actorSystem: ActorSystem[Nothing],
  ec: ExecutionContext
) {
  def start(host: String, port: Int = -1): Future[ServerBinding] =
    Http()
      .newServerAt(host, port)
      .bind(routes)
      .map { server =>
        println(s"Server is available at ${server.localAddress}")
        server
      }
}

object HttpServer {
  def apply(routes: Routes)(implicit actorSystem: ActorSystem[Nothing],
                            ex: ExecutionContext): Option[HttpServer] =
    routes match {
      case null => None
      case _ => Some(new HttpServer(routes))
    }
}
