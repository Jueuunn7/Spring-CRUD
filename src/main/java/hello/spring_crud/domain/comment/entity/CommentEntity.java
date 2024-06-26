package hello.spring_crud.domain.comment.entity;

import hello.spring_crud.domain.board.entity.BoardEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board")
    private BoardEntity board;

    private String comment;

    public CommentEntity(BoardEntity board, String comment) {
        this.board = board;
        this.comment = comment;
    }
}
