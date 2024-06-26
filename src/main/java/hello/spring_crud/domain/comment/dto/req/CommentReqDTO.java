package hello.spring_crud.domain.comment.dto.req;

import com.mysql.cj.log.Log;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentReqDTO {

    private Long board;

    private String comment;
}
