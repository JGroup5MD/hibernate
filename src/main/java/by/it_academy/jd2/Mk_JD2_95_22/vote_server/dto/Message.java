package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Message {
    private final LocalDateTime time;
    private final String message;

    public Message(LocalDateTime time, String message) {
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
