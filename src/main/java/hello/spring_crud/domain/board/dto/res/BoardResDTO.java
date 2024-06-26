package hello.spring_crud.domain.board.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardResDTO {

    private Long id;

    private String title;

    private String content;
}
