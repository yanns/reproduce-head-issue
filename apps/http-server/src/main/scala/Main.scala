import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes.OK
import akka.http.scaladsl.server.Directives.{complete, head, path}
import com.typesafe.config.ConfigFactory

import scala.concurrent.ExecutionContext
import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load
    implicit val system: ActorSystem = ActorSystem("my-system")
    implicit val executionContext: ExecutionContext = system.dispatcher

    val routes =
      path("hello") {
        head {
          complete(OK)
        }
      }

    val bindingFuture = Http().newServerAt("localhost", 8080).bindFlow(routes)

    println(s"Server now online. Please navigate to http://localhost:8080/hello\nPress RETURN to stop...")
    StdIn.readLine()

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}
