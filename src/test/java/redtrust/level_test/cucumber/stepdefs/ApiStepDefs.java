package redtrust.level_test.cucumber.stepdefs;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.marcperez06.java_utilities.logger.Logger;
import redtrust.level_test.api.actions.SearchActions;
import redtrust.level_test.api.objects.Track;

public class ApiStepDefs {
	
	private SearchActions search = new SearchActions();

	@Given("access to spotify api")
	public void access_to_spotify_api() {
	    // Empty step, I'm using a developer access token I found in internet.
	}
	
	@When("add the song {string} to playlist {int}")
	public void add_the_song_to_playlist(String song, int playlistId) {
	    Track track = this.search.searchSongByName(song);
	    if (track != null) {
	    	Logger.println("Track Name: " + track.getName() + " Track ID: " + track.getId());
	    } else {
	    	Assert.fail("Can not find any song with the name " + song);
	    }
	}

	@Then("verify that song is added to playlist")
	public void verify_that_song_is_added_to_playlist() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
