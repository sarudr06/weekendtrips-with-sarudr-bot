package com.sarudr.reportservice.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.sarudr.reportservice.serviceImplementation.EmailSenderService;
import com.sarudr.reportservice.serviceImplementation.PdfGeneratorForAdmin;
import com.sarudr.reportservice.serviceImplementation.PdfGeneratorForUser;
import com.sarudr.travellerservice.model.Passenger;
import com.sarudr.travellerservice.model.Traveller;
import com.sarudr.travellerservice.service.PassengersService;
import com.sarudr.travellerservice.service.TravellersService;

//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/weekend")
public class ReportController {

	@Autowired
	private EmailSenderService senderService;
	@Autowired
	private PdfGeneratorForUser service;
//	@Autowired
//	private PassengersService passengersService;
//	@Autowired
//	private TravellersService travellersService;

	@Autowired
	private HttpServletResponse response;

	@Autowired
	private PdfGeneratorForAdmin generator;

	@Autowired
	private PdfGeneratorForUser generatorForUser;

	@GetMapping("/pdf/admin")
	public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);

//		List<Passenger> passengers = passengersService.getPassengers();
//		List<Traveller> trav = travellersService.getTraveller();

//		generator.setPassengersList(passengers);
//		generator.setTravellersList(trav);
		generator.generate(response);
	}

//	@GetMapping("/getcity/{id}")
//	public ResponseEntity<City> getCityById(@PathVariable(value = "id") long id) {
//		return ResponseEntity.ok(cityService.getById(id));
//	}

	@GetMapping("/pdf/user/{travellerId}/{amount}")
	public void generatePdfForUser(@PathVariable(value = "travellerId") long travellerId,
	@PathVariable(value = "amount") double amount)
			throws DocumentException, IOException {

		response.setContentType("application/pdf");

		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		Traveller traveller = service.getTravellerById(travellerId);

		System.out.println(travellerId);
		generatorForUser.generate(response, travellerId,amount);
		try {
			triggerMail(traveller);
		} catch (MessagingException e) {

			e.printStackTrace();
		}

	}

//	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail(Traveller traveller) throws MessagingException {
//		traveller.getTravellerEmail()
		senderService.sendSimpleEmail(traveller.getTravellerEmail(), "Weekendtrips booking confirmation ",
				"This is informed that your booking with mail " + traveller.getTravellerEmail() + "is confirmed ."
				+"Here are the list of passengers"+traveller.getPassenger()
				);

	}

}