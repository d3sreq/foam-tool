package org.foam.transform.ucm2ucm

import com.google.common.collect.Multimap
import com.google.common.collect.HashMultimap

abstract class Annot {
	final private Multimap<Class<? extends Annot>, Annot> annotations = HashMultimap.create

	def final Iterable<Class<? extends Annot>> getAnnotationTypes() {
		annotations.keys
	}

	def final <T extends Annot> Iterable<T> getAnnotationsOfType(Class<T> type) {
		annotations.get(type as Class<? extends Annot>) as Iterable<T>
	}

	def final void addAnnotation(Annot annot) {
		annotations.put(annot.class, annot)
	}

	/**
	    * Convenience function for Xtend-based programs.
	    * Usage: import static extension nicknames.Annot.*
	    */
	def final static void +=(Annot where, Annot what) {
		where.addAnnotation(what)
	}

	def final static void +=(Annot where, Iterable<? extends Annot> what) {
		what.forEach[where += it]
	}

	/**
        * Convenience function for Xtend-based programs.
        * Usage: import static extension nicknames.Annot.*
        */
	def final static <T extends Annot> Iterable<T> >>>(Annot src, Class<T> type) {
		src.getAnnotationsOfType(type)
	}
}
