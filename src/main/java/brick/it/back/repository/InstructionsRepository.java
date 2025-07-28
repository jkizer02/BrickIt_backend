package brick.it.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import  brick.it.back.model.Instructions;

public interface InstructionsRepository  extends JpaRepository<Instructions,Long>{

}
