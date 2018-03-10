package com.hgl.recruitms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttachExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttachExample() {
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

        public Criteria andNAttachNoIsNull() {
            addCriterion("N_ATTACH_NO is null");
            return (Criteria) this;
        }

        public Criteria andNAttachNoIsNotNull() {
            addCriterion("N_ATTACH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNAttachNoEqualTo(Integer value) {
            addCriterion("N_ATTACH_NO =", value, "nAttachNo");
            return (Criteria) this;
        }

        public Criteria andNAttachNoNotEqualTo(Integer value) {
            addCriterion("N_ATTACH_NO <>", value, "nAttachNo");
            return (Criteria) this;
        }

        public Criteria andNAttachNoGreaterThan(Integer value) {
            addCriterion("N_ATTACH_NO >", value, "nAttachNo");
            return (Criteria) this;
        }

        public Criteria andNAttachNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_ATTACH_NO >=", value, "nAttachNo");
            return (Criteria) this;
        }

        public Criteria andNAttachNoLessThan(Integer value) {
            addCriterion("N_ATTACH_NO <", value, "nAttachNo");
            return (Criteria) this;
        }

        public Criteria andNAttachNoLessThanOrEqualTo(Integer value) {
            addCriterion("N_ATTACH_NO <=", value, "nAttachNo");
            return (Criteria) this;
        }

        public Criteria andNAttachNoIn(List<Integer> values) {
            addCriterion("N_ATTACH_NO in", values, "nAttachNo");
            return (Criteria) this;
        }

        public Criteria andNAttachNoNotIn(List<Integer> values) {
            addCriterion("N_ATTACH_NO not in", values, "nAttachNo");
            return (Criteria) this;
        }

        public Criteria andNAttachNoBetween(Integer value1, Integer value2) {
            addCriterion("N_ATTACH_NO between", value1, value2, "nAttachNo");
            return (Criteria) this;
        }

        public Criteria andNAttachNoNotBetween(Integer value1, Integer value2) {
            addCriterion("N_ATTACH_NO not between", value1, value2, "nAttachNo");
            return (Criteria) this;
        }

        public Criteria andSAttachNameIsNull() {
            addCriterion("S_ATTACH_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSAttachNameIsNotNull() {
            addCriterion("S_ATTACH_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSAttachNameEqualTo(String value) {
            addCriterion("S_ATTACH_NAME =", value, "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachNameNotEqualTo(String value) {
            addCriterion("S_ATTACH_NAME <>", value, "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachNameGreaterThan(String value) {
            addCriterion("S_ATTACH_NAME >", value, "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachNameGreaterThanOrEqualTo(String value) {
            addCriterion("S_ATTACH_NAME >=", value, "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachNameLessThan(String value) {
            addCriterion("S_ATTACH_NAME <", value, "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachNameLessThanOrEqualTo(String value) {
            addCriterion("S_ATTACH_NAME <=", value, "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachNameLike(String value) {
            addCriterion("S_ATTACH_NAME like", value, "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachNameNotLike(String value) {
            addCriterion("S_ATTACH_NAME not like", value, "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachNameIn(List<String> values) {
            addCriterion("S_ATTACH_NAME in", values, "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachNameNotIn(List<String> values) {
            addCriterion("S_ATTACH_NAME not in", values, "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachNameBetween(String value1, String value2) {
            addCriterion("S_ATTACH_NAME between", value1, value2, "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachNameNotBetween(String value1, String value2) {
            addCriterion("S_ATTACH_NAME not between", value1, value2, "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeIsNull() {
            addCriterion("S_ATTACH_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeIsNotNull() {
            addCriterion("S_ATTACH_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeEqualTo(String value) {
            addCriterion("S_ATTACH_TYPE =", value, "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeNotEqualTo(String value) {
            addCriterion("S_ATTACH_TYPE <>", value, "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeGreaterThan(String value) {
            addCriterion("S_ATTACH_TYPE >", value, "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeGreaterThanOrEqualTo(String value) {
            addCriterion("S_ATTACH_TYPE >=", value, "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeLessThan(String value) {
            addCriterion("S_ATTACH_TYPE <", value, "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeLessThanOrEqualTo(String value) {
            addCriterion("S_ATTACH_TYPE <=", value, "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeLike(String value) {
            addCriterion("S_ATTACH_TYPE like", value, "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeNotLike(String value) {
            addCriterion("S_ATTACH_TYPE not like", value, "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeIn(List<String> values) {
            addCriterion("S_ATTACH_TYPE in", values, "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeNotIn(List<String> values) {
            addCriterion("S_ATTACH_TYPE not in", values, "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeBetween(String value1, String value2) {
            addCriterion("S_ATTACH_TYPE between", value1, value2, "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeNotBetween(String value1, String value2) {
            addCriterion("S_ATTACH_TYPE not between", value1, value2, "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSPathIsNull() {
            addCriterion("S_PATH is null");
            return (Criteria) this;
        }

        public Criteria andSPathIsNotNull() {
            addCriterion("S_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andSPathEqualTo(String value) {
            addCriterion("S_PATH =", value, "sPath");
            return (Criteria) this;
        }

        public Criteria andSPathNotEqualTo(String value) {
            addCriterion("S_PATH <>", value, "sPath");
            return (Criteria) this;
        }

        public Criteria andSPathGreaterThan(String value) {
            addCriterion("S_PATH >", value, "sPath");
            return (Criteria) this;
        }

        public Criteria andSPathGreaterThanOrEqualTo(String value) {
            addCriterion("S_PATH >=", value, "sPath");
            return (Criteria) this;
        }

        public Criteria andSPathLessThan(String value) {
            addCriterion("S_PATH <", value, "sPath");
            return (Criteria) this;
        }

        public Criteria andSPathLessThanOrEqualTo(String value) {
            addCriterion("S_PATH <=", value, "sPath");
            return (Criteria) this;
        }

        public Criteria andSPathLike(String value) {
            addCriterion("S_PATH like", value, "sPath");
            return (Criteria) this;
        }

        public Criteria andSPathNotLike(String value) {
            addCriterion("S_PATH not like", value, "sPath");
            return (Criteria) this;
        }

        public Criteria andSPathIn(List<String> values) {
            addCriterion("S_PATH in", values, "sPath");
            return (Criteria) this;
        }

        public Criteria andSPathNotIn(List<String> values) {
            addCriterion("S_PATH not in", values, "sPath");
            return (Criteria) this;
        }

        public Criteria andSPathBetween(String value1, String value2) {
            addCriterion("S_PATH between", value1, value2, "sPath");
            return (Criteria) this;
        }

        public Criteria andSPathNotBetween(String value1, String value2) {
            addCriterion("S_PATH not between", value1, value2, "sPath");
            return (Criteria) this;
        }

        public Criteria andNVersionIsNull() {
            addCriterion("N_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andNVersionIsNotNull() {
            addCriterion("N_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andNVersionEqualTo(Integer value) {
            addCriterion("N_VERSION =", value, "nVersion");
            return (Criteria) this;
        }

        public Criteria andNVersionNotEqualTo(Integer value) {
            addCriterion("N_VERSION <>", value, "nVersion");
            return (Criteria) this;
        }

        public Criteria andNVersionGreaterThan(Integer value) {
            addCriterion("N_VERSION >", value, "nVersion");
            return (Criteria) this;
        }

        public Criteria andNVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_VERSION >=", value, "nVersion");
            return (Criteria) this;
        }

        public Criteria andNVersionLessThan(Integer value) {
            addCriterion("N_VERSION <", value, "nVersion");
            return (Criteria) this;
        }

        public Criteria andNVersionLessThanOrEqualTo(Integer value) {
            addCriterion("N_VERSION <=", value, "nVersion");
            return (Criteria) this;
        }

        public Criteria andNVersionIn(List<Integer> values) {
            addCriterion("N_VERSION in", values, "nVersion");
            return (Criteria) this;
        }

        public Criteria andNVersionNotIn(List<Integer> values) {
            addCriterion("N_VERSION not in", values, "nVersion");
            return (Criteria) this;
        }

        public Criteria andNVersionBetween(Integer value1, Integer value2) {
            addCriterion("N_VERSION between", value1, value2, "nVersion");
            return (Criteria) this;
        }

        public Criteria andNVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("N_VERSION not between", value1, value2, "nVersion");
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

        public Criteria andSCreatorNoEqualTo(String value) {
            addCriterion("S_CREATOR_NO =", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoNotEqualTo(String value) {
            addCriterion("S_CREATOR_NO <>", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoGreaterThan(String value) {
            addCriterion("S_CREATOR_NO >", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoGreaterThanOrEqualTo(String value) {
            addCriterion("S_CREATOR_NO >=", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoLessThan(String value) {
            addCriterion("S_CREATOR_NO <", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoLessThanOrEqualTo(String value) {
            addCriterion("S_CREATOR_NO <=", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoLike(String value) {
            addCriterion("S_CREATOR_NO like", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoNotLike(String value) {
            addCriterion("S_CREATOR_NO not like", value, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoIn(List<String> values) {
            addCriterion("S_CREATOR_NO in", values, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoNotIn(List<String> values) {
            addCriterion("S_CREATOR_NO not in", values, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoBetween(String value1, String value2) {
            addCriterion("S_CREATOR_NO between", value1, value2, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoNotBetween(String value1, String value2) {
            addCriterion("S_CREATOR_NO not between", value1, value2, "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andNLastAttachNoIsNull() {
            addCriterion("N_LAST_ATTACH_NO is null");
            return (Criteria) this;
        }

        public Criteria andNLastAttachNoIsNotNull() {
            addCriterion("N_LAST_ATTACH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNLastAttachNoEqualTo(Integer value) {
            addCriterion("N_LAST_ATTACH_NO =", value, "nLastAttachNo");
            return (Criteria) this;
        }

        public Criteria andNLastAttachNoNotEqualTo(Integer value) {
            addCriterion("N_LAST_ATTACH_NO <>", value, "nLastAttachNo");
            return (Criteria) this;
        }

        public Criteria andNLastAttachNoGreaterThan(Integer value) {
            addCriterion("N_LAST_ATTACH_NO >", value, "nLastAttachNo");
            return (Criteria) this;
        }

        public Criteria andNLastAttachNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_LAST_ATTACH_NO >=", value, "nLastAttachNo");
            return (Criteria) this;
        }

        public Criteria andNLastAttachNoLessThan(Integer value) {
            addCriterion("N_LAST_ATTACH_NO <", value, "nLastAttachNo");
            return (Criteria) this;
        }

        public Criteria andNLastAttachNoLessThanOrEqualTo(Integer value) {
            addCriterion("N_LAST_ATTACH_NO <=", value, "nLastAttachNo");
            return (Criteria) this;
        }

        public Criteria andNLastAttachNoIn(List<Integer> values) {
            addCriterion("N_LAST_ATTACH_NO in", values, "nLastAttachNo");
            return (Criteria) this;
        }

        public Criteria andNLastAttachNoNotIn(List<Integer> values) {
            addCriterion("N_LAST_ATTACH_NO not in", values, "nLastAttachNo");
            return (Criteria) this;
        }

        public Criteria andNLastAttachNoBetween(Integer value1, Integer value2) {
            addCriterion("N_LAST_ATTACH_NO between", value1, value2, "nLastAttachNo");
            return (Criteria) this;
        }

        public Criteria andNLastAttachNoNotBetween(Integer value1, Integer value2) {
            addCriterion("N_LAST_ATTACH_NO not between", value1, value2, "nLastAttachNo");
            return (Criteria) this;
        }

        public Criteria andSFileTypeIsNull() {
            addCriterion("S_FILE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSFileTypeIsNotNull() {
            addCriterion("S_FILE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSFileTypeEqualTo(String value) {
            addCriterion("S_FILE_TYPE =", value, "sFileType");
            return (Criteria) this;
        }

        public Criteria andSFileTypeNotEqualTo(String value) {
            addCriterion("S_FILE_TYPE <>", value, "sFileType");
            return (Criteria) this;
        }

        public Criteria andSFileTypeGreaterThan(String value) {
            addCriterion("S_FILE_TYPE >", value, "sFileType");
            return (Criteria) this;
        }

        public Criteria andSFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("S_FILE_TYPE >=", value, "sFileType");
            return (Criteria) this;
        }

        public Criteria andSFileTypeLessThan(String value) {
            addCriterion("S_FILE_TYPE <", value, "sFileType");
            return (Criteria) this;
        }

        public Criteria andSFileTypeLessThanOrEqualTo(String value) {
            addCriterion("S_FILE_TYPE <=", value, "sFileType");
            return (Criteria) this;
        }

        public Criteria andSFileTypeLike(String value) {
            addCriterion("S_FILE_TYPE like", value, "sFileType");
            return (Criteria) this;
        }

        public Criteria andSFileTypeNotLike(String value) {
            addCriterion("S_FILE_TYPE not like", value, "sFileType");
            return (Criteria) this;
        }

        public Criteria andSFileTypeIn(List<String> values) {
            addCriterion("S_FILE_TYPE in", values, "sFileType");
            return (Criteria) this;
        }

        public Criteria andSFileTypeNotIn(List<String> values) {
            addCriterion("S_FILE_TYPE not in", values, "sFileType");
            return (Criteria) this;
        }

        public Criteria andSFileTypeBetween(String value1, String value2) {
            addCriterion("S_FILE_TYPE between", value1, value2, "sFileType");
            return (Criteria) this;
        }

        public Criteria andSFileTypeNotBetween(String value1, String value2) {
            addCriterion("S_FILE_TYPE not between", value1, value2, "sFileType");
            return (Criteria) this;
        }

        public Criteria andSSavePathIsNull() {
            addCriterion("S_SAVE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andSSavePathIsNotNull() {
            addCriterion("S_SAVE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andSSavePathEqualTo(String value) {
            addCriterion("S_SAVE_PATH =", value, "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSavePathNotEqualTo(String value) {
            addCriterion("S_SAVE_PATH <>", value, "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSavePathGreaterThan(String value) {
            addCriterion("S_SAVE_PATH >", value, "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSavePathGreaterThanOrEqualTo(String value) {
            addCriterion("S_SAVE_PATH >=", value, "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSavePathLessThan(String value) {
            addCriterion("S_SAVE_PATH <", value, "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSavePathLessThanOrEqualTo(String value) {
            addCriterion("S_SAVE_PATH <=", value, "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSavePathLike(String value) {
            addCriterion("S_SAVE_PATH like", value, "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSavePathNotLike(String value) {
            addCriterion("S_SAVE_PATH not like", value, "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSavePathIn(List<String> values) {
            addCriterion("S_SAVE_PATH in", values, "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSavePathNotIn(List<String> values) {
            addCriterion("S_SAVE_PATH not in", values, "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSavePathBetween(String value1, String value2) {
            addCriterion("S_SAVE_PATH between", value1, value2, "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSavePathNotBetween(String value1, String value2) {
            addCriterion("S_SAVE_PATH not between", value1, value2, "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSubPathIsNull() {
            addCriterion("S_SUB_PATH is null");
            return (Criteria) this;
        }

        public Criteria andSSubPathIsNotNull() {
            addCriterion("S_SUB_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andSSubPathEqualTo(String value) {
            addCriterion("S_SUB_PATH =", value, "sSubPath");
            return (Criteria) this;
        }

        public Criteria andSSubPathNotEqualTo(String value) {
            addCriterion("S_SUB_PATH <>", value, "sSubPath");
            return (Criteria) this;
        }

        public Criteria andSSubPathGreaterThan(String value) {
            addCriterion("S_SUB_PATH >", value, "sSubPath");
            return (Criteria) this;
        }

        public Criteria andSSubPathGreaterThanOrEqualTo(String value) {
            addCriterion("S_SUB_PATH >=", value, "sSubPath");
            return (Criteria) this;
        }

        public Criteria andSSubPathLessThan(String value) {
            addCriterion("S_SUB_PATH <", value, "sSubPath");
            return (Criteria) this;
        }

        public Criteria andSSubPathLessThanOrEqualTo(String value) {
            addCriterion("S_SUB_PATH <=", value, "sSubPath");
            return (Criteria) this;
        }

        public Criteria andSSubPathLike(String value) {
            addCriterion("S_SUB_PATH like", value, "sSubPath");
            return (Criteria) this;
        }

        public Criteria andSSubPathNotLike(String value) {
            addCriterion("S_SUB_PATH not like", value, "sSubPath");
            return (Criteria) this;
        }

        public Criteria andSSubPathIn(List<String> values) {
            addCriterion("S_SUB_PATH in", values, "sSubPath");
            return (Criteria) this;
        }

        public Criteria andSSubPathNotIn(List<String> values) {
            addCriterion("S_SUB_PATH not in", values, "sSubPath");
            return (Criteria) this;
        }

        public Criteria andSSubPathBetween(String value1, String value2) {
            addCriterion("S_SUB_PATH between", value1, value2, "sSubPath");
            return (Criteria) this;
        }

        public Criteria andSSubPathNotBetween(String value1, String value2) {
            addCriterion("S_SUB_PATH not between", value1, value2, "sSubPath");
            return (Criteria) this;
        }

        public Criteria andSAttachNameLikeInsensitive(String value) {
            addCriterion("upper(S_ATTACH_NAME) like", value.toUpperCase(), "sAttachName");
            return (Criteria) this;
        }

        public Criteria andSAttachTypeLikeInsensitive(String value) {
            addCriterion("upper(S_ATTACH_TYPE) like", value.toUpperCase(), "sAttachType");
            return (Criteria) this;
        }

        public Criteria andSPathLikeInsensitive(String value) {
            addCriterion("upper(S_PATH) like", value.toUpperCase(), "sPath");
            return (Criteria) this;
        }

        public Criteria andSStatusLikeInsensitive(String value) {
            addCriterion("upper(S_STATUS) like", value.toUpperCase(), "sStatus");
            return (Criteria) this;
        }

        public Criteria andSCreatorLikeInsensitive(String value) {
            addCriterion("upper(S_CREATOR) like", value.toUpperCase(), "sCreator");
            return (Criteria) this;
        }

        public Criteria andSCreatorNoLikeInsensitive(String value) {
            addCriterion("upper(S_CREATOR_NO) like", value.toUpperCase(), "sCreatorNo");
            return (Criteria) this;
        }

        public Criteria andSFileTypeLikeInsensitive(String value) {
            addCriterion("upper(S_FILE_TYPE) like", value.toUpperCase(), "sFileType");
            return (Criteria) this;
        }

        public Criteria andSSavePathLikeInsensitive(String value) {
            addCriterion("upper(S_SAVE_PATH) like", value.toUpperCase(), "sSavePath");
            return (Criteria) this;
        }

        public Criteria andSSubPathLikeInsensitive(String value) {
            addCriterion("upper(S_SUB_PATH) like", value.toUpperCase(), "sSubPath");
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