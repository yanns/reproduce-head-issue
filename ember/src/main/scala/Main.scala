import cats.effect.{IO, IOApp}
import org.http4s.Method.HEAD
import org.http4s.Request
import org.http4s.client.Client
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.implicits.http4sLiteralsSyntax

object Main extends IOApp.Simple {
  private def headRequest(client: Client[IO]): IO[Unit] = {
    val request = Request[IO](method = HEAD, uri = uri"http://localhost:8080/hello")
    client.run(request).use(r => IO.println(r.status))
  }

  val run: IO[Unit] = EmberClientBuilder
    .default[IO]
    .build
    .use(client => headRequest(client))
}
