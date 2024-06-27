package hello.spring_crud.domain.board.controller;

import hello.spring_crud.domain.board.dto.req.BoardReqDTO;
import hello.spring_crud.domain.board.dto.res.BoardByIdResDTO;
import hello.spring_crud.domain.board.dto.res.BoardResDTO;
import hello.spring_crud.domain.board.service.BoardService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public ResponseEntity<List<BoardResDTO>> getBoardList() {
        return new ResponseEntity<>(boardService.getBoardList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardByIdResDTO> getBoardById(@PathVariable Long id) {
        return new ResponseEntity<>(boardService.getBoardById(id)
                , HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<BoardResDTO> uploadBoard(@RequestBody BoardReqDTO boardUploadReqDTO) {
        return new ResponseEntity<>(boardService.uploadBoard(boardUploadReqDTO)
        , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardResDTO> updateBoard(@RequestBody BoardReqDTO boardUpdateReqDTO
    , @PathVariable Long id) {
        return new ResponseEntity<>(boardService.putBoard(id, boardUpdateReqDTO)
        , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
