package guru.springframework.msscbrewery.web.service.beer;

import guru.springframework.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto save(BeerDto beerToSave);

    BeerDto update(UUID beerId, BeerDto beerNewValues);

    boolean delete(UUID beerId);
}
