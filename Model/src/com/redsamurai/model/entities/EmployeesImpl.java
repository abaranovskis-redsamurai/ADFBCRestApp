package com.redsamurai.model.entities;

import java.math.BigDecimal;

import oracle.adf.share.ADFContext;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Aug 05 14:40:00 EEST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmployeesImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        EmployeeId,
        FirstName,
        LastName,
        Email,
        PhoneNumber,
        HireDate,
        JobId,
        Salary,
        CommissionPct,
        ManagerId,
        DepartmentId,
        CHANGEINDICATORATTR,
        Employees,
        ManagerIdEmployees,
        Jobs;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }

    public static final int EMPLOYEEID = AttributesEnum.EmployeeId.index();
    public static final int FIRSTNAME = AttributesEnum.FirstName.index();
    public static final int LASTNAME = AttributesEnum.LastName.index();
    public static final int EMAIL = AttributesEnum.Email.index();
    public static final int PHONENUMBER = AttributesEnum.PhoneNumber.index();
    public static final int HIREDATE = AttributesEnum.HireDate.index();
    public static final int JOBID = AttributesEnum.JobId.index();
    public static final int SALARY = AttributesEnum.Salary.index();
    public static final int COMMISSIONPCT = AttributesEnum.CommissionPct.index();
    public static final int MANAGERID = AttributesEnum.ManagerId.index();
    public static final int DEPARTMENTID = AttributesEnum.DepartmentId.index();
    public static final int CHANGEINDICATORATTR = AttributesEnum.CHANGEINDICATORATTR.index();
    public static final int EMPLOYEES = AttributesEnum.Employees.index();
    public static final int MANAGERIDEMPLOYEES = AttributesEnum.ManagerIdEmployees.index();
    public static final int JOBS = AttributesEnum.Jobs.index();

    /**
     * This is the default constructor (do not remove).
     */
    public EmployeesImpl() {
    }

    /**
     * @param employeeId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer employeeId) {
        return new Key(new Object[] { employeeId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.redsamurai.model.entities.Employees");
    }


    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        // value currently in DB
        BigDecimal changeIndicatorAttrPosted = (BigDecimal) this.getPostedAttribute(this.getEntityDef()
                                                                              .findAttributeDef("ChangeIndicatorAttr")
                                                                              .getIndex());
        // value coming from REST request
        BigDecimal changeIndicatorAttr = (BigDecimal) this.getAttribute("ChangeIndicatorAttr");

        
        if (changeIndicatorAttrPosted != null && changeIndicatorAttr != null && changeIndicatorAttrPosted.compareTo(changeIndicatorAttr) > 0) {
            this.setAttribute("ChangeIndicatorAttr", changeIndicatorAttrPosted);
            ADFContext.getCurrent().getRequestScope().put("dataConflict", "Y");
        } else {
            super.doDML(operation, e);   
        }
        
    }
}
