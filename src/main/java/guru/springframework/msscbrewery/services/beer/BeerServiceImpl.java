package guru.springframework.msscbrewery.services.beer;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        log.info("Searching beer with id: " + beerId.toString());
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .build();
    }

    @Override
    public BeerDto save(BeerDto beerToSave) {
        log.info("Creating beer with id: " + beerToSave);
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public BeerDto update(UUID beerId, BeerDto beerNewValues) {
        log.info("Updating beer with id: " + beerId.toString());
        return BeerDto.builder()
                .id(beerId)
                .beerName(beerNewValues.getBeerName())
                .beerStyle(beerNewValues.getBeerStyle())
                .upc(beerNewValues.getUpc())
                .build();
    }

    @Override
    public boolean delete(UUID beerId) {
        log.info("Deleting beer with id: " + beerId.toString());
        return true;
    }
}
