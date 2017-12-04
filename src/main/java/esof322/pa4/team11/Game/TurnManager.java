
package esof322.pa4.team11.Game;

import esof322.pa4.team11.Game.Board.Card.Card;
import esof322.pa4.team11.Game.Board.Tiles.Property;
import esof322.pa4.team11.Game.Board.Tiles.SpecialTile;
import esof322.pa4.team11.Game.UI.GameWindowController;
import javafx.application.Platform;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Random;

public class TurnManager {

    private ObservableList<Player> players;
    private int currentPlayerIndex;
    private Player currentPlayer;
    private TurnPhase turnPhase;

    private Random random;

    private GameWindowController gameWindowController;
    private GameBoard gameBoard;

    public TurnManager(GameWindowController gameWindowController, GameBoard gameBoard, ObservableList<Player> players) {
        this.gameWindowController = gameWindowController;
        this.gameBoard = gameBoard;
        this.players = players;

        random = new Random();

        this.currentPlayerIndex = 0;
        this.currentPlayer = players.get(0);
        this.turnPhase = TurnPhase.Movement;
        gameWindowController.setTurnPhase(currentPlayer, TurnPhase.Movement);
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
                gameWindowController.setLastActionLabel("Player " + currentPlayer.playerNumber + " was forced to pay $50 to leave jail.");
                phase = TurnPhase.Movement;
            }
        } else {
            phase = TurnPhase.Movement;
        }

        setPhase(phase);
    }

    public void setPhase(TurnPhase phase) {
        this.turnPhase = phase;
        gameWindowController.setTurnPhase(currentPlayer, turnPhase);
    }

    public void movePlayer() throws Exception {
        movePlayer(random.nextInt(11) + 2);
    }

    public void movePlayer(int roll) throws Exception {
        String description = "";
        description += "Player " + currentPlayer.playerNumber + " rolled a " + roll + ", ";
        int startLocation = gameBoard.tiles.indexOf(currentPlayer.token.currentLocation);
        int endLocation = startLocation + roll;
        if(endLocation >= gameBoard.tiles.size()) {
            endLocation -= gameBoard.tiles.size();
            currentPlayer.giveMoney(200);
            description += "collected $200 from Go, ";
        }
        gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(endLocation));
        description = handleLand(description);

        gameWindowController.setLastActionLabel(description);
        setPhase(TurnPhase.Management);
    }

    public void buyProperty() throws Exception {
        if (currentPlayer.getMoney() >= ((Property) currentPlayer.token.currentLocation).deed.printedPrice) {
            currentPlayer.buyDeed(((Property) currentPlayer.token.currentLocation).deed);
            gameWindowController.setLastActionLabel("Player " + currentPlayer.playerNumber + " bought " + currentPlayer.token.currentLocation.name + " for $" + ((Property) currentPlayer.token.currentLocation).deed.printedPrice + ".");
            setPhase(TurnPhase.Management);
        } else {
            throw new Exception("Can't afford property.");
        }
    }

    public void completeAuction(Player player, int amount, Property property) throws Exception {
        if(player == null) {
            gameWindowController.setLastActionLabel("Nobody bid on " + property.name);
        } else {
            gameWindowController.setLastActionLabel("Player " + player.playerNumber + " won the auction for " + property.name + " for $" + amount + ".");
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
        gameWindowController.setLastActionLabel(description);
    }

    public void payToLeaveJail() {
        currentPlayer.setInJail(false);
        currentPlayer.takeMoney(50);
        gameWindowController.setLastActionLabel("Player " + currentPlayer.playerNumber + " paid $50 to leave jail.");
        setPhase(TurnPhase.Movement);
    }

    public void cardToLeaveJail(){
        currentPlayer.setInJail(false);
        if (currentPlayer.chanceJailCard){
            currentPlayer.setChanceJailCard(false);
            gameBoard.replaceChanceJailCard();
            gameWindowController.setLastActionLabel("Player " + currentPlayer.playerNumber + " used the chance get out of jail free card.");
        }else{
            currentPlayer.setChestJailCard(false);
            gameBoard.replaceChestJailCard();
            gameWindowController.setLastActionLabel("Player " + currentPlayer.playerNumber + " used the community chest get out of jail free card.");
        }
        setPhase(TurnPhase.Movement);
    }

    public String handleLand(String description) throws Exception{
        if(currentPlayer.token.currentLocation instanceof Property) {
            Property property = (Property) currentPlayer.token.currentLocation;
            if(property.deed.getOwner() == null) {
                description += "and landed on " + property.name + " which is unowned.";
                gameWindowController.startAskBuyMode(property, currentPlayer);
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
            int currentLocation = gameBoard.getLocation(currentPlayer.token.currentLocation);
            switch (specialTile.type) {
                case Go:
                    description += "and landed on " + currentPlayer.token.currentLocation.name + " and received $200.";
                    break;
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
                    gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(10));
                    currentPlayer.setInJail(true);
                    gameWindowController.setLastActionLabel(description);
                    nextTurn();
                    break;
                case CommunityChest:
                    Card chestCard = gameBoard.getChestCard();
                    gameWindowController.drawChestCard(chestCard);
                    description = handleChest(chestCard);
                    gameWindowController.setLastActionLabel(description);
                    break;
                case Chance:
                    Card chanceCard = gameBoard.getChanceCard();
                    gameWindowController.drawChanceCard(chanceCard);
                    description = handleChance(chanceCard, currentLocation);
                    gameWindowController.setLastActionLabel(description);
                    break;
                case Jail:
                    if (currentPlayer.inJail()){
                        description = "Player " + currentPlayer.playerNumber + " was sent to jail";
                    }else{
                        description += "and landed on " + currentPlayer.token.currentLocation.name + ", just visiting";
                    }
                    break;
                default:
                    description += "and landed on " + currentPlayer.token.currentLocation.name + " which had no effect.";
            }
        } else {
            description += "and landed on " + currentPlayer.token.currentLocation.name + " which had no effect.";
        }
        return description;
    }

    public String handleChest(Card chestCard) throws Exception{
        String description = "";
        switch (chestCard.getCardNum()){
            case 1:
                currentPlayer.giveMoney(200);
                gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(0));
                description = handleLand(description);
                break;
            case 2:
                currentPlayer.giveMoney(200);
                description = "Player " + currentPlayer.playerNumber +  " received $200";
                break;
            case 3:
                currentPlayer.takeMoney(50);
                description = "Player " + currentPlayer.playerNumber +  " lost $50";
                break;
            case 4:
                currentPlayer.giveMoney(45);
                description = "Player " + currentPlayer.playerNumber +  " received $45";
                break;
            case 5:
                gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(10));
                currentPlayer.setInJail(true);
                description = handleLand(description);
                gameWindowController.setLastActionLabel(description);
                nextTurn();
                break;
            case 6:
                int numPlayers = players.size();
                currentPlayer.giveMoney(numPlayers * 50);
                for(int i = 0; i < numPlayers; i++){
                    players.get(i).takeMoney(50);
                }
                description = "Player " + currentPlayer.playerNumber +  " received $" + ((numPlayers - 1) * 50);
                break;
            case 7:
                currentPlayer.giveMoney(100);
                description = "Player " + currentPlayer.playerNumber +  " received $100";
                break;
            case 8:
                currentPlayer.giveMoney(20);
                description = "Player " + currentPlayer.playerNumber +  " received $20";
                break;
            case 9:
                currentPlayer.giveMoney(100);
                description = "Player " + currentPlayer.playerNumber +  " received $100";
                break;
            case 10:
                currentPlayer.takeMoney(100);
                description = "Player " + currentPlayer.playerNumber +  " lost $100";
                break;
            case 11:
                currentPlayer.takeMoney(150);
                description = "Player " + currentPlayer.playerNumber +  " lost $150";
                break;
            case 12:
                currentPlayer.giveMoney(25);
                description = "Player " + currentPlayer.playerNumber +  " received $25";
                break;
            case 13:
                int repairs = 0;
                repairs = currentPlayer.getChestRepairs();
                currentPlayer.takeMoney(repairs);
                description = "Player " + currentPlayer.playerNumber +  " pays " + repairs + " for repairs.";
                break;
            case 14:
                currentPlayer.giveMoney(10);
                description = "Player " + currentPlayer.playerNumber +  " received $10";
                break;
            case 15:
                currentPlayer.giveMoney(100);
                description = "Player " + currentPlayer.playerNumber +  " received $100";
                break;
            case 16:
                currentPlayer.setChestJailCard(true);
                description = "Player " + currentPlayer.playerNumber +  " received a Get Out of Jail Free card";
                break;
            default:
                description = "unknown card";
        }
        return description;
    }

    public String handleChance(Card chanceCard, int currentLocation) throws Exception{
        String description = "";
        switch (chanceCard.getCardNum()){
            case 1:
                currentPlayer.giveMoney(200);
                gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(0));
                description = handleLand(description);
                break;
            case 2:
                currentPlayer.giveMoney(50);
                description = "Player " + currentPlayer.playerNumber +  " received $50";
                break;
            case 3:
                currentLocation -= 3;
                gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                description = handleLand(description);
                break;
            case 4:
                if (currentLocation == 7 || currentLocation == 36){
                    currentLocation = 12;
                    gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                    description = handleLand(description);
                }else{
                    currentLocation = 28;
                    gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                    description = handleLand(description);
                }
                break;
            case 5:
                if (currentLocation == 7){
                    currentLocation = 15;
                    gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                    description = handleLand(description);
                }else if(currentLocation == 22){
                    currentLocation = 25;
                    gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                    description = handleLand(description);
                }
                else{
                    currentLocation = 5;
                    gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                    description = handleLand(description);
                }
                break;
            case 6:
                if (currentLocation == 7){
                    currentLocation = 15;
                    gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                    description = handleLand(description);
                }else if(currentLocation == 22){
                    currentLocation = 25;
                    gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                    description = handleLand(description);
                }
                else{
                    currentLocation = 5;
                    gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                    description = handleLand(description);
                }
                break;
            case 7:
                gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(10));
                currentPlayer.setInJail(true);
                description = handleLand(description);
                gameWindowController.setLastActionLabel(description);
                nextTurn();
                break;
            case 8:
                currentPlayer.takeMoney(15);
                description = "Player " + currentPlayer.playerNumber +  " lost $15";
                break;
            case 9:
                int repairs = 0;
                repairs = currentPlayer.getChanceRepairs();
                currentPlayer.takeMoney(repairs);
                description = "Player " + currentPlayer.playerNumber +  " pays " + repairs + " for repairs.";
                break;
            case 10:
                currentLocation = 5;
                gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                description = handleLand(description);
                break;
            case 11:
                currentLocation = 24;
                gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                description = handleLand(description);
                break;
            case 12:
                currentLocation = 11;
                gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                description = handleLand(description);
                break;
            case 13:
                currentLocation = 39;
                gameWindowController.setTokenLocation(currentPlayer.token, gameBoard.tiles.get(currentLocation));
                description = handleLand(description);
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
                currentPlayer.setChanceJailCard(true);
                description = "Player " + currentPlayer.playerNumber +  " received a Get Out of Jail Free card";
                break;
            default:
                description = "unknown card";
        }
        return description;
    }
}