package org.foam.transform.utils.modeling;

import java.util.Iterator;

import org.eclipse.xtext.xbase.lib.Functions.Function2;

public class ZippingWithIterable<T, U, V> implements Iterable<V> {

	final private Iterable<U> iterable2;
	final private Iterable<T> iterable1;
	private Function2<T, U, V> fn;

	public ZippingWithIterable(Iterable<T> iterable1, Iterable<U> iterable2, Function2<T,U,V> fn) {
		this.iterable1 = iterable1;
		this.iterable2 = iterable2;
		this.fn = fn;
	}

	@Override
	public Iterator<V> iterator() {
		return new Iterator<V>() {

			final private Iterator<T> iterator1 = iterable1.iterator();
			final private Iterator<U> iterator2 = iterable2.iterator();

			@Override
			public boolean hasNext() {
				return iterator1.hasNext() && iterator2.hasNext();
			}

			@Override
			public V next() {
				return fn.apply(iterator1.next(), iterator2.next());
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

}
