import Move.Move
import Result.Result

object Main {
  var isPlaying: Boolean = true

  def main(args: Array[String]): Unit = {

    while (isPlaying) {
      println("Your turn. Choose ROCK, PAPER or SCISSOR")
      val playerInput = Console.in.readLine
      val playerMove: Move = if (playerInput.toUpperCase.equals("ROCK")) Move.ROCK
      else if (playerInput.toUpperCase.equals("PAPER")) Move.PAPER
      else if (playerInput.toUpperCase.equals("SCISSOR")) Move.SCISSOR
      else null
      val player1: ConsolePlayer = new ConsolePlayer(playerMove)
      println("PLAYER 1: " + player1.getMove)
      val player2: RockAI = new RockAI()
      println("PLAYER 2: " + player2.getMove)
      val result: Result = if (player1.getMove.equals(player2.getMove)) Result.TIE
      else if (player1.getMove.equals(Move.ROCK) && player2.getMove.equals(Move.SCISSOR) ||
        player1.getMove.equals(Move.PAPER) && player2.getMove.equals(Move.ROCK) ||
        player1.getMove.equals(Move.SCISSOR) && player2.getMove.equals(Move.PAPER)) Result.PLAYER1_WON
      else if (player2.getMove.equals(Move.ROCK) && player1.getMove.equals(Move.SCISSOR) ||
        player2.getMove.equals(Move.PAPER) && player1.getMove.equals(Move.ROCK) ||
        player2.getMove.equals(Move.SCISSOR) && player1.getMove.equals(Move.PAPER)) Result.PLAYER2_WON
      else null
      println("Result: " + result)

      val game: Game = new Game(player1, player2)
      if (result.equals(Result.PLAYER1_WON)) game.scorePlayer1 += 1
      else if (result.equals(Result.PLAYER2_WON)) game.scorePlayer2 += 1
      println("Score: " + game.getScorePlayer1 + "-" + game.getScorePlayer2)
      println("Keep playing? Y/N")
      val keepPlayingInput = Console.in.readLine
      if (keepPlayingInput.toUpperCase.contains("N")) this.togglePlaying()
    }

  }

  def togglePlaying(): Unit = {
    this.isPlaying = false
  }
}
