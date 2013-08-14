/*
 * Copyright © 2006-2010. BSkyB Ltd All Rights reserved
 */

package com.sky.dvdstore;

public class Dvd {
	
	private String reference;
	private String title;
	private String review;
	
	public Dvd(String reference, String title, String review) {
		this.reference = reference;
		this.title = title;
		this.review = review;
	}

    public String getReview() {
		return review;
	}

	public String getReference() {
		return reference;
	}

	public String getTitle() {
		return title;
	}
	
	public boolean equals(Object aThat) {
		if (this == aThat) return true;		
		if(!(aThat instanceof Dvd)) return false;
		
		Dvd that = (Dvd)aThat;
		return (this.review.equals(that.getReview()) && 
				this.reference.equals(that.getReference()) &&
						this.title.equals(that.getTitle()));
		
	}
    
}
