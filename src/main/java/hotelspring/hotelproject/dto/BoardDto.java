package hotelspring.hotelproject.dto;

import hotelspring.hotelproject.domain.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {

    private Long boardId;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    // dto에서 필요한 부분을 빌더패턴을 통해 entity로 만드는 역할
    public Board toEntity() {
        Board build = Board.builder()
                .boardId(boardId)
                .title(title)
                .writer(writer)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long boardId, String title, String writer, String content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.boardId = boardId;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
