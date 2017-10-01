package esof322.a1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class Vector3DTest {

    @Test
    public void instantiatingTheClassShouldCreateAVectorWithPassedValues() {
        Vector3D vector = new Vector3D(234.12, 41.635265, 513.5125);
        assertArrayEquals(new double[]{vector.x, vector.y, vector.z}, new double[]{234.12, 41.635265, 513.5125}, 0);
    }

    @Test
    public void theScaleMethodShouldProperlyScaleByACommonFactor() {
        Vector3D vector = new Vector3D(1,2,4);
        Vector3D newVector = vector.scale(2);
        assertArrayEquals(new double[]{2,4,8}, new double[]{newVector.x, newVector.y, newVector.z}, 0);
    }

    @Test
    public void theAddMethodShouldAddCoordinatesOfTwoVectors() {
        Vector3D vector1 = new Vector3D(1,2,4);
        Vector3D vector2 = new Vector3D(1,2,4);
        Vector3D newVector = vector1.add(vector2);
        assertArrayEquals(new double[]{2,4,8}, new double[]{newVector.x, newVector.y, newVector.z}, 0);
    }
}