package com.hgl.recruitms.model;

import java.util.ArrayList;
import java.util.List;

public class DictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictionaryExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andNDictNoIsNull() {
            addCriterion("N_DICT_NO is null");
            return (Criteria) this;
        }

        public Criteria andNDictNoIsNotNull() {
            addCriterion("N_DICT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNDictNoEqualTo(Integer value) {
            addCriterion("N_DICT_NO =", value, "nDictNo");
            return (Criteria) this;
        }

        public Criteria andNDictNoNotEqualTo(Integer value) {
            addCriterion("N_DICT_NO <>", value, "nDictNo");
            return (Criteria) this;
        }

        public Criteria andNDictNoGreaterThan(Integer value) {
            addCriterion("N_DICT_NO >", value, "nDictNo");
            return (Criteria) this;
        }

        public Criteria andNDictNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_DICT_NO >=", value, "nDictNo");
            return (Criteria) this;
        }

        public Criteria andNDictNoLessThan(Integer value) {
            addCriterion("N_DICT_NO <", value, "nDictNo");
            return (Criteria) this;
        }

        public Criteria andNDictNoLessThanOrEqualTo(Integer value) {
            addCriterion("N_DICT_NO <=", value, "nDictNo");
            return (Criteria) this;
        }

        public Criteria andNDictNoIn(List<Integer> values) {
            addCriterion("N_DICT_NO in", values, "nDictNo");
            return (Criteria) this;
        }

        public Criteria andNDictNoNotIn(List<Integer> values) {
            addCriterion("N_DICT_NO not in", values, "nDictNo");
            return (Criteria) this;
        }

        public Criteria andNDictNoBetween(Integer value1, Integer value2) {
            addCriterion("N_DICT_NO between", value1, value2, "nDictNo");
            return (Criteria) this;
        }

        public Criteria andNDictNoNotBetween(Integer value1, Integer value2) {
            addCriterion("N_DICT_NO not between", value1, value2, "nDictNo");
            return (Criteria) this;
        }

        public Criteria andSItemCodeIsNull() {
            addCriterion("S_ITEM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSItemCodeIsNotNull() {
            addCriterion("S_ITEM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSItemCodeEqualTo(String value) {
            addCriterion("S_ITEM_CODE =", value, "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSItemCodeNotEqualTo(String value) {
            addCriterion("S_ITEM_CODE <>", value, "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSItemCodeGreaterThan(String value) {
            addCriterion("S_ITEM_CODE >", value, "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("S_ITEM_CODE >=", value, "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSItemCodeLessThan(String value) {
            addCriterion("S_ITEM_CODE <", value, "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSItemCodeLessThanOrEqualTo(String value) {
            addCriterion("S_ITEM_CODE <=", value, "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSItemCodeLike(String value) {
            addCriterion("S_ITEM_CODE like", value, "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSItemCodeNotLike(String value) {
            addCriterion("S_ITEM_CODE not like", value, "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSItemCodeIn(List<String> values) {
            addCriterion("S_ITEM_CODE in", values, "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSItemCodeNotIn(List<String> values) {
            addCriterion("S_ITEM_CODE not in", values, "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSItemCodeBetween(String value1, String value2) {
            addCriterion("S_ITEM_CODE between", value1, value2, "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSItemCodeNotBetween(String value1, String value2) {
            addCriterion("S_ITEM_CODE not between", value1, value2, "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSSortNoIsNull() {
            addCriterion("S_SORT_NO is null");
            return (Criteria) this;
        }

        public Criteria andSSortNoIsNotNull() {
            addCriterion("S_SORT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSSortNoEqualTo(String value) {
            addCriterion("S_SORT_NO =", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoNotEqualTo(String value) {
            addCriterion("S_SORT_NO <>", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoGreaterThan(String value) {
            addCriterion("S_SORT_NO >", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoGreaterThanOrEqualTo(String value) {
            addCriterion("S_SORT_NO >=", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoLessThan(String value) {
            addCriterion("S_SORT_NO <", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoLessThanOrEqualTo(String value) {
            addCriterion("S_SORT_NO <=", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoLike(String value) {
            addCriterion("S_SORT_NO like", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoNotLike(String value) {
            addCriterion("S_SORT_NO not like", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoIn(List<String> values) {
            addCriterion("S_SORT_NO in", values, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoNotIn(List<String> values) {
            addCriterion("S_SORT_NO not in", values, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoBetween(String value1, String value2) {
            addCriterion("S_SORT_NO between", value1, value2, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoNotBetween(String value1, String value2) {
            addCriterion("S_SORT_NO not between", value1, value2, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSItemKeyIsNull() {
            addCriterion("S_ITEM_KEY is null");
            return (Criteria) this;
        }

        public Criteria andSItemKeyIsNotNull() {
            addCriterion("S_ITEM_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andSItemKeyEqualTo(String value) {
            addCriterion("S_ITEM_KEY =", value, "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemKeyNotEqualTo(String value) {
            addCriterion("S_ITEM_KEY <>", value, "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemKeyGreaterThan(String value) {
            addCriterion("S_ITEM_KEY >", value, "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemKeyGreaterThanOrEqualTo(String value) {
            addCriterion("S_ITEM_KEY >=", value, "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemKeyLessThan(String value) {
            addCriterion("S_ITEM_KEY <", value, "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemKeyLessThanOrEqualTo(String value) {
            addCriterion("S_ITEM_KEY <=", value, "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemKeyLike(String value) {
            addCriterion("S_ITEM_KEY like", value, "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemKeyNotLike(String value) {
            addCriterion("S_ITEM_KEY not like", value, "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemKeyIn(List<String> values) {
            addCriterion("S_ITEM_KEY in", values, "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemKeyNotIn(List<String> values) {
            addCriterion("S_ITEM_KEY not in", values, "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemKeyBetween(String value1, String value2) {
            addCriterion("S_ITEM_KEY between", value1, value2, "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemKeyNotBetween(String value1, String value2) {
            addCriterion("S_ITEM_KEY not between", value1, value2, "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemValueIsNull() {
            addCriterion("S_ITEM_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andSItemValueIsNotNull() {
            addCriterion("S_ITEM_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andSItemValueEqualTo(String value) {
            addCriterion("S_ITEM_VALUE =", value, "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSItemValueNotEqualTo(String value) {
            addCriterion("S_ITEM_VALUE <>", value, "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSItemValueGreaterThan(String value) {
            addCriterion("S_ITEM_VALUE >", value, "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSItemValueGreaterThanOrEqualTo(String value) {
            addCriterion("S_ITEM_VALUE >=", value, "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSItemValueLessThan(String value) {
            addCriterion("S_ITEM_VALUE <", value, "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSItemValueLessThanOrEqualTo(String value) {
            addCriterion("S_ITEM_VALUE <=", value, "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSItemValueLike(String value) {
            addCriterion("S_ITEM_VALUE like", value, "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSItemValueNotLike(String value) {
            addCriterion("S_ITEM_VALUE not like", value, "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSItemValueIn(List<String> values) {
            addCriterion("S_ITEM_VALUE in", values, "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSItemValueNotIn(List<String> values) {
            addCriterion("S_ITEM_VALUE not in", values, "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSItemValueBetween(String value1, String value2) {
            addCriterion("S_ITEM_VALUE between", value1, value2, "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSItemValueNotBetween(String value1, String value2) {
            addCriterion("S_ITEM_VALUE not between", value1, value2, "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSRemarkIsNull() {
            addCriterion("S_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andSRemarkIsNotNull() {
            addCriterion("S_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andSRemarkEqualTo(String value) {
            addCriterion("S_REMARK =", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkNotEqualTo(String value) {
            addCriterion("S_REMARK <>", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkGreaterThan(String value) {
            addCriterion("S_REMARK >", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("S_REMARK >=", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkLessThan(String value) {
            addCriterion("S_REMARK <", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkLessThanOrEqualTo(String value) {
            addCriterion("S_REMARK <=", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkLike(String value) {
            addCriterion("S_REMARK like", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkNotLike(String value) {
            addCriterion("S_REMARK not like", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkIn(List<String> values) {
            addCriterion("S_REMARK in", values, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkNotIn(List<String> values) {
            addCriterion("S_REMARK not in", values, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkBetween(String value1, String value2) {
            addCriterion("S_REMARK between", value1, value2, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkNotBetween(String value1, String value2) {
            addCriterion("S_REMARK not between", value1, value2, "sRemark");
            return (Criteria) this;
        }

        public Criteria andCValidFlagIsNull() {
            addCriterion("C_VALID_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCValidFlagIsNotNull() {
            addCriterion("C_VALID_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCValidFlagEqualTo(String value) {
            addCriterion("C_VALID_FLAG =", value, "cValidFlag");
            return (Criteria) this;
        }

        public Criteria andCValidFlagNotEqualTo(String value) {
            addCriterion("C_VALID_FLAG <>", value, "cValidFlag");
            return (Criteria) this;
        }

        public Criteria andCValidFlagGreaterThan(String value) {
            addCriterion("C_VALID_FLAG >", value, "cValidFlag");
            return (Criteria) this;
        }

        public Criteria andCValidFlagGreaterThanOrEqualTo(String value) {
            addCriterion("C_VALID_FLAG >=", value, "cValidFlag");
            return (Criteria) this;
        }

        public Criteria andCValidFlagLessThan(String value) {
            addCriterion("C_VALID_FLAG <", value, "cValidFlag");
            return (Criteria) this;
        }

        public Criteria andCValidFlagLessThanOrEqualTo(String value) {
            addCriterion("C_VALID_FLAG <=", value, "cValidFlag");
            return (Criteria) this;
        }

        public Criteria andCValidFlagLike(String value) {
            addCriterion("C_VALID_FLAG like", value, "cValidFlag");
            return (Criteria) this;
        }

        public Criteria andCValidFlagNotLike(String value) {
            addCriterion("C_VALID_FLAG not like", value, "cValidFlag");
            return (Criteria) this;
        }

        public Criteria andCValidFlagIn(List<String> values) {
            addCriterion("C_VALID_FLAG in", values, "cValidFlag");
            return (Criteria) this;
        }

        public Criteria andCValidFlagNotIn(List<String> values) {
            addCriterion("C_VALID_FLAG not in", values, "cValidFlag");
            return (Criteria) this;
        }

        public Criteria andCValidFlagBetween(String value1, String value2) {
            addCriterion("C_VALID_FLAG between", value1, value2, "cValidFlag");
            return (Criteria) this;
        }

        public Criteria andCValidFlagNotBetween(String value1, String value2) {
            addCriterion("C_VALID_FLAG not between", value1, value2, "cValidFlag");
            return (Criteria) this;
        }

        public Criteria andSItemCodeLikeInsensitive(String value) {
            addCriterion("upper(S_ITEM_CODE) like", value.toUpperCase(), "sItemCode");
            return (Criteria) this;
        }

        public Criteria andSSortNoLikeInsensitive(String value) {
            addCriterion("upper(S_SORT_NO) like", value.toUpperCase(), "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSItemKeyLikeInsensitive(String value) {
            addCriterion("upper(S_ITEM_KEY) like", value.toUpperCase(), "sItemKey");
            return (Criteria) this;
        }

        public Criteria andSItemValueLikeInsensitive(String value) {
            addCriterion("upper(S_ITEM_VALUE) like", value.toUpperCase(), "sItemValue");
            return (Criteria) this;
        }

        public Criteria andSRemarkLikeInsensitive(String value) {
            addCriterion("upper(S_REMARK) like", value.toUpperCase(), "sRemark");
            return (Criteria) this;
        }

        public Criteria andCValidFlagLikeInsensitive(String value) {
            addCriterion("upper(C_VALID_FLAG) like", value.toUpperCase(), "cValidFlag");
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