package guru.springframework.msscbrewery.web.service.beer;

import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerType("Pale Ale")
                .build();
    }

    @Override
    public BeerDto save(BeerDto beerToSave) {
        return beerToSave;
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerNewValues) {
        return BeerDto.builder()
                .id(beerId)
                .beerName(beerNewValues.getBeerName())
                .beerType(beerNewValues.getBeerType())
                .upc(beerNewValues.getUpc())
                .build();
    }
}
