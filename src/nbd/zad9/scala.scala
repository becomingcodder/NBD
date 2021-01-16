package nbd.zad9

object scala {
  def main(args: Array[String]): Unit = {


    class Container[A](private val value: A) {

      def getContent: A = value

      def applyFunction[R] (f: A => R): R = f(value)

    }

    val value = new Container[Int](8)
    println("zad 1: " +"\n" + value.getContent)

    println(value.applyFunction((value: Int) => value*2))


    trait Maybe[A] {
      def applyFunction[R](f: A => R): Maybe[R]
      def getOrElse[R >: A](default: R): R
    }

    class No[Nothing] extends Maybe[Nothing] {
      override def applyFunction[R](f: Nothing => R): Maybe[R] = new No[R]

      override def getOrElse[R >: Nothing](default: R): R = {default}
    }

    class Yes[A](var value: A) extends Maybe[A] {
      override def applyFunction[R](f: A => R): Maybe[R] = new Yes[R](f(value))

      override def getOrElse[R >: A](default: R): R = value
    }

    val no = new No[Int]
    val yes = new Yes[String]("yes value")

    println("zad 2: " + "\n" + "czy no jest podtypem Maybe?: "+ no.isInstanceOf[Maybe[_]])
    println("czy yes jest podtypem Maybe?: "+ yes.isInstanceOf[Maybe[_]])

    println("zad3 i zad4: ")
    println(no.applyFunction((value: Int) => value*2).getOrElse("getOrElse param"))
    println(yes.applyFunction((value: String) => value + " - post apply call").getOrElse("getOrElse param"))













  }

}