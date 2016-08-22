package com.milleniuminfinity.app.milleniuminfinity.repository;

import java.util.Set;

/**
 * Created by 208023429 on 4/21/2016.
 */
public interface Repository <Entity, Identity> {

    Entity findById(Identity identity1, Identity identity2);
    Entity save(Entity entity) throws Exception;
    Entity update(Entity entity) throws Exception;
    Entity delete (Entity entity) throws Exception;
    int deleteAll() throws Exception;
    Set<Entity> findAll() throws Exception;
}
