package interview.programs.first;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class DiskspaceTest {

	@Test
	public void test1() {
		assertTrue(DiskSpace.isWritable(1, 1, new HashSet<>()));
	}

	@Test
	public void test2() {
		assertFalse(DiskSpace.isWritable(1, 1, new HashSet<>(Arrays.asList(1))));
	}

	@Test
	public void test3() {
		assertTrue(DiskSpace.isWritable(4, 2, new HashSet<>(Arrays.asList(1, 4))));
	}

	@Test
	public void test4() {
		assertFalse(DiskSpace.isWritable(1000000, 100001,

				new HashSet<>(Arrays.asList(100000, 200000, 300000,
						400000, 500000, 600000, 700000, 800000, 900000))));
	}


	@Test
	public void test5() {
		assertTrue(DiskSpace.isWritable(1000000, 100001,

				new HashSet<>(Arrays.asList(100000, 200000, 300000,
						700000, 800000, 900000))));
	}

	@Ignore
	@Test
	public void test6() {

		List<Integer> l = IntStream.range(0, 99998).boxed().collect(Collectors.toList());

		assertFalse(DiskSpace.isWritable(1000000, 11,

				new HashSet<>(l)));
	}
}
