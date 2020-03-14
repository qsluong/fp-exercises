class Game(p1: Player, p2: Player) {
  var scorePlayer1: Int = 0
  var scorePlayer2: Int = 0

  def getScorePlayer1: Int = scorePlayer1
  def getScorePlayer2: Int = scorePlayer2
  def playTurn: TurnResult = {
    var result = Result.TIE
    if (p1.getMove.equals(Move.ROCK) && p2.getMove.equals(Move.SCISSOR) ||
      p1.getMove.equals(Move.SCISSOR) && p2.getMove.equals(Move.PAPER) ||
      p1.getMove.equals(Move.PAPER) && p2.getMove.equals(Move.ROCK)) result = Result.PLAYER1_WON
    else if ((p2.getMove.equals(Move.ROCK) && p1.getMove.equals(Move.SCISSOR) ||
      p2.getMove.equals(Move.SCISSOR) && p1.getMove.equals(Move.PAPER) ||
      p2.getMove.equals(Move.PAPER) && p1.getMove.equals(Move.ROCK))) result = Result.PLAYER2_WON
    if (result.equals(Result.PLAYER1_WON)) scorePlayer1 += 1
    else if (result.equals(Result.PLAYER2_WON)) scorePlayer2 += 2
    new TurnResult(p1.getMove, p2.getMove, result)
  }
}
