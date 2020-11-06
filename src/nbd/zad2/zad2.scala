package nbd.zad2

object zad2 {

  def main(args: Array[String]) = {

    val konto1 = new KontoBankowe();
    val konto2 = new KontoBankowe(1000)
    val s1 = new Osoba2("Grzesiek", "Kacperczyk", 5) with Student
    val p1 = new Osoba2("Jan", "Nowak", 15) with Pracownik
    val n1 = new Osoba2("Paweł", "Kowalski", 20) with Nauczyciel


    val studentIpracownik = new Osoba2("Maurycy", "Górecki", 20) with Student with Pracownik
    studentIpracownik.pensja = 2600
    val pracownikIStudent = new Osoba2("Marcin", "Stępień", 20) with Pracownik with Student
    pracownikIStudent.pensja = 2600

    val daylist = List("poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela", "świątek", null)
    print("zad1: ")
    pMathingPrint(daylist)
    print("\n")

    println("zad2: konto1 bez parametru: " + konto1.stanKonta.toString)
    println("konto2 - konstruktor z parametrem: " + konto2.stanKonta.toString)
    konto1.wplata(1337)
    println("konto1 po wpłacie: " + konto1.stanKonta.toString())
    konto2.wyplata(50)
    println("konto2 po wypłacie: " + konto2.stanKonta.toString())

    print("zad3: " + hello(Osoba("Jacek", "Młynarski")))
    print(", " + hello(Osoba("Paweł", "Piotrowski")))
    println(", " + hello(Osoba("Jan", "Kowalski")))

    println("zad4: " + doThrice(2, x => x * x))

    println("zad5: dla porównania każdy ma pensje 2600." + "\n" +
      "podatek studenta: " + s1.podatek + ", podatek pracownika: " + p1.podatek + ", podatek naucyzciela: " + n1.podatek)
    println("podatek studenta-pracownika: " + studentIpracownik.podatek)
    println("podatek pracownika-studenta: " + pracownikIStudent.podatek)

  }


  def pMathingPrint(daylist: List[String]) = {
    for (e <- daylist) println(pMatching(e))
  }

  def pMatching(day: String): String = {
    day match {
      case "poniedziałek" => "Praca"
      case "wtorek" => "Praca"
      case "środa" => "Praca"
      case "czwartek" => "Praca"
      case "piątek" => "Praca"
      case "sobota" => "Weekend"
      case "niedziela" => "Weekend"
      case _ => "Nie ma takiego dnia"
    }
  }

  case class Osoba(firstName: String, surname: String)

  def hello(osoba: Osoba): String = {
    osoba match {
      case Osoba("Jacek", "Młynarski") => "cześć Jacek"
      case Osoba("Paweł", "Piotrowski") => "siema Paweł"
      case _ => "dzień dobry"
    }
  }

  def doThrice(value: Int, f: Int => Int) = f(f(f(value)))

}
