package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    @Test
    public void testValueSearchStringPlaceholderFirstPage() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        assertTrue("Значение плейсхолдера в поле ввода 'Search string' отличается от ожидаемого",
                searchPageObject.getValueSearchInputPlaceholder().contains("Search"));
    }

    @Test
    public void testCancelSearch() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Japan");
        searchPageObject.clickCloseButton();
        searchPageObject.waitSearchResultsBlockNotPresent();
    }
}
