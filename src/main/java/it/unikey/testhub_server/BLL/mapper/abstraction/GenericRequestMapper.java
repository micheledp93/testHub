package it.unikey.testhub_server.BLL.mapper.abstraction;

import java.util.List;

public interface GenericRequestMapper<E, D> {
    E asEntity(D dto);
    List<E> asEntityList(List<D> entities);
}
