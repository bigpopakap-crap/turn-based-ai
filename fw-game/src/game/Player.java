package game;

/**
 * Created by kapil on 12/18/17.
 */
public interface Player {

  Move takeTurn(long turnDurationMillis, State state);

}
