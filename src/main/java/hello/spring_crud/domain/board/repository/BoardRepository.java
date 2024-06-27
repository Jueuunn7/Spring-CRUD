package hello.spring_crud.domain.board.repository;

import hello.spring_crud.domain.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
