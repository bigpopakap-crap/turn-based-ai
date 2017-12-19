package player;

import game.Move;
import game.Player;
import game.State;
import strategy.Strategy;

/**
 * Created by kapil on 12/18/17.
 */
public class AiPlayer implements Player {

  private final Strategy strategy;

  public AiPlayer(Strategy strategy) {
    this.strategy = strategy;
  }

  public Move takeTurn(long turnDurationMillis, State state) {
    return strategy.pickMove(turnDurationMillis, this, state);
  }

  public Strategy getStrategy() {
    return strategy;
  }

}
