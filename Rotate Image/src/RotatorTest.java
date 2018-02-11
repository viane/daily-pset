import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RotatorTest {

	@Test
	void test() {
		Rotator r = new Rotator();
		int[][] sampleMatrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] correctResult = {{7,4,1 },{8,5,2},{9,6,3}};
		int[][] rotateImage = r.rotate(sampleMatrix);
		
		
		
		assertTrue(Arrays.deepEquals(correctResult, rotateImage));
	}

}
