package com.hgl.recruitms.model;

import java.util.ArrayList;
import java.util.List;

public class StudentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentInfoExample() {
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

        public Criteria andSNativePlaceIsNull() {
            addCriterion("S_NATIVE_PLACE is null");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceIsNotNull() {
            addCriterion("S_NATIVE_PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceEqualTo(String value) {
            addCriterion("S_NATIVE_PLACE =", value, "sNativePlace");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceNotEqualTo(String value) {
            addCriterion("S_NATIVE_PLACE <>", value, "sNativePlace");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceGreaterThan(String value) {
            addCriterion("S_NATIVE_PLACE >", value, "sNativePlace");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("S_NATIVE_PLACE >=", value, "sNativePlace");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceLessThan(String value) {
            addCriterion("S_NATIVE_PLACE <", value, "sNativePlace");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("S_NATIVE_PLACE <=", value, "sNativePlace");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceLike(String value) {
            addCriterion("S_NATIVE_PLACE like", value, "sNativePlace");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceNotLike(String value) {
            addCriterion("S_NATIVE_PLACE not like", value, "sNativePlace");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceIn(List<String> values) {
            addCriterion("S_NATIVE_PLACE in", values, "sNativePlace");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceNotIn(List<String> values) {
            addCriterion("S_NATIVE_PLACE not in", values, "sNativePlace");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceBetween(String value1, String value2) {
            addCriterion("S_NATIVE_PLACE between", value1, value2, "sNativePlace");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceNotBetween(String value1, String value2) {
            addCriterion("S_NATIVE_PLACE not between", value1, value2, "sNativePlace");
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

        public Criteria andSDataFlagIsNull() {
            addCriterion("S_DATA_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSDataFlagIsNotNull() {
            addCriterion("S_DATA_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSDataFlagEqualTo(String value) {
            addCriterion("S_DATA_FLAG =", value, "sDataFlag");
            return (Criteria) this;
        }

        public Criteria andSDataFlagNotEqualTo(String value) {
            addCriterion("S_DATA_FLAG <>", value, "sDataFlag");
            return (Criteria) this;
        }

        public Criteria andSDataFlagGreaterThan(String value) {
            addCriterion("S_DATA_FLAG >", value, "sDataFlag");
            return (Criteria) this;
        }

        public Criteria andSDataFlagGreaterThanOrEqualTo(String value) {
            addCriterion("S_DATA_FLAG >=", value, "sDataFlag");
            return (Criteria) this;
        }

        public Criteria andSDataFlagLessThan(String value) {
            addCriterion("S_DATA_FLAG <", value, "sDataFlag");
            return (Criteria) this;
        }

        public Criteria andSDataFlagLessThanOrEqualTo(String value) {
            addCriterion("S_DATA_FLAG <=", value, "sDataFlag");
            return (Criteria) this;
        }

        public Criteria andSDataFlagLike(String value) {
            addCriterion("S_DATA_FLAG like", value, "sDataFlag");
            return (Criteria) this;
        }

        public Criteria andSDataFlagNotLike(String value) {
            addCriterion("S_DATA_FLAG not like", value, "sDataFlag");
            return (Criteria) this;
        }

        public Criteria andSDataFlagIn(List<String> values) {
            addCriterion("S_DATA_FLAG in", values, "sDataFlag");
            return (Criteria) this;
        }

        public Criteria andSDataFlagNotIn(List<String> values) {
            addCriterion("S_DATA_FLAG not in", values, "sDataFlag");
            return (Criteria) this;
        }

        public Criteria andSDataFlagBetween(String value1, String value2) {
            addCriterion("S_DATA_FLAG between", value1, value2, "sDataFlag");
            return (Criteria) this;
        }

        public Criteria andSDataFlagNotBetween(String value1, String value2) {
            addCriterion("S_DATA_FLAG not between", value1, value2, "sDataFlag");
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

        public Criteria andCSexLikeInsensitive(String value) {
            addCriterion("upper(C_SEX) like", value.toUpperCase(), "cSex");
            return (Criteria) this;
        }

        public Criteria andSNativePlaceLikeInsensitive(String value) {
            addCriterion("upper(S_NATIVE_PLACE) like", value.toUpperCase(), "sNativePlace");
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

        public Criteria andSPolitiisLikeInsensitive(String value) {
            addCriterion("upper(S_POLITIIS) like", value.toUpperCase(), "sPolitiis");
            return (Criteria) this;
        }

        public Criteria andSDataFlagLikeInsensitive(String value) {
            addCriterion("upper(S_DATA_FLAG) like", value.toUpperCase(), "sDataFlag");
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