package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    @Test
    public void testArticleTitle() {
        String searchValue = "Java";
        String articleName = "Java (programming language)";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchValue);
        searchPageObject.waitSearchResultsBlockPresent();
        searchPageObject.swipeToArticle(articleName);
        searchPageObject.clickArticleTitle(articleName);

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);

        articlePageObject.checkArticleTitlePresent(articleName);
    }
}
