package im.admt.team11.PA3.Game;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class GameSettingsTest {

    @Test
    public void testInitializedArrayList() {
        assertTrue(new GameSettings().players instanceof ArrayList);
    }
}
