import java.util.Arrays;
import java.util.List;
public class JuniorSupportHandler extends AbstractSupportHandler {

    private final List<String> supportedIssues = Arrays.asList("refund_request", "billing_issue");

    @Override
    public void handle(String issue) {
        if (supportedIssues.contains(issue)) {
            System.out.println("[JuniorSupport] Запрос обработан: " + issue);
        } else {
            System.out.println("[JuniorSupport] Не удалось обработать запрос: " + issue + " — передаём дальше...");
            passToNext(issue);
        }
    }
}
