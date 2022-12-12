package event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class EventGame extends ApplicationEvent {
    public EventGame(Object source) {
        super(source);
    }
    public static EventGame of(String title, String details){
        return new EventGame(new EventData(title, details));
    }
}
