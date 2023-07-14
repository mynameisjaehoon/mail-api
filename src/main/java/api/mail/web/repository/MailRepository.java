package api.mail.web.repository;

import api.mail.domain.dto.Mail;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public interface MailRepository {

    Mail save(Mail mail);

    Optional<Mail> findById(AtomicLong id);

    List<Mail> findByUserId(String id);

    void deleteMail(String id);

}
