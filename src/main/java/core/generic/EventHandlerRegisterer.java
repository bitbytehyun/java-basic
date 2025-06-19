package core.generic;

import java.util.ArrayList;
import java.util.List;

public class EventHandlerRegisterer {

    public void execute() {
        List<Object> allHandlers = new ArrayList<>();
        allHandlers.add(new ClickHandler());
    }

    // WRITE
    public void registerHandler(List<? super EventHandler> handlers, EventHandler newHandler) {
        handlers.add(newHandler);
    }

    public interface EventHandler {
    }

    public class ClickHandler implements EventHandler {
    }

    public class HoverHandler implements EventHandler {
    }


}
