package hello.spring_crud.domain.board.controller;

import hello.spring_crud.domain.board.dto.req.BoardReqDTO;
import hello.spring_crud.domain.board.dto.res.BoardByIdResDTO;
import hello.spring_crud.domain.board.dto.res.BoardResDTO;
import hello.spring_crud.domain.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public List<BoardResDTO> getBoardList() {
        return boardService.getBoardList();
    }

    @GetMapping("/{id}")
    public BoardByIdResDTO getBoardById(@PathVariable Long id) {
        return boardService.getBoardById(id);
    }

    @PostMapping("/")
    public BoardResDTO uploadBoard(@RequestBody BoardReqDTO boardUploadReqDTO) {
        return boardService.uploadBoard(boardUploadReqDTO);
    }

    @PutMapping("/{id}")
    public BoardResDTO updateBoard(@RequestBody BoardReqDTO boardUpdateReqDTO
    , @PathVariable Long id) {
        return boardService.putBoard(id, boardUpdateReqDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}
