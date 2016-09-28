package kyunysh;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public abstract class NumberWriter {

	public void writeNumbers(final int n1, final int n2, final String aFileName) {
		try {
			final File file = new File(aFileName);
			final FileWriter fw = new FileWriter(file, true);
			final BufferedWriter bw = new BufferedWriter(fw);
			bw.write(String.valueOf(n1));
			bw.write(",");
			bw.write(String.valueOf(n2));
			bw.write("\n");
			bw.flush();
			bw.close();
		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
