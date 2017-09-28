sealed abstract class HttpMethod() {
    def body: List[String]
    def bodyLength = body.length
}

case class Connect(body: List[String]) extends HttpMethod
case class Delete (body: List[String]) extends HttpMethod
case class Get    (body: List[String]) extends HttpMethod
case class Head   (body: List[String]) extends HttpMethod
case class Options(body: List[String]) extends HttpMethod
case class Post   (body: List[String]) extends HttpMethod
case class Put    (body: List[String]) extends HttpMethod
case class Trace  (body: List[String]) extends HttpMethod

def handle (method: HttpMethod) = method match {
  case Connect (body) => s"connect: (length: ${method.bodyLength}) ${body.head}" //added head
  case Delete  (body) => s"delete:  (length: ${method.bodyLength}) $body"
  case Get     (body) => s"get:     (length: ${method.bodyLength}) $body"
  case Head    (body) => s"head:    (length: ${method.bodyLength}) $body"
  case Options (body) => s"options: (length: ${method.bodyLength}) $body"
  case Post    (body) => s"post:    (length: ${method.bodyLength}) $body"
  case Put     (body) => s"put:     (length: ${method.bodyLength}) $body"
  case Trace   (body) => s"trace:   (length: ${method.bodyLength}) $body"
}

val methods = Seq(
  Connect(List("connect body...", "connecting body2...")),
  Delete (List("delete body...")),
  Get    (List("get body...")),
  Head   (List("head body...")),
  Options(List("options body...")),
  Post   (List("post body...")),
  Put    (List("put body...")),
  Trace  (List("trace body...")))

methods foreach (method => println(handle(method)))
