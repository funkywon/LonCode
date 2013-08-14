package com.sky.dvdstore.implementation;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sky.dvdstore.Dvd;
import com.sky.dvdstore.DvdNotFoundException;
import com.sky.dvdstore.DvdRepositoryStub;
import com.sky.dvdstore.DvdService;


public class DvdServiceImplTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	private DvdService dvdService;
	private DvdRepositoryStub dvdRepository;
	
	@Before
	public void setup() {
		this.dvdRepository = new DvdRepositoryStub();
		this.dvdService = new DvdServiceImpl(this.dvdRepository);
	}
	
	@Test
	public void retrieveDvd1() throws Exception {
		String reference = DvdRepositoryStub.DVD_TOPGUN_REFERENCE;
		Dvd topGunDvd = this.dvdRepository.retrieveDvd(reference);
		
		Dvd dvd = this.dvdService.retrieveDvd(reference);
		
		assertThat(dvd, is(equalTo(topGunDvd)));
	}
	
	@Test
	public void retrieveDvd2() throws Exception {
		String reference = DvdRepositoryStub.DVD_DIRTYDANCING_REFERENCE;
		Dvd dirtyDancingDvd = this.dvdRepository.retrieveDvd(reference);
		
		Dvd dvd = this.dvdService.retrieveDvd(reference);
		
		assertThat(dvd, equalTo(dirtyDancingDvd));
	}
	
	@Test
	public void  throwsIllegalArgumentExceptionOnWrongPrefix() throws Exception {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("DVD reference has to start with 'DVD-'");
		
		this.dvdService.retrieveDvd("ILLEGALPREFIX-123GH");
	}
	
	@Test
	public void  throwsDvdNotFoundExceptionWhenDvdNotFound() throws Exception {
		exception.expect(DvdNotFoundException.class);
		
		this.dvdService.retrieveDvd("DVD-123NOTEXISTENT");
	}
	
	
	

}
