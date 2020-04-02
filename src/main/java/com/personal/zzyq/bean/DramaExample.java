package com.personal.zzyq.bean;

import java.util.ArrayList;
import java.util.List;

public class DramaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DramaExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDramaIdIsNull() {
            addCriterion("drama_id is null");
            return (Criteria) this;
        }

        public Criteria andDramaIdIsNotNull() {
            addCriterion("drama_id is not null");
            return (Criteria) this;
        }

        public Criteria andDramaIdEqualTo(Integer value) {
            addCriterion("drama_id =", value, "dramaId");
            return (Criteria) this;
        }

        public Criteria andDramaIdNotEqualTo(Integer value) {
            addCriterion("drama_id <>", value, "dramaId");
            return (Criteria) this;
        }

        public Criteria andDramaIdGreaterThan(Integer value) {
            addCriterion("drama_id >", value, "dramaId");
            return (Criteria) this;
        }

        public Criteria andDramaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("drama_id >=", value, "dramaId");
            return (Criteria) this;
        }

        public Criteria andDramaIdLessThan(Integer value) {
            addCriterion("drama_id <", value, "dramaId");
            return (Criteria) this;
        }

        public Criteria andDramaIdLessThanOrEqualTo(Integer value) {
            addCriterion("drama_id <=", value, "dramaId");
            return (Criteria) this;
        }

        public Criteria andDramaIdIn(List<Integer> values) {
            addCriterion("drama_id in", values, "dramaId");
            return (Criteria) this;
        }

        public Criteria andDramaIdNotIn(List<Integer> values) {
            addCriterion("drama_id not in", values, "dramaId");
            return (Criteria) this;
        }

        public Criteria andDramaIdBetween(Integer value1, Integer value2) {
            addCriterion("drama_id between", value1, value2, "dramaId");
            return (Criteria) this;
        }

        public Criteria andDramaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("drama_id not between", value1, value2, "dramaId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andDramaNameIsNull() {
            addCriterion("drama_name is null");
            return (Criteria) this;
        }

        public Criteria andDramaNameIsNotNull() {
            addCriterion("drama_name is not null");
            return (Criteria) this;
        }

        public Criteria andDramaNameEqualTo(String value) {
            addCriterion("drama_name =", value, "dramaName");
            return (Criteria) this;
        }

        public Criteria andDramaNameNotEqualTo(String value) {
            addCriterion("drama_name <>", value, "dramaName");
            return (Criteria) this;
        }

        public Criteria andDramaNameGreaterThan(String value) {
            addCriterion("drama_name >", value, "dramaName");
            return (Criteria) this;
        }

        public Criteria andDramaNameGreaterThanOrEqualTo(String value) {
            addCriterion("drama_name >=", value, "dramaName");
            return (Criteria) this;
        }

        public Criteria andDramaNameLessThan(String value) {
            addCriterion("drama_name <", value, "dramaName");
            return (Criteria) this;
        }

        public Criteria andDramaNameLessThanOrEqualTo(String value) {
            addCriterion("drama_name <=", value, "dramaName");
            return (Criteria) this;
        }

        public Criteria andDramaNameLike(String value) {
            addCriterion("drama_name like", value, "dramaName");
            return (Criteria) this;
        }

        public Criteria andDramaNameNotLike(String value) {
            addCriterion("drama_name not like", value, "dramaName");
            return (Criteria) this;
        }

        public Criteria andDramaNameIn(List<String> values) {
            addCriterion("drama_name in", values, "dramaName");
            return (Criteria) this;
        }

        public Criteria andDramaNameNotIn(List<String> values) {
            addCriterion("drama_name not in", values, "dramaName");
            return (Criteria) this;
        }

        public Criteria andDramaNameBetween(String value1, String value2) {
            addCriterion("drama_name between", value1, value2, "dramaName");
            return (Criteria) this;
        }

        public Criteria andDramaNameNotBetween(String value1, String value2) {
            addCriterion("drama_name not between", value1, value2, "dramaName");
            return (Criteria) this;
        }

        public Criteria andDramaWatchingIsNull() {
            addCriterion("drama_watching is null");
            return (Criteria) this;
        }

        public Criteria andDramaWatchingIsNotNull() {
            addCriterion("drama_watching is not null");
            return (Criteria) this;
        }

        public Criteria andDramaWatchingEqualTo(Integer value) {
            addCriterion("drama_watching =", value, "dramaWatching");
            return (Criteria) this;
        }

        public Criteria andDramaWatchingNotEqualTo(Integer value) {
            addCriterion("drama_watching <>", value, "dramaWatching");
            return (Criteria) this;
        }

        public Criteria andDramaWatchingGreaterThan(Integer value) {
            addCriterion("drama_watching >", value, "dramaWatching");
            return (Criteria) this;
        }

        public Criteria andDramaWatchingGreaterThanOrEqualTo(Integer value) {
            addCriterion("drama_watching >=", value, "dramaWatching");
            return (Criteria) this;
        }

        public Criteria andDramaWatchingLessThan(Integer value) {
            addCriterion("drama_watching <", value, "dramaWatching");
            return (Criteria) this;
        }

        public Criteria andDramaWatchingLessThanOrEqualTo(Integer value) {
            addCriterion("drama_watching <=", value, "dramaWatching");
            return (Criteria) this;
        }

        public Criteria andDramaWatchingIn(List<Integer> values) {
            addCriterion("drama_watching in", values, "dramaWatching");
            return (Criteria) this;
        }

        public Criteria andDramaWatchingNotIn(List<Integer> values) {
            addCriterion("drama_watching not in", values, "dramaWatching");
            return (Criteria) this;
        }

        public Criteria andDramaWatchingBetween(Integer value1, Integer value2) {
            addCriterion("drama_watching between", value1, value2, "dramaWatching");
            return (Criteria) this;
        }

        public Criteria andDramaWatchingNotBetween(Integer value1, Integer value2) {
            addCriterion("drama_watching not between", value1, value2, "dramaWatching");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentIsNull() {
            addCriterion("drama_current is null");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentIsNotNull() {
            addCriterion("drama_current is not null");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentEqualTo(Integer value) {
            addCriterion("drama_current =", value, "dramaCurrent");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentNotEqualTo(Integer value) {
            addCriterion("drama_current <>", value, "dramaCurrent");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentGreaterThan(Integer value) {
            addCriterion("drama_current >", value, "dramaCurrent");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentGreaterThanOrEqualTo(Integer value) {
            addCriterion("drama_current >=", value, "dramaCurrent");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentLessThan(Integer value) {
            addCriterion("drama_current <", value, "dramaCurrent");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentLessThanOrEqualTo(Integer value) {
            addCriterion("drama_current <=", value, "dramaCurrent");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentIn(List<Integer> values) {
            addCriterion("drama_current in", values, "dramaCurrent");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentNotIn(List<Integer> values) {
            addCriterion("drama_current not in", values, "dramaCurrent");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentBetween(Integer value1, Integer value2) {
            addCriterion("drama_current between", value1, value2, "dramaCurrent");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentNotBetween(Integer value1, Integer value2) {
            addCriterion("drama_current not between", value1, value2, "dramaCurrent");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddIsNull() {
            addCriterion("drama_current_add is null");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddIsNotNull() {
            addCriterion("drama_current_add is not null");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddEqualTo(String value) {
            addCriterion("drama_current_add =", value, "dramaCurrentAdd");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddNotEqualTo(String value) {
            addCriterion("drama_current_add <>", value, "dramaCurrentAdd");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddGreaterThan(String value) {
            addCriterion("drama_current_add >", value, "dramaCurrentAdd");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddGreaterThanOrEqualTo(String value) {
            addCriterion("drama_current_add >=", value, "dramaCurrentAdd");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddLessThan(String value) {
            addCriterion("drama_current_add <", value, "dramaCurrentAdd");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddLessThanOrEqualTo(String value) {
            addCriterion("drama_current_add <=", value, "dramaCurrentAdd");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddLike(String value) {
            addCriterion("drama_current_add like", value, "dramaCurrentAdd");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddNotLike(String value) {
            addCriterion("drama_current_add not like", value, "dramaCurrentAdd");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddIn(List<String> values) {
            addCriterion("drama_current_add in", values, "dramaCurrentAdd");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddNotIn(List<String> values) {
            addCriterion("drama_current_add not in", values, "dramaCurrentAdd");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddBetween(String value1, String value2) {
            addCriterion("drama_current_add between", value1, value2, "dramaCurrentAdd");
            return (Criteria) this;
        }

        public Criteria andDramaCurrentAddNotBetween(String value1, String value2) {
            addCriterion("drama_current_add not between", value1, value2, "dramaCurrentAdd");
            return (Criteria) this;
        }

        public Criteria andDramaAllIsNull() {
            addCriterion("drama_all is null");
            return (Criteria) this;
        }

        public Criteria andDramaAllIsNotNull() {
            addCriterion("drama_all is not null");
            return (Criteria) this;
        }

        public Criteria andDramaAllEqualTo(Integer value) {
            addCriterion("drama_all =", value, "dramaAll");
            return (Criteria) this;
        }

        public Criteria andDramaAllNotEqualTo(Integer value) {
            addCriterion("drama_all <>", value, "dramaAll");
            return (Criteria) this;
        }

        public Criteria andDramaAllGreaterThan(Integer value) {
            addCriterion("drama_all >", value, "dramaAll");
            return (Criteria) this;
        }

        public Criteria andDramaAllGreaterThanOrEqualTo(Integer value) {
            addCriterion("drama_all >=", value, "dramaAll");
            return (Criteria) this;
        }

        public Criteria andDramaAllLessThan(Integer value) {
            addCriterion("drama_all <", value, "dramaAll");
            return (Criteria) this;
        }

        public Criteria andDramaAllLessThanOrEqualTo(Integer value) {
            addCriterion("drama_all <=", value, "dramaAll");
            return (Criteria) this;
        }

        public Criteria andDramaAllIn(List<Integer> values) {
            addCriterion("drama_all in", values, "dramaAll");
            return (Criteria) this;
        }

        public Criteria andDramaAllNotIn(List<Integer> values) {
            addCriterion("drama_all not in", values, "dramaAll");
            return (Criteria) this;
        }

        public Criteria andDramaAllBetween(Integer value1, Integer value2) {
            addCriterion("drama_all between", value1, value2, "dramaAll");
            return (Criteria) this;
        }

        public Criteria andDramaAllNotBetween(Integer value1, Integer value2) {
            addCriterion("drama_all not between", value1, value2, "dramaAll");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}