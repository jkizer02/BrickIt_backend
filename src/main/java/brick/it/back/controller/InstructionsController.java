package brick.it.back.controller;

import java.util.Collections;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; // needed for sorting list of users by ID
import org.springframework.web.bind.annotation.*;

import brick.it.back.exception.InstructionNotFoundException;
import brick.it.back.model.Instructions;
import brick.it.back.repository.InstructionsRepository;

@RestController
@CrossOrigin("http://localhost:5173")
public class InstructionsController {

	@Autowired
	private InstructionsRepository userRepository;

	// Stub: Always throws UnsupportedOperationException (Test should fail
	// initially)
	@PostMapping("/instruction")
	 Instructions newInstruction(@RequestBody Instructions newUser) {
		return userRepository.save(newUser);
	}

	// Stub: Returns an empty list (Test should fail if expecting actual users)
	@GetMapping("/models")
	List<Instructions> getAllInstructions() {
		return userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	
	@GetMapping("/Instruction/{id}")
	 Instructions getInstructionById(@PathVariable Long id) {
		return userRepository.findById(id)
				.orElseThrow(()->new InstructionNotFoundException(id));
	}

	
	@PutMapping("/Instruction/{id}")
	Instructions updateUser(@RequestBody Instructions newUser, @PathVariable Long id) {
		return userRepository.findById(id)
				.map(
						Instruction -> {
							Instruction.setUsername(newUser.getUsername());
							Instruction.setDescription(newUser.getDescription());
							Instruction.setTitle(newUser.getTitle());
							Instruction.setInstructpdfzipid(newUser.getInstructpdfzipid());
							Instruction.setIconImage(newUser.getIconImage());
			return userRepository.save(Instruction);
			}).orElseThrow(()->new InstructionNotFoundException(id));
	}

	
	@DeleteMapping("/Instruction/{id}")
	String deleteInstruction(@PathVariable Long id) {
		if (!userRepository.existsById(id)) {
			throw new InstructionNotFoundException(id);
		}
		userRepository.deleteById(id);
		return " Instructions with id " + id + " has been deleted successfully.";
	}

} // end class UserController