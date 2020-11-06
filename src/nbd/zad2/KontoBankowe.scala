package nbd.zad2

class KontoBankowe(private var _stanKonta: Double){

  def stanKonta: Double = _stanKonta

  def this(){
    this(0)
  }

  def wplata(value: Double):Double={
    _stanKonta+=value
    _stanKonta
  }

  def wyplata (value:Double): Double={
    _stanKonta-=value
    _stanKonta
  }


}
