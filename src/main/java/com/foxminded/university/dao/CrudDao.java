package com.foxminded.university.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao <T, Id> {

    Optional<List<T>> getAll();

    Optional<T> getById(Id id);

    void create(T t);

    void delete (Id id);

}
