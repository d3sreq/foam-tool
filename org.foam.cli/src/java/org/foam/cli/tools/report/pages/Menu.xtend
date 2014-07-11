package org.foam.cli.tools.report.pages

import java.util.ArrayList
import java.util.List
import org.foam.transform.utils.sort.NaturalOrderComparator

/**
 * Represents menu.
 */
@Data
class Menu {
	val List<MenuCategory> categories = new ArrayList<MenuCategory>
	
	def printMenu(Page active) '''
		«FOR category : categories»
			«IF !category.menuItems.empty»
				«IF category.name != null»
					<li class="nav-header">«category.name»</li>
				«ENDIF»
				«FOR menuItem : category.menuItems»
					<li«IF menuItem.page == active» class="active"«ENDIF»><a href="«menuItem.relativePath»">«menuItem.label»</a></li>
				«ENDFOR»
			«ENDIF»
		«ENDFOR»
	'''
}

/**
 * Represents grouping of the menu items.
 * 
 * @param name 		text above links in menu or <code>null</code> if no text should be present
 * @param menuItems links in menu  
 */
@Data
class MenuCategory {
	val String name
	val List<MenuItem> menuItems = newArrayList
	
	val naturalOrderComparator = new NaturalOrderComparator
	
	def void sort() {
		menuItems.sortInplace[a, b | naturalOrderComparator.compare(a.label.toString, b.label.toString)]
	}
}

/**
 * Represents single menu item.
 * 
 * @param label 		text used on the link
 * @param relativePath	path to the referenced html page
 */
@Data 
class MenuItem {
	val CharSequence label
	val CharSequence relativePath
	val Page page
}