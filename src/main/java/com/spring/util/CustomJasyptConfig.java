package com.spring.util;

import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public class CustomJasyptConfig extends EnvironmentStringPBEConfig {
	
	@Override
	public char[] getPasswordCharArray() {
		return "SpringDataSpringJdbc".toCharArray();
	}

}
