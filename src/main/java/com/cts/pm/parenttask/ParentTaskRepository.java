package com.cts.pm.parenttask;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParentTaskRepository extends CrudRepository<ParentTask,Integer> {

//    @Query("SELECT S FROM Stage S INNER JOIN S.subStages SS " +
//            "INNER JOIN SS.contents C INNER JOIN C.roles R WHERE S.name=:name and R.id=:role_id")
//    List<Stage> findByStageAndRole(@Param("name")String name, @Param("role_id") int id);

}
