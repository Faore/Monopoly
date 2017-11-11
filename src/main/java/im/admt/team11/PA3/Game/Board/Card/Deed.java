package im.admt.team11.PA3.Game.Board.Card;

import im.admt.team11.PA3.Game.Board.Tiles.Properties.Railroad;
import im.admt.team11.PA3.Game.Board.Tiles.Properties.StandardProperty;
import im.admt.team11.PA3.Game.Board.Tiles.Properties.Utility;
import im.admt.team11.PA3.Game.Board.Tiles.Property;
import im.admt.team11.PA3.Game.Player;

import java.util.ArrayList;
import java.util.Random;

public class Deed {

    public final int printedPrice;
    public final int mortgageValue;
    private final int rent;
    public final boolean canHaveBuildings;
    private final int buildingCost;
    private final int[] buildingRents;
    private Property property;

    public ArrayList<Deed> associatedDeeds;

    public Player currentOwner;

    private int currentBuildingLevel;

    public Deed(int printedPrice) {
        this.printedPrice = printedPrice;
        this.mortgageValue = printedPrice / 2;
        this.rent = -1;
        this.canHaveBuildings = false;
        this.buildingCost = -1;
        this.buildingRents = new int[0];
        this.currentBuildingLevel = -1;
        this.associatedDeeds = new ArrayList<>();
    }

    public Deed(int printedPrice, int rent) {
        this.printedPrice = printedPrice;
        this.mortgageValue = printedPrice / 2;
        this.rent = rent;
        this.canHaveBuildings = false;
        this.buildingCost = -1;
        this.buildingRents = new int[0];
        this.currentBuildingLevel = -1;
        this.associatedDeeds = new ArrayList<>();
    }

    public Deed(int printedPrice, int rent, int buildingCost, int rent1, int rent2, int rent3, int rent4, int rent5) {
        this.printedPrice = printedPrice;
        this.mortgageValue = printedPrice / 2;
        this.rent = rent;
        this.canHaveBuildings = true;
        this.buildingCost = buildingCost;
        this.buildingRents = new int[]{rent1, rent2, rent3, rent4, rent5};
        this.currentBuildingLevel = 0;
        this.associatedDeeds = new ArrayList<>();
    }

    public void associateWithDeed(Deed deed) {
        this.associatedDeeds.add(deed);
        deed.associatedDeeds.add(this);
    }

    public void attachToProperty(Property property) throws Exception {
        if(canHaveBuildings && property.getClass() == StandardProperty.class) {
            this.property = property;
            return;
        }
        if(!canHaveBuildings && rent > -1 && property.getClass() == Railroad.class) {
            this.property = property;
            return;
        }
        if(!canHaveBuildings && rent == -1 && property.getClass() == Utility.class) {
            this.property = property;
            return;
        }

        throw new Exception("Property-deed mismatch.");
    }

    public int getBuildingCost() throws Exception {
        if(!canHaveBuildings) {
            throw new Exception("This deed cannot have buildings.");
        }
        return this.buildingCost;
    }
    //TODO: Rent based on properties owned.
    public int getRent() {
        if(this.currentOwner == null) {
            return 0;
        }
        if(this.rent == -1) {
            for(Deed deed : this.associatedDeeds) {
                if(!(deed.getOwner() == this.currentOwner)) {
                    return (new Random().nextInt(6) + 1)*4;
                }
            }
            //This is a utility.
            return (new Random().nextInt(6) + 1) * 10;
        }

        if(!canHaveBuildings) {
            //This is a railroad.
            int numberOwned = 1;
            for(Deed deed : this.associatedDeeds) {
                if(deed.getOwner() == this.currentOwner) {
                    numberOwned++;
                }
            }
            int rent = this.rent;
            for(int i = 0; i < numberOwned; i++) {
                rent *= 2;
            }
            return rent;
        }

        if(currentBuildingLevel == 0 && canHaveBuildings) {
            return this.rent;
        }
        return this.buildingRents[currentBuildingLevel - 1];
    }

    public void addBuildingLevel() throws Exception {
        if (!canHaveBuildings) {
            throw new Exception("Buildings cannot be built using this deed.");
        }
        if(currentBuildingLevel == 5) {
            throw new Exception("Building already at max level.");
        }
        this.currentBuildingLevel++;
    }

    public Player getOwner() {
        return currentOwner;
    }

    public void setOwner(Player currentOwner) throws Exception {
        if(this.currentOwner == null) {
            this.currentOwner = currentOwner;
            this.currentOwner.deeds.add(this);
        } else {
            throw new Exception("This deed already has an owner.");
        }
    }

    public Property getProperty() {
        return property;
    }
}