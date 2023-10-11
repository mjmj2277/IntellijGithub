package hotelspring.hotelproject.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1. 룸id
    @Column
    private Long roomId;

    // 2. 룸 타입
    @Column(nullable = false)
    private String room_type;

    // 3. 고객 이름
    @Column
    private String name;

    // 4. 고객 이메일
    @Column
    private String email;

    // 5. 어른
    @Column
    private Long adultCount;

    // 6. 어린이
    @Column
    private Long childCount;

    // 7. 전화 번호
    @Column
    private String phoneNum;

    @Column
    private String request;

    // 8. 예약 날짜
    @Column
    private String reservationDate;
}
