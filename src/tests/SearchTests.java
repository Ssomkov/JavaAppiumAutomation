package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    @Test
    public void testValueSearchStringPlaceholderFirstPage() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        assertTrue("Значение плейсхолдера в поле ввода 'Search string' отличается от ожидаемого",
                searchPageObject.getValueSearchInputPlaceholder().contains("Search"));
    }

    @Test
    public void testCancelSearch() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Japan");
        searchPageObject.clickCloseButton();
        searchPageObject.waitSearchResultsBlockNotPresent();
    }
}
