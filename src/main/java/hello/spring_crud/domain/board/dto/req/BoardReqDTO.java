package hello.spring_crud.domain.board.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardReqDTO {
    private String title;

    private String content;
}
