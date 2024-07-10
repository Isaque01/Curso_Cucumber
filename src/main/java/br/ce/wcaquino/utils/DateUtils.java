package br.ce.wcaquino.utils;

import java.util.Calendar;
import java.util.Date;

import io.cucumber.java.ParameterType;

public class DateUtils {
	

	public static Date obterDataDiferenciaDias(int dias) {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, dias);
		return cal.getTime();
	}

}
