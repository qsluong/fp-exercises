import Move.Move
class ConsolePlayer(move: Move) extends Player {
  private val _move: Move = move
  
  override def getMove: Move = _move
}
