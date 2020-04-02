package com.personal.zzyq.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Drama {
    private Integer dramaId;

    private Integer userId;

    private Integer typeId;

    
    @Pattern(regexp = "^[\\s\\S]*.*[^\\s][\\s\\S]*$",message = "剧集名称不可为空哟Σ (ﾟДﾟ;) ")
    private String dramaName;

    private Integer dramaWatching;

    private Integer dramaCurrent;

    private String dramaCurrentAdd;

    private Integer dramaAll;
    
    //查询剧集差类别
    private Type type;
    
    public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Drama [dramaId=" + dramaId + ", userId=" + userId + ", typeId=" + typeId + ", dramaName=" + dramaName
				+ ", dramaWatching=" + dramaWatching + ", dramaCurrent=" + dramaCurrent + ", dramaCurrentAdd="
				+ dramaCurrentAdd + ", dramaAll=" + dramaAll + ", type=" + type + "]";
	}

	public Drama() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drama(Integer dramaId, Integer userId, Integer typeId, String dramaName, Integer dramaWatching,
			Integer dramaCurrent, String dramaCurrentAdd, Integer dramaAll) {
		super();
		this.dramaId = dramaId;
		this.userId = userId;
		this.typeId = typeId;
		this.dramaName = dramaName;
		this.dramaWatching = dramaWatching;
		this.dramaCurrent = dramaCurrent;
		this.dramaCurrentAdd = dramaCurrentAdd;
		this.dramaAll = dramaAll;
		
	}

	public Integer getDramaId() {
        return dramaId;
    }

    public void setDramaId(Integer dramaId) {
        this.dramaId = dramaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getDramaName() {
        return dramaName;
    }

    public void setDramaName(String dramaName) {
        this.dramaName = dramaName == null ? null : dramaName.trim();
    }

    public Integer getDramaWatching() {
        return dramaWatching;
    }

    public void setDramaWatching(Integer dramaWatching) {
        this.dramaWatching = dramaWatching;
    }

    public Integer getDramaCurrent() {
        return dramaCurrent;
    }

    public void setDramaCurrent(Integer dramaCurrent) {
        this.dramaCurrent = dramaCurrent;
    }

    public String getDramaCurrentAdd() {
        return dramaCurrentAdd;
    }

    public void setDramaCurrentAdd(String dramaCurrentAdd) {
        this.dramaCurrentAdd = dramaCurrentAdd == null ? null : dramaCurrentAdd.trim();
    }

    public Integer getDramaAll() {
        return dramaAll;
    }

    public void setDramaAll(Integer dramaAll) {
        this.dramaAll = dramaAll;
    }
}