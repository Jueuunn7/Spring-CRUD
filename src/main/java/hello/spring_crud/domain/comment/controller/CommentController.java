package hello.spring_crud.domain.comment.controller;

import hello.spring_crud.domain.comment.dto.req.CommentReqDTO;
import hello.spring_crud.domain.comment.dto.res.CommentResDTO;
import hello.spring_crud.domain.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/")
    public ResponseEntity<CommentResDTO> uploadComment(@RequestBody CommentReqDTO commentReqDTO) {
        return new ResponseEntity<>(commentService.uploadComment(commentReqDTO), HttpStatus.OK);
    }
}
