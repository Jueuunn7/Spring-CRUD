package hello.spring_crud.domain.comment.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentByResDTO {

    private Long id;

    private String comment;
}
