package nbd.zad10

object zad10 {

  def main(args: Array[String]) = {

    println("zad1")

    def pair: Iterator[(Int, Int)] = for {
      a <- Iterator.from(1)
      b <- 1 until a + 1 if a % b == 0
    } yield (a, b)

    println("next:")
    var i = 0
    val p = pair.buffered
    while (i < 20) {
      i += 1
      println(p.next)
    }

    println("take:")
    pair.take(20).foreach(println)

    trait Maybe[A] {
      def applyFunction[R](f: A => R): Maybe[R]

      def getOrElse[R >: A](default: R): R

      def map[R](f: A => R): Maybe[R]

      def flatMap[R](f: A => Maybe[R]): Maybe[R]
    }

    case class No[Nothing]() extends Maybe[Nothing] {
      override def applyFunction[R](f: Nothing => R): Maybe[R] = new No[R]

      override def getOrElse[R >: Nothing](default: R): R = {
        default
      }

      override def map[R](f: Nothing => R): Maybe[R] = No()

      override def flatMap[R](f: Nothing => Maybe[R]): Maybe[R] = No()
    }

    case class Yes[A](var value: A) extends Maybe[A] {
      override def applyFunction[R](f: A => R): Maybe[R] = new Yes[R](f(value))

      override def getOrElse[R >: A](default: R): R = value

      override def map[R](f: A => R): Maybe[R] = Yes(f(value))

      override def flatMap[R](f: A => Maybe[R]): Maybe[R] = f(value)
    }

    def addSomeString(s: String): Maybe[String] = Yes(s + " - post flatMap call")

    val no = No[Int]
    val yes = Yes("yes value")

    println("\n"+ "zad2:" +"\n"+no.map((value: Int) => value * 2))
    println(yes.map((value: String) => value + " - post map call"))
    println(yes.flatMap(addSomeString))
  }
}
