package com.hgl.recruitms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuditInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuditInfoExample() {
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

        public Criteria andNAuditNoIsNull() {
            addCriterion("N_AUDIT_NO is null");
            return (Criteria) this;
        }

        public Criteria andNAuditNoIsNotNull() {
            addCriterion("N_AUDIT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andNAuditNoEqualTo(Integer value) {
            addCriterion("N_AUDIT_NO =", value, "nAuditNo");
            return (Criteria) this;
        }

        public Criteria andNAuditNoNotEqualTo(Integer value) {
            addCriterion("N_AUDIT_NO <>", value, "nAuditNo");
            return (Criteria) this;
        }

        public Criteria andNAuditNoGreaterThan(Integer value) {
            addCriterion("N_AUDIT_NO >", value, "nAuditNo");
            return (Criteria) this;
        }

        public Criteria andNAuditNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("N_AUDIT_NO >=", value, "nAuditNo");
            return (Criteria) this;
        }

        public Criteria andNAuditNoLessThan(Integer value) {
            addCriterion("N_AUDIT_NO <", value, "nAuditNo");
            return (Criteria) this;
        }

        public Criteria andNAuditNoLessThanOrEqualTo(Integer value) {
            addCriterion("N_AUDIT_NO <=", value, "nAuditNo");
            return (Criteria) this;
        }

        public Criteria andNAuditNoIn(List<Integer> values) {
            addCriterion("N_AUDIT_NO in", values, "nAuditNo");
            return (Criteria) this;
        }

        public Criteria andNAuditNoNotIn(List<Integer> values) {
            addCriterion("N_AUDIT_NO not in", values, "nAuditNo");
            return (Criteria) this;
        }

        public Criteria andNAuditNoBetween(Integer value1, Integer value2) {
            addCriterion("N_AUDIT_NO between", value1, value2, "nAuditNo");
            return (Criteria) this;
        }

        public Criteria andNAuditNoNotBetween(Integer value1, Integer value2) {
            addCriterion("N_AUDIT_NO not between", value1, value2, "nAuditNo");
            return (Criteria) this;
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

        public Criteria andSModifyItemidIsNull() {
            addCriterion("S_MODIFY_ITEMID is null");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidIsNotNull() {
            addCriterion("S_MODIFY_ITEMID is not null");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidEqualTo(String value) {
            addCriterion("S_MODIFY_ITEMID =", value, "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidNotEqualTo(String value) {
            addCriterion("S_MODIFY_ITEMID <>", value, "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidGreaterThan(String value) {
            addCriterion("S_MODIFY_ITEMID >", value, "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidGreaterThanOrEqualTo(String value) {
            addCriterion("S_MODIFY_ITEMID >=", value, "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidLessThan(String value) {
            addCriterion("S_MODIFY_ITEMID <", value, "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidLessThanOrEqualTo(String value) {
            addCriterion("S_MODIFY_ITEMID <=", value, "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidLike(String value) {
            addCriterion("S_MODIFY_ITEMID like", value, "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidNotLike(String value) {
            addCriterion("S_MODIFY_ITEMID not like", value, "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidIn(List<String> values) {
            addCriterion("S_MODIFY_ITEMID in", values, "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidNotIn(List<String> values) {
            addCriterion("S_MODIFY_ITEMID not in", values, "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidBetween(String value1, String value2) {
            addCriterion("S_MODIFY_ITEMID between", value1, value2, "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemidNotBetween(String value1, String value2) {
            addCriterion("S_MODIFY_ITEMID not between", value1, value2, "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemIsNull() {
            addCriterion("S_MODIFY_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andSModifyItemIsNotNull() {
            addCriterion("S_MODIFY_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andSModifyItemEqualTo(String value) {
            addCriterion("S_MODIFY_ITEM =", value, "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSModifyItemNotEqualTo(String value) {
            addCriterion("S_MODIFY_ITEM <>", value, "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSModifyItemGreaterThan(String value) {
            addCriterion("S_MODIFY_ITEM >", value, "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSModifyItemGreaterThanOrEqualTo(String value) {
            addCriterion("S_MODIFY_ITEM >=", value, "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSModifyItemLessThan(String value) {
            addCriterion("S_MODIFY_ITEM <", value, "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSModifyItemLessThanOrEqualTo(String value) {
            addCriterion("S_MODIFY_ITEM <=", value, "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSModifyItemLike(String value) {
            addCriterion("S_MODIFY_ITEM like", value, "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSModifyItemNotLike(String value) {
            addCriterion("S_MODIFY_ITEM not like", value, "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSModifyItemIn(List<String> values) {
            addCriterion("S_MODIFY_ITEM in", values, "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSModifyItemNotIn(List<String> values) {
            addCriterion("S_MODIFY_ITEM not in", values, "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSModifyItemBetween(String value1, String value2) {
            addCriterion("S_MODIFY_ITEM between", value1, value2, "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSModifyItemNotBetween(String value1, String value2) {
            addCriterion("S_MODIFY_ITEM not between", value1, value2, "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyIsNull() {
            addCriterion("S_BEFORE_MODIFY is null");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyIsNotNull() {
            addCriterion("S_BEFORE_MODIFY is not null");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyEqualTo(String value) {
            addCriterion("S_BEFORE_MODIFY =", value, "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyNotEqualTo(String value) {
            addCriterion("S_BEFORE_MODIFY <>", value, "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyGreaterThan(String value) {
            addCriterion("S_BEFORE_MODIFY >", value, "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyGreaterThanOrEqualTo(String value) {
            addCriterion("S_BEFORE_MODIFY >=", value, "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyLessThan(String value) {
            addCriterion("S_BEFORE_MODIFY <", value, "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyLessThanOrEqualTo(String value) {
            addCriterion("S_BEFORE_MODIFY <=", value, "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyLike(String value) {
            addCriterion("S_BEFORE_MODIFY like", value, "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyNotLike(String value) {
            addCriterion("S_BEFORE_MODIFY not like", value, "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyIn(List<String> values) {
            addCriterion("S_BEFORE_MODIFY in", values, "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyNotIn(List<String> values) {
            addCriterion("S_BEFORE_MODIFY not in", values, "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyBetween(String value1, String value2) {
            addCriterion("S_BEFORE_MODIFY between", value1, value2, "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyNotBetween(String value1, String value2) {
            addCriterion("S_BEFORE_MODIFY not between", value1, value2, "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyIsNull() {
            addCriterion("S_AFTER_MODIFY is null");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyIsNotNull() {
            addCriterion("S_AFTER_MODIFY is not null");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyEqualTo(String value) {
            addCriterion("S_AFTER_MODIFY =", value, "sAfterModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyNotEqualTo(String value) {
            addCriterion("S_AFTER_MODIFY <>", value, "sAfterModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyGreaterThan(String value) {
            addCriterion("S_AFTER_MODIFY >", value, "sAfterModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyGreaterThanOrEqualTo(String value) {
            addCriterion("S_AFTER_MODIFY >=", value, "sAfterModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyLessThan(String value) {
            addCriterion("S_AFTER_MODIFY <", value, "sAfterModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyLessThanOrEqualTo(String value) {
            addCriterion("S_AFTER_MODIFY <=", value, "sAfterModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyLike(String value) {
            addCriterion("S_AFTER_MODIFY like", value, "sAfterModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyNotLike(String value) {
            addCriterion("S_AFTER_MODIFY not like", value, "sAfterModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyIn(List<String> values) {
            addCriterion("S_AFTER_MODIFY in", values, "sAfterModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyNotIn(List<String> values) {
            addCriterion("S_AFTER_MODIFY not in", values, "sAfterModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyBetween(String value1, String value2) {
            addCriterion("S_AFTER_MODIFY between", value1, value2, "sAfterModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyNotBetween(String value1, String value2) {
            addCriterion("S_AFTER_MODIFY not between", value1, value2, "sAfterModify");
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

        public Criteria andSModifyItemidLikeInsensitive(String value) {
            addCriterion("upper(S_MODIFY_ITEMID) like", value.toUpperCase(), "sModifyItemid");
            return (Criteria) this;
        }

        public Criteria andSModifyItemLikeInsensitive(String value) {
            addCriterion("upper(S_MODIFY_ITEM) like", value.toUpperCase(), "sModifyItem");
            return (Criteria) this;
        }

        public Criteria andSBeforeModifyLikeInsensitive(String value) {
            addCriterion("upper(S_BEFORE_MODIFY) like", value.toUpperCase(), "sBeforeModify");
            return (Criteria) this;
        }

        public Criteria andSAfterModifyLikeInsensitive(String value) {
            addCriterion("upper(S_AFTER_MODIFY) like", value.toUpperCase(), "sAfterModify");
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

        public Criteria andSOperatorLikeInsensitive(String value) {
            addCriterion("upper(S_OPERATOR) like", value.toUpperCase(), "sOperator");
            return (Criteria) this;
        }

        public Criteria andSStatusLikeInsensitive(String value) {
            addCriterion("upper(S_STATUS) like", value.toUpperCase(), "sStatus");
            return (Criteria) this;
        }

        public Criteria andSOperatorNoLikeInsensitive(String value) {
            addCriterion("upper(S_OPERATOR_NO) like", value.toUpperCase(), "sOperatorNo");
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