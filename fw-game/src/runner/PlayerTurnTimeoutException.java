package runner;

import game.Player;

/**
 * Created by kapil on 12/18/17.
 */
public class PlayerTurnTimeoutException extends Exception {

  private final Player player;

  public PlayerTurnTimeoutException(Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }

}
