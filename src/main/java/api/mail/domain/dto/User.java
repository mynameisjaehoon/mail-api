package api.mail.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private Long userId;
    private String name;
    private String email;
    private String password;

}
