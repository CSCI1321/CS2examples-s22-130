package cs2.cardgames

class Deck() {
  private var cards:List[Card] = Nil //List()

  def isEmpty():Boolean = { this.cards == Nil }
  def add(magicBunnyRabbit:Card):Unit = {
    this.cards = magicBunnyRabbit :: this.cards
  }
  def deal():Card = {
    val ret = this.cards.head
    this.cards = this.cards.tail
    ret
  }
  def shuffle():Unit = {
    this.cards = scala.util.Random.shuffle(this.cards)
  }


}

object Deck {
  def apply():Deck = {
    val d = new Deck()
    for(r <- 1 to 13) {
      for(s <- Card.SUITS) {
        d.cards ::= new Card(r,s)
      }
    }
    d
  }

  def main(args:Array[String]):Unit = {
    val stdDeck = Deck()
    println(stdDeck.cards)
  }

}

