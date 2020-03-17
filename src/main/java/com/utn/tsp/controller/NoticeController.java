package com.utn.tsp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.tsp.dto.NoticeDTO;
import com.utn.tsp.services.NoticeService;

@Controller
@RestController
@RequestMapping(path = "api/v1/notices")
public class NoticeController implements ObjectController<NoticeDTO> {
	
	private NoticeService service;
	
	public NoticeController(NoticeService service) {
		this.service = service;
	}
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/")
	public List<NoticeDTO> getAll() {
		return ResponseEntity.status(200).body(service.getAll()).getBody();
	}//getAll()

	@Override
	@CrossOrigin("*")
	@GetMapping("/{id}")
	public NoticeDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(service.getOne(id)).getBody();
	}//getOne()

	@Override
	@PostMapping(path = "/",consumes = "application/json")
	public ResponseEntity save(@RequestBody NoticeDTO t) {
		NoticeDTO temp = service.save(t);
		if(temp.getId() != 0) {
			return ResponseEntity.status(201).body(temp);			
		} else {
			return ResponseEntity.status(400).body("{ \"error\": \"Bad request\"}");
		}
	}//save()

	@Override
	@PutMapping("/{id}")
	public ResponseEntity update(@RequestBody NoticeDTO t, @PathVariable int id) {
		NoticeDTO temp = service.update(t, id);
		if(temp.getId() != 0) {
			return ResponseEntity.status(201).body(temp);			
		} else {
			return ResponseEntity.status(400).body("{ \"error\": \"Bad request\"}");
		}
	}//update()

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = service.delete(id);
		if(det) {
			return ResponseEntity.status(204).body("'messsage': 'Eliminado'");
		} else {
			return ResponseEntity.status(400).body("'messsage': 'Error al eliminar'");
		}
	}//delete()

}
