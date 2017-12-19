package runner;

import game.Game;
import game.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import player.AiPlayer;
import strategy.Strategy;

/**
 * Created by kapil on 12/18/17.
 */
class AiGenerationRunner {

  private final Game game;

  public AiGenerationRunner(Game game) {
    this.game = game;
  }

  public Map<Strategy, Long> play(List<Strategy> strategies) {
    List<AiPlayer> players = strategies.stream().map(AiPlayer::new).collect(Collectors.toList());

    // run the game and report the scores of each strategy
    GameRunner gameRunner = new GameRunner(game);
    try {
      Map<Player, Long> playerScores = gameRunner.play(players);
      return scores(playerScores);
    } catch (PlayerMoveNotValidException ex) {
      return minScoreForPlayer(ex.getPlayer());
    } catch (PlayerTurnTimeoutException ex) {
      return minScoreForPlayer(ex.getPlayer());
    }
  }

  private Map<Strategy, Long> scores(Map<Player, Long> playerScores) {
    Map<Strategy, Long> strategyScores = new HashMap<>();

    playerScores.forEach((key, value) -> strategyScores.put(
      ((AiPlayer) key).getStrategy(),
      value
    ));

    return strategyScores;
  }

  private Map<Strategy, Long> minScoreForPlayer(Player player) {
    Map<Strategy, Long> scores = new HashMap<>();
    scores.put(((AiPlayer) player).getStrategy(), Long.MIN_VALUE);
    return scores;
  }

}
