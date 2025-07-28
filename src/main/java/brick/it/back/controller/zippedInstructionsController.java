package brick.it.back.controller;

import java.util.Collections;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; // needed for sorting list of users by ID
import org.springframework.web.bind.annotation.*;

import brick.it.back.exception.InstructionNotFoundException;
import brick.it.back.model.InstructionsZipped;
import brick.it.back.repository.InstructionsZippedRepository;

@RestController
public class zippedInstructionsController {

	@Autowired
	private InstructionsZippedRepository userRepository;

	// Stub: Always throws UnsupportedOperationException (Test should fail
	// initially)
	@PostMapping("/instructionZipped")
	InstructionsZipped newInstruction(@RequestBody InstructionsZipped newUser) {
		return userRepository.save(newUser);
	}

	// Stub: Returns an empty list (Test should fail if expecting actual users)
	
	@GetMapping("/instructionZipped/{id}")
	InstructionsZipped getInstructionById(@PathVariable Long id) {
		return userRepository.findById(id)
				.orElseThrow(()->new InstructionNotFoundException(id));
	}

	

	
	@DeleteMapping("/instructionZipped/{id}")
	String deleteInstruction(@PathVariable Long id) {
		if (!userRepository.existsById(id)) {
			throw new InstructionNotFoundException(id);
		}
		userRepository.deleteById(id);
		return " Instructions with id " + id + " has been deleted successfully.";
	}

} // end class UserController