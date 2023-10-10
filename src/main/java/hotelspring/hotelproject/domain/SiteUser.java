package hotelspring.hotelproject.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1. 사용자 아이디
    @Column(unique = true) //값을 중복되게 저장할 수 없음
    private String username;

    // 2. 사용자 비밀 번호
    @Column(nullable = false)
    private String password;

    // 3. 사용자 이메일
    @Column(unique = true)
    private String email;
}
