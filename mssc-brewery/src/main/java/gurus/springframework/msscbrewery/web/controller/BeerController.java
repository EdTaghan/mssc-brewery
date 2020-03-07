package gurus.springframework.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import gurus.springframework.msscbrewery.services.BeerService;
import gurus.springframework.msscbrewery.web.model.BeerDto;

@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	
	private final BeerService beerService;
	
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}	

	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping // POST - create new beer
	public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
		
		BeerDto savedDto = beerService.saveNewBeer(beerDto);
		
		HttpHeaders headers = new HttpHeaders();
		//todo add hostname to url
		//headers.add(headerName: "Location", headerValue: "/api/v1/beer/"+savedDto.getId().toString());
		headers.add( "Location", "/api/v1/beer/"+savedDto.getId().toString());
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@PutMapping({"/{beerId}"})
	public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
		
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
