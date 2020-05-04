package cosmo.springframework.msscbrewery.controller;


import cosmo.springframework.msscbrewery.services.BeerService;
import cosmo.springframework.msscbrewery.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

// @Deprecated since we have v2 of the api now
@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.getBeerById(beerId),HttpStatus.OK);

    }

    @PostMapping({"/beer"})
    public ResponseEntity<BeerDto> handlePost(@RequestBody  BeerDto beerDto){
     BeerDto  savedDto =   beerService.saveBeerDto(beerDto);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to URL later
        headers.add("Location","/api/v1/beer/"+savedDto.getId().toString());

        return  new ResponseEntity<BeerDto>(savedDto,headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody  BeerDto beerDto){

        beerService.updateBeer(beerId,beerDto);

        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId ){

        beerService.deleteById(beerId);

    }

}
