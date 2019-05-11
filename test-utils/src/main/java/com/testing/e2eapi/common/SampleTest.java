package com.testing.e2eapi.common;

import com.testing.e2eapi.config.ConfigGenerator;
import org.testng.annotations.Test;

public class SampleTest {
	@Test
	public static void sampleTest() {
		System.out.println(ConfigGenerator.INSTANCE.getConfiguration().getBaseURI());
		System.out.println(ConfigGenerator.INSTANCE.getConfiguration().getBasePath());
	}
}
