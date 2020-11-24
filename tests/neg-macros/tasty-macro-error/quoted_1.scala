import scala.quoted._

object Macros {

  inline def fun(x: Any): Unit = ${ impl('x) }

  def impl(x: Expr[Any])(using Quotes) : Expr[Unit] = {
    import quotes.reflect._
    Reporting.error("here is the the argument is " + Term.of(x).underlyingArgument.show, Term.of(x).underlyingArgument.pos)
    '{}
  }

}
