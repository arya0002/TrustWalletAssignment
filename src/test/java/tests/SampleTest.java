package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateConfirmPasscodePage;
import pages.AppLandingPage;
import pages.CreateWalletPage;
import pages.WalletHomePage;

public class SampleTest extends BaseTest {

    @Test(description = "User will open the app, create and confirm passcode and skip the notification and create secret phrase wallet")
    public void createNewSecretPhraseWalletTest() throws InterruptedException {
        AppLandingPage appLandingPage = new AppLandingPage();
        CreateConfirmPasscodePage createConfirmPasscodePage ;
        CreateWalletPage createWalletPage;
        WalletHomePage walletHomePage;

        createConfirmPasscodePage = appLandingPage.clickCreateNewWallet();
        createConfirmPasscodePage.isCreatePasscodeHeaderVisible();
        createConfirmPasscodePage.fillNewPasscode();
        createConfirmPasscodePage.isConfirmPasscodeHeaderVisible();
        createWalletPage = createConfirmPasscodePage.fillExistingpassode();
        createWalletPage.isNotificationPageHeaderVisible();
        createWalletPage.clickSkipButton();
        createWalletPage.isCreateNewWalletHeaderVisible();
        walletHomePage = createWalletPage.clickSecretPhraseCreateButton();
        walletHomePage.isWalletHeaderVisible();
        String walletname = walletHomePage.getWalletname();
        Assert.assertEquals(walletname,"Main Wallet 1","Wallet name is not correct");

    }
//
//    @Test(description = "Sample description")
//    public void sampleTest1() {
//
//    }


}