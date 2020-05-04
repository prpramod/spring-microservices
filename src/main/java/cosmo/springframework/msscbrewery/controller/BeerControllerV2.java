package cosmo.springframework.msscbrewery.controller;


import cosmo.springframework.msscbrewery.model.v2.BeerDtoV2;
import cosmo.springframework.msscbrewery.services.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequestMapping("api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }


    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId),HttpStatus.OK);

    }

    @PostMapping({"/beer"})
    public ResponseEntity<BeerDtoV2> handlePost(@RequestBody  BeerDtoV2 beerDto){
        BeerDtoV2  savedDto =   beerServiceV2.saveBeerDto(beerDto);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to URL later
        headers.add("Location","/api/v2/beer/"+savedDto.getId().toString());

        return  new ResponseEntity<BeerDtoV2>(savedDto,headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody  BeerDtoV2 beerDto){

        beerServiceV2.updateBeer(beerId,beerDto);

        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId ){

        beerServiceV2.deleteById(beerId);

    }
}
