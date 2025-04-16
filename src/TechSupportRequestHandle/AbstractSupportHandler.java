package TechSupportRequestHandle;

public abstract class AbstractSupportHandler implements SupportHandler {
    protected SupportHandler next;

    @Override
    public SupportHandler setNext(SupportHandler handler) {
        this.next = handler;
        return handler;
    }

    protected void passToNext(String issue) {
        if (next != null) {
            next.handle(issue);
        } else {
            System.out.println("[Система] Нет обработчика для запроса: " + issue);
        }
    }

    protected void logTry(String handlerName, String issue) {
        System.out.println("⏳ [" + handlerName + "] Пытается обработать: " + issue);
    }
}
