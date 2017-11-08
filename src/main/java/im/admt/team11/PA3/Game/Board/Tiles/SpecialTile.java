package im.admt.team11.PA3.Game.Board.Tiles;

import im.admt.team11.PA3.Game.Board.Pieces.Token;
import im.admt.team11.PA3.Game.Board.Tile;

import javafx.geometry.Point2D;

public class SpecialTile extends Tile {
    public final SpecialTileTypes type;

    public SpecialTile(String name, Point2D firstBound, Point2D secondBound, TileOrientation orientation, SpecialTileTypes type) {
        super(name, firstBound, secondBound, orientation);
        this.type = type;

        double sizeIncrementX = 0;
        double sizeIncrementY = 0;
        Point2D topLeft = null;
        Point2D topRight = null;
        Point2D bottomLeft = null;
        Point2D bottomRight = null;

        switch (type) {
            case Go:
            case GoToJail:
            case FreeParking:
            case Chance:
            case IncomeTax:
            case LuxuryTax:
            case CommunityChest:
                sizeIncrementX = (secondBound.getX() - firstBound.getX()) / 3;
                sizeIncrementY = (firstBound.getY() - secondBound.getY()) / 3;

                topLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                topRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                bottomLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);
                bottomRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);
                break;
            case Jail:
                //TODO: Adjust for Jail's jail and just visiting sides. This is here to keep everything from breaking when someone adds the jail to the BoardBuilder.
                sizeIncrementX = (secondBound.getX() - firstBound.getX()) / 3;
                sizeIncrementY = (firstBound.getY() - secondBound.getY()) / 3;

                topLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                topRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + sizeIncrementY - tokenOffsetY);
                bottomLeft = new Point2D(firstBound.getX() + sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);
                bottomRight = new Point2D(firstBound.getX() + 2 * sizeIncrementX - tokenOffsetX, secondBound.getY() + 2 * sizeIncrementY - tokenOffsetY);
                break;
        }
        this.tokenSlots = new Point2D[]{topLeft, topRight, bottomLeft, bottomRight};
        this.tokensInSlots = new Token[4];
    }
}
