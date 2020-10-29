package nbd.zad1

import jdk.jfr.Percentage

import scala.annotation.tailrec
import scala.math.abs

object zad1 {
  /*1. Stwórz 7 elementową listę zawierającą nazwy dni tygodnia. Napisz funkcję tworzącą w oparciu o nią
  stringa z elementami oddzielonymi przecinkami korzystając z:
    a. Pętli for
    b. Pętli for wypisując tylko dni z nazwami zaczynającymi się na „P”
    c. Pętli while*/

  def main(args: Array[String]) = {
    val daylist = List("poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela")
    val productMap= Map[String, Double]("Jabłko" -> 3.99, "Jajka" -> 7, "Czekolada" -> 4.30)
    val zeroList: List [Int]= List(-1, 3, 12, 0, 22, -10, -2, 0)
    val dobuleList: List [Double]= List(-1, 3, 12, 0, 22, -10, -2, 0)

    println("1a: " + forLoop(daylist))
    println("1b: " + startsWithP(daylist))
    println("1c: " + whileLoop(daylist))
    println("2a: " + listRecurrence(daylist))
    println("2b: " + listRecurrenceReversed(daylist))
    println("3: " + listTailRecurrence(daylist))
    println("4a: " + listFoldl(daylist))
    println("4b: " + listFoldr(daylist))
    println("4c: " + listFoldlStartsWithP(daylist))
    println("5: "+ mapDiscount(productMap, 0.1))
    println("6: "+ listTuple(25, "dwadzieścia pięć", true))
    println("7: "+ productMap.get("Czekolada") + productMap.get("Ciastka"))
    println("8: "+ zeroRemove(zeroList))
    println("9: "+ increaseByOne(zeroList))
    println("10: "+ filter(dobuleList))

  }

  def forLoop(daylist: List[String]): String = {
    var result: String = ""
    for (days <- daylist) {
      if (days != daylist.last) {
        result = result + days + ", "
      }
      else result = result + days
    }
    return result
  }

  def startsWithP(daylist: List[String]): String = {
    var result: String = ""
    for (days <- daylist) {
      if (days.startsWith("p")) {
        result = result + days + ", "
      }
    }
    if (result.endsWith(" ")) {
      result.dropRight(2)
    }
    else {
      result
    }
  }

  def whileLoop(daylist: List[String]): String = {
    var result: String = ""
    var i = 0
    while (i < daylist.size) {
      result = result + daylist(i) + ", "
      i += 1
    }
    if (result.endsWith(" ")) {
      result.dropRight(2)
    }
    else {
      result
    }
  }

  def listRecurrence(daylist: List[String]): String = {
    def iter(daylist: List[String]): String = {
      if (daylist.size == 1) daylist.head
      else daylist.head + ", " + iter(daylist.tail)
    }

    iter(daylist)
  }

  def listRecurrenceReversed(daylist: List[String]): String = {
    def iter(daylist: List[String]): String = {
      if (daylist.size == 1) daylist.head
      else daylist.head + ", " + iter(daylist.tail)
    }

    iter(daylist.reverse)
  }

  def listTailRecurrence(daylist: List[String]): String = {
    @tailrec
    def iter(remainingList: List[String], result: String): String = {
      val nextElement = remainingList.head
      val nextResult = result.concat(", " + nextElement)
      if (nextElement == daylist.last) nextResult
      else iter(remainingList.tail, nextResult)
    }

    iter(daylist.tail, daylist.head)
  }

  def listFoldl(daylist: List[String]): String = {
    daylist.tail.foldLeft(daylist.head)(_ + ", " + _)
    //(poniedziałek+wtorek)+środa)+czwartek...
  }

  def listFoldr(daylist: List[String]): String = {
    daylist.dropRight(1).foldRight(daylist.last)(_ + ", " + _)
    //(...czwartek+(piątek+(-niedziela + sobota+niedziela)
  }

  def listFoldlStartsWithP(daylist: List[String]): String = {
    daylist.foldLeft("")(
      (result, next) => {
        if (next.startsWith("p")) result + next + ", "
        else result
      }).dropRight(2)
  }

  def mapDiscount(productMap : Map[String, Double], percentage: Double): Map[String, Double]={
    productMap.view.mapValues(v => v - v * percentage).toMap
  }

  def listTuple(tuple: (Int, String, Boolean)) : String={
    tuple._1 +", "+ tuple._2 +", "+ tuple._3
  }

  def zeroRemove(list: List[Int]): List[Int] = {
    @tailrec
    def iter(remainingList: List[Int], result: List[Int]): List[Int] = {
      if (remainingList.isEmpty) result
      else if (remainingList.head != 0) {
        iter(remainingList.tail, result.appended(remainingList.head))
      } else {
        iter(remainingList.tail, result)
      }
    }
    iter(list, List())
  }

  def increaseByOne(list: List[Int]): List[Int] = {
    list.map(v => v + 1)
  }

  def filter(list: List[Double]): List[Double] = {
    list.filter(element => element <= 12 )
      .filter(element => element >= -5)
      .map(element => abs(element))
  }

}
