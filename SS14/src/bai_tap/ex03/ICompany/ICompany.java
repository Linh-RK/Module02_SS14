package bai_tap.ex03.ICompany;

public interface ICompany <T, E>{
    void displayAll();
    void addNew();
    void update();
    void delete();
    T findById(E id);
}
