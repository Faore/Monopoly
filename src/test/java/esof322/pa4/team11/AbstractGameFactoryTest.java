package esof322.pa4.team11;

import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class AbstractGameFactoryTest extends ApplicationTest {
    @Test
    public void testStandardThemeFactoryRetrieval() throws NoSuchFieldException, IllegalAccessException {
        Assert.assertTrue(AbstractGameFactory.getFactory(Theme.Standard) instanceof StandardMonopolyGameFactory);
    }

    @Test
    public void testOverwatchThemeFactoryRetrieval() throws NoSuchFieldException, IllegalAccessException {
        Assert.assertTrue(AbstractGameFactory.getFactory(Theme.Overwatch) instanceof OverwatchMonopolyGameFactory);
    }
}