package esof322.a1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Vector3DTest {

    @Test
    public void instantiatingTheClassShouldCreateAVectorWithPassedValues() {
        Vector3D vector = new Vector3D(234.12, 41.635265, 513.5125);
        assertArrayEquals(new double[]{vector.x, vector.y, vector.z}, new double[]{234.12, 41.635265, 513.5125}, 0);
    }

}