package com.hgl.recruitms.example.service;

import java.text.NumberFormat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hgl.recruitms.common.test.BaseSpringContextTest;
import com.hgl.recruitms.service.impl.TestServiceImpl;

public class ServiceTest extends BaseSpringContextTest {

	@Autowired
	private TestServiceImpl testService;

	@Test
	public void select() {
		System.out.println(testService.select());
	}

	public static void main(String[] args) {
		// DecimalFormat df = new DecimalFormat(",###,##0"); // 没有小数
		//// DecimalFormat decimal = new DecimalFormat(",###,##0.0"); // 保留一位小数
		// String result = df.format(12334567);
		// System.out.println(result);
		// 创建一个数值格式化对象
		NumberFormat numberFormat = NumberFormat.getInstance();
		// 设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(2);
		String sRateRigister = numberFormat.format((float) 30 / (float) 402 * 100);
		System.out.println("报到率为:" + sRateRigister + "%");
	}
}
