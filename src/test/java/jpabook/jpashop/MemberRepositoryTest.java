package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() throws Exception{

        Member member = new Member();
        member.setUsername("memberA");

        Long saveId = memberRepository.save(member);
        Member memberA = memberRepository.find(saveId);

        Assertions.assertThat(memberA.getId()).isEqualTo(member.getId());
        Assertions.assertThat(memberA.getUsername()).isEqualTo(member.getUsername());
    }

}