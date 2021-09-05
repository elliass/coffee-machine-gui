package coffeemachine.view;

import javafx.event.Event;
import javafx.event.EventType;

public class CustomEvent extends Event {

    public CustomEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public static final EventType<CustomEvent> GO_TO_OVERVIEW_SCENE =
            new EventType<>("GO_TO_OVERVIEW_SCENE");

    public static final EventType<CustomEvent> GO_TO_PREPARATION_SCENE =
            new EventType<>("GO_TO_PREPARATION_SCENE");

    public static final EventType<CustomEvent> GO_TO_MAINTENANCE_SCENE =
            new EventType<>("GO_TO_MAINTENANCE_SCENE");

    public static final EventType<CustomEvent> GO_TO_ISSUE_SCENE =
            new EventType<>("GO_TO_ISSUE_SCENE");

    public static final EventType<CustomEvent> GO_TO_FAVORITE_SCENE =
            new EventType<>("GO_TO_FAVORITE_SCENE");

    public static final EventType<CustomEvent> GO_TO_SECURITY_SCENE =
            new EventType<>("GO_TO_SECURITY_SCENE");
}
