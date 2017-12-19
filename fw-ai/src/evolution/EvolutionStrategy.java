package evolution;

import strategy.Strategy;

/**
 * Created by kapil on 12/18/17.
 */
public interface EvolutionStrategy<S extends Strategy> {

  S getInitialStrategy();
  S updateStrategy(S strategy, long score);

}
