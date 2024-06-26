package hello.spring_crud.domain.comment.controller;

import hello.spring_crud.domain.comment.dto.req.CommentReqDTO;
import hello.spring_crud.domain.comment.dto.res.CommentResDTO;
import hello.spring_crud.domain.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/")
    public CommentResDTO uploadComment(@RequestBody CommentReqDTO commentReqDTO) {
        return commentService.uploadComment(commentReqDTO);
    }
}
