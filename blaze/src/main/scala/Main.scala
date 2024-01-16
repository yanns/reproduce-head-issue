import cats.effect.{IO, IOApp}
import org.http4s.Method.HEAD
import org.http4s.Request
import org.http4s.blaze.client.BlazeClientBuilder
import org.http4s.client.Client
import org.http4s.implicits.http4sLiteralsSyntax

object Main extends IOApp.Simple {
  private def headRequest(client: Client[IO]): IO[Unit] = {
    val request = Request[IO](method = HEAD, uri = uri"http://localhost:8080/hello")
    client.run(request).use { http4sResp =>
      http4sResp
        .bodyText
        .compile
        .string
        .flatMap { decodedBody =>
          IO.println(http4sResp.status + " " + decodedBody)
        }

    }
  }

  val run: IO[Unit] = BlazeClientBuilder[IO]
    .resource
    .use(client => headRequest(client))
}
