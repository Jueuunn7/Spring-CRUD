package hello.spring_crud.domain.comment.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentResDTO {

    private Long id;

    private Long board;

    private String comment;;
}
