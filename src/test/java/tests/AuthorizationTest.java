package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorizationTest {

    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeEach
    void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    void successfulLogin() {
        page.locator("#username").fill("student");
        page.locator("#password").fill("Password123");
        page.locator("#submit").click();

        page.waitForURL("https://practicetestautomation.com/logged-in-successfully/");
        assertTrue(page.url().contains("logged-in-successfully"), 
                "URL не содержит logged-in-successfully");

        assertTrue(page.url().contains("logged-in-successfully"), "Неверный URL");
        assertTrue(page.locator("a.wp-block-button__link").isVisible(), "Кнопка Log out не видна");
    }

    @Test
    void loginWithInvalidUsername() {
        page.locator("#username").fill("incorrectUser");
        page.locator("#password").fill("Password123");
        page.locator("#submit").click();

        page.locator("#error").waitFor();

        assertTrue(page.locator("#error").isVisible(), "Ошибка не появилась");
        assertEquals("Your username is invalid!", page.locator("#error").textContent().trim());
    }

    @Test
    void loginWithInvalidPassword() {
        page.locator("#username").fill("student");
        page.locator("#password").fill("incorrectPassword");
        page.locator("#submit").click();

        page.locator("#error").waitFor();

        assertTrue(page.locator("#error").isVisible(), "Ошибка не появилась");
        assertEquals("Your password is invalid!", page.locator("#error").textContent().trim());
    }

    @AfterEach
    void tearDown() {
        browser.close();
        playwright.close();
    }
}