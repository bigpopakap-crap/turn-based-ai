package game;

import java.util.List;
import java.util.Map;

/**
 * Created by kapil on 12/18/17.
 */
public interface State<S extends State, M extends Move> {

  boolean isTerminal();
  Map<Player, Long> getScores();

  Player getNextPlayer();
  List<M> getPossibleMoves();
  S applyMove(M move) throws MoveNotValidException;

}
