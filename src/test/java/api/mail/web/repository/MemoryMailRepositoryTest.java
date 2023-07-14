package api.mail.web.repository;

import api.mail.domain.dto.Mail;
import api.mail.domain.dto.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class MemoryMailRepositoryTest {

    private static final HashMap<AtomicLong, Mail> store = new HashMap<>();

    @Autowired
    MailRepository mailRepository;

    @BeforeEach
    void setUp() {
        store.clear();
    }

    @Test
    @DisplayName("메일 데이터 저장")
    void saveMailTest() {

        User userA = new User(new AtomicLong(1), "aaa@gmail.com", "userA", "");
        User userB = new User(new AtomicLong(2), "bbb@gmail.com", "userB", "");

        Mail mail = new Mail(null, userA, userB, LocalDateTime.now(), "제목", "본문");
        Mail savedMail = mailRepository.save(mail);

        assertThat(mail).isSameAs(savedMail);
    }

    @Test
    void findById() {

        User userA = new User(new AtomicLong(1), "aaa@gmail.com", "userA", "");
        User userB = new User(new AtomicLong(2), "bbb@gmail.com", "userB", "");

        Mail mail = new Mail(null, userA, userB, LocalDateTime.now(), "제목", "본문");
        Mail savedMail = mailRepository.save(mail);
        Mail findMail = mailRepository.findById(savedMail.getId()).orElse(null);

        assertThat(findMail).isEqualTo(findMail);
    }

    @Test
    void findByUserId() {
    }

    @Test
    void deleteMail() {
    }
}