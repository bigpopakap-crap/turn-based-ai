package runner;

import strategy.Strategy;

/**
 * Created by kapil on 12/18/17.
 */
public class StrategyReport {

  private final Strategy strategy;
  private final long sumScore;
  private final int gamesPlayed;

  public StrategyReport(Strategy strategy) {
    this(strategy, 0L, 0);
  }

  private StrategyReport(Strategy strategy, long sumScore, int gamesPlayed) {
    this.strategy = strategy;
    this.sumScore = sumScore;
    this.gamesPlayed = gamesPlayed;
  }

  public Strategy getStrategy() {
    return strategy;
  }

  public long getSumScore() {
    return sumScore;
  }

  public int getGamesPlayed() {
    return gamesPlayed;
  }

  public StrategyReport updateReport(long score) {
    return new StrategyReport(getStrategy(), getSumScore() + score, getGamesPlayed() + 1);
  }

}
