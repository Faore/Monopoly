package im.admt.team11.PA3.Game.Board.Tiles.Properties;

import im.admt.team11.PA3.Game.Board.Tiles.Property;
import javafx.geometry.Point2D;

public class StandardProperty extends Property {
    public StandardProperty(String name, Point2D firstBound, Point2D secondBound, Point2D[] tokenSlots, Point2D building1, Point2D building2, Point2D building3, Point2D building4) {
        super(name, firstBound, secondBound, tokenSlots);
    }
}
