package strategy;

import game.Move;
import game.Player;
import game.State;

/**
 * Created by kapil on 12/18/17.
 */
public interface Strategy {

  Move pickMove(long duration, Player player, State state);

}
