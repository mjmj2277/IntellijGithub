package hotelspring.hotelproject.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends TimeEntity{

    @Id
    @GeneratedValue
    private Long boardId;

    // 1. 제목
    @Column(length = 100, nullable = false)
    private String title;

    // 2. 작성자
    @Column(length = 10, nullable = false)
    private String writer;

    // 3. 내용
    @Column(columnDefinition = "Text", nullable = false)
    private String content;

//    4. 조회수
//    @Column
//    private Long viewCount;

    @Builder
    public Board(Long boardId, String title, String writer, String content) {
        this.boardId = boardId;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}
