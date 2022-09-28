package `com.train.app`

object Playing extends App {

  val str: String = "The quick brown fox jumps over the lazy dog"
  val mappedFlatten = str.split(" ").flatMap(_.toLowerCase())
  // println(mappedFlatten)

  val myVector = Vector(1, 2, 3)
  println(myVector ++ myVector)
  println(myVector.toSeq)
  println(myVector.toList)
  println(myVector.toSet)
  println((myVector ++ myVector).toSet)
  println(myVector.isEmpty)
  println(myVector.size)
  println(myVector.contains(1))
  println(myVector.contains("Hello World"))

//   Playing with functional programming
  println(
    myVector
      .filter(_ > 1)
      .map(_ * 10)
      .reduce(_ + _))

  println("Hello World".filter(char => List('a', 'e', 'i', 'o', 'u').contains(char)))
  println("Hello World".filterNot(char => List('a', 'e', 'i', 'o', 'u').contains(char)))

  //  For loops (Expression)
  val test = for {
    n <- 1 to 3
    m <- 1 to n
  } yield n * m

  println(test)

}
