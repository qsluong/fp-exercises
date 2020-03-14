object Main {
  var isPlaying: Boolean = true

  def main(args: Array[String]): Unit = {

    while (isPlaying) {
      println("Your turn. Choose ROCK, PAPER or SCISSOR")
      val player1: ConsolePlayer = new ConsolePlayer
      println("PLAYER 1: " + player1.getMove)
      val player2: RockAI = new RockAI()
      println("PLAYER 2: " + player2.getMove)
      val game: Game = new Game(player1, player2)

      println("Result: " + game.playTurn.getResult)
      println("Score: " + game.getScorePlayer1 + "-" + game.getScorePlayer2)

      val input2 = keepPlayingInput()
      if (input2.toUpperCase.contains("N")) isPlaying = false
    }
  }

  def keepPlayingInput(): String = {
    println("Keep playing? Y/N")
    Console.in.readLine
  }

}
