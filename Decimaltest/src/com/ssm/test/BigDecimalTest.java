package com.ssm.test;

import java.math.BigDecimal;

public class BigDecimalTest{

		private String val;
		
		public BigDecimalTest(String val) {
			this.val=val;
		}
		
		public BigDecimalTest() {}
		
		
	public String getVal() {
			return val;
		}

		public void setVal(String val) {
			this.val = val;
		}

	public void test02(){
		double a=0.09;
		double b=0.07;
		//使用BigDecimal的String类型的构造方法
		BigDecimal bigDecimala = new BigDecimal(String.valueOf(a));
		BigDecimal bigDecimalb = new BigDecimal(String.valueOf(b));
		//使用BigDecimal的subtract的方法计算差值
		BigDecimal subtract = bigDecimala.subtract(bigDecimalb);
		
		System.out.println(bigDecimala);
		System.out.println(bigDecimalb);
		System.out.println(subtract);
		
	}
}

