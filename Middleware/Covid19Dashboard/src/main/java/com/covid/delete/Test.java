package com.covid.delete;

import java.util.Arrays;
import java.util.List;

import com.covid.bo.CovidDataBO;
import com.covid.dao.HomeDAO;

public class Test {

	public static void main(String[] args) {
		HomeDAO h = new HomeDAO();
		List l = h.getCaseCount();
		//Arrays.toString(l);
		for(int i=0;i<l.size();i++) {
			Object o = l.get(i);
			Object[] arr= (Object[]) o;
			System.out.println((arr[0] instanceof String));
			String a;
			//System.out.println(o);
			//System.out.println((o instanceof Object[]));
			//CovidDataBO c = (CovidDataBO) l.get(i);
			System.out.println();
		}
	}

}
