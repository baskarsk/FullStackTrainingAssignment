package com.cts.pm.project;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.cts.pm.project.ProjectFilter;

public interface ProjectRepository extends CrudRepository<Project, Integer> {


//    String CUSTOM_QUERY_BY_ROLE = "SELECT NEW com.cts.cde.io.onboarding.content.ContentFilter(" +
//            "SC.id,SC.name,SC.subStage.name,SC.subStage.stage.name)" +
//            " FROM Content SC INNER JOIN SC.roles RS " +
//            "INNER JOIN RS.users US WHERE US.userName=:name";
//
//    String CUSTOM_QUERY_FOR_ADMIN = "SELECT NEW com.cts.cde.io.onboarding.content.ContentFilter(" +
//            "SC.id,SC.name,SC.subStage.name,SC.subStage.stage.name)" +
//            " FROM Content SC";
//
//    String CUSTOM_QUERY_FOR_DELETE = "DELETE FROM ContentStatus CS " +
//            "WHERE CS.content.id= :contentId";
//
//    @Query(CUSTOM_QUERY_BY_ROLE)
//    List<ProjectFilter> findByRoleId(@Param("name") String name);
//
//    @Query(CUSTOM_QUERY_FOR_ADMIN)
//    List<ProjectFilter> findAllForAdmin();
//
//    @Transactional
//    @Modifying
//    @Query(CUSTOM_QUERY_FOR_DELETE)
//    void deleteAllUserContentStatus(@Param("contentId") int contentId);





}
