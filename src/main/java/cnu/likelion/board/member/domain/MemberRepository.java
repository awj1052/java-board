package cnu.likelion.board.member.domain;

import cnu.likelion.board.member.domain.Member;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    private final Map<Long, Member> members = new HashMap<>();
    private Long sequence = 1L;

    public Member save(Member member) {
        member.setId(sequence++);
        members.put(member.getId(), member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(members.get(id));
    }

    public Optional<Member> findByUsername(String username) {
        return members.values()
                .stream()
                .filter(value -> value.getUsername().equals(username))
                .findAny();
    }

    // for test
    public void clear() {
        this.members.clear();
    }
}
