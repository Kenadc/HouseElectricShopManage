package com.oaec.Util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author itellyou
 *
 */
public class QueryList extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	// 当前页码
	private int page;
	// 每页条数
	private int limit;

	private String userType;

	private String reserveResult;

	public QueryList(Map<String, Object> map) {
		this.putAll(map);

		// 分页参数
		this.page = Integer.parseInt(map.get("page").toString());
		this.limit = Integer.parseInt(map.get("limit").toString());
		this.userType = map.get("userType").toString();
		this.reserveResult = map.get("reserveResult").toString();
		this.put("offset", (page - 1) * limit);
		this.put("page", page);
		this.put("limit", limit);
		this.put("userType", userType);
		this.put("reserveResult", reserveResult);
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getReserveResult() {
		return reserveResult;
	}

	public void setReserveResult(String reserveResult) {
		this.reserveResult = reserveResult;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
