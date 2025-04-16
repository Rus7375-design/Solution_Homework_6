import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаём обработчики
        List<SupportHandler> handlers = Arrays.asList(
                new FAQBotHandler(),
                new JuniorSupportHandler(),
                new SeniorSupportHandler()
        );

        // Собираем цепочку динамически
        SupportHandler chain = SupportChainBuilder.buildChain(handlers);

        // Список запросов
        String[] issues = {
                "password_reset",
                "refund_request",
                "account_ban",
                "unknown_bug"
        };

        for (String issue : issues) {
            System.out.println("▶ Обрабатываем запрос: " + issue);
            chain.handle(issue);
            System.out.println();
        }
    }
}
