package com.sist.jdbc;
import java.util.*;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.sql.*;

public class MainClass2 {
	public static void main(String[] args) throws Exception {

			CSVReader cr = new CSVReader(new FileReader("/home/sist/csv_data/dept.csv"));
			List<String[]> list =cr.readAll();
			for(String[] ss :list){
				for (String s :ss) {
					System.out.println(s+" ");
				}
			}
		cr.close();
		
				
}

}
