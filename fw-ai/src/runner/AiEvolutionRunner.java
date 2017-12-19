package runner;

import evolution.EvolutionStrategy;
import game.Game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import strategy.Strategy;

/**
 * Created by kapil on 12/18/17.
 */
public class AiEvolutionRunner {

  private final Game game;
  private final EvolutionStrategy evolutionStrategy;

  public AiEvolutionRunner(Game game, EvolutionStrategy evolutionStrategy) {
    this.game = game;
    this.evolutionStrategy = evolutionStrategy;
  }

  public Strategy run(int numGenerations) {
    int numPlayers = game.getNumPlayers();
    List<StrategyReport> strategyReports = getInitialStrategies(numPlayers);

    for (int i = 0; i < numGenerations; i++) {
      List<Strategy> strategies =
          strategyReports.stream().map(StrategyReport::getStrategy).collect(Collectors.toList());
      Map<Strategy, Long> scores = new AiGenerationRunner(game).play(strategies);

      // update the strategies
      // TODO
    }

    // return the best strategy
    // TODO
    return null;
  }

  private List<StrategyReport> getInitialStrategies(int numPlayers) {
    List<StrategyReport> strategies = new ArrayList<>(numPlayers);

    for (int i = 0; i < numPlayers; i++) {
      strategies.set(i, new StrategyReport(evolutionStrategy.getInitialStrategy()));
    }

    return Collections.unmodifiableList(strategies);
  }

}
