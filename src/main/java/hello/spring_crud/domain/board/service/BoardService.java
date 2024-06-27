package hello.spring_crud.domain.board.service;

import hello.spring_crud.domain.board.dto.req.BoardReqDTO;
import hello.spring_crud.domain.board.dto.res.BoardByIdResDTO;
import hello.spring_crud.domain.board.dto.res.BoardResDTO;
import hello.spring_crud.domain.board.entity.BoardEntity;
import hello.spring_crud.domain.board.repository.BoardRepository;
import hello.spring_crud.domain.comment.dto.res.CommentByResDTO;
import hello.spring_crud.domain.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<BoardResDTO> getBoardList() {
         return boardRepository.findAll()
                .stream().map(b -> new BoardResDTO(
                        b.getId(),
                        b.getTitle(),
                        b.getContent()
                )).toList();
    }

    public BoardByIdResDTO getBoardById(Long id){
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        List<CommentByResDTO> comment = board.getComments().stream()
                .map(c -> new CommentByResDTO(c.getId(), c.getComment())).toList();

        return new BoardByIdResDTO(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                comment
        );
    }

    public BoardResDTO uploadBoard(BoardReqDTO dto){

        BoardEntity board = boardRepository.save(new BoardEntity(
                dto.getTitle(),
                dto.getContent()
        ));

        return new BoardResDTO(
                board.getId(),
                board.getTitle(),
                board.getContent()
        );
    }

    public BoardResDTO putBoard(Long id, BoardReqDTO dto){
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        board.update(
                dto.getTitle(),
                dto.getContent()
        );
        boardRepository.save(board);

        return new BoardResDTO(
                board.getId(),
                board.getTitle(),
                board.getContent()
        );
    }

    public void deleteBoard(Long id){
        boardRepository.deleteById(id);
    }
}
