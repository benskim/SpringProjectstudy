package com.sist.manager;

import java.util.regex.Pattern;

public class MainRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Pattern.matches("맛있[아-잏][가-힣]", "맛있어요"));
	}

}
