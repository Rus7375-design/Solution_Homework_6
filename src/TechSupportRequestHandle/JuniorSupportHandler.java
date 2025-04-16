package TechSupportRequestHandle;

import TechSupportRequestHandle.AbstractSupportHandler;

import java.util.Arrays;
import java.util.List;
public class JuniorSupportHandler extends AbstractSupportHandler {

    private final List<String> supportedIssues = Arrays.asList("refund_request", "billing_issue");

    @Override
    public void handle(String issue) {
        logTry("JuniorSupport", issue);
        if (supportedIssues.contains(issue)) {
            System.out.println("[FAQBot] Запрос обработан: " + issue);
        } else {
            System.out.println("[FAQBot] Не удалось обработать запрос: " + issue + " — передаём дальше...");
            passToNext(issue);
        }
    }

}
