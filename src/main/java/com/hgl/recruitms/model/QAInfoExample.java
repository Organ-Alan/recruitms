package com.hgl.recruitms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QAInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QAInfoExample() {
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

        public Criteria andNQaIdIsNull() {
            addCriterion("N_QA_ID is null");
            return (Criteria) this;
        }

        public Criteria andNQaIdIsNotNull() {
            addCriterion("N_QA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNQaIdEqualTo(Integer value) {
            addCriterion("N_QA_ID =", value, "nQaId");
            return (Criteria) this;
        }

        public Criteria andNQaIdNotEqualTo(Integer value) {
            addCriterion("N_QA_ID <>", value, "nQaId");
            return (Criteria) this;
        }

        public Criteria andNQaIdGreaterThan(Integer value) {
            addCriterion("N_QA_ID >", value, "nQaId");
            return (Criteria) this;
        }

        public Criteria andNQaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_QA_ID >=", value, "nQaId");
            return (Criteria) this;
        }

        public Criteria andNQaIdLessThan(Integer value) {
            addCriterion("N_QA_ID <", value, "nQaId");
            return (Criteria) this;
        }

        public Criteria andNQaIdLessThanOrEqualTo(Integer value) {
            addCriterion("N_QA_ID <=", value, "nQaId");
            return (Criteria) this;
        }

        public Criteria andNQaIdIn(List<Integer> values) {
            addCriterion("N_QA_ID in", values, "nQaId");
            return (Criteria) this;
        }

        public Criteria andNQaIdNotIn(List<Integer> values) {
            addCriterion("N_QA_ID not in", values, "nQaId");
            return (Criteria) this;
        }

        public Criteria andNQaIdBetween(Integer value1, Integer value2) {
            addCriterion("N_QA_ID between", value1, value2, "nQaId");
            return (Criteria) this;
        }

        public Criteria andNQaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("N_QA_ID not between", value1, value2, "nQaId");
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

        public Criteria andSSortNoEqualTo(Integer value) {
            addCriterion("S_SORT_NO =", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoNotEqualTo(Integer value) {
            addCriterion("S_SORT_NO <>", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoGreaterThan(Integer value) {
            addCriterion("S_SORT_NO >", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("S_SORT_NO >=", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoLessThan(Integer value) {
            addCriterion("S_SORT_NO <", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoLessThanOrEqualTo(Integer value) {
            addCriterion("S_SORT_NO <=", value, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoIn(List<Integer> values) {
            addCriterion("S_SORT_NO in", values, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoNotIn(List<Integer> values) {
            addCriterion("S_SORT_NO not in", values, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoBetween(Integer value1, Integer value2) {
            addCriterion("S_SORT_NO between", value1, value2, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSSortNoNotBetween(Integer value1, Integer value2) {
            addCriterion("S_SORT_NO not between", value1, value2, "sSortNo");
            return (Criteria) this;
        }

        public Criteria andSQuestionIsNull() {
            addCriterion("S_QUESTION is null");
            return (Criteria) this;
        }

        public Criteria andSQuestionIsNotNull() {
            addCriterion("S_QUESTION is not null");
            return (Criteria) this;
        }

        public Criteria andSQuestionEqualTo(String value) {
            addCriterion("S_QUESTION =", value, "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSQuestionNotEqualTo(String value) {
            addCriterion("S_QUESTION <>", value, "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSQuestionGreaterThan(String value) {
            addCriterion("S_QUESTION >", value, "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("S_QUESTION >=", value, "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSQuestionLessThan(String value) {
            addCriterion("S_QUESTION <", value, "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSQuestionLessThanOrEqualTo(String value) {
            addCriterion("S_QUESTION <=", value, "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSQuestionLike(String value) {
            addCriterion("S_QUESTION like", value, "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSQuestionNotLike(String value) {
            addCriterion("S_QUESTION not like", value, "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSQuestionIn(List<String> values) {
            addCriterion("S_QUESTION in", values, "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSQuestionNotIn(List<String> values) {
            addCriterion("S_QUESTION not in", values, "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSQuestionBetween(String value1, String value2) {
            addCriterion("S_QUESTION between", value1, value2, "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSQuestionNotBetween(String value1, String value2) {
            addCriterion("S_QUESTION not between", value1, value2, "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSAnswerIsNull() {
            addCriterion("S_ANSWER is null");
            return (Criteria) this;
        }

        public Criteria andSAnswerIsNotNull() {
            addCriterion("S_ANSWER is not null");
            return (Criteria) this;
        }

        public Criteria andSAnswerEqualTo(String value) {
            addCriterion("S_ANSWER =", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerNotEqualTo(String value) {
            addCriterion("S_ANSWER <>", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerGreaterThan(String value) {
            addCriterion("S_ANSWER >", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("S_ANSWER >=", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerLessThan(String value) {
            addCriterion("S_ANSWER <", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerLessThanOrEqualTo(String value) {
            addCriterion("S_ANSWER <=", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerLike(String value) {
            addCriterion("S_ANSWER like", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerNotLike(String value) {
            addCriterion("S_ANSWER not like", value, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerIn(List<String> values) {
            addCriterion("S_ANSWER in", values, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerNotIn(List<String> values) {
            addCriterion("S_ANSWER not in", values, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerBetween(String value1, String value2) {
            addCriterion("S_ANSWER between", value1, value2, "sAnswer");
            return (Criteria) this;
        }

        public Criteria andSAnswerNotBetween(String value1, String value2) {
            addCriterion("S_ANSWER not between", value1, value2, "sAnswer");
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

        public Criteria andDCreateTimeIsNull() {
            addCriterion("D_CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDCreateTimeIsNotNull() {
            addCriterion("D_CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDCreateTimeEqualTo(Date value) {
            addCriterion("D_CREATE_TIME =", value, "dCreateTime");
            return (Criteria) this;
        }

        public Criteria andDCreateTimeNotEqualTo(Date value) {
            addCriterion("D_CREATE_TIME <>", value, "dCreateTime");
            return (Criteria) this;
        }

        public Criteria andDCreateTimeGreaterThan(Date value) {
            addCriterion("D_CREATE_TIME >", value, "dCreateTime");
            return (Criteria) this;
        }

        public Criteria andDCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("D_CREATE_TIME >=", value, "dCreateTime");
            return (Criteria) this;
        }

        public Criteria andDCreateTimeLessThan(Date value) {
            addCriterion("D_CREATE_TIME <", value, "dCreateTime");
            return (Criteria) this;
        }

        public Criteria andDCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("D_CREATE_TIME <=", value, "dCreateTime");
            return (Criteria) this;
        }

        public Criteria andDCreateTimeIn(List<Date> values) {
            addCriterion("D_CREATE_TIME in", values, "dCreateTime");
            return (Criteria) this;
        }

        public Criteria andDCreateTimeNotIn(List<Date> values) {
            addCriterion("D_CREATE_TIME not in", values, "dCreateTime");
            return (Criteria) this;
        }

        public Criteria andDCreateTimeBetween(Date value1, Date value2) {
            addCriterion("D_CREATE_TIME between", value1, value2, "dCreateTime");
            return (Criteria) this;
        }

        public Criteria andDCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("D_CREATE_TIME not between", value1, value2, "dCreateTime");
            return (Criteria) this;
        }

        public Criteria andSCreatorIsNull() {
            addCriterion("S_CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andSCreatorIsNotNull() {
            addCriterion("S_CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andSCreatorEqualTo(String value) {
            addCriterion("S_CREATOR =", value, "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorNotEqualTo(String value) {
            addCriterion("S_CREATOR <>", value, "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorGreaterThan(String value) {
            addCriterion("S_CREATOR >", value, "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("S_CREATOR >=", value, "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorLessThan(String value) {
            addCriterion("S_CREATOR <", value, "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorLessThanOrEqualTo(String value) {
            addCriterion("S_CREATOR <=", value, "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorLike(String value) {
            addCriterion("S_CREATOR like", value, "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorNotLike(String value) {
            addCriterion("S_CREATOR not like", value, "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorIn(List<String> values) {
            addCriterion("S_CREATOR in", values, "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorNotIn(List<String> values) {
            addCriterion("S_CREATOR not in", values, "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorBetween(String value1, String value2) {
            addCriterion("S_CREATOR between", value1, value2, "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorNotBetween(String value1, String value2) {
            addCriterion("S_CREATOR not between", value1, value2, "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoIsNull() {
            addCriterion("S_CREATOR_NO is null");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoIsNotNull() {
            addCriterion("S_CREATOR_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoEqualTo(Integer value) {
            addCriterion("S_CREATOR_NO =", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoNotEqualTo(Integer value) {
            addCriterion("S_CREATOR_NO <>", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoGreaterThan(Integer value) {
            addCriterion("S_CREATOR_NO >", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("S_CREATOR_NO >=", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoLessThan(Integer value) {
            addCriterion("S_CREATOR_NO <", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoLessThanOrEqualTo(Integer value) {
            addCriterion("S_CREATOR_NO <=", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoIn(List<Integer> values) {
            addCriterion("S_CREATOR_NO in", values, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoNotIn(List<Integer> values) {
            addCriterion("S_CREATOR_NO not in", values, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoBetween(Integer value1, Integer value2) {
            addCriterion("S_CREATOR_NO between", value1, value2, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoNotBetween(Integer value1, Integer value2) {
            addCriterion("S_CREATOR_NO not between", value1, value2, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSQuestionLikeInsensitive(String value) {
            addCriterion("upper(S_QUESTION) like", value.toUpperCase(), "sQuestion");
            return (Criteria) this;
        }

        public Criteria andSAnswerLikeInsensitive(String value) {
            addCriterion("upper(S_ANSWER) like", value.toUpperCase(), "sAnswer");
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

        public Criteria andSCreatorLikeInsensitive(String value) {
            addCriterion("upper(S_CREATOR) like", value.toUpperCase(), "sCreator");
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