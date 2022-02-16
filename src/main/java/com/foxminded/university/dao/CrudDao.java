package com.foxminded.university.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao <T, Id> {

    List<T> getAll();

    Optional<T> getById(Id id);

    boolean create(T t);

    boolean delete (Id id);

}
