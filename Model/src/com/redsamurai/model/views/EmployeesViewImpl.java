package com.redsamurai.model.views;


import com.redsamurai.model.views.common.EmployeesView;

import oracle.jbo.VariableValueManager;
import oracle.jbo.common.ViewCriteriaImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jul 16 12:22:07 EEST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmployeesViewImpl extends ViewObjectImpl implements EmployeesView {
    /**
     * This is the default constructor (do not remove).
     */
    public EmployeesViewImpl() {
        //this.setNestedSelectForFullSql(false);
    }
    
    public String calculateEmployees(String firstName, String lastName) {
        ViewCriteriaImpl vc = (ViewCriteriaImpl) this.getViewCriteria("EmployeesViewCriteria");
        VariableValueManager vvm = this.ensureVariableManager();
        vvm.setVariableValue("firstNameVar", firstName);
        vvm.setVariableValue("lastNameVar", lastName);
        this.applyViewCriteria(vc);
        this.executeQuery();
        
        return Long.toString(this.getEstimatedRowCount());
    }
    
    public String login() {
        return "OK";
    }

    /**
     * Returns the variable value for firstNameVar.
     * @return variable value for firstNameVar
     */
    public String getfirstNameVar() {
        return (String) ensureVariableManager().getVariableValue("firstNameVar");
    }

    /**
     * Sets <code>value</code> for variable firstNameVar.
     * @param value value to bind as firstNameVar
     */
    public void setfirstNameVar(String value) {
        ensureVariableManager().setVariableValue("firstNameVar", value);
    }

    /**
     * Returns the variable value for lastNameVar.
     * @return variable value for lastNameVar
     */
    public String getlastNameVar() {
        return (String) ensureVariableManager().getVariableValue("lastNameVar");
    }

    /**
     * Sets <code>value</code> for variable lastNameVar.
     * @param value value to bind as lastNameVar
     */
    public void setlastNameVar(String value) {
        ensureVariableManager().setVariableValue("lastNameVar", value);
    }

//    @Override
//    protected ViewRowImpl createRowFromResultSet(Object object, ResultSet resultSet) {
//        ViewRowImpl row = super.createRowFromResultSet(object, resultSet);
//        
//        ViewCriteriaImpl vc = (ViewCriteriaImpl) this.getViewCriteria("__DefaultViewCriteria__");
//        ViewCriteriaRow vcRow = (ViewCriteriaRow) vc.first();
//              
//        ViewCriteriaItem vci = vcRow.getCriteriaItem("JobId");
//        
//        System.out.println(row.getKey());
//        row.setAttribute("JobId", vci.getValue());
//        
//        return row;
//    }
}

