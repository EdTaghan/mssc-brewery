package gurus.springframework.msscbrewery.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* @Data creates getters and setters from Lombok */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
	
	private UUID id;
	private String beerName;
	private String beerStyle;
	private Long upc;

}
