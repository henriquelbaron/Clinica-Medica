package br.com.clinica.dao.banco;

import java.util.List;

public interface DaoTemplate<T> {

    public List<T> findAll();

    public int save(T obj);

    public boolean update(T obj);

    public boolean delete(int id);

    public T findById(int id);

    public List<T> findByValue(String value);

}
