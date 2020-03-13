import Move.Move
import Result.Result

class TurnResult(movePlayer1: Move, movePlayer2: Move, result: Result) {
  def getMovePlayer1: Move = movePlayer1
  def getMovePlayer2: Move = movePlayer2
  def getResult: Result = result
}
