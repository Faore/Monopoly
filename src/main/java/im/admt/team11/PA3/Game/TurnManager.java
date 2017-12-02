
package im.admt.team11.PA3.Game;

import im.admt.team11.PA3.Game.Board.Card.Card;
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
    private TurnPhase turnPhase;

    private Random random;

    public TurnManager() {
        random = new Random();
        players = MonopolyGame.getInstance().gameSettings.players;

        this.currentPlayerIndex = 0;
        this.currentPlayer = players.get(0);
        this.turnPhase = TurnPhase.Movement;
        MonopolyGame.getInstance().gameWindowManager.setTurnPhase(currentPlayer, TurnPhase.Movement);
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
        TurnPhase phase;

        if(currentPlayer.inJail()) {
            currentPlayer.decrementTimeInJail();
            if(currentPlayer.inJail()) {
                phase = TurnPhase.InJail;
            } else {
                currentPlayer.takeMoney(50);
                MonopolyGame.getInstance().gameWindowManager.setLastActionLabel("Player " + currentPlayer.playerNumber + " was forced to pay $50 to leave jail.");
                phase = TurnPhase.Movement;
            }
        } else {
            phase = TurnPhase.Movement;
        }

        setPhase(phase);
    }

    public void setPhase(TurnPhase phase) {
        this.turnPhase = phase;
        MonopolyGame.getInstance().gameWindowManager.setTurnPhase(currentPlayer, turnPhase);
    }

    public void movePlayer() throws Exception {
        movePlayer(random.nextInt(11) + 2);
    }

    public void movePlayer(int roll) throws Exception {
        String description = "";
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
                MonopolyGame.getInstance().gameWindowManager.startAskBuyMode(property, currentPlayer);
            } else {
                if(property.deed.getOwner() != currentPlayer) {
                    if(!property.deed.isMortgaged) {
                        int rent = property.deed.getRent();
                        description += "and landed on " + property.name + " which was owned by Player " + property.deed.getOwner().playerNumber + " and was charged $" + rent + " for rent.";
                        property.deed.getOwner().collectMoneyFromPlayer(currentPlayer, rent);
                    } else {
                        description += "and landed on " + property.name + " which was owned by Player " + property.deed.getOwner().playerNumber + " and is mortgaged.";
                    }

                } else {
                    description += "and landed on " + property.name + " which they own.";
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
                case GoToJail:
                    description += "and landed on " + currentPlayer.token.currentLocation.name + " and was sent to jail.";
                    MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(10));
                    currentPlayer.setInJail(true);
                    MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
                    nextTurn();
                    return;
                case Chance:
                    description += "and landed on " + currentPlayer.token.currentLocation.name;
                    Card card = MonopolyGame.getInstance().gameBoard.getCard();
                    MonopolyGame.getInstance().gameWindowManager.drawChanceCard(card);
                    int currentLocation = MonopolyGame.getInstance().gameBoard.getLocation(currentPlayer.token.currentLocation);
                    switch (card.getCardNum()){
                        case 1:
                            MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(0));
                            description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            break;
                        case 2:
                            currentPlayer.giveMoney(50);
                            description = "Player " + currentPlayer.playerNumber +  " received $50";
                            break;
                        case 3:
                            currentLocation -= 3;
                            MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                            description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            break;
                        case 4:
                            if (currentLocation == 7 || currentLocation == 36){
                                currentLocation = 12;
                                MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                                description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            }else{
                                currentLocation = 28;
                                MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                                description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            }
                            break;
                        case 5:
                            if (currentLocation == 7){
                                currentLocation = 15;
                                MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                                description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            }else if(currentLocation == 22){
                                currentLocation = 25;
                                MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                                description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            }
                            else{
                                currentLocation = 5;
                                MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                                description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            }
                            break;
                        case 6:
                            if (currentLocation == 7){
                                currentLocation = 15;
                                MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                                description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            }else if(currentLocation == 22){
                                currentLocation = 25;
                                MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                                description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            }
                            else{
                                currentLocation = 5;
                                MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                                description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            }
                            break;
                        case 7:
                            description = "Player " + currentPlayer.playerNumber +  " was sent to jail.";
                            MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(10));
                            currentPlayer.setInJail(true);
                            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
                            nextTurn();
                            return;
                        case 8:
                            currentPlayer.takeMoney(15);
                            description = "Player " + currentPlayer.playerNumber +  " lost $15";
                            break;
                        case 9:
                            int repairs = 0;
                            repairs = currentPlayer.getRepairs();
                            currentPlayer.takeMoney(repairs);
                            description = "Player " + currentPlayer.playerNumber +  " pays " + repairs + " for repairs.";
                            break;
                        case 10:
                            currentLocation = 5;
                            MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                            description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            break;
                        case 11:
                            currentLocation = 24;
                            MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                            description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            break;
                        case 12:
                            currentLocation = 11;
                            MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                            description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            break;
                        case 13:
                            currentLocation = 39;
                            MonopolyGame.getInstance().gameWindowManager.setTokenLocation(currentPlayer.token, MonopolyGame.getInstance().gameBoard.tiles.get(currentLocation));
                            description = "Player " + currentPlayer.playerNumber +  " moved to " + currentPlayer.token.currentLocation.name;
                            break;
                        case 14:
                            int numPlayers = players.size();
                            currentPlayer.takeMoney(numPlayers * 50);
                            for(int i = 0; i < numPlayers; i++){
                                players.get(i).giveMoney(50);
                            }
                            description = "Player " + currentPlayer.playerNumber +  " lost $" + ((numPlayers - 1) * 50);
                            break;
                        case 15:
                            currentPlayer.giveMoney(150);
                            description = "Player " + currentPlayer.playerNumber +  " received $150";
                            break;
                        case 16:

                            break;
                        default:
                            description = "unknown card";

                    }
                    break;
                default:
                    description += "and landed on " + currentPlayer.token.currentLocation.name + " which had no effect.";
            }
        } else {
            description += "and landed on " + currentPlayer.token.currentLocation.name + " which had no effect.";
        }
        MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
        setPhase(TurnPhase.Management);
    }

    public void buyProperty() throws Exception {
        if (currentPlayer.getMoney() >= ((Property) currentPlayer.token.currentLocation).deed.printedPrice) {
            currentPlayer.buyDeed(((Property) currentPlayer.token.currentLocation).deed);
            MonopolyGame.getInstance().gameWindowManager.setLastActionLabel("Player " + currentPlayer.playerNumber + " bought " + currentPlayer.token.currentLocation.name + " for $" + ((Property) currentPlayer.token.currentLocation).deed.printedPrice + ".");
            setPhase(TurnPhase.Management);
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
        setPhase(TurnPhase.Management);
    }

    public void rollToLeaveJail() throws Exception {
        int roll1 = random.nextInt(6) + 1;
        int roll2 = random.nextInt(6) + 1;
        String description = "";
        if(roll1 == roll2) {
            description += "Player " + currentPlayer.playerNumber + " rolled double " + roll1 + " to escape jail.";
            currentPlayer.setInJail(false);
            movePlayer(roll1 + roll2);
        } else {
            description += "Player " + currentPlayer.playerNumber + " failed to roll doubles to escape jail.";
            nextTurn();
        }
        MonopolyGame.getInstance().gameWindowManager.setLastActionLabel(description);
    }

    public void payToLeaveJail() {
        currentPlayer.setInJail(false);
        currentPlayer.takeMoney(50);
        MonopolyGame.getInstance().gameWindowManager.setLastActionLabel("Player " + currentPlayer.playerNumber + " paid $50 to leave jail.");
        setPhase(TurnPhase.Movement);
    }
}