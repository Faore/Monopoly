
package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Tile;
import im.admt.team11.PA3.Game.Board.Tiles.Properties.StandardProperty;
import im.admt.team11.PA3.Game.Board.Tiles.Property;
import im.admt.team11.PA3.Game.Board.Tiles.SpecialTile;

import java.util.ArrayList;
import java.util.Random;

public class TurnManager {

    private ArrayList<Player> players;
    private int currentPlayerIndex;
    private Player currentPlayer;
    private boolean movementPhase;

    private Random random;

    public TurnManager() {
        random = new Random();
        players = MonopolyGame.getInstance().gameSettings.players;

        this.currentPlayerIndex = 0;
        this.currentPlayer = players.get(0);
        this.movementPhase = true;
        MonopolyGame.getInstance().gameWindowManager.setTurnPhase(currentPlayer, true);
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void nextTurn() {
        this.currentPlayerIndex++;
        if(this.currentPlayerIndex >= players.size()) {
            this.currentPlayerIndex = 0;
        }
        this.currentPlayer = players.get(currentPlayerIndex);
        this.movementPhase = true;
        MonopolyGame.getInstance().gameWindowManager.setTurnPhase(currentPlayer, true);
    }

    public boolean isMovementPhase() {
        return movementPhase;
    }

    public void setPhase(boolean movementPhase) {
        this.movementPhase = movementPhase;
        MonopolyGame.getInstance().gameWindowManager.setTurnPhase(currentPlayer, movementPhase);
    }

    public void movePlayer() throws Exception {
        MonopolyGame.getInstance().gameWindowManager.setTurnPhase(currentPlayer, false);
        String description = "";
        int roll = random.nextInt(11) + 2;
        description += "Player " + currentPlayer.playerNumber + " rolled a " + roll + ", ";
        int startLocation = MonopolyGame.getInstance().gameBoard.tiles.indexOf(currentPlayer.token.currentLocation);
        int endLocation = startLocation + roll;
        if(endLocation >= MonopolyGame.getInstance().gameBoard.tiles.size()) {
            endLocation -= MonopolyGame.getInstance().gameBoard.tiles.size();
            currentPlayer.giveMoney(200);
            description += "collected $200 from Go, ";
        }
        MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(endLocation));
        if(currentPlayer.token.currentLocation instanceof Property) {
            Property property = (Property) currentPlayer.token.currentLocation;
            if(property.deed.getOwner() == null) {
                description += "and landed on " + property.name + " which is unowned.";
                MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
                MonopolyGame.getInstance().gameWindowManager.startAskBuyMode(property, currentPlayer);
            } else {
                if(property.deed.getOwner() != currentPlayer) {
                    int rent = property.deed.getRent();
                    description += "and landed on " + property.name + " which was owned by Player " + property.deed.getOwner().playerNumber + " and was charged $" + rent + " for rent.";
                    MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
                    property.deed.getOwner().collectMoneyFromPlayer(currentPlayer, rent);
                } else {
                    description += "and landed on " + property.name + " which they own.";
                    MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
                }
            }
        } else if(currentPlayer.token.currentLocation instanceof SpecialTile) {
            SpecialTile specialTile = (SpecialTile) currentPlayer.token.currentLocation;
            switch (specialTile.type) {
                case LuxuryTax:
                    currentPlayer.takeMoney(100);
                    description += "and landed on " + currentPlayer.token.currentLocation.name + " and lost $100.";
                    break;
                case IncomeTax:
                    currentPlayer.takeMoney(200);
                    description += "and landed on " + currentPlayer.token.currentLocation.name + " and lost $200.";
                    break;
                default:
                    description += "and landed on " + currentPlayer.token.currentLocation.name + " which had no effect.";
            }
            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
        } else {
            description += "and landed on " + currentPlayer.token.currentLocation.name + " which had no effect.";
            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
        }
        setPhase(false);
    }

    public void buyProperty() throws Exception {
        if (currentPlayer.getMoney() >= ((Property) currentPlayer.token.currentLocation).deed.printedPrice) {
            currentPlayer.buyDeed(((Property) currentPlayer.token.currentLocation).deed);
            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel("Player " + currentPlayer.playerNumber + " bought " + currentPlayer.token.currentLocation.name + " for $" + ((Property) currentPlayer.token.currentLocation).deed.printedPrice + ".");
            setPhase(false);
        } else {
            throw new Exception("Can't afford property.");
        }
    }

    public void completeAuction(Player player, int amount, Property property) throws Exception {
        if(player == null) {
            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel("Nobody bid on " + property.name);
        } else {
            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel("Player " + player.playerNumber + " won the auction for " + property.name + " for $" + amount + ".");
            player.buyDeed(property.deed, amount);
        }
        setPhase(false);
    }
}