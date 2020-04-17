package com.spring.codeBrasil.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.codeBrasil.Repository.BrazilRepository;
import com.spring.codeBrasil.model.Brazil;

@Service
public class BrazilService {
	@Autowired
	private BrazilRepository repository;


	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}


	public ResponseEntity<?> findById(Long id) {
		Optional<Brazil> brazil = repository.findById(id);
		if(!brazil.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
		}
		
	}

	public ResponseEntity<?> add(Brazil brazil) {
		if(repository.existsById(brazil.getId())){
			return new	 ResponseEntity<>(HttpStatus.CONFLICT);
		}else{
				repository.save(brazil);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
	}

	public ResponseEntity<?> deleteStateById(Long id) {
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	public ResponseEntity<?> putStateById(Brazil brazil){
		if(repository.existsById(brazil.getId())){
			try{
				repository.save(brazil);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}catch (Exception e){
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		}else{
			System.out.println("Não existe um Estado com este id");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
