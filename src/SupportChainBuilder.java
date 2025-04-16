import java.util.List;
public class SupportChainBuilder {

    public static SupportHandler buildChain(List<SupportHandler> handlers) {
        if (handlers == null || handlers.isEmpty()) {
            return null;
        }

        SupportHandler head = handlers.get(0);
        SupportHandler current = head;

        for (int i = 1; i < handlers.size(); i++) {
            current = current.setNext(handlers.get(i));
        }

        return head;
    }
}
