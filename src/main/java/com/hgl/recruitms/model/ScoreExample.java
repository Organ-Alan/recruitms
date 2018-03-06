package com.hgl.recruitms.model;

import java.util.ArrayList;
import java.util.List;

public class ScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScoreExample() {
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

        public Criteria andNStudentIdIsNull() {
            addCriterion("N_STUDENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andNStudentIdIsNotNull() {
            addCriterion("N_STUDENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNStudentIdEqualTo(Integer value) {
            addCriterion("N_STUDENT_ID =", value, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdNotEqualTo(Integer value) {
            addCriterion("N_STUDENT_ID <>", value, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdGreaterThan(Integer value) {
            addCriterion("N_STUDENT_ID >", value, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_STUDENT_ID >=", value, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdLessThan(Integer value) {
            addCriterion("N_STUDENT_ID <", value, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("N_STUDENT_ID <=", value, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdIn(List<Integer> values) {
            addCriterion("N_STUDENT_ID in", values, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdNotIn(List<Integer> values) {
            addCriterion("N_STUDENT_ID not in", values, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("N_STUDENT_ID between", value1, value2, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andNStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("N_STUDENT_ID not between", value1, value2, "nStudentId");
            return (Criteria) this;
        }

        public Criteria andSStudentNameIsNull() {
            addCriterion("S_STUDENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSStudentNameIsNotNull() {
            addCriterion("S_STUDENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSStudentNameEqualTo(String value) {
            addCriterion("S_STUDENT_NAME =", value, "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNameNotEqualTo(String value) {
            addCriterion("S_STUDENT_NAME <>", value, "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNameGreaterThan(String value) {
            addCriterion("S_STUDENT_NAME >", value, "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("S_STUDENT_NAME >=", value, "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNameLessThan(String value) {
            addCriterion("S_STUDENT_NAME <", value, "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNameLessThanOrEqualTo(String value) {
            addCriterion("S_STUDENT_NAME <=", value, "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNameLike(String value) {
            addCriterion("S_STUDENT_NAME like", value, "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNameNotLike(String value) {
            addCriterion("S_STUDENT_NAME not like", value, "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNameIn(List<String> values) {
            addCriterion("S_STUDENT_NAME in", values, "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNameNotIn(List<String> values) {
            addCriterion("S_STUDENT_NAME not in", values, "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNameBetween(String value1, String value2) {
            addCriterion("S_STUDENT_NAME between", value1, value2, "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNameNotBetween(String value1, String value2) {
            addCriterion("S_STUDENT_NAME not between", value1, value2, "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNoIsNull() {
            addCriterion("S_STUDENT_NO is null");
            return (Criteria) this;
        }

        public Criteria andSStudentNoIsNotNull() {
            addCriterion("S_STUDENT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSStudentNoEqualTo(String value) {
            addCriterion("S_STUDENT_NO =", value, "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSStudentNoNotEqualTo(String value) {
            addCriterion("S_STUDENT_NO <>", value, "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSStudentNoGreaterThan(String value) {
            addCriterion("S_STUDENT_NO >", value, "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSStudentNoGreaterThanOrEqualTo(String value) {
            addCriterion("S_STUDENT_NO >=", value, "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSStudentNoLessThan(String value) {
            addCriterion("S_STUDENT_NO <", value, "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSStudentNoLessThanOrEqualTo(String value) {
            addCriterion("S_STUDENT_NO <=", value, "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSStudentNoLike(String value) {
            addCriterion("S_STUDENT_NO like", value, "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSStudentNoNotLike(String value) {
            addCriterion("S_STUDENT_NO not like", value, "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSStudentNoIn(List<String> values) {
            addCriterion("S_STUDENT_NO in", values, "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSStudentNoNotIn(List<String> values) {
            addCriterion("S_STUDENT_NO not in", values, "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSStudentNoBetween(String value1, String value2) {
            addCriterion("S_STUDENT_NO between", value1, value2, "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSStudentNoNotBetween(String value1, String value2) {
            addCriterion("S_STUDENT_NO not between", value1, value2, "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeIsNull() {
            addCriterion("S_SUBJECT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeIsNotNull() {
            addCriterion("S_SUBJECT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeEqualTo(String value) {
            addCriterion("S_SUBJECT_TYPE =", value, "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeNotEqualTo(String value) {
            addCriterion("S_SUBJECT_TYPE <>", value, "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeGreaterThan(String value) {
            addCriterion("S_SUBJECT_TYPE >", value, "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("S_SUBJECT_TYPE >=", value, "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeLessThan(String value) {
            addCriterion("S_SUBJECT_TYPE <", value, "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeLessThanOrEqualTo(String value) {
            addCriterion("S_SUBJECT_TYPE <=", value, "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeLike(String value) {
            addCriterion("S_SUBJECT_TYPE like", value, "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeNotLike(String value) {
            addCriterion("S_SUBJECT_TYPE not like", value, "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeIn(List<String> values) {
            addCriterion("S_SUBJECT_TYPE in", values, "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeNotIn(List<String> values) {
            addCriterion("S_SUBJECT_TYPE not in", values, "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeBetween(String value1, String value2) {
            addCriterion("S_SUBJECT_TYPE between", value1, value2, "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeNotBetween(String value1, String value2) {
            addCriterion("S_SUBJECT_TYPE not between", value1, value2, "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andDbScoreIsNull() {
            addCriterion("DB_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andDbScoreIsNotNull() {
            addCriterion("DB_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andDbScoreEqualTo(Double value) {
            addCriterion("DB_SCORE =", value, "dbScore");
            return (Criteria) this;
        }

        public Criteria andDbScoreNotEqualTo(Double value) {
            addCriterion("DB_SCORE <>", value, "dbScore");
            return (Criteria) this;
        }

        public Criteria andDbScoreGreaterThan(Double value) {
            addCriterion("DB_SCORE >", value, "dbScore");
            return (Criteria) this;
        }

        public Criteria andDbScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("DB_SCORE >=", value, "dbScore");
            return (Criteria) this;
        }

        public Criteria andDbScoreLessThan(Double value) {
            addCriterion("DB_SCORE <", value, "dbScore");
            return (Criteria) this;
        }

        public Criteria andDbScoreLessThanOrEqualTo(Double value) {
            addCriterion("DB_SCORE <=", value, "dbScore");
            return (Criteria) this;
        }

        public Criteria andDbScoreIn(List<Double> values) {
            addCriterion("DB_SCORE in", values, "dbScore");
            return (Criteria) this;
        }

        public Criteria andDbScoreNotIn(List<Double> values) {
            addCriterion("DB_SCORE not in", values, "dbScore");
            return (Criteria) this;
        }

        public Criteria andDbScoreBetween(Double value1, Double value2) {
            addCriterion("DB_SCORE between", value1, value2, "dbScore");
            return (Criteria) this;
        }

        public Criteria andDbScoreNotBetween(Double value1, Double value2) {
            addCriterion("DB_SCORE not between", value1, value2, "dbScore");
            return (Criteria) this;
        }

        public Criteria andDbChinsesIsNull() {
            addCriterion("DB_CHINSES is null");
            return (Criteria) this;
        }

        public Criteria andDbChinsesIsNotNull() {
            addCriterion("DB_CHINSES is not null");
            return (Criteria) this;
        }

        public Criteria andDbChinsesEqualTo(Double value) {
            addCriterion("DB_CHINSES =", value, "dbChinses");
            return (Criteria) this;
        }

        public Criteria andDbChinsesNotEqualTo(Double value) {
            addCriterion("DB_CHINSES <>", value, "dbChinses");
            return (Criteria) this;
        }

        public Criteria andDbChinsesGreaterThan(Double value) {
            addCriterion("DB_CHINSES >", value, "dbChinses");
            return (Criteria) this;
        }

        public Criteria andDbChinsesGreaterThanOrEqualTo(Double value) {
            addCriterion("DB_CHINSES >=", value, "dbChinses");
            return (Criteria) this;
        }

        public Criteria andDbChinsesLessThan(Double value) {
            addCriterion("DB_CHINSES <", value, "dbChinses");
            return (Criteria) this;
        }

        public Criteria andDbChinsesLessThanOrEqualTo(Double value) {
            addCriterion("DB_CHINSES <=", value, "dbChinses");
            return (Criteria) this;
        }

        public Criteria andDbChinsesIn(List<Double> values) {
            addCriterion("DB_CHINSES in", values, "dbChinses");
            return (Criteria) this;
        }

        public Criteria andDbChinsesNotIn(List<Double> values) {
            addCriterion("DB_CHINSES not in", values, "dbChinses");
            return (Criteria) this;
        }

        public Criteria andDbChinsesBetween(Double value1, Double value2) {
            addCriterion("DB_CHINSES between", value1, value2, "dbChinses");
            return (Criteria) this;
        }

        public Criteria andDbChinsesNotBetween(Double value1, Double value2) {
            addCriterion("DB_CHINSES not between", value1, value2, "dbChinses");
            return (Criteria) this;
        }

        public Criteria andDbEnglishIsNull() {
            addCriterion("DB_ENGLISH is null");
            return (Criteria) this;
        }

        public Criteria andDbEnglishIsNotNull() {
            addCriterion("DB_ENGLISH is not null");
            return (Criteria) this;
        }

        public Criteria andDbEnglishEqualTo(Double value) {
            addCriterion("DB_ENGLISH =", value, "dbEnglish");
            return (Criteria) this;
        }

        public Criteria andDbEnglishNotEqualTo(Double value) {
            addCriterion("DB_ENGLISH <>", value, "dbEnglish");
            return (Criteria) this;
        }

        public Criteria andDbEnglishGreaterThan(Double value) {
            addCriterion("DB_ENGLISH >", value, "dbEnglish");
            return (Criteria) this;
        }

        public Criteria andDbEnglishGreaterThanOrEqualTo(Double value) {
            addCriterion("DB_ENGLISH >=", value, "dbEnglish");
            return (Criteria) this;
        }

        public Criteria andDbEnglishLessThan(Double value) {
            addCriterion("DB_ENGLISH <", value, "dbEnglish");
            return (Criteria) this;
        }

        public Criteria andDbEnglishLessThanOrEqualTo(Double value) {
            addCriterion("DB_ENGLISH <=", value, "dbEnglish");
            return (Criteria) this;
        }

        public Criteria andDbEnglishIn(List<Double> values) {
            addCriterion("DB_ENGLISH in", values, "dbEnglish");
            return (Criteria) this;
        }

        public Criteria andDbEnglishNotIn(List<Double> values) {
            addCriterion("DB_ENGLISH not in", values, "dbEnglish");
            return (Criteria) this;
        }

        public Criteria andDbEnglishBetween(Double value1, Double value2) {
            addCriterion("DB_ENGLISH between", value1, value2, "dbEnglish");
            return (Criteria) this;
        }

        public Criteria andDbEnglishNotBetween(Double value1, Double value2) {
            addCriterion("DB_ENGLISH not between", value1, value2, "dbEnglish");
            return (Criteria) this;
        }

        public Criteria andDbMathIsNull() {
            addCriterion("DB_MATH is null");
            return (Criteria) this;
        }

        public Criteria andDbMathIsNotNull() {
            addCriterion("DB_MATH is not null");
            return (Criteria) this;
        }

        public Criteria andDbMathEqualTo(Double value) {
            addCriterion("DB_MATH =", value, "dbMath");
            return (Criteria) this;
        }

        public Criteria andDbMathNotEqualTo(Double value) {
            addCriterion("DB_MATH <>", value, "dbMath");
            return (Criteria) this;
        }

        public Criteria andDbMathGreaterThan(Double value) {
            addCriterion("DB_MATH >", value, "dbMath");
            return (Criteria) this;
        }

        public Criteria andDbMathGreaterThanOrEqualTo(Double value) {
            addCriterion("DB_MATH >=", value, "dbMath");
            return (Criteria) this;
        }

        public Criteria andDbMathLessThan(Double value) {
            addCriterion("DB_MATH <", value, "dbMath");
            return (Criteria) this;
        }

        public Criteria andDbMathLessThanOrEqualTo(Double value) {
            addCriterion("DB_MATH <=", value, "dbMath");
            return (Criteria) this;
        }

        public Criteria andDbMathIn(List<Double> values) {
            addCriterion("DB_MATH in", values, "dbMath");
            return (Criteria) this;
        }

        public Criteria andDbMathNotIn(List<Double> values) {
            addCriterion("DB_MATH not in", values, "dbMath");
            return (Criteria) this;
        }

        public Criteria andDbMathBetween(Double value1, Double value2) {
            addCriterion("DB_MATH between", value1, value2, "dbMath");
            return (Criteria) this;
        }

        public Criteria andDbMathNotBetween(Double value1, Double value2) {
            addCriterion("DB_MATH not between", value1, value2, "dbMath");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreIsNull() {
            addCriterion("S_TOTAL_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreIsNotNull() {
            addCriterion("S_TOTAL_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreEqualTo(String value) {
            addCriterion("S_TOTAL_SCORE =", value, "sTotalScore");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreNotEqualTo(String value) {
            addCriterion("S_TOTAL_SCORE <>", value, "sTotalScore");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreGreaterThan(String value) {
            addCriterion("S_TOTAL_SCORE >", value, "sTotalScore");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreGreaterThanOrEqualTo(String value) {
            addCriterion("S_TOTAL_SCORE >=", value, "sTotalScore");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreLessThan(String value) {
            addCriterion("S_TOTAL_SCORE <", value, "sTotalScore");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreLessThanOrEqualTo(String value) {
            addCriterion("S_TOTAL_SCORE <=", value, "sTotalScore");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreLike(String value) {
            addCriterion("S_TOTAL_SCORE like", value, "sTotalScore");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreNotLike(String value) {
            addCriterion("S_TOTAL_SCORE not like", value, "sTotalScore");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreIn(List<String> values) {
            addCriterion("S_TOTAL_SCORE in", values, "sTotalScore");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreNotIn(List<String> values) {
            addCriterion("S_TOTAL_SCORE not in", values, "sTotalScore");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreBetween(String value1, String value2) {
            addCriterion("S_TOTAL_SCORE between", value1, value2, "sTotalScore");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreNotBetween(String value1, String value2) {
            addCriterion("S_TOTAL_SCORE not between", value1, value2, "sTotalScore");
            return (Criteria) this;
        }

        public Criteria andSStudentNameLikeInsensitive(String value) {
            addCriterion("upper(S_STUDENT_NAME) like", value.toUpperCase(), "sStudentName");
            return (Criteria) this;
        }

        public Criteria andSStudentNoLikeInsensitive(String value) {
            addCriterion("upper(S_STUDENT_NO) like", value.toUpperCase(), "sStudentNo");
            return (Criteria) this;
        }

        public Criteria andSSubjectTypeLikeInsensitive(String value) {
            addCriterion("upper(S_SUBJECT_TYPE) like", value.toUpperCase(), "sSubjectType");
            return (Criteria) this;
        }

        public Criteria andSTotalScoreLikeInsensitive(String value) {
            addCriterion("upper(S_TOTAL_SCORE) like", value.toUpperCase(), "sTotalScore");
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