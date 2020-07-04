package com.whw.service;

import com.whw.query.PageQuery;
import com.whw.response.Page;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T, ID, Q extends PageQuery> implements InitializingBean, ApplicationContextAware {

    @Autowired
    protected EntityManager entityManager;
    protected JpaRepository<T, ID> dao;

    private ApplicationContext context;

    @Transactional(readOnly = true)
    public T findById(ID id) {
        Optional<T> optional = dao.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Page<T> page(Q params) {
        Class<T> clazz = getEntityClass();
        List<T> list = list(params, clazz);
        Long count = count(params, clazz);
        return new Page<>(list, count, params.getPage(), params.getPageSize());
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return dao.findAll();
    }

    public T save(T entity) {
        return dao.saveAndFlush(entity);
    }

    public void saveAll(List<T> entities) {
        dao.saveAll(entities);
    }

    public T update(T entity) {
        return dao.saveAndFlush(entity);
    }

    public void delete(T entity) {
        dao.delete(entity);
    }

    public void deleteById(ID id) {
        dao.deleteById(id);
    }

    public void deleteAll(List<ID> ids) {
        List<T> entities = dao.findAllById(ids);
        if (entities != null && !entities.isEmpty()) {
            dao.deleteAll(entities);
        }
    }

    protected abstract void makeupWhereClause(Q params, CriteriaBuilder builder, Root<T> root, List<Predicate> predicates);

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    private List<T> list(Q params, Class<T> clazz) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(clazz);  // select *
        Root<T> root = criteriaQuery.from(clazz); // from T
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();
        makeupWhereClause(params, builder, root, predicates);
        criteriaQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()]))); // where 1 and 2 and 3 and 4

        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        query.setFirstResult((params.getPage() - 1) * params.getPageSize());// page=3, pageSize=10, start=(3-1)*10=20, 从下标20的记录开始
        query.setMaxResults(params.getPageSize());

        return query.getResultList();
    }

    private Long count(Q params, Class<T> clazz) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);  // select *
        Root<T> root = criteriaQuery.from(clazz); // from T

        criteriaQuery.select(builder.count(root.get("id")));
        List<Predicate> predicates = new ArrayList<>();
        makeupWhereClause(params, builder, root, predicates);
        criteriaQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()]))); // where 1 and 2 and 3 and 4

        TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void afterPropertiesSet() throws Exception {
        Class<T> entityClass = getEntityClass();

        String entityPackageName = entityClass.getPackage().getName();
        String entityName = entityClass.getSimpleName();

        String daoFullName = entityPackageName.substring(0, entityPackageName.lastIndexOf('.')) + ".dao." + entityName + "Dao";
        Class<JpaRepository> daoClass = (Class<JpaRepository>) Class.forName(daoFullName);
        JpaRepository daoBean = context.getBean(daoClass);

        this.dao = daoBean;
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }
}
