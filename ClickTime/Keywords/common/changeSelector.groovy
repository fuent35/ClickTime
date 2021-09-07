package common

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObject

public class changeSelector {

	@Keyword
	public void setNewWelcomeSelector(TestObject testObject, String newValue) {
		testObject.setSelectorValue(SelectorMethod.XPATH, "//*/text()[normalize-space(.)='Welcome to WordGame " + newValue +"!']/parent::*");
	}

	@Keyword
	public void setNewCategorySelector(TestObject testObject, String newValue) {
		testObject.setSelectorValue(SelectorMethod.XPATH, "//*/text()[normalize-space(.)='You've currently chosen the " + newValue +"category.']/parent::*");
	}

	@Keyword
	public void setNewCharSelector(TestObject testObject, String newValue) {
		System.out.println("New Char: " + newValue);
		testObject.setSelectorValue(SelectorMethod.XPATH, "//*/text()[normalize-space(.)='" + newValue + "']/parent::**");
		
		
	}
}
