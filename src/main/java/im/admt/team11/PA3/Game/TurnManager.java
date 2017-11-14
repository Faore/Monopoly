
package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Tiles.Property;
import im.admt.team11.PA3.Game.Board.Tiles.SpecialTile;

import java.util.ArrayList;
import java.util.Random;

public class TurnManager {

    private ArrayList<Player> players;
    private int currentPlayerIndex;
    private Player currentPlayer;
    private TurnPhase currentPhase;

    private Random random;

    public TurnManager() {
        random = new Random();
        players = MonopolyGame.getInstance().gameSettings.players;

        this.currentPlayerIndex = 0;
        this.currentPlayer = players.get(0);
        this.currentPhase = TurnPhase.Movement;
        MonopolyGame.getInstance().gameWindowManager.setTurnPhase(currentPlayer, TurnPhase.Movement);
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void nextTurn() {
        this.currentPlayerIndex++;
        if (this.currentPlayerIndex >= players.size()) {
            this.currentPlayerIndex = 0;
        }
        this.currentPlayer = players.get(currentPlayerIndex);
        if (currentPlayer.isInJail) {
            currentPlayer.decrementTimeInJail();
            if (currentPlayer.isInJail) {
                currentPhase = TurnPhase.InJail;
            } else {
                currentPhase = TurnPhase.Movement;
                currentPlayer.takeMoney(50);
                currentPlayer.setInJail(false);
                MonopolyGame.getInstance().gameWindowManager.setLastActionLabel("Player " + currentPlayer.playerNumber + " has payed $50 to get out of jail.");
            }
        } else {
            currentPhase = TurnPhase.Movement;
        }
        MonopolyGame.getInstance().gameWindowManager.setTurnPhase(currentPlayer, currentPhase);
    }

    public TurnPhase getPhase() {
        return currentPhase;
    }

    public void setPhase(TurnPhase phase) {
        this.currentPhase = phase;
        MonopolyGame.getInstance().gameWindowManager.setTurnPhase(currentPlayer, currentPhase);
    }

    public void rollGetOutOfJail() throws Exception {
        int roll1 = random.nextInt(5) + 2;
        int roll2 = random.nextInt(5) + 2;
        String description = "";
        if (roll1 == roll2) {
            currentPlayer.setInJail(false);
            movePlayer(roll1+roll2);
            description += "Player " + currentPlayer.playerNumber + " rolled" + roll1 + " " + roll2 + ", and has been freed from jail. ";
            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description + MonopolyGame.getInstance().gameWindowManager.lastActionLabel.getText());
        } else {
            currentPlayer.decrementTimeInJail();
            description += "Player " + currentPlayer.playerNumber + " rolled" + roll1 + " and " + roll2 + ", and will stay in jail.";
            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
            nextTurn();
        }
    }

    public void payGetOutOfJail() {
        MonopolyGame.getInstance().gameWindowManager.setLastActionLabel("Player " + currentPlayer.playerNumber + " paid $50 to get out of jail.");
        currentPlayer.setInJail(false);
        currentPlayer.takeMoney(50);
        setPhase(TurnPhase.Movement);
    }

    public boolean moveSpaces(int roll) throws Exception {
        int startLocation = MonopolyGame.getInstance().gameBoard.tiles.indexOf(currentPlayer.token.currentLocation);
        int endLocation = startLocation + roll;
        if (endLocation >= MonopolyGame.getInstance().gameBoard.tiles.size()) {
            endLocation -= MonopolyGame.getInstance().gameBoard.tiles.size();
            currentPlayer.giveMoney(200);
            MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(endLocation));
            return true;
        }
        MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(endLocation));
        return false;
    }

    public void movePlayer(int roll) throws Exception {
        MonopolyGame.getInstance().gameWindowManager.setTurnPhase(currentPlayer, TurnPhase.Property);
        String description = "";
        if(roll == -1) {
            roll = random.nextInt(11) + 2;
        }
        description += "Player " + currentPlayer.playerNumber + " rolled a " + roll + ", ";
        if(moveSpaces(roll)) {
            description += "collected $200 from Go, ";
        }
        if (currentPlayer.token.currentLocation instanceof Property) {
            Property property = (Property) currentPlayer.token.currentLocation;
            if (property.deed.getOwner() == null) {
                description += "and landed on " + property.name + " which is unowned.";
                MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
                MonopolyGame.getInstance().gameWindowManager.startAskBuyMode(property, currentPlayer);
            } else {
                if (property.deed.getOwner() != currentPlayer) {
                    int rent = property.deed.getRent();
                    description += "and landed on " + property.name + " which was owned by Player " + property.deed.getOwner().playerNumber + " and was charged $" + rent + " for rent.";
                    MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
                    property.deed.getOwner().collectMoneyFromPlayer(currentPlayer, rent);
                } else {
                    description += "and landed on " + property.name + " which they own.";
                    MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
                }
            }
        } else if (currentPlayer.token.currentLocation instanceof SpecialTile) {
            SpecialTile specialTile = (SpecialTile) currentPlayer.token.currentLocation;
            switch (specialTile.type) {
                case LuxuryTax:
                    currentPlayer.takeMoney(100);
                    description += "and landed on " + currentPlayer.token.currentLocation.name + " and lost $100.";
                    MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
                    break;
                case IncomeTax:
                    currentPlayer.takeMoney(200);
                    description += "and landed on " + currentPlayer.token.currentLocation.name + " and lost $200.";
                    MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
                    break;
                case GoToJail:
                    description += "and landed on " + currentPlayer.token.currentLocation.name + " and goes directly to jail.";
                    //Move player to jail.
                    currentPlayer.setInJail(true);
                    MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(10));
                    MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
                    nextTurn();
                    return;
                default:
                    description += "and landed on " + currentPlayer.token.currentLocation.name + " which had no effect.";
                    MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
            }
        } else {
            description += "and landed on " + currentPlayer.token.currentLocation.name + " which had no effect.";
            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
        }
        setPhase(TurnPhase.Property);
    }

    public void buyProperty() throws Exception {
        if (currentPlayer.getMoney() >= ((Property) currentPlayer.token.currentLocation).deed.printedPrice) {
            currentPlayer.buyDeed(((Property) currentPlayer.token.currentLocation).deed);
            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel("Player " + currentPlayer.playerNumber + " bought " + currentPlayer.token.currentLocation.name + " for $" + ((Property) currentPlayer.token.currentLocation).deed.printedPrice + ".");
            setPhase(TurnPhase.Property);
        } else {
            throw new Exception("Can't afford property.");
        }
    }

    public void completeAuction(Player player, int amount, Property property) throws Exception {
        if (player == null) {
            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel("Nobody bid on " + property.name + ".");
        } else {
            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel("Player " + player.playerNumber + " won the auction for " + property.name + " for $" + amount + ".");
            player.buyDeed(property.deed, amount);
        }
        setPhase(TurnPhase.Property);
    }
}