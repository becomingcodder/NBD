package nbd.zad2

abstract class Osoba2(val imie: String, val nazwisko: String, private val _podatek: Double) {
  def podatek = _podatek
}

trait Pracownik extends Osoba2 {
  var pensja = 2600

  override def podatek: Double = pensja * 0.2
}

trait Student extends Osoba2 {
  override def podatek: Double = 0
}

trait Nauczyciel extends Pracownik {
  override def podatek: Double = pensja * 0.1
}



