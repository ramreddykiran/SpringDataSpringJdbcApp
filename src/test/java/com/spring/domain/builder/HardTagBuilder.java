package com.spring.domain.builder;

import org.apache.commons.lang3.builder.Builder;

import com.spring.domain.HardTag;

public class HardTagBuilder implements Builder<HardTag>{
	
	private String hardTag;

	@Override
	public HardTag build() {
		HardTag hardTagObj = new HardTag();
		hardTagObj.setHardTag(hardTag);
		return hardTagObj;
	}

}
