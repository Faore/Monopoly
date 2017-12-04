package esof322.pa4.team11.Game;

import esof322.pa4.team11.GameSettings;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class GameSettingsTest {

    @Test
    public void testInitializedArrayList() {
        assertTrue(new GameSettings().players instanceof ArrayList);
    }
}
