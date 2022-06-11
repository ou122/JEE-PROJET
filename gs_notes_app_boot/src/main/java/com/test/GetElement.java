package com.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.gsnotes.bo.Utilisateur;
import com.gsnotes.services.IPersonService;

import java.util.Iterator;
import java.util.Date;


@Controller
public class GetElement {
	
	
	//METHODE QUI VERIFIE LE NIVEAU D'EXCEL
public static void getNiveau(List<ArrayList<Object>> l,String NiveauDB) {
	List<Object> list=l.get(1);
	String niv=(String) list.get(1);
	if(niv.equals(NiveauDB)) {
		System.out.println("niveau correcte");
	}
	else
		System.out.println("erreur niveau");
}


//METODE POUR VERIFIER LA COHERENCE ENTRE LE PROF ET LE MODULE 
public static void checkModule(List<ArrayList<Object>> l,String ModuleDB) {
	List<Object> list=l.get(2);
	String MOD=(String) list.get(3);
	if(MOD.equals(ModuleDB)) {
		System.out.println("MODULE CORRECTE");
	}
	else
		System.out.println("ERREUR MODULE");
}


//METHODE QUI RETOURNE LA LISTE DES PROFS
public static List<Object> getProf(List<ArrayList<Object>> l){
	List<Object> list=l.get(1);
	List<Object> listProf= new ArrayList<Object>();
    for (int i = 2; i < list.size(); i++) {
    	listProf.add(list.get(i));
      }
	return listProf;
	
}



//METODE QUI RETOURN LA DATE ACTUELLE
public static String getCurrentYear(){
 int year=new Date().getYear()+1900;
 String str = (year-1)+"/"+year;
 System.out.println(str);
return str;
}


//METHODE QUI VERIFIE LA COHERENCE DE L'ANNEE DEPUIS EXCEL

public static String getAnnee(List<ArrayList<Object>> l) {
	List<Object> list=l.get(0);
	String Annee=(String) list.get(1);
	if(Annee.equals(getCurrentYear())) {
		System.out.println("Annee correct");
	}
	return Annee;
	
	
}




//VERIFICATION DES NOTES COMPRIS ENTRE 0 ET 20

public static void VerifierNotesElements(List<ArrayList<Object>> l) throws InvalidNoteException {
List<ArrayList<Object>> notes = l.subList(3, l.size());
int cmp=0;
Iterator <ArrayList<Object>> it = notes.iterator();
while(it.hasNext()) {	
 ArrayList<Object> iter = it.next();
 double note1 = (double)iter.get(4);
 double note2 = (double)iter.get(8);
 if(note1<0.0 ||  note2<0 || note1>20.0 || note2>20.0) throw new InvalidNoteException("invalid note de "+iter.get(2)+" "+iter.get(1)+"!!!") ;
 else {
 cmp++;
 continue;
 }  
}
if(cmp!=0) {
	System.out.println("notes bien remplies");
}
}



//VERIFICEATION FORMAT

public static void verificationFormat(String url)throws InvalidFormat{
	 url=url.toLowerCase();
	 if(url.endsWith(".xlsx")|| url.endsWith(".xls")) {
		 System.out.println("format valid");
	 }
	 else
		 throw new InvalidFormat("invalid format!!!") ; 
	
}



//VERIFICATION DE FORMULE DE CALCUL

public static void VerificationFormule(List<ArrayList<Object>> l) throws InvalidNoteException{
VerifierNotesElements(l);
List<ArrayList<Object>> notes = l.subList(3, l.size());
Iterator <ArrayList<Object>> it = notes.iterator();
while(it.hasNext()) {
 ArrayList<Object> iter = it.next();
 
 double N1 = (double)iter.get(6);
 double N2 = (double)iter.get(7);
 double MEAN   = (double)iter.get(8);
 
 if((N1+N2)/2 == MEAN) {
 System.out.print("Moyenne bien calculée");
 System.out.print("\n");
 }
 else {
 System.out.print("Attention moyenne mal calculée!!\n");
 continue;
 }  
}

}



//VERIFICATION DE VALIDATION
public static void VerificationValidation(List<ArrayList<Object>> l){
List<ArrayList<Object>> notes = l.subList(3, l.size());
int cmp=0;
Iterator <ArrayList<Object>> it = notes.iterator();
while(it.hasNext()) {
	
 ArrayList<Object> iter = it.next();
 double mean = (double)iter.get(10);
 String val=(String)iter.get(11);

 if(mean<12) {
	 if(val.equals("Ajourné")) {
		 System.out.println("validation correcte");
	 }
	 else {
		 System.out.println("faute dans la colonne validation veuillez corriger l'erreur");
	 }
 }
  else if(mean>=12) {
	  if(val.equals("Validé")) {
			 System.out.println("validation correcte");
		 }
		 else {
			 System.out.println("faute dans la colonne validation veuillez corriger l'erreur");
		 }
 }
   
}

}

//AUTREES.....


}
