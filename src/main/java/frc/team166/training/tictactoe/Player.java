package frc.team166.training.tictactoe;

import frc.team166.training.core.PlayerBase;

/**
 * The base class for all AI players
 */
public abstract class Player extends PlayerBase<Id, Move> {
    public Player() {
        playerId = Id.Empty;
    }
}
