package tests;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    @Test
    public void testDeletedArticles() {
        String listName = "test bookmark list";
        String firstSearchValue = "Java";
        String secondSearchValue = "Oracle";
        String firstArticleName = "Java (programming language)";
        String secondArticleName = "Oracle Corporation";

        SearchPageObject searchPageObject = new SearchPageObject(driver);
        //поиск 1 статьи
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(firstSearchValue);
        searchPageObject.waitSearchResultsBlockPresent();
        //выбор 1 статьи
        searchPageObject.swipeToArticle(firstArticleName);
        searchPageObject.clickArticleTitle(firstArticleName);
        //выбор закладок
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        articlePageObject.clickBookMarkButton();
        //закрытие всплывающего окна
        articlePageObject.clickGotItButton();
        //создание нового списка
        articlePageObject.clickBookMarkMenuCreateNewButton();
        articlePageObject.typeBookMarkCreateListNameField(listName);
        articlePageObject.typeBookMarkCreateListOkButton();
        //возврат к результатам поиска
        NavigationUI navigationUI = new NavigationUI(driver);
        navigationUI.clickReturnToSearchButton();
        //закрытие всплывающего окна
        PopupObject popupObject = new PopupObject(driver);
        popupObject.clickSyncReadingListNoThanksButton();
        //поиск 2 статьи
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(secondSearchValue);
        searchPageObject.waitSearchResultsBlockPresent();
        //выбор 2 статьи
        searchPageObject.swipeToArticle(secondArticleName);
        searchPageObject.clickArticleTitle(secondArticleName);
        //выбор закладок
        articlePageObject.clickBookMarkButton();
        //сохранение 2 статьи в список
        articlePageObject.clickBookMarkMenuListItemTitle(listName);
        //открытие сохраненного списка
        articlePageObject.clickShowOverflowMenuButton();
        articlePageObject.clickOverflowMenuReadingListsButton();
        popupObject.clickSyncReadingListNoThanksButton();
        MyListsPageObject myListsPageObject = new MyListsPageObject(driver);
        myListsPageObject.clickListItemTitle(listName);
        //удаление статьи
        SavedListPageObject savedListPageObject = new SavedListPageObject(driver);
        savedListPageObject.deleteArticleBySwipeToLeft(secondArticleName);
        //проверка что статья удалена
        savedListPageObject.waitArticleNotPresent(secondArticleName);
        //проверка заголовка оставшейся статьи
        savedListPageObject.clickListItemTitle(firstArticleName);
        String titleOfFirstArticle = articlePageObject.getValueArticleTitle(firstArticleName);
        assertEquals("Заголовок статьи не совпадает", firstArticleName, titleOfFirstArticle);
    }
}
