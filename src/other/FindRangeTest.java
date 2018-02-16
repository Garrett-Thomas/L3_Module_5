package other;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class FindRangeTest {
	private void runTest(List<String> testInput, List<String> expectedLines) {
		// Set up
		final InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream((String.join("\n", testInput) + "\n").getBytes()));
		final PrintStream stdout = System.out;
		final ByteArrayOutputStream capturedStdout = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedStdout));

		// Test
		FindRange.main(new String[0]);
		// Restore stdin/stdout
		System.setIn(stdin);
		System.setOut(stdout);

		// Verify
		final String actualOutput = new String(capturedStdout.toByteArray());
		final List<String> actualLines = Arrays.asList(actualOutput.split("\n"));
		for (final String expectedLine : expectedLines) {
			boolean found = false;
			for (String actualLine : actualLines) {
				if (actualLine.endsWith(expectedLine)) {
					found = true;
					break;
				}
			}
			if (!found) {
				fail("\"" + expectedLine + "\" not printed to the console as expected, actual output:\n"
						+ actualOutput);
			}
		}
	}

	@Test
	public void testBasic() {
		runTest(Arrays.asList(new String[] { "11", "17", "42", "9", "-3", "35", "0" }),
				Arrays.asList(new String[] { "smallest: -3", "largest: 42" }));
	}

	@Test
	public void testOneInput() {
		runTest(Arrays.asList(new String[] { "9999999", "0" }),
				Arrays.asList(new String[] { "smallest: 9999999", "largest: 9999999" }));
	}

	@Test
	public void testEmptyInput() {
		runTest(Arrays.asList(new String[] { "0" }),
				Arrays.asList(new String[] { "Please enter a number other than 0." }));
	}

	@Ignore
	@Test
	public void level0ExtraCreditTestNonNumeric1() {
		runTest(Arrays.asList(new String[] { "11", "17", "42", "9", "this is not a number", "-3", "35", "0" }),
				Arrays.asList(new String[] { "smallest: -3", "largest: 42" }));
	}

	@Ignore
	@Test
	public void level0ExtraCreditTestNonNumeric2() {
		runTest(Arrays.asList(new String[] { "alsonotanumber", "0" }),
				Arrays.asList(new String[] { "Please enter a number other than 0." }));
	}

	@Ignore
	@Test
	public void level1ExtraCreditTestSum1() {
		runTest(Arrays.asList(new String[] { "1", "1", "1", "0" }), Arrays.asList(new String[] { "sum: 3" }));
	}

	@Ignore
	@Test
	public void level1ExtraCreditTestSum2() {
		runTest(Arrays.asList(new String[] { "-2", "-2", "11", "-1", "0" }), Arrays.asList(new String[] { "sum: 6" }));
	}

	@Ignore
	@Test
	public void level1ExtraCreditTestMean1() {
		runTest(Arrays.asList(new String[] { "1", "1", "1", "0" }), Arrays.asList(new String[] { "mean: 1.000" }));
	}

	@Ignore
	@Test
	public void level1ExtraCreditTestMean2() {
		runTest(Arrays.asList(new String[] { "-2", "-2", "11", "-1", "0" }),
				Arrays.asList(new String[] { "mean: 1.500" }));
	}

	@Ignore
	@Test
	public void level1ExtraCreditTestMode1() {
		runTest(Arrays.asList(new String[] { "1", "1", "1", "0" }), Arrays.asList(new String[] { "mode: 1" }));
	}

	@Ignore
	@Test
	public void level1ExtraCreditTestMode2() {
		runTest(Arrays.asList(new String[] { "-2", "-2", "11", "-1", "0" }),
				Arrays.asList(new String[] { "mode: -2" }));
	}
}
