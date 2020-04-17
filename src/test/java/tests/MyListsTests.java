package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Assert;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    private static final String
            login = "Hairbaton",
            password = "KQ.gvZ2T6-Cm!VG";

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

        if (Platform.getInstance().isMW()) {

            articlePageObject.addArticlesToMySaved();

            AuthorizationPageObject authorizationPageObject = new AuthorizationPageObject(driver);
            authorizationPageObject.clickAuthButton();
            authorizationPageObject.enterLoginData(login, password);
            authorizationPageObject.submitForm();

            articlePageObject.checkArticleTitlePresent(firstArticleName);

            Assert.assertEquals("Не на той же странице после авторизации", firstArticleName, articlePageObject.getValueArticleTitle(firstArticleName));
        }


        if (Platform.getInstance().isAndroid()) {
            articlePageObject.clickBookMarkButton();
            //закрытие всплывающего окна
            articlePageObject.clickGotItButton();
            //создание нового списка
            articlePageObject.clickBookMarkMenuCreateNewButton();
            articlePageObject.typeBookMarkCreateListNameField(listName);
            articlePageObject.typeBookMarkCreateListOkButton();
        } else if (Platform.getInstance().isIOS()) {
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
            searchPageObject.swipeToArticle(secondArticleName + secondArticleDesc);
            searchPageObject.clickArticleTitle(secondArticleName + secondArticleDesc);
        } else {
            searchPageObject.swipeToArticle(secondArticleName);
            searchPageObject.clickArticleTitle(secondArticleName);
        }
        //сохранение 2 статьи в список
        if (Platform.getInstance().isIOS()) {
            articlePageObject.addArticlesToMySaved();
        } else if (Platform.getInstance().isAndroid()) {
            articlePageObject.clickBookMarkButton();
            articlePageObject.clickBookMarkMenuListItemTitle(listName);
        }
        articlePageObject.addArticlesToMySaved();
        //открытие сохраненного списка
        if (Platform.getInstance().isAndroid()) {
            articlePageObject.clickShowOverflowMenuButton();
            articlePageObject.clickOverflowMenuReadingListsButton();
            PopupObject popupObject = PopupObjectFactory.get(driver);
            popupObject.clickSyncReadingListNoThanksButton();
            MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
            myListsPageObject.clickListItemTitle(listName);
        } else if (Platform.getInstance().isIOS()) {
            articlePageObject.openSavedArticlesList();
        }
        navigationUI.openNavigation();
        navigationUI.clickMyLists();
        //удаление статьи
        SavedListPageObject savedListPageObject = SavedListPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            savedListPageObject.deleteArticleBySwipeToLeft(secondArticleName);
        } else if (Platform.getInstance().isIOS()) {
            savedListPageObject.deleteArticleBySwipeToLeft(secondArticleName + secondArticleDesc);
        }
        savedListPageObject.deleteArticleByButton();
        //проверка что статья удалена
        if (Platform.getInstance().isAndroid()) {
            savedListPageObject.waitArticleNotPresent(secondArticleName);
        } else if (Platform.getInstance().isAndroid()) {
            savedListPageObject.waitArticleNotPresent(secondArticleName + secondArticleDesc);
        }
        savedListPageObject.waitArticleNotPresent(secondArticleName);
        //проверка заголовка оставшейся статьи
        if (Platform.getInstance().isAndroid()) {
            savedListPageObject.clickListItemTitle(firstArticleName);
        } else if (Platform.getInstance().isIOS()) {
            savedListPageObject.clickListItemTitle(firstArticleName + firstArticleDesc);
        }

        savedListPageObject.clickListItemTitle(firstArticleName);

        String titleOfFirstArticle = articlePageObject.getValueArticleTitle(firstArticleName);
        assertEquals("Заголовок статьи не совпадает", firstArticleName, titleOfFirstArticle);
    }
}
