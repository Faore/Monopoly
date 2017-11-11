package im.admt.team11.PA3.Game.Board.Tiles.Properties;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Tiles.Property;
import im.admt.team11.PA3.Game.Board.Tiles.TileOrientation;
import javafx.geometry.Point2D;

public class StandardProperty extends Property {

    public static final int buildingSlotSize = 110;
    public static final int buildingSlotOffset = 117;

    public StandardProperty(String name, Point2D firstBound, Point2D secondBound, TileOrientation orientation, Deed deed) throws Exception {
        super(name, firstBound, secondBound, orientation, deed);

        double sizeIncrementX = 0;
        double sizeIncrementY = 0;
        Point2D topLeft = null;
        Point2D topRight = null;
        Point2D bottomLeft = null;
        Point2D bottomRight = null;

        switch (orientation) {
            case Bottom:
                sizeIncrementX = (secondBound.getX() - firstBound.getX()) / 3;
                sizeIncrementY = (firstBound.getY() - secondBound.getY() - buildingSlotOffset) / 3;

                topLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + buildingSlotOffset + sizeIncrementY - tokenOffsetY);
                topRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + buildingSlotOffset + sizeIncrementY - tokenOffsetY);
                bottomLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + buildingSlotOffset + 2 * sizeIncrementY - tokenOffsetY);
                bottomRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + buildingSlotOffset + 2 * sizeIncrementY - tokenOffsetY);
                break;
            case Top:
                sizeIncrementX = (secondBound.getX() - firstBound.getX()) / 3;
                sizeIncrementY = (firstBound.getY() - secondBound.getY() - buildingSlotOffset) / 3;

                topLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() - buildingSlotOffset + sizeIncrementY - tokenOffsetY);
                topRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() - buildingSlotOffset + sizeIncrementY - tokenOffsetY);
                bottomLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() - buildingSlotOffset + 2 * sizeIncrementY - tokenOffsetY);
                bottomRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() - buildingSlotOffset + 2 * sizeIncrementY - tokenOffsetY);
                break;
            case Left:
                sizeIncrementX = (secondBound.getX() - firstBound.getX() - buildingSlotOffset) / 3;
                sizeIncrementY = (firstBound.getY() - secondBound.getY()) / 3;

                topLeft = new Point2D(firstBound.getX() - buildingSlotOffset + sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                topRight = new Point2D(firstBound.getX() - buildingSlotOffset + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                bottomLeft = new Point2D(firstBound.getX() - buildingSlotOffset + sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);
                bottomRight = new Point2D(firstBound.getX() - buildingSlotOffset + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);
                break;
            case Right:
                sizeIncrementX = (secondBound.getX() - firstBound.getX() - buildingSlotOffset) / 3;
                sizeIncrementY = (firstBound.getY() - secondBound.getY()) / 3;

                topLeft = new Point2D(firstBound.getX() + buildingSlotOffset + sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                topRight = new Point2D(firstBound.getX() + buildingSlotOffset + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                bottomLeft = new Point2D(firstBound.getX() + buildingSlotOffset + sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);
                bottomRight = new Point2D(firstBound.getX() + buildingSlotOffset + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);
                break;
        }

        this.tokenSlots = new Point2D[]{topLeft, topRight, bottomLeft, bottomRight};
        this.tokensInSlots = new Token[4];
    }
}
