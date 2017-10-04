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
    
    @Test
    public void theSubtractMethodShouldSubtractCoordinatesOfTwoVectors() {
        Vector3D vector1 = new Vector3D(2,4,6);
        Vector3D vector2 = new Vector3D(1,2,3);
        Vector3D newVector = vector1.subtract(vector2);
        assertArrayEquals(new double[]{1,2,3}, new double[]{newVector.x, newVector.y, newVector.z}, 0);
    }
    
    @Test
    public void theNegateMethodShouldGiveSameMagnitudeButOppositeDirection() {
        Vector3D vector1 = new Vector3D(2,4,6);
        vector1 = vector1.negate();
        assertArrayEquals(new double[]{-2,-4,-6}, new double[]{newVector.x, newVector.y, newVector.z}, 0);
    }
	
	@Test
	public void theDotMethodShouldGiveTheDotProductOfTwoVectors() {
		Vector3D vector1 = new Vector3D(6,6,6);
		Vector3D vector2 = new Vector3D(4,2,0);
		double testingDouble = 36;
		double dotProduct = vector1.dot(vector2);
		assertEquals(testingDouble, dotProduct, 0);
	}
	
	@Test
	public void theMagnitudeMethodShouldProvideTheMagnitudeOfAVector() {
		Vector3D vector1 = new Vector3D(2,4,4);
		double testingMagnitude = 6;
		assertEquals(testingMagnitude, vector1.magnitude(), 0);
	}

@Test
public void theToStringMethodShouldGiveOutput(){
	Vector3D vector1 = new Vector3D(6,5,4);
	String testingString = "Coordinates are x: 6.0  y: 5.0  z: 4.0";
	String outputString = vector1.toString();
	assertEquals(testingString , outputString, 0);
	}

@Test
public void theEqualsMethodShouldShowTheTwoVectorsAreEqualOrNot(){
	Vector3D vector1 = new Vector3D(6,2,0);
	Vector3D vector2 = new Vector3D(6,2,1);
	boolean vectorEqualTest = false;
	boolean vectorEqual = vector1.equals(vector2);
	assertEquals(vectorEqualTest, vectorEqual);
	}

}