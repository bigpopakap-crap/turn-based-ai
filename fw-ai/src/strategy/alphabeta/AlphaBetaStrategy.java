package strategy.alphabeta;

import game.Move;
import game.Player;
import game.State;
import strategy.Strategy;

/**
 * Created by kapil on 12/18/17.
 */
public class AlphaBetaStrategy<S extends State> implements Strategy {

  private final StateEvaluator<S> evaluator;

  public AlphaBetaStrategy(StateEvaluator<S> evaluator) {
    this.evaluator = evaluator;
  }

  public Move pickMove(long duration, Player player, State state) {
    // TODO implement iterative alpha beta
    return null;
  }

}
