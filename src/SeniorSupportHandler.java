import java.util.Arrays;
import java.util.List;
public class SeniorSupportHandler extends AbstractSupportHandler {

    private final List<String> supportedIssues = Arrays.asList("account_ban", "data_loss");

    @Override
    public void handle(String issue) {
        if (supportedIssues.contains(issue)) {
            System.out.println("[SeniorSupport] Запрос обработан: " + issue);
        } else {
            System.out.println("[SeniorSupport] Не удалось обработать запрос: " + issue + " — требуется ручная эскалация");
        }
    }
}
