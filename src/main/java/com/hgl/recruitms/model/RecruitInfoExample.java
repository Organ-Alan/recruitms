package com.hgl.recruitms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecruitInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecruitInfoExample() {
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

        public Criteria andSCandidateNumIsNull() {
            addCriterion("S_CANDIDATE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumIsNotNull() {
            addCriterion("S_CANDIDATE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumEqualTo(String value) {
            addCriterion("S_CANDIDATE_NUM =", value, "sCandidateNum");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumNotEqualTo(String value) {
            addCriterion("S_CANDIDATE_NUM <>", value, "sCandidateNum");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumGreaterThan(String value) {
            addCriterion("S_CANDIDATE_NUM >", value, "sCandidateNum");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumGreaterThanOrEqualTo(String value) {
            addCriterion("S_CANDIDATE_NUM >=", value, "sCandidateNum");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumLessThan(String value) {
            addCriterion("S_CANDIDATE_NUM <", value, "sCandidateNum");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumLessThanOrEqualTo(String value) {
            addCriterion("S_CANDIDATE_NUM <=", value, "sCandidateNum");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumLike(String value) {
            addCriterion("S_CANDIDATE_NUM like", value, "sCandidateNum");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumNotLike(String value) {
            addCriterion("S_CANDIDATE_NUM not like", value, "sCandidateNum");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumIn(List<String> values) {
            addCriterion("S_CANDIDATE_NUM in", values, "sCandidateNum");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumNotIn(List<String> values) {
            addCriterion("S_CANDIDATE_NUM not in", values, "sCandidateNum");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumBetween(String value1, String value2) {
            addCriterion("S_CANDIDATE_NUM between", value1, value2, "sCandidateNum");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumNotBetween(String value1, String value2) {
            addCriterion("S_CANDIDATE_NUM not between", value1, value2, "sCandidateNum");
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

        public Criteria andNAgeIsNull() {
            addCriterion("N_AGE is null");
            return (Criteria) this;
        }

        public Criteria andNAgeIsNotNull() {
            addCriterion("N_AGE is not null");
            return (Criteria) this;
        }

        public Criteria andNAgeEqualTo(Integer value) {
            addCriterion("N_AGE =", value, "nAge");
            return (Criteria) this;
        }

        public Criteria andNAgeNotEqualTo(Integer value) {
            addCriterion("N_AGE <>", value, "nAge");
            return (Criteria) this;
        }

        public Criteria andNAgeGreaterThan(Integer value) {
            addCriterion("N_AGE >", value, "nAge");
            return (Criteria) this;
        }

        public Criteria andNAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_AGE >=", value, "nAge");
            return (Criteria) this;
        }

        public Criteria andNAgeLessThan(Integer value) {
            addCriterion("N_AGE <", value, "nAge");
            return (Criteria) this;
        }

        public Criteria andNAgeLessThanOrEqualTo(Integer value) {
            addCriterion("N_AGE <=", value, "nAge");
            return (Criteria) this;
        }

        public Criteria andNAgeIn(List<Integer> values) {
            addCriterion("N_AGE in", values, "nAge");
            return (Criteria) this;
        }

        public Criteria andNAgeNotIn(List<Integer> values) {
            addCriterion("N_AGE not in", values, "nAge");
            return (Criteria) this;
        }

        public Criteria andNAgeBetween(Integer value1, Integer value2) {
            addCriterion("N_AGE between", value1, value2, "nAge");
            return (Criteria) this;
        }

        public Criteria andNAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("N_AGE not between", value1, value2, "nAge");
            return (Criteria) this;
        }

        public Criteria andCSexIsNull() {
            addCriterion("C_SEX is null");
            return (Criteria) this;
        }

        public Criteria andCSexIsNotNull() {
            addCriterion("C_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andCSexEqualTo(String value) {
            addCriterion("C_SEX =", value, "cSex");
            return (Criteria) this;
        }

        public Criteria andCSexNotEqualTo(String value) {
            addCriterion("C_SEX <>", value, "cSex");
            return (Criteria) this;
        }

        public Criteria andCSexGreaterThan(String value) {
            addCriterion("C_SEX >", value, "cSex");
            return (Criteria) this;
        }

        public Criteria andCSexGreaterThanOrEqualTo(String value) {
            addCriterion("C_SEX >=", value, "cSex");
            return (Criteria) this;
        }

        public Criteria andCSexLessThan(String value) {
            addCriterion("C_SEX <", value, "cSex");
            return (Criteria) this;
        }

        public Criteria andCSexLessThanOrEqualTo(String value) {
            addCriterion("C_SEX <=", value, "cSex");
            return (Criteria) this;
        }

        public Criteria andCSexLike(String value) {
            addCriterion("C_SEX like", value, "cSex");
            return (Criteria) this;
        }

        public Criteria andCSexNotLike(String value) {
            addCriterion("C_SEX not like", value, "cSex");
            return (Criteria) this;
        }

        public Criteria andCSexIn(List<String> values) {
            addCriterion("C_SEX in", values, "cSex");
            return (Criteria) this;
        }

        public Criteria andCSexNotIn(List<String> values) {
            addCriterion("C_SEX not in", values, "cSex");
            return (Criteria) this;
        }

        public Criteria andCSexBetween(String value1, String value2) {
            addCriterion("C_SEX between", value1, value2, "cSex");
            return (Criteria) this;
        }

        public Criteria andCSexNotBetween(String value1, String value2) {
            addCriterion("C_SEX not between", value1, value2, "cSex");
            return (Criteria) this;
        }

        public Criteria andSAddressIsNull() {
            addCriterion("S_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andSAddressIsNotNull() {
            addCriterion("S_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andSAddressEqualTo(String value) {
            addCriterion("S_ADDRESS =", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressNotEqualTo(String value) {
            addCriterion("S_ADDRESS <>", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressGreaterThan(String value) {
            addCriterion("S_ADDRESS >", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressGreaterThanOrEqualTo(String value) {
            addCriterion("S_ADDRESS >=", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressLessThan(String value) {
            addCriterion("S_ADDRESS <", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressLessThanOrEqualTo(String value) {
            addCriterion("S_ADDRESS <=", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressLike(String value) {
            addCriterion("S_ADDRESS like", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressNotLike(String value) {
            addCriterion("S_ADDRESS not like", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressIn(List<String> values) {
            addCriterion("S_ADDRESS in", values, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressNotIn(List<String> values) {
            addCriterion("S_ADDRESS not in", values, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressBetween(String value1, String value2) {
            addCriterion("S_ADDRESS between", value1, value2, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressNotBetween(String value1, String value2) {
            addCriterion("S_ADDRESS not between", value1, value2, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSContactIsNull() {
            addCriterion("S_CONTACT is null");
            return (Criteria) this;
        }

        public Criteria andSContactIsNotNull() {
            addCriterion("S_CONTACT is not null");
            return (Criteria) this;
        }

        public Criteria andSContactEqualTo(String value) {
            addCriterion("S_CONTACT =", value, "sContact");
            return (Criteria) this;
        }

        public Criteria andSContactNotEqualTo(String value) {
            addCriterion("S_CONTACT <>", value, "sContact");
            return (Criteria) this;
        }

        public Criteria andSContactGreaterThan(String value) {
            addCriterion("S_CONTACT >", value, "sContact");
            return (Criteria) this;
        }

        public Criteria andSContactGreaterThanOrEqualTo(String value) {
            addCriterion("S_CONTACT >=", value, "sContact");
            return (Criteria) this;
        }

        public Criteria andSContactLessThan(String value) {
            addCriterion("S_CONTACT <", value, "sContact");
            return (Criteria) this;
        }

        public Criteria andSContactLessThanOrEqualTo(String value) {
            addCriterion("S_CONTACT <=", value, "sContact");
            return (Criteria) this;
        }

        public Criteria andSContactLike(String value) {
            addCriterion("S_CONTACT like", value, "sContact");
            return (Criteria) this;
        }

        public Criteria andSContactNotLike(String value) {
            addCriterion("S_CONTACT not like", value, "sContact");
            return (Criteria) this;
        }

        public Criteria andSContactIn(List<String> values) {
            addCriterion("S_CONTACT in", values, "sContact");
            return (Criteria) this;
        }

        public Criteria andSContactNotIn(List<String> values) {
            addCriterion("S_CONTACT not in", values, "sContact");
            return (Criteria) this;
        }

        public Criteria andSContactBetween(String value1, String value2) {
            addCriterion("S_CONTACT between", value1, value2, "sContact");
            return (Criteria) this;
        }

        public Criteria andSContactNotBetween(String value1, String value2) {
            addCriterion("S_CONTACT not between", value1, value2, "sContact");
            return (Criteria) this;
        }

        public Criteria andSEmailIsNull() {
            addCriterion("S_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andSEmailIsNotNull() {
            addCriterion("S_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andSEmailEqualTo(String value) {
            addCriterion("S_EMAIL =", value, "sEmail");
            return (Criteria) this;
        }

        public Criteria andSEmailNotEqualTo(String value) {
            addCriterion("S_EMAIL <>", value, "sEmail");
            return (Criteria) this;
        }

        public Criteria andSEmailGreaterThan(String value) {
            addCriterion("S_EMAIL >", value, "sEmail");
            return (Criteria) this;
        }

        public Criteria andSEmailGreaterThanOrEqualTo(String value) {
            addCriterion("S_EMAIL >=", value, "sEmail");
            return (Criteria) this;
        }

        public Criteria andSEmailLessThan(String value) {
            addCriterion("S_EMAIL <", value, "sEmail");
            return (Criteria) this;
        }

        public Criteria andSEmailLessThanOrEqualTo(String value) {
            addCriterion("S_EMAIL <=", value, "sEmail");
            return (Criteria) this;
        }

        public Criteria andSEmailLike(String value) {
            addCriterion("S_EMAIL like", value, "sEmail");
            return (Criteria) this;
        }

        public Criteria andSEmailNotLike(String value) {
            addCriterion("S_EMAIL not like", value, "sEmail");
            return (Criteria) this;
        }

        public Criteria andSEmailIn(List<String> values) {
            addCriterion("S_EMAIL in", values, "sEmail");
            return (Criteria) this;
        }

        public Criteria andSEmailNotIn(List<String> values) {
            addCriterion("S_EMAIL not in", values, "sEmail");
            return (Criteria) this;
        }

        public Criteria andSEmailBetween(String value1, String value2) {
            addCriterion("S_EMAIL between", value1, value2, "sEmail");
            return (Criteria) this;
        }

        public Criteria andSEmailNotBetween(String value1, String value2) {
            addCriterion("S_EMAIL not between", value1, value2, "sEmail");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactIsNull() {
            addCriterion("S_OTHER_CTACT is null");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactIsNotNull() {
            addCriterion("S_OTHER_CTACT is not null");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactEqualTo(String value) {
            addCriterion("S_OTHER_CTACT =", value, "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactNotEqualTo(String value) {
            addCriterion("S_OTHER_CTACT <>", value, "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactGreaterThan(String value) {
            addCriterion("S_OTHER_CTACT >", value, "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactGreaterThanOrEqualTo(String value) {
            addCriterion("S_OTHER_CTACT >=", value, "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactLessThan(String value) {
            addCriterion("S_OTHER_CTACT <", value, "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactLessThanOrEqualTo(String value) {
            addCriterion("S_OTHER_CTACT <=", value, "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactLike(String value) {
            addCriterion("S_OTHER_CTACT like", value, "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactNotLike(String value) {
            addCriterion("S_OTHER_CTACT not like", value, "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactIn(List<String> values) {
            addCriterion("S_OTHER_CTACT in", values, "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactNotIn(List<String> values) {
            addCriterion("S_OTHER_CTACT not in", values, "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactBetween(String value1, String value2) {
            addCriterion("S_OTHER_CTACT between", value1, value2, "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactNotBetween(String value1, String value2) {
            addCriterion("S_OTHER_CTACT not between", value1, value2, "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorIsNull() {
            addCriterion("S_ENROL_MAJOR is null");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorIsNotNull() {
            addCriterion("S_ENROL_MAJOR is not null");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorEqualTo(String value) {
            addCriterion("S_ENROL_MAJOR =", value, "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorNotEqualTo(String value) {
            addCriterion("S_ENROL_MAJOR <>", value, "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorGreaterThan(String value) {
            addCriterion("S_ENROL_MAJOR >", value, "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorGreaterThanOrEqualTo(String value) {
            addCriterion("S_ENROL_MAJOR >=", value, "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorLessThan(String value) {
            addCriterion("S_ENROL_MAJOR <", value, "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorLessThanOrEqualTo(String value) {
            addCriterion("S_ENROL_MAJOR <=", value, "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorLike(String value) {
            addCriterion("S_ENROL_MAJOR like", value, "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorNotLike(String value) {
            addCriterion("S_ENROL_MAJOR not like", value, "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorIn(List<String> values) {
            addCriterion("S_ENROL_MAJOR in", values, "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorNotIn(List<String> values) {
            addCriterion("S_ENROL_MAJOR not in", values, "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorBetween(String value1, String value2) {
            addCriterion("S_ENROL_MAJOR between", value1, value2, "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorNotBetween(String value1, String value2) {
            addCriterion("S_ENROL_MAJOR not between", value1, value2, "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorIsNull() {
            addCriterion("S_ADMITED_MAJOR is null");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorIsNotNull() {
            addCriterion("S_ADMITED_MAJOR is not null");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorEqualTo(String value) {
            addCriterion("S_ADMITED_MAJOR =", value, "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorNotEqualTo(String value) {
            addCriterion("S_ADMITED_MAJOR <>", value, "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorGreaterThan(String value) {
            addCriterion("S_ADMITED_MAJOR >", value, "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorGreaterThanOrEqualTo(String value) {
            addCriterion("S_ADMITED_MAJOR >=", value, "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorLessThan(String value) {
            addCriterion("S_ADMITED_MAJOR <", value, "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorLessThanOrEqualTo(String value) {
            addCriterion("S_ADMITED_MAJOR <=", value, "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorLike(String value) {
            addCriterion("S_ADMITED_MAJOR like", value, "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorNotLike(String value) {
            addCriterion("S_ADMITED_MAJOR not like", value, "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorIn(List<String> values) {
            addCriterion("S_ADMITED_MAJOR in", values, "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorNotIn(List<String> values) {
            addCriterion("S_ADMITED_MAJOR not in", values, "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorBetween(String value1, String value2) {
            addCriterion("S_ADMITED_MAJOR between", value1, value2, "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorNotBetween(String value1, String value2) {
            addCriterion("S_ADMITED_MAJOR not between", value1, value2, "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedNoIsNull() {
            addCriterion("S_ADMITED_NO is null");
            return (Criteria) this;
        }

        public Criteria andSAdmitedNoIsNotNull() {
            addCriterion("S_ADMITED_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSAdmitedNoEqualTo(Integer value) {
            addCriterion("S_ADMITED_NO =", value, "sAdmitedNo");
            return (Criteria) this;
        }

        public Criteria andSAdmitedNoNotEqualTo(Integer value) {
            addCriterion("S_ADMITED_NO <>", value, "sAdmitedNo");
            return (Criteria) this;
        }

        public Criteria andSAdmitedNoGreaterThan(Integer value) {
            addCriterion("S_ADMITED_NO >", value, "sAdmitedNo");
            return (Criteria) this;
        }

        public Criteria andSAdmitedNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("S_ADMITED_NO >=", value, "sAdmitedNo");
            return (Criteria) this;
        }

        public Criteria andSAdmitedNoLessThan(Integer value) {
            addCriterion("S_ADMITED_NO <", value, "sAdmitedNo");
            return (Criteria) this;
        }

        public Criteria andSAdmitedNoLessThanOrEqualTo(Integer value) {
            addCriterion("S_ADMITED_NO <=", value, "sAdmitedNo");
            return (Criteria) this;
        }

        public Criteria andSAdmitedNoIn(List<Integer> values) {
            addCriterion("S_ADMITED_NO in", values, "sAdmitedNo");
            return (Criteria) this;
        }

        public Criteria andSAdmitedNoNotIn(List<Integer> values) {
            addCriterion("S_ADMITED_NO not in", values, "sAdmitedNo");
            return (Criteria) this;
        }

        public Criteria andSAdmitedNoBetween(Integer value1, Integer value2) {
            addCriterion("S_ADMITED_NO between", value1, value2, "sAdmitedNo");
            return (Criteria) this;
        }

        public Criteria andSAdmitedNoNotBetween(Integer value1, Integer value2) {
            addCriterion("S_ADMITED_NO not between", value1, value2, "sAdmitedNo");
            return (Criteria) this;
        }

        public Criteria andSGradeIsNull() {
            addCriterion("S_GRADE is null");
            return (Criteria) this;
        }

        public Criteria andSGradeIsNotNull() {
            addCriterion("S_GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andSGradeEqualTo(String value) {
            addCriterion("S_GRADE =", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeNotEqualTo(String value) {
            addCriterion("S_GRADE <>", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeGreaterThan(String value) {
            addCriterion("S_GRADE >", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeGreaterThanOrEqualTo(String value) {
            addCriterion("S_GRADE >=", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeLessThan(String value) {
            addCriterion("S_GRADE <", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeLessThanOrEqualTo(String value) {
            addCriterion("S_GRADE <=", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeLike(String value) {
            addCriterion("S_GRADE like", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeNotLike(String value) {
            addCriterion("S_GRADE not like", value, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeIn(List<String> values) {
            addCriterion("S_GRADE in", values, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeNotIn(List<String> values) {
            addCriterion("S_GRADE not in", values, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeBetween(String value1, String value2) {
            addCriterion("S_GRADE between", value1, value2, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSGradeNotBetween(String value1, String value2) {
            addCriterion("S_GRADE not between", value1, value2, "sGrade");
            return (Criteria) this;
        }

        public Criteria andSPolitiisIsNull() {
            addCriterion("S_POLITIIS is null");
            return (Criteria) this;
        }

        public Criteria andSPolitiisIsNotNull() {
            addCriterion("S_POLITIIS is not null");
            return (Criteria) this;
        }

        public Criteria andSPolitiisEqualTo(String value) {
            addCriterion("S_POLITIIS =", value, "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPolitiisNotEqualTo(String value) {
            addCriterion("S_POLITIIS <>", value, "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPolitiisGreaterThan(String value) {
            addCriterion("S_POLITIIS >", value, "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPolitiisGreaterThanOrEqualTo(String value) {
            addCriterion("S_POLITIIS >=", value, "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPolitiisLessThan(String value) {
            addCriterion("S_POLITIIS <", value, "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPolitiisLessThanOrEqualTo(String value) {
            addCriterion("S_POLITIIS <=", value, "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPolitiisLike(String value) {
            addCriterion("S_POLITIIS like", value, "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPolitiisNotLike(String value) {
            addCriterion("S_POLITIIS not like", value, "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPolitiisIn(List<String> values) {
            addCriterion("S_POLITIIS in", values, "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPolitiisNotIn(List<String> values) {
            addCriterion("S_POLITIIS not in", values, "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPolitiisBetween(String value1, String value2) {
            addCriterion("S_POLITIIS between", value1, value2, "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPolitiisNotBetween(String value1, String value2) {
            addCriterion("S_POLITIIS not between", value1, value2, "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPayFlagIsNull() {
            addCriterion("S_PAY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSPayFlagIsNotNull() {
            addCriterion("S_PAY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSPayFlagEqualTo(String value) {
            addCriterion("S_PAY_FLAG =", value, "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSPayFlagNotEqualTo(String value) {
            addCriterion("S_PAY_FLAG <>", value, "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSPayFlagGreaterThan(String value) {
            addCriterion("S_PAY_FLAG >", value, "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSPayFlagGreaterThanOrEqualTo(String value) {
            addCriterion("S_PAY_FLAG >=", value, "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSPayFlagLessThan(String value) {
            addCriterion("S_PAY_FLAG <", value, "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSPayFlagLessThanOrEqualTo(String value) {
            addCriterion("S_PAY_FLAG <=", value, "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSPayFlagLike(String value) {
            addCriterion("S_PAY_FLAG like", value, "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSPayFlagNotLike(String value) {
            addCriterion("S_PAY_FLAG not like", value, "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSPayFlagIn(List<String> values) {
            addCriterion("S_PAY_FLAG in", values, "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSPayFlagNotIn(List<String> values) {
            addCriterion("S_PAY_FLAG not in", values, "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSPayFlagBetween(String value1, String value2) {
            addCriterion("S_PAY_FLAG between", value1, value2, "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSPayFlagNotBetween(String value1, String value2) {
            addCriterion("S_PAY_FLAG not between", value1, value2, "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSOperatorIsNull() {
            addCriterion("S_OPERATOR is null");
            return (Criteria) this;
        }

        public Criteria andSOperatorIsNotNull() {
            addCriterion("S_OPERATOR is not null");
            return (Criteria) this;
        }

        public Criteria andSOperatorEqualTo(String value) {
            addCriterion("S_OPERATOR =", value, "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorNotEqualTo(String value) {
            addCriterion("S_OPERATOR <>", value, "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorGreaterThan(String value) {
            addCriterion("S_OPERATOR >", value, "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("S_OPERATOR >=", value, "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorLessThan(String value) {
            addCriterion("S_OPERATOR <", value, "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorLessThanOrEqualTo(String value) {
            addCriterion("S_OPERATOR <=", value, "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorLike(String value) {
            addCriterion("S_OPERATOR like", value, "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorNotLike(String value) {
            addCriterion("S_OPERATOR not like", value, "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorIn(List<String> values) {
            addCriterion("S_OPERATOR in", values, "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorNotIn(List<String> values) {
            addCriterion("S_OPERATOR not in", values, "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorBetween(String value1, String value2) {
            addCriterion("S_OPERATOR between", value1, value2, "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorNotBetween(String value1, String value2) {
            addCriterion("S_OPERATOR not between", value1, value2, "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoIsNull() {
            addCriterion("S_OPERATOR_NO is null");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoIsNotNull() {
            addCriterion("S_OPERATOR_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoEqualTo(String value) {
            addCriterion("S_OPERATOR_NO =", value, "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoNotEqualTo(String value) {
            addCriterion("S_OPERATOR_NO <>", value, "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoGreaterThan(String value) {
            addCriterion("S_OPERATOR_NO >", value, "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoGreaterThanOrEqualTo(String value) {
            addCriterion("S_OPERATOR_NO >=", value, "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoLessThan(String value) {
            addCriterion("S_OPERATOR_NO <", value, "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoLessThanOrEqualTo(String value) {
            addCriterion("S_OPERATOR_NO <=", value, "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoLike(String value) {
            addCriterion("S_OPERATOR_NO like", value, "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoNotLike(String value) {
            addCriterion("S_OPERATOR_NO not like", value, "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoIn(List<String> values) {
            addCriterion("S_OPERATOR_NO in", values, "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoNotIn(List<String> values) {
            addCriterion("S_OPERATOR_NO not in", values, "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoBetween(String value1, String value2) {
            addCriterion("S_OPERATOR_NO between", value1, value2, "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoNotBetween(String value1, String value2) {
            addCriterion("S_OPERATOR_NO not between", value1, value2, "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andDOperateTimeIsNull() {
            addCriterion("D_OPERATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDOperateTimeIsNotNull() {
            addCriterion("D_OPERATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDOperateTimeEqualTo(Date value) {
            addCriterion("D_OPERATE_TIME =", value, "dOperateTime");
            return (Criteria) this;
        }

        public Criteria andDOperateTimeNotEqualTo(Date value) {
            addCriterion("D_OPERATE_TIME <>", value, "dOperateTime");
            return (Criteria) this;
        }

        public Criteria andDOperateTimeGreaterThan(Date value) {
            addCriterion("D_OPERATE_TIME >", value, "dOperateTime");
            return (Criteria) this;
        }

        public Criteria andDOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("D_OPERATE_TIME >=", value, "dOperateTime");
            return (Criteria) this;
        }

        public Criteria andDOperateTimeLessThan(Date value) {
            addCriterion("D_OPERATE_TIME <", value, "dOperateTime");
            return (Criteria) this;
        }

        public Criteria andDOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("D_OPERATE_TIME <=", value, "dOperateTime");
            return (Criteria) this;
        }

        public Criteria andDOperateTimeIn(List<Date> values) {
            addCriterion("D_OPERATE_TIME in", values, "dOperateTime");
            return (Criteria) this;
        }

        public Criteria andDOperateTimeNotIn(List<Date> values) {
            addCriterion("D_OPERATE_TIME not in", values, "dOperateTime");
            return (Criteria) this;
        }

        public Criteria andDOperateTimeBetween(Date value1, Date value2) {
            addCriterion("D_OPERATE_TIME between", value1, value2, "dOperateTime");
            return (Criteria) this;
        }

        public Criteria andDOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("D_OPERATE_TIME not between", value1, value2, "dOperateTime");
            return (Criteria) this;
        }

        public Criteria andSStatusIsNull() {
            addCriterion("S_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSStatusIsNotNull() {
            addCriterion("S_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSStatusEqualTo(String value) {
            addCriterion("S_STATUS =", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusNotEqualTo(String value) {
            addCriterion("S_STATUS <>", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusGreaterThan(String value) {
            addCriterion("S_STATUS >", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusGreaterThanOrEqualTo(String value) {
            addCriterion("S_STATUS >=", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusLessThan(String value) {
            addCriterion("S_STATUS <", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusLessThanOrEqualTo(String value) {
            addCriterion("S_STATUS <=", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusLike(String value) {
            addCriterion("S_STATUS like", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusNotLike(String value) {
            addCriterion("S_STATUS not like", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusIn(List<String> values) {
            addCriterion("S_STATUS in", values, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusNotIn(List<String> values) {
            addCriterion("S_STATUS not in", values, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusBetween(String value1, String value2) {
            addCriterion("S_STATUS between", value1, value2, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusNotBetween(String value1, String value2) {
            addCriterion("S_STATUS not between", value1, value2, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSCandidateNumLikeInsensitive(String value) {
            addCriterion("upper(S_CANDIDATE_NUM) like", value.toUpperCase(), "sCandidateNum");
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

        public Criteria andCSexLikeInsensitive(String value) {
            addCriterion("upper(C_SEX) like", value.toUpperCase(), "cSex");
            return (Criteria) this;
        }

        public Criteria andSAddressLikeInsensitive(String value) {
            addCriterion("upper(S_ADDRESS) like", value.toUpperCase(), "sAddress");
            return (Criteria) this;
        }

        public Criteria andSContactLikeInsensitive(String value) {
            addCriterion("upper(S_CONTACT) like", value.toUpperCase(), "sContact");
            return (Criteria) this;
        }

        public Criteria andSEmailLikeInsensitive(String value) {
            addCriterion("upper(S_EMAIL) like", value.toUpperCase(), "sEmail");
            return (Criteria) this;
        }

        public Criteria andSOtherCtactLikeInsensitive(String value) {
            addCriterion("upper(S_OTHER_CTACT) like", value.toUpperCase(), "sOtherCtact");
            return (Criteria) this;
        }

        public Criteria andSEnrolMajorLikeInsensitive(String value) {
            addCriterion("upper(S_ENROL_MAJOR) like", value.toUpperCase(), "sEnrolMajor");
            return (Criteria) this;
        }

        public Criteria andSAdmitedMajorLikeInsensitive(String value) {
            addCriterion("upper(S_ADMITED_MAJOR) like", value.toUpperCase(), "sAdmitedMajor");
            return (Criteria) this;
        }

        public Criteria andSGradeLikeInsensitive(String value) {
            addCriterion("upper(S_GRADE) like", value.toUpperCase(), "sGrade");
            return (Criteria) this;
        }

        public Criteria andSPolitiisLikeInsensitive(String value) {
            addCriterion("upper(S_POLITIIS) like", value.toUpperCase(), "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSPayFlagLikeInsensitive(String value) {
            addCriterion("upper(S_PAY_FLAG) like", value.toUpperCase(), "sPayFlag");
            return (Criteria) this;
        }

        public Criteria andSOperatorLikeInsensitive(String value) {
            addCriterion("upper(S_OPERATOR) like", value.toUpperCase(), "sOperator");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoLikeInsensitive(String value) {
            addCriterion("upper(S_OPERATOR_NO) like", value.toUpperCase(), "sOperatorNo");
            return (Criteria) this;
        }

        public Criteria andSStatusLikeInsensitive(String value) {
            addCriterion("upper(S_STATUS) like", value.toUpperCase(), "sStatus");
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