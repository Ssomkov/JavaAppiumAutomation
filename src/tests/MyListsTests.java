package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    @Test
    public void testDeletedArticles() {
        String listName = "test bookmark list";
        String firstSearchValue = "Java";
        String secondSearchValue = "Oracle";
        String firstArticleName = "Java (programming language)";
        String firstArticleDesc = " Object-oriented programming language";
        String secondArticleName = "Oracle Corporation";
        String secondArticleDesc = " American multinational computer technology corporation";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        //поиск 1 статьи
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(firstSearchValue);
        searchPageObject.waitSearchResultsBlockPresent();
        //выбор 1 статьи
        if (Platform.getInstance().isIOS()) {
            searchPageObject.swipeToArticle(firstArticleName + firstArticleDesc);
            searchPageObject.clickArticleTitle(firstArticleName + firstArticleDesc);
        } else {
            searchPageObject.swipeToArticle(firstArticleName);
            searchPageObject.clickArticleTitle(firstArticleName);
        }
        //выбор закладок
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            articlePageObject.clickBookMarkButton();
            //закрытие всплывающего окна
            articlePageObject.clickGotItButton();
            //создание нового списка
            articlePageObject.clickBookMarkMenuCreateNewButton();
            articlePageObject.typeBookMarkCreateListNameField(listName);
            articlePageObject.typeBookMarkCreateListOkButton();
        } else {
            articlePageObject.addArticlesToMySaved();
            PopupObject popupObject = PopupObjectFactory.get(driver);
            popupObject.clickCloseSyncReadingListWindowButton();
        }
        //возврат к результатам поиска
        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.clickReturnToSearchButton();
        if (Platform.getInstance().isAndroid()) {
            //закрытие всплывающего окна
            PopupObject popupObject = PopupObjectFactory.get(driver);
            popupObject.clickSyncReadingListNoThanksButton();
        }
        //поиск 2 статьи
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(secondSearchValue);
        searchPageObject.waitSearchResultsBlockPresent();
        //выбор 2 статьи
        if (Platform.getInstance().isIOS()) {
            searchPageObject.swipeToArticle(firstArticleName + firstArticleDesc);
            searchPageObject.clickArticleTitle(firstArticleName + firstArticleDesc);
        } else {
            searchPageObject.swipeToArticle(firstArticleName);
            searchPageObject.clickArticleTitle(firstArticleName);
        }
        //сохранение 2 статьи в список
        if (Platform.getInstance().isIOS()) {
            articlePageObject.addArticlesToMySaved();
        } else {
            articlePageObject.clickBookMarkButton();
            articlePageObject.clickBookMarkMenuListItemTitle(listName);
        }
        //открытие сохраненного списка
        if (Platform.getInstance().isAndroid()) {
            articlePageObject.clickShowOverflowMenuButton();
            articlePageObject.clickOverflowMenuReadingListsButton();
            PopupObject popupObject = PopupObjectFactory.get(driver);
            popupObject.clickSyncReadingListNoThanksButton();
            MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
            myListsPageObject.clickListItemTitle(listName);
        } else articlePageObject.openSavedArticlesList();
        //удаление статьи
        SavedListPageObject savedListPageObject = SavedListPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            savedListPageObject.deleteArticleBySwipeToLeft(secondArticleName);
        } else {
            savedListPageObject.deleteArticleBySwipeToLeft(secondArticleName + secondArticleDesc);
        }
        //проверка что статья удалена
        if (Platform.getInstance().isAndroid()) {
            savedListPageObject.waitArticleNotPresent(secondArticleName);
        } else savedListPageObject.waitArticleNotPresent(secondArticleName + secondArticleDesc);
        //проверка заголовка оставшейся статьи
        if (Platform.getInstance().isAndroid()) {
            savedListPageObject.clickListItemTitle(firstArticleName);
        } else {
            savedListPageObject.clickListItemTitle(firstArticleName + firstArticleDesc);
        }
        String titleOfFirstArticle = articlePageObject.getValueArticleTitle(firstArticleName);
        assertEquals("Заголовок статьи не совпадает", firstArticleName, titleOfFirstArticle);
    }
}
