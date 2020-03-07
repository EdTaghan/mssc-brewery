package gurus.springframework.msscbrewery.web.controller.v2;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import gurus.springframework.msscbrewery.services.v2.BeerServiceV2;
import gurus.springframework.msscbrewery.web.model.v2.BeerDtoV2;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

	private final BeerServiceV2 beerService;
	
	public BeerControllerV2(BeerServiceV2 beerService) {
		this.beerService = beerService;
	}	

	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping // POST - create new beer
	public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDto) {
		
		BeerDtoV2 savedDto = beerService.saveNewBeer(beerDto);
		
		HttpHeaders headers = new HttpHeaders();
		//todo add hostname to url
		//headers.add(headerName: "Location", headerValue: "/api/v1/beer/"+savedDto.getId().toString());
		headers.add( "Location", "/api/v1/beer/"+savedDto.getId().toString());
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@PutMapping({"/{beerId}"})
	public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto) {
		
		beerService.updateBeer(beerId, beerDto);
		//return a 204
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		beerService.deleteById(beerId);
	}
}
