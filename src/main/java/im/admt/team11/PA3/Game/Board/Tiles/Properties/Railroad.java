package im.admt.team11.PA3.Game.Board.Tiles.Properties;

import im.admt.team11.PA3.Game.Board.Tiles.Property;
import javafx.geometry.Point2D;

public class Railroad extends Property {
    public Railroad(String name, Point2D firstBound, Point2D secondBound, Point2D[] tokenSlots) {
        super(name, firstBound, secondBound, tokenSlots);
    }
}
