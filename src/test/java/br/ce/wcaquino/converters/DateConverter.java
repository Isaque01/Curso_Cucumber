package br.ce.wcaquino.converters;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cucumber.api.Transformer;

public class DateConverter extends Transformer<Date>{
	

	public Date transform(String arg0) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date retorno = format.parse(arg0);
			return retorno;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
