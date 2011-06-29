package bowling;

/**
 * ScoreKeeper is responsible for
 *
 * @author skuenzli
 */
public class ScoreKeeper {

	private int score = 0;
	private int[] rollScores = new int[21];
	private int currentRoll = 0;

	public void roll(int pins) {
		rollScores[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;

		int frameIndex = 0;
		for(int frame = 0; frame < 10; frame++){
			if (isStrike(frameIndex)) {
				score += 10 + calculateStrikeBonus(frameIndex);
				frameIndex++;
			} else if (isSpare(frameIndex)) {
				score += 10 + calculateSpareBonus(frameIndex);
				frameIndex += 2;
			} else {
				score += sumOfBallsInFrame(frameIndex);
				frameIndex += 2;
			}
		}

		return score;
	}

	private boolean isStrike(int frameIndex) {
		return rollScores[frameIndex] == 10;
	}

	private int sumOfBallsInFrame(int frameIndex) {
		return rollScores[frameIndex] + rollScores[frameIndex + 1];
	}

	private int calculateSpareBonus(int frameIndex) {
		return rollScores[frameIndex + 2];
	}

	private int calculateStrikeBonus(int frameIndex) {
		return rollScores[frameIndex + 1] + rollScores[frameIndex + 2];
	}

	private boolean isSpare(int frameIndex) {
		return (sumOfBallsInFrame(frameIndex)) == 10;
	}
}
