package com.test;

import java.util.ArrayList;
import java.util.List;

import com.boudaa.tools.ExcelHandler;
import com.boudaa.tools.ExcelHandlerException;

public class MAIN {

public static void main(String[]args) throws ExcelHandlerException, InvalidNoteException, InvalidFormat {

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
}
}
