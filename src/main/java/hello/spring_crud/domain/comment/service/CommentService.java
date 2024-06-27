package hello.spring_crud.domain.comment.service;

import hello.spring_crud.domain.board.entity.BoardEntity;
import hello.spring_crud.domain.board.repository.BoardRepository;
import hello.spring_crud.domain.comment.dto.req.CommentReqDTO;
import hello.spring_crud.domain.comment.dto.res.CommentResDTO;
import hello.spring_crud.domain.comment.entity.CommentEntity;
import hello.spring_crud.domain.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {


    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(BoardRepository boardRepository, CommentRepository commentRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
    }

    public CommentResDTO uploadComment(CommentReqDTO commentReqDTO) {
        CommentEntity comment = new CommentEntity(
                boardRepository.findById(commentReqDTO.getBoard())
                        .orElseThrow(IllegalArgumentException::new),
                commentReqDTO.getComment()
        );

        commentRepository.save(comment);

        return new CommentResDTO(
                comment.getId(),
                comment.getBoard().getId(),
                comment.getComment()
        );
    }
}
