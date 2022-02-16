package cs2.cardgames

import scalafx.scene.input.KeyCode

class Card(r:Int, s:Char) {
  val rank:Int = if(r > 0 && r < 14) r else 1
  val suit:Char = if(Card.SUITS.contains(s)) s else Card.SPADE
  override def toString():String = {
    rank.toString + " of " + suit
  }

  def < (other:Card):Boolean = { this.rank < other.rank }
  def > (other:Card):Boolean = { this.rank > other.rank }
  def == (other:Card):Boolean = { this.rank == other.rank }

}

object Card {
  val HEART = 'H'
  val DIAMOND = 'D'
  val SPADE = 'S'
  val CLUB = 'C'
  val SUITS = Array(HEART, DIAMOND, SPADE, CLUB)

  def main(args:Array[String]):Unit = {
    val c = new Card(11, HEART)
    val d = new Card(11, SPADE)
    println(c + "\t" + d)
    println(c < d)
    println(c > d)
    println(c == d)
  }

}



