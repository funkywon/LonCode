package com.sky.dvdstore;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class DvdTest {

	@Test
	public void testConstructor() {
		String reference = "123456";
		String title = "The dark knight";
		String review = "This movie is awesome!";
		
		Dvd dvd = new Dvd(reference, title, review);
		
		assertThat(dvd.getReference(), equalTo(reference));
		assertThat(dvd.getTitle(), equalTo(title));
		assertThat(dvd.getReview(), equalTo(review));
	}
	
	@Test
	public void testAreEqual() {
		String reference1 = "123";
		String title1 = "The dark knight";
		String review1 = "This movie is awesome!";

		String reference2 = "123";
		String title2 = "The dark knight";
		String review2 = "This movie is awesome!";
		
		Dvd dvd1 = new Dvd(reference1, title1, review1);
		Dvd dvd2 = new Dvd(reference2, title2, review2);
		
		assertThat(dvd1, is(equalTo(dvd2)));
	}
	
	@Test
	public void testAreNotEqualBecauseOfReference() {
		String reference = "123";
		String title = "The dark knight";
		String review = "This movie is awesome!";

		String differentReference = "123345";
		
		Dvd dvd1 = new Dvd(reference, title, review);
		Dvd dvd2 = new Dvd(differentReference, title, review);
		
		assertThat(dvd1, not(equalTo(dvd2)));
	}

	@Test
	public void testAreNotEqualBecauseOfTitle() {
		String reference = "123";
		String title = "The dark knight";
		String review = "This movie is awesome!";

		String differentTitle = "The light knight";
		
		Dvd dvd1 = new Dvd(reference, title, review);
		Dvd dvd2 = new Dvd(reference, differentTitle, review);
		
		assertThat(dvd1, not(equalTo(dvd2)));
	}

	@Test
	public void testAreNotEqualBecauseOfReview() {
		String reference = "123";
		String title = "The dark knight";
		String review = "This movie is awesome!";
		
		String differentReview = "This is another review.";
		
		Dvd dvd1 = new Dvd(reference, title, review);
		Dvd dvd2 = new Dvd(reference, title, differentReview);
		
		assertThat(dvd1, not(equalTo(dvd2)));
	}

	
}
