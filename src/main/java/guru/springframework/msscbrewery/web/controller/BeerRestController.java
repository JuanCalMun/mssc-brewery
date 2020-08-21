package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.service.beer.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerRestController {

    private final BeerService beerService;

    public BeerRestController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerDto beerToSave) {
        BeerDto savedBeer = beerService.save(beerToSave);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/api/v1/beer/" + savedBeer.getId().toString()));
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(@PathVariable UUID beerId,
                           @RequestBody BeerDto beerNewValues) {
        beerService.update(beerId, beerNewValues);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID customerId) {
        beerService.delete(customerId);
    }
}
