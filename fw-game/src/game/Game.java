package game;

import java.util.List;

/**
 * Created by kapil on 12/18/17.
 */
public interface Game<S extends State> {

  int getNumPlayers();
  long getDurationPerTurnMillis();
  S getInitialState(List<Player> players);

}
