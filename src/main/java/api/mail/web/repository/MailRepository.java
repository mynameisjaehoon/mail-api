package api.mail.web.repository;

import api.mail.domain.dto.Mail;

import java.util.List;
import java.util.Optional;

public interface MailRepository {

    Mail save(Mail mail);

    Optional<Mail> findById(Long id);

    List<Mail> findByUserId(String id);

    void deleteMail(String id);

}
