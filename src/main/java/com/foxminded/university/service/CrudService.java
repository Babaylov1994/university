package com.foxminded.university.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, Id> {

    List<T> getAll();

    Optional<T> getById(Id id);

    boolean create(T t);

    boolean delete (Id id);
}
