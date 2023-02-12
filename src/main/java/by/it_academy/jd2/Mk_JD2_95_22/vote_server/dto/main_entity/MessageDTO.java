package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity;

import java.time.LocalDateTime;

public class MessageDTO {
    private final LocalDateTime time;
    private final String message;

    public MessageDTO(LocalDateTime time, String message) {
        this.time = time;
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "time=" + time +
                ", message='" + message + '\'' +
                '}';
    }
}
