package api.mail.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
@AllArgsConstructor
public class User {

    private AtomicLong userId;
    private String name;
    private String email;
    private String password;

}
