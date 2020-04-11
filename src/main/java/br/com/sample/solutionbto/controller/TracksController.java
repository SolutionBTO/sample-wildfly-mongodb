package br.com.sample.solutionbto.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sample.solutionbto.model.Tracks;

@RestController
public class TracksController {

	private List<Tracks> tracks = Arrays.asList(
										new Tracks(1, "Enter sandman", "Metallica"),
										new Tracks(2, "Sad but true", "Metallica"), 
										new Tracks(3, "Holier than thou", "Metallica"),
										new Tracks(4, "Unforgiven", "Metallica"));

	@GetMapping(value = "tracks")
	public List<Tracks> getTrack() {
		return this.tracks;
	}

	@GetMapping(value = "tracks/{index}")
	public Tracks getTrack(@PathVariable Integer index) {
		return tracks.stream().filter(t -> t.getIndex() == index).findFirst().orElse(null);
	}

	@PostMapping(value = "tracks/{index}")
	public Tracks postTrack(@RequestBody Tracks track, @PathVariable Integer index) {
		return tracks.stream().filter(t -> t.getIndex() == index).findFirst().orElse(null);
	}

	@PutMapping(value = "tracks/{index}")
	public Tracks putTrack(@RequestBody Tracks track, @PathVariable Integer index) {
		return tracks.stream().filter(t -> t.getIndex() == index).findFirst().orElse(null);
	}

	@DeleteMapping(value = "tracks/{index}")
	public void deleteTrack(@PathVariable Integer index) {
		Tracks track = tracks.stream().filter(t -> t.getIndex() == index).findFirst().orElse(null);
		System.out.println(track + " is deleted!");
	}
}
