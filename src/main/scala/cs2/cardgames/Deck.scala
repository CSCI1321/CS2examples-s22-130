package cs2.cardgames

class Deck() {
  private var cards:List[Card] = Nil //List()

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
}

