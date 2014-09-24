package org.foam.transform.utils.modeling;

import java.util.Iterator;

import org.eclipse.xtext.xbase.lib.Pair;

public class ZippingIterable<T, U> implements Iterable<Pair<T, U>> {

	final private Iterable<U> iterable2;
	final private Iterable<T> iterable1;

	public ZippingIterable(Iterable<T> iterable1, Iterable<U> iterable2) {
		this.iterable1 = iterable1;
		this.iterable2 = iterable2;
	}

	@Override
	public Iterator<Pair<T, U>> iterator() {
		return new Iterator<Pair<T, U>>() {

			final private Iterator<T> iterator1 = iterable1.iterator();
			final private Iterator<U> iterator2 = iterable2.iterator();

			@Override
			public boolean hasNext() {
				return iterator1.hasNext() && iterator2.hasNext();
			}

			@Override
			public Pair<T, U> next() {
				return new Pair<T, U>(iterator1.next(), iterator2.next());
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

}
