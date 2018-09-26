package com.mycom.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycom.helper.ArrayHelper;

public class ArrayHelperServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ArrayHelper arrayHelper = null;
		PrintWriter writer = null;
		int[] input = null;
		int[] output=  null;
		
		input=  new int[3];
		input[0] = Integer.parseInt(request.getParameter("val1"));
		input[1] = Integer.parseInt(request.getParameter("val2"));
		input[2] = Integer.parseInt(request.getParameter("val3"));
		
		arrayHelper = new ArrayHelper();
		writer = response.getWriter();
		try {
			output = arrayHelper.reverse(input);
			for(int o : output) {
				writer.println("Reverse: ");				
				writer.print(o + ",");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
