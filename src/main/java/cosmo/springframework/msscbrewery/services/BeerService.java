package cosmo.springframework.msscbrewery.services;

import cosmo.springframework.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}

