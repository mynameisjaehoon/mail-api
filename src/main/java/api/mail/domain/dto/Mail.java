package api.mail.domain.dto;


import lombok.Data;

@Data
public class Mail {

    private String sender;
    private String receiver;
    private String title;
    private String body;

}
