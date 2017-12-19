package strategy.alphabeta;

import game.State;

/**
 * Created by kapil on 12/18/17.
 */
public interface StateEvaluator<S extends State> {

  long evaluate(S state);

}
