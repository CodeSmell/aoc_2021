package aoc.day1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SonarSweepTest {

    @Test
    public void test_runTestData() {
        SonarSweep sonarSweep = new SonarSweep();
        List<Integer> sourceList = Arrays.asList(199, 200, 208, 210);
        List<Integer> resultList = sonarSweep.slidingWindow(sourceList, 3);
        assertNotNull(resultList);
        assertEquals(2, resultList.size());
        assertEquals(Integer.valueOf(607), resultList.get(0));
        assertEquals(Integer.valueOf(618), resultList.get(1));
    }
}
