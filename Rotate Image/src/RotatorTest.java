import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RotatorTest {

	@Test
	void testRotation() {
		Rotator r = new Rotator();
		int[][] sampleMatrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[][][] correctResult = {{{7,4,1 },{8,5,2},{9,6,3}},{{1,2,3},{4,5,6},{7,8,9}}};

		try {
			assertTrue(Arrays.deepEquals(correctResult[0], r.rotate(sampleMatrix,0)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertTrue(Arrays.deepEquals(correctResult[1], r.rotate(sampleMatrix,1)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
