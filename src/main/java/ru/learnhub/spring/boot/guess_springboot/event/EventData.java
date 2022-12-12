package event;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class EventData {
    private final String title;
    private final String details;
    private final LocalDateTime createdAt;
    public EventData(String title, String details) {
        this.title = title;
        this.details = details;
        this.createdAt=LocalDateTime.now();
    }

    public String getDetails() {
        return details;
    }
}
