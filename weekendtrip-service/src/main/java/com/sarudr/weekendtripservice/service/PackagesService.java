package com.sarudr.weekendtripservice.service;
import com.sarudr.weekendtripservice.model.Package;
import java.util.List;

public interface PackagesService {

	Package savePackage(com.sarudr.weekendtripservice.model.Package package1);

	List<Package> getPack();

	Package getPackById(long packId);

	Package updatepack(long packId, Package packages);

	Package savepackageById(long cityId, Package package1);

	String changeStatus(long packId);

	Package findbypackName(String packageName);
}
