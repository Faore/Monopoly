package esof322.pa4.team11.Game.Board.Tiles.Properties;

import esof322.pa4.team11.Game.Board.Pieces.Token;
import esof322.pa4.team11.Game.Util.TokenMap;
import esof322.pa4.team11.Game.Board.Card.Deed;
import esof322.pa4.team11.Game.Board.Pieces.TokenTypes;
import esof322.pa4.team11.Game.Board.Tiles.Property;
import esof322.pa4.team11.Game.Board.Tiles.TileOrientation;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;

public class StandardProperty extends Property {

    public static final int buildingSlotMiddleOffset = 110/2 - buildingOffset;
    public static final int buildingSlotOffset = 117;
    public Point2D[] buildingSlots;
    public Button[] buildingsInSlots;

    public StandardProperty(String name, Point2D firstBound, Point2D secondBound, TileOrientation orientation, Deed deed) throws Exception {
        super(name, firstBound, secondBound, orientation, deed);

        double sizeIncrementX = 0;
        double sizeIncrementY = 0;
        Point2D topLeft = null;
        Point2D topRight = null;
        Point2D bottomLeft = null;
        Point2D bottomRight = null;

        Point2D b1 = null;
        Point2D b2 = null;
        Point2D b3 = null;
        Point2D b4 = null;

        //Bounds defined by first: bottom left, second: top right
        switch (orientation) {
            case Bottom:
                sizeIncrementX = (secondBound.getX() - firstBound.getX()) / 3;
                sizeIncrementY = (firstBound.getY() - secondBound.getY() - buildingSlotOffset) / 3;

                topLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + buildingSlotOffset + sizeIncrementY - tokenOffsetY);
                topRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + buildingSlotOffset + sizeIncrementY - tokenOffsetY);
                bottomLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + buildingSlotOffset + 2 * sizeIncrementY - tokenOffsetY);
                bottomRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + buildingSlotOffset + 2 * sizeIncrementY - tokenOffsetY);

                sizeIncrementX = (secondBound.getX() - firstBound.getX()) / 5;
                b1 = new Point2D(firstBound.getX() + sizeIncrementX - buildingOffset, secondBound.getY() + buildingSlotMiddleOffset);
                b2 = new Point2D(firstBound.getX() + 2*sizeIncrementX - buildingOffset, secondBound.getY() + buildingSlotMiddleOffset);
                b3 = new Point2D(firstBound.getX() + 3*sizeIncrementX - buildingOffset, secondBound.getY() + buildingSlotMiddleOffset);
                b4 = new Point2D(firstBound.getX() + 4*sizeIncrementX - buildingOffset, secondBound.getY() + buildingSlotMiddleOffset);

                break;
            case Top:
                sizeIncrementX = (secondBound.getX() - firstBound.getX()) / 3;
                sizeIncrementY = (firstBound.getY() - secondBound.getY() - buildingSlotOffset) / 3;

                topLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                topRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                bottomLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);
                bottomRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);

                sizeIncrementX = (secondBound.getX() - firstBound.getX()) / 5;
                b1 = new Point2D(firstBound.getX() + sizeIncrementX - buildingOffset, firstBound.getY() - 2*buildingSlotMiddleOffset);
                b2 = new Point2D(firstBound.getX() + 2*sizeIncrementX - buildingOffset, firstBound.getY() - 2*buildingSlotMiddleOffset);
                b3 = new Point2D(firstBound.getX() + 3*sizeIncrementX - buildingOffset, firstBound.getY() - 2*buildingSlotMiddleOffset);
                b4 = new Point2D(firstBound.getX() + 4*sizeIncrementX - buildingOffset, firstBound.getY() - 2*buildingSlotMiddleOffset);

                break;
            case Left:
                sizeIncrementX = (secondBound.getX() - firstBound.getX() - buildingSlotOffset) / 3;
                sizeIncrementY = (firstBound.getY() - secondBound.getY()) / 3;

                topLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                topRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                bottomLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);
                bottomRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);

                sizeIncrementY = (secondBound.getY() - firstBound.getY()) / 5;
                b1 = new Point2D(secondBound.getX() - 2*buildingSlotMiddleOffset, firstBound.getY() + sizeIncrementY - buildingOffset);
                b2 = new Point2D(secondBound.getX() - 2*buildingSlotMiddleOffset, firstBound.getY() + 2*sizeIncrementY - buildingOffset);
                b3 = new Point2D(secondBound.getX() - 2*buildingSlotMiddleOffset, firstBound.getY() + 3*sizeIncrementY - buildingOffset);
                b4 = new Point2D(secondBound.getX() - 2*buildingSlotMiddleOffset, firstBound.getY() + 4*sizeIncrementY - buildingOffset);

                break;
            case Right:
                sizeIncrementX = (secondBound.getX() - firstBound.getX() - buildingSlotOffset) / 3;
                sizeIncrementY = (firstBound.getY() - secondBound.getY()) / 3;

                topLeft = new Point2D(firstBound.getX() + buildingSlotOffset + sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                topRight = new Point2D(firstBound.getX() + buildingSlotOffset + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                bottomLeft = new Point2D(firstBound.getX() + buildingSlotOffset + sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);
                bottomRight = new Point2D(firstBound.getX() + buildingSlotOffset + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);

                sizeIncrementY = (secondBound.getY() - firstBound.getY()) / 5;
                b1 = new Point2D(firstBound.getX() + buildingSlotMiddleOffset, secondBound.getY() - sizeIncrementY - buildingOffset);
                b2 = new Point2D(firstBound.getX() + buildingSlotMiddleOffset, secondBound.getY() - 2*sizeIncrementY - buildingOffset);
                b3 = new Point2D(firstBound.getX() + buildingSlotMiddleOffset, secondBound.getY() - 3*sizeIncrementY - buildingOffset);
                b4 = new Point2D(firstBound.getX() + buildingSlotMiddleOffset, secondBound.getY() - 4*sizeIncrementY - buildingOffset);

                break;
        }

        this.tokenSlots = new Point2D[]{topLeft, topRight, bottomLeft, bottomRight};
        this.tokensInSlots = new Token[4];
        this.buildingSlots = new Point2D[]{b1, b2, b3, b4};
        this.buildingsInSlots = new Button[4];
    }

    public static Button generateHouse(TokenTypes tokenType) {
        Button button = new Button();
        button.setStyle("-fx-graphic: url('" + TokenMap.getHouseMap().get(tokenType) +"'); -fx-background-color: transparent;");
        return button;
    }

    public static Button generateHotel(TokenTypes tokenType) {
        Button button = new Button();
        button.setStyle("-fx-graphic: url('" + TokenMap.getHotelMap().get(tokenType) +"'); -fx-background-color: transparent;");
        return button;
    }
}
