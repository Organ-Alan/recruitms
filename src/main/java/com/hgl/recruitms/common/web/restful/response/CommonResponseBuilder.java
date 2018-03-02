package com.hgl.recruitms.common.web.restful.response;

import org.springframework.stereotype.Component;

@Component
public class CommonResponseBuilder extends AbstractExtResponseObjectBuilder{

	@Override
	public ErrorInfoGetter getErrorInfoGetter() {
		
		return null;
	}

}
