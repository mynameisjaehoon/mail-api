package api.mail.web.repository;

import api.mail.domain.dto.Mail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * 메일을 메모리 기반으로 저장하는 레포지토리 클래스 입니다.
 */
@Slf4j
@Repository
public class MemoryMailRepository implements MailRepository {

    private static final ConcurrentHashMap<Long, Mail> store = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong(1);

    @Override
    public Mail save(Mail mail) {
        mail.setId(sequence.getAndSet(sequence.get() + 1));
        store.put(mail.getId(), mail);
        return mail;
    }

    /**
     * @param id 메일 id
     * @return 메일 id에 해당하는 메일. 데이터가 없을 수 있다.
     */
    @Override
    public Optional<Mail> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    /**
     * @param id 유저 id
     * @return 유저 id의 회원이 받은 메일(Mail)의 List
     */
    @Override
    public List<Mail> findByUserId(String id) {
        return store.values().stream()
            .filter(mail -> {
                return mail.getReceiver().getUserId().equals(id);
            })
            .collect(Collectors.toList());
    }

    /**
     * 메일을 저장소에서 삭제한다.
     * @param id 메일의 id
     */
    @Override
    public void deleteMail(String id) {
        store.remove(id);
    }
}
