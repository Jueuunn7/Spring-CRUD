package hello.spring_crud.domain.board.dto.res;

import hello.spring_crud.domain.comment.dto.res.CommentByResDTO;
import hello.spring_crud.domain.comment.dto.res.CommentResDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BoardByIdResDTO {
    private Long id;

    private String title;

    private String content;

    private List<CommentByResDTO> comments;
}
