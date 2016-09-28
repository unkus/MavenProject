package kyunysh;

public class PositiveWriter extends NumberWriter implements Listener {

	public PositiveWriter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void notify(final int n1, final int n2) {
		if (n1 > 0 && n2 > 0) {
			writeNumbers(n1, n2, "positiveNumbers.txt");
		}
	}

}
