package com.gfg.addressapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.gfg.addressapp.entity.Address;
import com.gfg.addressapp.repository.AddressRepo;
import com.gfg.addressapp.response.AddressResponse;

@Service
public class AddressService {
	
	
	private AddressRepo addressRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public AddressResponse findAddressByEmployeeId(int employeeId) {
		Optional<Address> addressByEmployeeId = addressRepo.findAddressByEmployeeId(employeeId);
		AddressResponse addressResponse = mapper.map(addressByEmployeeId, AddressResponse.class);
		
		return addressResponse;
	}

}
