package Person.Employee;

import Person.Person;

import java.time.LocalDate;

public class Employee extends Person {

    private int _employeeid;
    private TypeOfWork _typeOfWork;
    private double _basesalary;


    public int getEmployeeid(){
        return this._employeeid;
    }
    public void setEmployeeid(int employeeid){
        this._employeeid = employeeid;
    }
    public TypeOfWork getTypeOfWork(){
        return this._typeOfWork;
    }
    public void setTypeOfWork(TypeOfWork typeOfWork){
        this._typeOfWork=_typeOfWork;
    }
    public double getBasesalary(){
        return _basesalary;
    }
    public void setBasesalary(double basesalary){
        this._basesalary=basesalary;
    }

    public Employee(){

        this(0, " ", " ", null, ' ',0,TypeOfWork.not_specified,0);
    }
    public Employee(int id, String firstname, String lastname, LocalDate birthdate, char gender, int employeeid, TypeOfWork typeOfWork, double basesalary){
        super(id,firstname,lastname,birthdate,gender);
        this.setEmployeeid(employeeid);
        this.setTypeOfWork(typeOfWork);
        this.setBasesalary(basesalary);
    }

    @Override
    public String toString(){
        return super.toString()+"\n "+ this._employeeid +" "+ this._typeOfWork+" "+this._basesalary;
    }


}
