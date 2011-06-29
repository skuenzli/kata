package bowling;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * ScoreKeeperTest is responsible for
 *
 * @author skuenzli
 */
public class ScoreKeeperTest {

	private ScoreKeeper scoreKeeper;

	@Before
	public void setUp() throws Exception {
		scoreKeeper = new ScoreKeeper();
	}

	@Test
	public void test_scorekeeper_can_be_created(){
		ScoreKeeper scoreKeeper = new ScoreKeeper();
		assertEquals(0, scoreKeeper.score());
	}

	@Test
	public void test_scorekeeper_accept_score_20_times(){
		rollMany(20, 0);

		assertEquals(0, scoreKeeper.score());
	}

	@Test
	public void test_AllOnes(){
		rollMany(20, 1);

		assertEquals(20, scoreKeeper.score());
	}

	@Test
	public void test_OneSpare() {
		rollSpare();
		scoreKeeper.roll(3);
		rollMany(17, 0);
		assertEquals(16, scoreKeeper.score());
	}

	private void rollSpare() {
		scoreKeeper.roll(5);
		scoreKeeper.roll(5);
	}

	@Test
	public void test_OneStrike() {
		rollStrike();
		scoreKeeper.roll(3);
		scoreKeeper.roll(4);
		rollMany(16, 0);
		assertEquals(24, scoreKeeper.score());
	}

	@Test
	public void test_PerfectGame(){
		rollMany(12, 10);
		assertEquals(300, scoreKeeper.score());
	}

	@Test
	public void test_ManyGutterBalls(){
		rollMany(18, 0);
		rollMany(3, 10);
		assertEquals(30, scoreKeeper.score());
	}

	private void rollStrike() {
		scoreKeeper.roll(10);
	}


	private void rollMany(int numRolls, int pins) {
		for(int i = 0; i < numRolls; i++){
			scoreKeeper.roll(pins);
		}
	}
}
