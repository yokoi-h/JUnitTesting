package parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTest {

	private int x;
	private int y;
	private int expected;
	
	@Parameters(name = "{index}: add {0}+{1}={2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{1,1,2},
				{2,2,4},
				{3,3,6}
		});
	}
	
	public ParameterizedTest(int x, int y, int expected){
		this.x = x;
		this.y = y;
		this.expected = expected;
	}
	
	@Test
	public void test() {
		Calc sut = new Calc();
		int result = sut.add(this.x, this.y);
		assertThat(result, is(expected));
	}
}
