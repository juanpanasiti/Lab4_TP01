package com.utn.tsp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.utn.tsp.dto.NoticeDTO;
import com.utn.tsp.entities.Notice;
import com.utn.tsp.repository.NoticeRepository;

@Service
public class NoticeService implements ObjectService<NoticeDTO>{
	
	private NoticeRepository repository;
	
	public NoticeService(NoticeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<NoticeDTO> getAll() {
		List<NoticeDTO> result = new ArrayList<NoticeDTO>();
		
		for(Notice notice : repository.findAll()) {
			result.add(this.entityToDto(notice));
		}
		return result;
	}//getAll()

	@Override
	public NoticeDTO getOne(int id) {
		Optional<Notice> entityOptional = repository.findById(id);
		NoticeDTO temp = new NoticeDTO();
		
		try {
			Notice notice = entityOptional.get();
			temp = this.entityToDto(notice);
		} catch (Exception e) {
			System.out.println("No existe la noticia con ese ID");
		}
		return temp;
	}//getOne()

	@Override
	public NoticeDTO save(NoticeDTO t) {
		Notice notice = this.dtoToEntity(t);
		
		try {
			repository.save(notice);
		} catch (Exception e) {
			System.out.println("Bad request");
		}
		return null;
	}//save()

	@Override
	public NoticeDTO update(NoticeDTO t, int id) {
		Optional<Notice> entityOptional = repository.findById(id);
		Notice temp = new Notice();
		
		try {
			temp = this.dtoToEntity(t);
			temp.setId(id);
			
			repository.save(temp);
		} catch (Exception e) {
			System.out.println("Bad request.");
		}
		t.setId(temp.getId());
		return t;
	}//update()

	@Override
	public boolean delete(int id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}//delete()
	
	//Helpers
	private NoticeDTO entityToDto(Notice entity) {
		NoticeDTO dto = new NoticeDTO();
		
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setSummary(entity.getSummary());
		dto.setImage(entity.getImage());
		dto.setHtml_content(entity.getHtml_content());
		dto.setPublished(entity.getPublished());
		dto.setPublication_date(entity.getPublication_date());
		//dto.setEnterprise(enterprise);
		
		return dto;
	}//entityToDto()
	
	private Notice dtoToEntity(NoticeDTO dto) {
		Notice entity = new Notice();
		
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setSummary(dto.getSummary());
		entity.setImage(dto.getImage());
		entity.setHtml_content(dto.getHtml_content());
		entity.setPublished(dto.getPublished());
		entity.setPublication_date(dto.getPublication_date());
		
		return entity;
	}//dtoToEntity()

}
