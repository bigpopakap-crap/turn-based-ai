package runner;

import game.Move;
import game.MoveNotValidException;
import game.Player;
import game.State;

/**
 * Created by kapil on 12/18/17.
 */
public class PlayerMoveNotValidException extends MoveNotValidException {

  private final Player player;

  public PlayerMoveNotValidException(State state, Move move, Player player) {
    super(state, move);
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }

}
