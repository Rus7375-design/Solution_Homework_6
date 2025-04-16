package TechSupportRequestHandle;

import TechSupportRequestHandle.AbstractSupportHandler;

import java.util.Arrays;
import java.util.List;

public class FAQBotHandler extends AbstractSupportHandler {

    private final List<String> supportedIssues = Arrays.asList("password_reset", "how_to_login");

    @Override
    public void handle(String issue) {
        logTry("FAQBot", issue);
        if (supportedIssues.contains(issue)) {
            System.out.println("[FAQBot] Запрос обработан: " + issue);
        } else {
            System.out.println("[FAQBot] Не удалось обработать запрос: " + issue + " — передаём дальше...");
            passToNext(issue);
        }
    }
}
