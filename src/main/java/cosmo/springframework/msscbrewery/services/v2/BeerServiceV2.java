package cosmo.springframework.msscbrewery.services.v2;

import cosmo.springframework.msscbrewery.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {


    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveBeerDto(BeerDtoV2 beerDto);

    void updateBeer(UUID beerId, BeerDtoV2 beerDto);

    void deleteById(UUID beerId);
}
