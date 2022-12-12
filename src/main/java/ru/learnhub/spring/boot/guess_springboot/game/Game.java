package game;

import event.EventData;
import event.EventGame;
import org.springframework.context.ApplicationListener;

public class Game implements ApplicationListener<EventGame> {
    private int value = 0;
    private int min = 0;
    private int max = 1000;
    public String code="greeting";

    public Game() {
        value = (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public int getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    @Override
    public void onApplicationEvent(EventGame event) {
        EventData data = (EventData) event.getSource();
        if (Integer.decode(data.getDetails()) > value) {
            code = "less";
        } else if (Integer.decode(data.getDetails()) < value) {
            code = "more";
        } else {
            code = "exact";
        }
    }
}