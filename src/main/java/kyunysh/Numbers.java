package kyunysh;

import java.util.LinkedList;
import java.util.List;

public class Numbers implements Observable {

	List<Listener> itsObserversList = new LinkedList<Listener>();

	public Numbers() {
		// TODO Auto-generated constructor stub
	}

	public void setNumbers(final int n1, final int n2) {
		for (final Listener someListener : itsObserversList) {
			someListener.notify(n1, n2);
		}
	}

	@Override
	public void addListener(final Listener aListener) {
		itsObserversList.add(aListener);
	}
}
