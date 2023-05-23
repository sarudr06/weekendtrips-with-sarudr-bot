package com.sarudr.travellerservice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sarudr.travellerservice.model.Traveller;

public interface TravellersService {

	Traveller saveTraveller(Traveller travellers);

	List<Traveller> getTraveller();

	String deleteTravellerById(long travellerId);

	Traveller getTravellerById(long travellerId);

	Page<Traveller> findAll(Pageable paging);

	List<Traveller> findByEmail(String email);

}
