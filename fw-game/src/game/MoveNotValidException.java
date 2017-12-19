package game;

/**
 * Created by kapil on 12/18/17.
 */
public class MoveNotValidException extends Exception {

  private final State state;
  private final Move move;

  public MoveNotValidException(State state, Move move) {
    this.state = state;
    this.move = move;
  }

  public State getState() {
    return state;
  }

  public Move getMove() {
    return move;
  }

}
