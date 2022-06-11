package com.gsnotes.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.boudaa.tools.ExcelHandler;
import com.boudaa.tools.ExcelHandlerException;
import com.gsnotes.bo.Utilisateur;
import com.gsnotes.services.IPersonService;
import com.test.GetElement;
import com.test.InvalidFormat;
import com.test.InvalidNoteException;

@Repository
@Controller
public class MyController {
	
	@Autowired
	private IPersonService personService;
	
	@GetMapping("/admin/getUti")
	public String getUtilisateur() throws InvalidNoteException, InvalidFormat, ExcelHandlerException {
		
		List<ArrayList<Object>> list=ExcelHandler.readFromExcel("C:\\\\Users\\\\OUNIR\\\\Downloads\\\\noteDelibe.xlsx", 0);
		 for (int i = 0; i < list.size(); i++) {
		      System.out.println(list.get(i));
		    }
		 System.out.println(list.get(1));
		 GetElement.getNiveau(list,"GI2");
		System.out.println( GetElement.getProf(list));
		System.out.print(GetElement.getAnnee(list));
	    GetElement.VerifierNotesElements(list);
	    GetElement.verificationFormat("C:\\\\Users\\\\OUNIR\\\\Downloads\\\\noteDelibe.xlsx");
	   GetElement.VerificationFormule(list);
	   GetElement.getCurrentYear();
	   GetElement.getAnnee(list);
	   GetElement.VerificationValidation(list);
	   GetElement.checkModule(list,"JEE");
	   return "admin/adminHome";
}
	}
