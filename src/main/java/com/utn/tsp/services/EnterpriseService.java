package com.utn.tsp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.utn.tsp.dto.EnterpriseDTO;
import com.utn.tsp.entities.Enterprise;
import com.utn.tsp.repository.EnterpriseRepository;

@Service
public class EnterpriseService implements ObjectService<EnterpriseDTO>{

	private EnterpriseRepository repository;
	
	public EnterpriseService(EnterpriseRepository repository) {
		this.repository = repository;
	}
	@Override
	public List<EnterpriseDTO> getAll() {
		
		List<EnterpriseDTO> result = new ArrayList<>();
		
		for(Enterprise enterprise : repository.findAll()) {
			
			result.add(this.entityToDto(enterprise));
		}
		
		return result;
	}//getAll()

	@Override
	public EnterpriseDTO getOne(int id) {
		
		Optional<Enterprise> entityOptional = repository.findById(id);
		EnterpriseDTO temp = new EnterpriseDTO();
		
		try {
			Enterprise enterprise = entityOptional.get();
			
			temp = this.entityToDto(enterprise);
		} catch (Exception e) {
			System.out.println("No exite una empresa con ese ID.");
		}
		
		return temp;
	}

	@Override
	public EnterpriseDTO save(EnterpriseDTO t) {
		Enterprise enterprise = this.dtoToEntity(t);
		
		try {			
			repository.save(enterprise);
		} catch (Exception e) {
			System.out.println("Bad request.");
		}
		
		t.setId(enterprise.getId());
		
		return t;
	}

	@Override
	public EnterpriseDTO update(EnterpriseDTO t, int id) {
		Optional<Enterprise> entityOptional = repository.findById(id);
		Enterprise temp = new Enterprise();
		
		try {
			temp = entityOptional.get();
			//temp = this.dtoToEntity(t);
			
			temp.setId(id);
			temp.setDesignation(t.getDesignation());
			temp.setPhone(t.getPhone());
			temp.setAttention_time(t.getAttention_time());
			temp.setAbout_us(t.getAbout_us());
			temp.setLatitude(t.getLatitude());
			temp.setLongitude(t.getLongitude());
			temp.setAddress(t.getAddress());
			temp.setEmail(t.getEmail());
			
			repository.save(temp);
			
		} catch (Exception e) {
			System.out.println("Bad request.");
		}
		t.setId(temp.getId());
		return t;
	}

	@Override
	public boolean delete(int id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	
	///Helpers
	private EnterpriseDTO entityToDto(Enterprise entity) {
		EnterpriseDTO dto = new EnterpriseDTO();
		
		dto.setId(entity.getId());
		dto.setDesignation(entity.getDesignation());
		dto.setPhone(entity.getPhone());
		dto.setAttention_time(entity.getAttention_time());
		dto.setAbout_us(entity.getAbout_us());
		dto.setLatitude(entity.getLatitude());
		dto.setLongitude(entity.getLongitude());
		dto.setAddress(entity.getAddress());
		dto.setEmail(entity.getEmail());
		
		return dto;
	}//entityToDto()
	
	private Enterprise dtoToEntity(EnterpriseDTO dto) {
		Enterprise entity = new Enterprise();
		
		//entity.setId(dto.getId());
		entity.setDesignation(dto.getDesignation());
		entity.setPhone(dto.getPhone());
		entity.setAttention_time(dto.getAttention_time());
		entity.setAbout_us(dto.getAbout_us());
		entity.setLatitude(dto.getLatitude());
		entity.setLongitude(dto.getLongitude());
		entity.setAddress(dto.getAddress());
		entity.setEmail(dto.getEmail());
		
		return entity;
	}//dtoToEntity()

}
