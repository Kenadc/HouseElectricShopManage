package com.oaec.Controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oaec.Util.KdniaoTrackQueryAPI;

@Controller
@RequestMapping("/logistisc")
public class LogisticsController {
	
	/**
	 * ����������ݺŲ�ѯ�����Ϣ
	 * @param logistiscNum
	 * @return
	 */
	@RequestMapping("/logistiscInfo")
	@ResponseBody
	public Map<String,Object> logistiscInfo(String logistiscNum) {
		Map<String,Object> map = new HashMap<String,Object>();
		KdniaoTrackQueryAPI api = new KdniaoTrackQueryAPI();
		try {
			String result = api.getOrderTracesByJson("ANE", logistiscNum);
			System.out.print(result);
			map.put("code", 200);
			map.put("data", result);
			map.put("msg", "�ɹ�");
			return map;

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("code", 200);
		map.put("data", null);
		map.put("msg", "ʧ��");
		return map;
	}
}
