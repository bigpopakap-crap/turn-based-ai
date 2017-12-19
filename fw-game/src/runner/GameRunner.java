package runner;

import game.Game;
import game.Move;
import game.MoveNotValidException;
import game.Player;
import game.State;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by kapil on 12/18/17.
 */
public class GameRunner<G extends Game> {

  private final Game game;

  public GameRunner(Game game) {
    this.game = game;
  }

  public Map<Player, Long> play(List<Player> players) throws PlayerMoveNotValidException, PlayerTurnTimeoutException {
    long durationPerTurnMillis = game.getDurationPerTurnMillis();
    State state = game.getInitialState(players);

    while (!state.isTerminal()) {
      Player player = state.getNextPlayer();

      // get the function ready to pick the player's move
      final State currentState = state;
      final Move[] moveHolder = new Move[] { null };
      Callable<Object> takePlayerTurn = () -> {
        moveHolder[0] = player.takeTurn(durationPerTurnMillis, currentState);
        return null;
      };

      // actually run the player's turn selection
      ExecutorService executor = Executors.newSingleThreadExecutor();
      try {
        executor.invokeAll(Collections.singletonList(takePlayerTurn), durationPerTurnMillis, TimeUnit.MILLISECONDS);
      } catch (InterruptedException e) {
        throw new PlayerTurnTimeoutException(player);
      }

      // wait for the thread to complete
      executor.shutdown();
      try {
        executor.awaitTermination(2*durationPerTurnMillis, TimeUnit.MILLISECONDS);
      } catch (InterruptedException ex) {
        throw new RuntimeException(ex);
      }

      // get the move back from the other thread
      Move move = moveHolder[0];

      // apply the move selected by the player and advance game state
      try {
        state = state.applyMove(move);
      } catch (MoveNotValidException e) {
        throw new PlayerMoveNotValidException(state, move, player);
      }
    }

    return state.getScores();
  }

}
