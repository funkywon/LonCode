package com.sky.dvdstore.implementation;
import com.sky.dvdstore.Dvd;
import com.sky.dvdstore.DvdNotFoundException;
import com.sky.dvdstore.DvdRepository;
import com.sky.dvdstore.DvdService;

public class DvdServiceImpl implements DvdService {

	private DvdRepository dvdRepository;

	public DvdServiceImpl(DvdRepository dvdRepository) {
		this.dvdRepository = dvdRepository;
		
	}
	
	@Override
	public Dvd retrieveDvd(String dvdReference) throws DvdNotFoundException {
		if(!dvdReference.startsWith("DVD-")) throw new IllegalArgumentException("DVD reference has to start with 'DVD-'");
		
		Dvd retrievedDvd = dvdRepository.retrieveDvd(dvdReference);
		if(retrievedDvd == null) throw new DvdNotFoundException();
		
		return retrievedDvd;
	}

	@Override
	public String getDvdSummary(String dvdReference)
			throws DvdNotFoundException {
		return null;
	}

	
}
