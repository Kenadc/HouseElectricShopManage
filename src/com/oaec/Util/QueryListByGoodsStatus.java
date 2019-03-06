package com.oaec.Util;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author ½��
 *
 */
public class QueryListByGoodsStatus extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	//��ǰҳ��
    private int page;
    //ÿҳ����
    private int limit;
    
    private String goodsStatus;
    

    public QueryListByGoodsStatus(Map<String, Object> map){
        this.putAll(map);

        //��ҳ����
        this.page = Integer.parseInt(map.get("page").toString());
        this.limit = Integer.parseInt(map.get("limit").toString());
        this.goodsStatus = map.get("goodsStatus").toString();
        this.put("offset", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);
        this.put("goodsStatus", goodsStatus);
    }


	public String getGoodsStatus() {
		return goodsStatus;
	}


	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
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
