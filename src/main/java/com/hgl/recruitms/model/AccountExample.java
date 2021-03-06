package com.hgl.recruitms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountExample() {
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

        public Criteria andNAcnNoIsNull() {
            addCriterion("N_ACN_NO is null");
            return (Criteria) this;
        }

        public Criteria andNAcnNoIsNotNull() {
            addCriterion("N_ACN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNAcnNoEqualTo(Integer value) {
            addCriterion("N_ACN_NO =", value, "nAcnNo");
            return (Criteria) this;
        }

        public Criteria andNAcnNoNotEqualTo(Integer value) {
            addCriterion("N_ACN_NO <>", value, "nAcnNo");
            return (Criteria) this;
        }

        public Criteria andNAcnNoGreaterThan(Integer value) {
            addCriterion("N_ACN_NO >", value, "nAcnNo");
            return (Criteria) this;
        }

        public Criteria andNAcnNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_ACN_NO >=", value, "nAcnNo");
            return (Criteria) this;
        }

        public Criteria andNAcnNoLessThan(Integer value) {
            addCriterion("N_ACN_NO <", value, "nAcnNo");
            return (Criteria) this;
        }

        public Criteria andNAcnNoLessThanOrEqualTo(Integer value) {
            addCriterion("N_ACN_NO <=", value, "nAcnNo");
            return (Criteria) this;
        }

        public Criteria andNAcnNoIn(List<Integer> values) {
            addCriterion("N_ACN_NO in", values, "nAcnNo");
            return (Criteria) this;
        }

        public Criteria andNAcnNoNotIn(List<Integer> values) {
            addCriterion("N_ACN_NO not in", values, "nAcnNo");
            return (Criteria) this;
        }

        public Criteria andNAcnNoBetween(Integer value1, Integer value2) {
            addCriterion("N_ACN_NO between", value1, value2, "nAcnNo");
            return (Criteria) this;
        }

        public Criteria andNAcnNoNotBetween(Integer value1, Integer value2) {
            addCriterion("N_ACN_NO not between", value1, value2, "nAcnNo");
            return (Criteria) this;
        }

        public Criteria andSUserNoIsNull() {
            addCriterion("S_USER_NO is null");
            return (Criteria) this;
        }

        public Criteria andSUserNoIsNotNull() {
            addCriterion("S_USER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSUserNoEqualTo(String value) {
            addCriterion("S_USER_NO =", value, "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUserNoNotEqualTo(String value) {
            addCriterion("S_USER_NO <>", value, "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUserNoGreaterThan(String value) {
            addCriterion("S_USER_NO >", value, "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("S_USER_NO >=", value, "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUserNoLessThan(String value) {
            addCriterion("S_USER_NO <", value, "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUserNoLessThanOrEqualTo(String value) {
            addCriterion("S_USER_NO <=", value, "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUserNoLike(String value) {
            addCriterion("S_USER_NO like", value, "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUserNoNotLike(String value) {
            addCriterion("S_USER_NO not like", value, "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUserNoIn(List<String> values) {
            addCriterion("S_USER_NO in", values, "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUserNoNotIn(List<String> values) {
            addCriterion("S_USER_NO not in", values, "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUserNoBetween(String value1, String value2) {
            addCriterion("S_USER_NO between", value1, value2, "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUserNoNotBetween(String value1, String value2) {
            addCriterion("S_USER_NO not between", value1, value2, "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUsernameIsNull() {
            addCriterion("S_USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andSUsernameIsNotNull() {
            addCriterion("S_USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andSUsernameEqualTo(String value) {
            addCriterion("S_USERNAME =", value, "sUsername");
            return (Criteria) this;
        }

        public Criteria andSUsernameNotEqualTo(String value) {
            addCriterion("S_USERNAME <>", value, "sUsername");
            return (Criteria) this;
        }

        public Criteria andSUsernameGreaterThan(String value) {
            addCriterion("S_USERNAME >", value, "sUsername");
            return (Criteria) this;
        }

        public Criteria andSUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("S_USERNAME >=", value, "sUsername");
            return (Criteria) this;
        }

        public Criteria andSUsernameLessThan(String value) {
            addCriterion("S_USERNAME <", value, "sUsername");
            return (Criteria) this;
        }

        public Criteria andSUsernameLessThanOrEqualTo(String value) {
            addCriterion("S_USERNAME <=", value, "sUsername");
            return (Criteria) this;
        }

        public Criteria andSUsernameLike(String value) {
            addCriterion("S_USERNAME like", value, "sUsername");
            return (Criteria) this;
        }

        public Criteria andSUsernameNotLike(String value) {
            addCriterion("S_USERNAME not like", value, "sUsername");
            return (Criteria) this;
        }

        public Criteria andSUsernameIn(List<String> values) {
            addCriterion("S_USERNAME in", values, "sUsername");
            return (Criteria) this;
        }

        public Criteria andSUsernameNotIn(List<String> values) {
            addCriterion("S_USERNAME not in", values, "sUsername");
            return (Criteria) this;
        }

        public Criteria andSUsernameBetween(String value1, String value2) {
            addCriterion("S_USERNAME between", value1, value2, "sUsername");
            return (Criteria) this;
        }

        public Criteria andSUsernameNotBetween(String value1, String value2) {
            addCriterion("S_USERNAME not between", value1, value2, "sUsername");
            return (Criteria) this;
        }

        public Criteria andSPasswordIsNull() {
            addCriterion("S_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andSPasswordIsNotNull() {
            addCriterion("S_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andSPasswordEqualTo(String value) {
            addCriterion("S_PASSWORD =", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordNotEqualTo(String value) {
            addCriterion("S_PASSWORD <>", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordGreaterThan(String value) {
            addCriterion("S_PASSWORD >", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("S_PASSWORD >=", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordLessThan(String value) {
            addCriterion("S_PASSWORD <", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordLessThanOrEqualTo(String value) {
            addCriterion("S_PASSWORD <=", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordLike(String value) {
            addCriterion("S_PASSWORD like", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordNotLike(String value) {
            addCriterion("S_PASSWORD not like", value, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordIn(List<String> values) {
            addCriterion("S_PASSWORD in", values, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordNotIn(List<String> values) {
            addCriterion("S_PASSWORD not in", values, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordBetween(String value1, String value2) {
            addCriterion("S_PASSWORD between", value1, value2, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSPasswordNotBetween(String value1, String value2) {
            addCriterion("S_PASSWORD not between", value1, value2, "sPassword");
            return (Criteria) this;
        }

        public Criteria andSUserTypeIsNull() {
            addCriterion("S_USER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSUserTypeIsNotNull() {
            addCriterion("S_USER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSUserTypeEqualTo(String value) {
            addCriterion("S_USER_TYPE =", value, "sUserType");
            return (Criteria) this;
        }

        public Criteria andSUserTypeNotEqualTo(String value) {
            addCriterion("S_USER_TYPE <>", value, "sUserType");
            return (Criteria) this;
        }

        public Criteria andSUserTypeGreaterThan(String value) {
            addCriterion("S_USER_TYPE >", value, "sUserType");
            return (Criteria) this;
        }

        public Criteria andSUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("S_USER_TYPE >=", value, "sUserType");
            return (Criteria) this;
        }

        public Criteria andSUserTypeLessThan(String value) {
            addCriterion("S_USER_TYPE <", value, "sUserType");
            return (Criteria) this;
        }

        public Criteria andSUserTypeLessThanOrEqualTo(String value) {
            addCriterion("S_USER_TYPE <=", value, "sUserType");
            return (Criteria) this;
        }

        public Criteria andSUserTypeLike(String value) {
            addCriterion("S_USER_TYPE like", value, "sUserType");
            return (Criteria) this;
        }

        public Criteria andSUserTypeNotLike(String value) {
            addCriterion("S_USER_TYPE not like", value, "sUserType");
            return (Criteria) this;
        }

        public Criteria andSUserTypeIn(List<String> values) {
            addCriterion("S_USER_TYPE in", values, "sUserType");
            return (Criteria) this;
        }

        public Criteria andSUserTypeNotIn(List<String> values) {
            addCriterion("S_USER_TYPE not in", values, "sUserType");
            return (Criteria) this;
        }

        public Criteria andSUserTypeBetween(String value1, String value2) {
            addCriterion("S_USER_TYPE between", value1, value2, "sUserType");
            return (Criteria) this;
        }

        public Criteria andSUserTypeNotBetween(String value1, String value2) {
            addCriterion("S_USER_TYPE not between", value1, value2, "sUserType");
            return (Criteria) this;
        }

        public Criteria andDRgTimeIsNull() {
            addCriterion("D_RG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDRgTimeIsNotNull() {
            addCriterion("D_RG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDRgTimeEqualTo(Date value) {
            addCriterion("D_RG_TIME =", value, "dRgTime");
            return (Criteria) this;
        }

        public Criteria andDRgTimeNotEqualTo(Date value) {
            addCriterion("D_RG_TIME <>", value, "dRgTime");
            return (Criteria) this;
        }

        public Criteria andDRgTimeGreaterThan(Date value) {
            addCriterion("D_RG_TIME >", value, "dRgTime");
            return (Criteria) this;
        }

        public Criteria andDRgTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("D_RG_TIME >=", value, "dRgTime");
            return (Criteria) this;
        }

        public Criteria andDRgTimeLessThan(Date value) {
            addCriterion("D_RG_TIME <", value, "dRgTime");
            return (Criteria) this;
        }

        public Criteria andDRgTimeLessThanOrEqualTo(Date value) {
            addCriterion("D_RG_TIME <=", value, "dRgTime");
            return (Criteria) this;
        }

        public Criteria andDRgTimeIn(List<Date> values) {
            addCriterion("D_RG_TIME in", values, "dRgTime");
            return (Criteria) this;
        }

        public Criteria andDRgTimeNotIn(List<Date> values) {
            addCriterion("D_RG_TIME not in", values, "dRgTime");
            return (Criteria) this;
        }

        public Criteria andDRgTimeBetween(Date value1, Date value2) {
            addCriterion("D_RG_TIME between", value1, value2, "dRgTime");
            return (Criteria) this;
        }

        public Criteria andDRgTimeNotBetween(Date value1, Date value2) {
            addCriterion("D_RG_TIME not between", value1, value2, "dRgTime");
            return (Criteria) this;
        }

        public Criteria andSExtValue1IsNull() {
            addCriterion("S_EXT_VALUE1 is null");
            return (Criteria) this;
        }

        public Criteria andSExtValue1IsNotNull() {
            addCriterion("S_EXT_VALUE1 is not null");
            return (Criteria) this;
        }

        public Criteria andSExtValue1EqualTo(String value) {
            addCriterion("S_EXT_VALUE1 =", value, "sExtValue1");
            return (Criteria) this;
        }

        public Criteria andSExtValue1NotEqualTo(String value) {
            addCriterion("S_EXT_VALUE1 <>", value, "sExtValue1");
            return (Criteria) this;
        }

        public Criteria andSExtValue1GreaterThan(String value) {
            addCriterion("S_EXT_VALUE1 >", value, "sExtValue1");
            return (Criteria) this;
        }

        public Criteria andSExtValue1GreaterThanOrEqualTo(String value) {
            addCriterion("S_EXT_VALUE1 >=", value, "sExtValue1");
            return (Criteria) this;
        }

        public Criteria andSExtValue1LessThan(String value) {
            addCriterion("S_EXT_VALUE1 <", value, "sExtValue1");
            return (Criteria) this;
        }

        public Criteria andSExtValue1LessThanOrEqualTo(String value) {
            addCriterion("S_EXT_VALUE1 <=", value, "sExtValue1");
            return (Criteria) this;
        }

        public Criteria andSExtValue1Like(String value) {
            addCriterion("S_EXT_VALUE1 like", value, "sExtValue1");
            return (Criteria) this;
        }

        public Criteria andSExtValue1NotLike(String value) {
            addCriterion("S_EXT_VALUE1 not like", value, "sExtValue1");
            return (Criteria) this;
        }

        public Criteria andSExtValue1In(List<String> values) {
            addCriterion("S_EXT_VALUE1 in", values, "sExtValue1");
            return (Criteria) this;
        }

        public Criteria andSExtValue1NotIn(List<String> values) {
            addCriterion("S_EXT_VALUE1 not in", values, "sExtValue1");
            return (Criteria) this;
        }

        public Criteria andSExtValue1Between(String value1, String value2) {
            addCriterion("S_EXT_VALUE1 between", value1, value2, "sExtValue1");
            return (Criteria) this;
        }

        public Criteria andSExtValue1NotBetween(String value1, String value2) {
            addCriterion("S_EXT_VALUE1 not between", value1, value2, "sExtValue1");
            return (Criteria) this;
        }

        public Criteria andSUserNoLikeInsensitive(String value) {
            addCriterion("upper(S_USER_NO) like", value.toUpperCase(), "sUserNo");
            return (Criteria) this;
        }

        public Criteria andSUsernameLikeInsensitive(String value) {
            addCriterion("upper(S_USERNAME) like", value.toUpperCase(), "sUsername");
            return (Criteria) this;
        }

        public Criteria andSPasswordLikeInsensitive(String value) {
            addCriterion("upper(S_PASSWORD) like", value.toUpperCase(), "sPassword");
            return (Criteria) this;
        }

        public Criteria andSUserTypeLikeInsensitive(String value) {
            addCriterion("upper(S_USER_TYPE) like", value.toUpperCase(), "sUserType");
            return (Criteria) this;
        }

        public Criteria andSExtValue1LikeInsensitive(String value) {
            addCriterion("upper(S_EXT_VALUE1) like", value.toUpperCase(), "sExtValue1");
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