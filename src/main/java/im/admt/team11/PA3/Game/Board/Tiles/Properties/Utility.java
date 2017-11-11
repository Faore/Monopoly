package im.admt.team11.PA3.Game.Board.Tiles.Properties;

import im.admt.team11.PA3.Game.Board.Card.Deed;
import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Tiles.Property;
import im.admt.team11.PA3.Game.Board.Tiles.TileOrientation;
import javafx.geometry.Point2D;

public class Utility extends Property {
    public Utility(String name, Point2D firstBound, Point2D secondBound, TileOrientation orientation, Deed deed) throws Exception {
        super(name, firstBound, secondBound, orientation, deed);

        double sizeIncrementX = (secondBound.getX() - firstBound.getX()) / 3;
        double sizeIncrementY = (firstBound.getY() - secondBound.getY()) / 3;

        Point2D topLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
        Point2D topRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
        Point2D bottomLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);
        Point2D bottomRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);

        this.tokenSlots = new Point2D[]{topLeft, topRight, bottomLeft, bottomRight};
        this.tokensInSlots = new Token[4];
    }
}