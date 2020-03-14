import Move.Move
class ConsolePlayer extends Player {
  private val _move: Move = {
    val _input = Console.in.readLine()
    if (_input.toUpperCase.equals("ROCK")) Move.ROCK
    else if (_input.toUpperCase.equals("PAPER")) Move.PAPER
    else if (_input.toUpperCase.equals("SCISSOR")) Move.SCISSOR
    else null
  }

  override def getMove: Move = _move
}
