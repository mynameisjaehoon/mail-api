package api.mail.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Data
@AllArgsConstructor
public class Mail {

    private AtomicLong id;
    private User sender;
    private User receiver;
    private LocalDateTime date;
    private String title;
    private String body;

}
