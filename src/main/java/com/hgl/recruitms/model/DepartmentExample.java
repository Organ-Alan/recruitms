package com.hgl.recruitms.model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepartmentExample() {
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

        public Criteria andNDeptNoIsNull() {
            addCriterion("N_DEPT_NO is null");
            return (Criteria) this;
        }

        public Criteria andNDeptNoIsNotNull() {
            addCriterion("N_DEPT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNDeptNoEqualTo(Integer value) {
            addCriterion("N_DEPT_NO =", value, "nDeptNo");
            return (Criteria) this;
        }

        public Criteria andNDeptNoNotEqualTo(Integer value) {
            addCriterion("N_DEPT_NO <>", value, "nDeptNo");
            return (Criteria) this;
        }

        public Criteria andNDeptNoGreaterThan(Integer value) {
            addCriterion("N_DEPT_NO >", value, "nDeptNo");
            return (Criteria) this;
        }

        public Criteria andNDeptNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_DEPT_NO >=", value, "nDeptNo");
            return (Criteria) this;
        }

        public Criteria andNDeptNoLessThan(Integer value) {
            addCriterion("N_DEPT_NO <", value, "nDeptNo");
            return (Criteria) this;
        }

        public Criteria andNDeptNoLessThanOrEqualTo(Integer value) {
            addCriterion("N_DEPT_NO <=", value, "nDeptNo");
            return (Criteria) this;
        }

        public Criteria andNDeptNoIn(List<Integer> values) {
            addCriterion("N_DEPT_NO in", values, "nDeptNo");
            return (Criteria) this;
        }

        public Criteria andNDeptNoNotIn(List<Integer> values) {
            addCriterion("N_DEPT_NO not in", values, "nDeptNo");
            return (Criteria) this;
        }

        public Criteria andNDeptNoBetween(Integer value1, Integer value2) {
            addCriterion("N_DEPT_NO between", value1, value2, "nDeptNo");
            return (Criteria) this;
        }

        public Criteria andNDeptNoNotBetween(Integer value1, Integer value2) {
            addCriterion("N_DEPT_NO not between", value1, value2, "nDeptNo");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeIsNull() {
            addCriterion("S_DEPT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeIsNotNull() {
            addCriterion("S_DEPT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeEqualTo(String value) {
            addCriterion("S_DEPT_CODE =", value, "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeNotEqualTo(String value) {
            addCriterion("S_DEPT_CODE <>", value, "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeGreaterThan(String value) {
            addCriterion("S_DEPT_CODE >", value, "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("S_DEPT_CODE >=", value, "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeLessThan(String value) {
            addCriterion("S_DEPT_CODE <", value, "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeLessThanOrEqualTo(String value) {
            addCriterion("S_DEPT_CODE <=", value, "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeLike(String value) {
            addCriterion("S_DEPT_CODE like", value, "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeNotLike(String value) {
            addCriterion("S_DEPT_CODE not like", value, "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeIn(List<String> values) {
            addCriterion("S_DEPT_CODE in", values, "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeNotIn(List<String> values) {
            addCriterion("S_DEPT_CODE not in", values, "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeBetween(String value1, String value2) {
            addCriterion("S_DEPT_CODE between", value1, value2, "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSDeptCodeNotBetween(String value1, String value2) {
            addCriterion("S_DEPT_CODE not between", value1, value2, "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSShortNameIsNull() {
            addCriterion("S_SHORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSShortNameIsNotNull() {
            addCriterion("S_SHORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSShortNameEqualTo(String value) {
            addCriterion("S_SHORT_NAME =", value, "sShortName");
            return (Criteria) this;
        }

        public Criteria andSShortNameNotEqualTo(String value) {
            addCriterion("S_SHORT_NAME <>", value, "sShortName");
            return (Criteria) this;
        }

        public Criteria andSShortNameGreaterThan(String value) {
            addCriterion("S_SHORT_NAME >", value, "sShortName");
            return (Criteria) this;
        }

        public Criteria andSShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("S_SHORT_NAME >=", value, "sShortName");
            return (Criteria) this;
        }

        public Criteria andSShortNameLessThan(String value) {
            addCriterion("S_SHORT_NAME <", value, "sShortName");
            return (Criteria) this;
        }

        public Criteria andSShortNameLessThanOrEqualTo(String value) {
            addCriterion("S_SHORT_NAME <=", value, "sShortName");
            return (Criteria) this;
        }

        public Criteria andSShortNameLike(String value) {
            addCriterion("S_SHORT_NAME like", value, "sShortName");
            return (Criteria) this;
        }

        public Criteria andSShortNameNotLike(String value) {
            addCriterion("S_SHORT_NAME not like", value, "sShortName");
            return (Criteria) this;
        }

        public Criteria andSShortNameIn(List<String> values) {
            addCriterion("S_SHORT_NAME in", values, "sShortName");
            return (Criteria) this;
        }

        public Criteria andSShortNameNotIn(List<String> values) {
            addCriterion("S_SHORT_NAME not in", values, "sShortName");
            return (Criteria) this;
        }

        public Criteria andSShortNameBetween(String value1, String value2) {
            addCriterion("S_SHORT_NAME between", value1, value2, "sShortName");
            return (Criteria) this;
        }

        public Criteria andSShortNameNotBetween(String value1, String value2) {
            addCriterion("S_SHORT_NAME not between", value1, value2, "sShortName");
            return (Criteria) this;
        }

        public Criteria andSFullNameIsNull() {
            addCriterion("S_FULL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSFullNameIsNotNull() {
            addCriterion("S_FULL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSFullNameEqualTo(String value) {
            addCriterion("S_FULL_NAME =", value, "sFullName");
            return (Criteria) this;
        }

        public Criteria andSFullNameNotEqualTo(String value) {
            addCriterion("S_FULL_NAME <>", value, "sFullName");
            return (Criteria) this;
        }

        public Criteria andSFullNameGreaterThan(String value) {
            addCriterion("S_FULL_NAME >", value, "sFullName");
            return (Criteria) this;
        }

        public Criteria andSFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("S_FULL_NAME >=", value, "sFullName");
            return (Criteria) this;
        }

        public Criteria andSFullNameLessThan(String value) {
            addCriterion("S_FULL_NAME <", value, "sFullName");
            return (Criteria) this;
        }

        public Criteria andSFullNameLessThanOrEqualTo(String value) {
            addCriterion("S_FULL_NAME <=", value, "sFullName");
            return (Criteria) this;
        }

        public Criteria andSFullNameLike(String value) {
            addCriterion("S_FULL_NAME like", value, "sFullName");
            return (Criteria) this;
        }

        public Criteria andSFullNameNotLike(String value) {
            addCriterion("S_FULL_NAME not like", value, "sFullName");
            return (Criteria) this;
        }

        public Criteria andSFullNameIn(List<String> values) {
            addCriterion("S_FULL_NAME in", values, "sFullName");
            return (Criteria) this;
        }

        public Criteria andSFullNameNotIn(List<String> values) {
            addCriterion("S_FULL_NAME not in", values, "sFullName");
            return (Criteria) this;
        }

        public Criteria andSFullNameBetween(String value1, String value2) {
            addCriterion("S_FULL_NAME between", value1, value2, "sFullName");
            return (Criteria) this;
        }

        public Criteria andSFullNameNotBetween(String value1, String value2) {
            addCriterion("S_FULL_NAME not between", value1, value2, "sFullName");
            return (Criteria) this;
        }

        public Criteria andSRegionIsNull() {
            addCriterion("S_REGION is null");
            return (Criteria) this;
        }

        public Criteria andSRegionIsNotNull() {
            addCriterion("S_REGION is not null");
            return (Criteria) this;
        }

        public Criteria andSRegionEqualTo(String value) {
            addCriterion("S_REGION =", value, "sRegion");
            return (Criteria) this;
        }

        public Criteria andSRegionNotEqualTo(String value) {
            addCriterion("S_REGION <>", value, "sRegion");
            return (Criteria) this;
        }

        public Criteria andSRegionGreaterThan(String value) {
            addCriterion("S_REGION >", value, "sRegion");
            return (Criteria) this;
        }

        public Criteria andSRegionGreaterThanOrEqualTo(String value) {
            addCriterion("S_REGION >=", value, "sRegion");
            return (Criteria) this;
        }

        public Criteria andSRegionLessThan(String value) {
            addCriterion("S_REGION <", value, "sRegion");
            return (Criteria) this;
        }

        public Criteria andSRegionLessThanOrEqualTo(String value) {
            addCriterion("S_REGION <=", value, "sRegion");
            return (Criteria) this;
        }

        public Criteria andSRegionLike(String value) {
            addCriterion("S_REGION like", value, "sRegion");
            return (Criteria) this;
        }

        public Criteria andSRegionNotLike(String value) {
            addCriterion("S_REGION not like", value, "sRegion");
            return (Criteria) this;
        }

        public Criteria andSRegionIn(List<String> values) {
            addCriterion("S_REGION in", values, "sRegion");
            return (Criteria) this;
        }

        public Criteria andSRegionNotIn(List<String> values) {
            addCriterion("S_REGION not in", values, "sRegion");
            return (Criteria) this;
        }

        public Criteria andSRegionBetween(String value1, String value2) {
            addCriterion("S_REGION between", value1, value2, "sRegion");
            return (Criteria) this;
        }

        public Criteria andSRegionNotBetween(String value1, String value2) {
            addCriterion("S_REGION not between", value1, value2, "sRegion");
            return (Criteria) this;
        }

        public Criteria andSTuitionIsNull() {
            addCriterion("S_TUITION is null");
            return (Criteria) this;
        }

        public Criteria andSTuitionIsNotNull() {
            addCriterion("S_TUITION is not null");
            return (Criteria) this;
        }

        public Criteria andSTuitionEqualTo(String value) {
            addCriterion("S_TUITION =", value, "sTuition");
            return (Criteria) this;
        }

        public Criteria andSTuitionNotEqualTo(String value) {
            addCriterion("S_TUITION <>", value, "sTuition");
            return (Criteria) this;
        }

        public Criteria andSTuitionGreaterThan(String value) {
            addCriterion("S_TUITION >", value, "sTuition");
            return (Criteria) this;
        }

        public Criteria andSTuitionGreaterThanOrEqualTo(String value) {
            addCriterion("S_TUITION >=", value, "sTuition");
            return (Criteria) this;
        }

        public Criteria andSTuitionLessThan(String value) {
            addCriterion("S_TUITION <", value, "sTuition");
            return (Criteria) this;
        }

        public Criteria andSTuitionLessThanOrEqualTo(String value) {
            addCriterion("S_TUITION <=", value, "sTuition");
            return (Criteria) this;
        }

        public Criteria andSTuitionLike(String value) {
            addCriterion("S_TUITION like", value, "sTuition");
            return (Criteria) this;
        }

        public Criteria andSTuitionNotLike(String value) {
            addCriterion("S_TUITION not like", value, "sTuition");
            return (Criteria) this;
        }

        public Criteria andSTuitionIn(List<String> values) {
            addCriterion("S_TUITION in", values, "sTuition");
            return (Criteria) this;
        }

        public Criteria andSTuitionNotIn(List<String> values) {
            addCriterion("S_TUITION not in", values, "sTuition");
            return (Criteria) this;
        }

        public Criteria andSTuitionBetween(String value1, String value2) {
            addCriterion("S_TUITION between", value1, value2, "sTuition");
            return (Criteria) this;
        }

        public Criteria andSTuitionNotBetween(String value1, String value2) {
            addCriterion("S_TUITION not between", value1, value2, "sTuition");
            return (Criteria) this;
        }

        public Criteria andNCountEnrolIsNull() {
            addCriterion("N_COUNT_ENROL is null");
            return (Criteria) this;
        }

        public Criteria andNCountEnrolIsNotNull() {
            addCriterion("N_COUNT_ENROL is not null");
            return (Criteria) this;
        }

        public Criteria andNCountEnrolEqualTo(Integer value) {
            addCriterion("N_COUNT_ENROL =", value, "nCountEnrol");
            return (Criteria) this;
        }

        public Criteria andNCountEnrolNotEqualTo(Integer value) {
            addCriterion("N_COUNT_ENROL <>", value, "nCountEnrol");
            return (Criteria) this;
        }

        public Criteria andNCountEnrolGreaterThan(Integer value) {
            addCriterion("N_COUNT_ENROL >", value, "nCountEnrol");
            return (Criteria) this;
        }

        public Criteria andNCountEnrolGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_COUNT_ENROL >=", value, "nCountEnrol");
            return (Criteria) this;
        }

        public Criteria andNCountEnrolLessThan(Integer value) {
            addCriterion("N_COUNT_ENROL <", value, "nCountEnrol");
            return (Criteria) this;
        }

        public Criteria andNCountEnrolLessThanOrEqualTo(Integer value) {
            addCriterion("N_COUNT_ENROL <=", value, "nCountEnrol");
            return (Criteria) this;
        }

        public Criteria andNCountEnrolIn(List<Integer> values) {
            addCriterion("N_COUNT_ENROL in", values, "nCountEnrol");
            return (Criteria) this;
        }

        public Criteria andNCountEnrolNotIn(List<Integer> values) {
            addCriterion("N_COUNT_ENROL not in", values, "nCountEnrol");
            return (Criteria) this;
        }

        public Criteria andNCountEnrolBetween(Integer value1, Integer value2) {
            addCriterion("N_COUNT_ENROL between", value1, value2, "nCountEnrol");
            return (Criteria) this;
        }

        public Criteria andNCountEnrolNotBetween(Integer value1, Integer value2) {
            addCriterion("N_COUNT_ENROL not between", value1, value2, "nCountEnrol");
            return (Criteria) this;
        }

        public Criteria andNCountExtRnrolIsNull() {
            addCriterion("N_COUNT_EXT_RNROL is null");
            return (Criteria) this;
        }

        public Criteria andNCountExtRnrolIsNotNull() {
            addCriterion("N_COUNT_EXT_RNROL is not null");
            return (Criteria) this;
        }

        public Criteria andNCountExtRnrolEqualTo(Integer value) {
            addCriterion("N_COUNT_EXT_RNROL =", value, "nCountExtRnrol");
            return (Criteria) this;
        }

        public Criteria andNCountExtRnrolNotEqualTo(Integer value) {
            addCriterion("N_COUNT_EXT_RNROL <>", value, "nCountExtRnrol");
            return (Criteria) this;
        }

        public Criteria andNCountExtRnrolGreaterThan(Integer value) {
            addCriterion("N_COUNT_EXT_RNROL >", value, "nCountExtRnrol");
            return (Criteria) this;
        }

        public Criteria andNCountExtRnrolGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_COUNT_EXT_RNROL >=", value, "nCountExtRnrol");
            return (Criteria) this;
        }

        public Criteria andNCountExtRnrolLessThan(Integer value) {
            addCriterion("N_COUNT_EXT_RNROL <", value, "nCountExtRnrol");
            return (Criteria) this;
        }

        public Criteria andNCountExtRnrolLessThanOrEqualTo(Integer value) {
            addCriterion("N_COUNT_EXT_RNROL <=", value, "nCountExtRnrol");
            return (Criteria) this;
        }

        public Criteria andNCountExtRnrolIn(List<Integer> values) {
            addCriterion("N_COUNT_EXT_RNROL in", values, "nCountExtRnrol");
            return (Criteria) this;
        }

        public Criteria andNCountExtRnrolNotIn(List<Integer> values) {
            addCriterion("N_COUNT_EXT_RNROL not in", values, "nCountExtRnrol");
            return (Criteria) this;
        }

        public Criteria andNCountExtRnrolBetween(Integer value1, Integer value2) {
            addCriterion("N_COUNT_EXT_RNROL between", value1, value2, "nCountExtRnrol");
            return (Criteria) this;
        }

        public Criteria andNCountExtRnrolNotBetween(Integer value1, Integer value2) {
            addCriterion("N_COUNT_EXT_RNROL not between", value1, value2, "nCountExtRnrol");
            return (Criteria) this;
        }

        public Criteria andDbEnrolScoreIsNull() {
            addCriterion("DB_ENROL_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andDbEnrolScoreIsNotNull() {
            addCriterion("DB_ENROL_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andDbEnrolScoreEqualTo(Double value) {
            addCriterion("DB_ENROL_SCORE =", value, "dbEnrolScore");
            return (Criteria) this;
        }

        public Criteria andDbEnrolScoreNotEqualTo(Double value) {
            addCriterion("DB_ENROL_SCORE <>", value, "dbEnrolScore");
            return (Criteria) this;
        }

        public Criteria andDbEnrolScoreGreaterThan(Double value) {
            addCriterion("DB_ENROL_SCORE >", value, "dbEnrolScore");
            return (Criteria) this;
        }

        public Criteria andDbEnrolScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("DB_ENROL_SCORE >=", value, "dbEnrolScore");
            return (Criteria) this;
        }

        public Criteria andDbEnrolScoreLessThan(Double value) {
            addCriterion("DB_ENROL_SCORE <", value, "dbEnrolScore");
            return (Criteria) this;
        }

        public Criteria andDbEnrolScoreLessThanOrEqualTo(Double value) {
            addCriterion("DB_ENROL_SCORE <=", value, "dbEnrolScore");
            return (Criteria) this;
        }

        public Criteria andDbEnrolScoreIn(List<Double> values) {
            addCriterion("DB_ENROL_SCORE in", values, "dbEnrolScore");
            return (Criteria) this;
        }

        public Criteria andDbEnrolScoreNotIn(List<Double> values) {
            addCriterion("DB_ENROL_SCORE not in", values, "dbEnrolScore");
            return (Criteria) this;
        }

        public Criteria andDbEnrolScoreBetween(Double value1, Double value2) {
            addCriterion("DB_ENROL_SCORE between", value1, value2, "dbEnrolScore");
            return (Criteria) this;
        }

        public Criteria andDbEnrolScoreNotBetween(Double value1, Double value2) {
            addCriterion("DB_ENROL_SCORE not between", value1, value2, "dbEnrolScore");
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

        public Criteria andSDeptCodeLikeInsensitive(String value) {
            addCriterion("upper(S_DEPT_CODE) like", value.toUpperCase(), "sDeptCode");
            return (Criteria) this;
        }

        public Criteria andSShortNameLikeInsensitive(String value) {
            addCriterion("upper(S_SHORT_NAME) like", value.toUpperCase(), "sShortName");
            return (Criteria) this;
        }

        public Criteria andSFullNameLikeInsensitive(String value) {
            addCriterion("upper(S_FULL_NAME) like", value.toUpperCase(), "sFullName");
            return (Criteria) this;
        }

        public Criteria andSRegionLikeInsensitive(String value) {
            addCriterion("upper(S_REGION) like", value.toUpperCase(), "sRegion");
            return (Criteria) this;
        }

        public Criteria andSTuitionLikeInsensitive(String value) {
            addCriterion("upper(S_TUITION) like", value.toUpperCase(), "sTuition");
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