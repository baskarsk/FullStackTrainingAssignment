package com.cts.pm.task;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



import java.util.List;

public interface TaskRepository extends CrudRepository<Task,Integer>{
//    @Query("SELECT NEW com.cts.cde.io.onboarding.sub_stage.SubStageFilter(SS.id, SS.name, SS.stage) FROM SubStage SS")
//    List<TaskFilter> findAllWithFilter();
//
//    //Update stage id also in on 06/12/17
//    @Modifying
//    @Query("UPDATE SubStage SS SET SS.name = :subStageName, SS.stage = :stage WHERE SS.id= :subStageId")
//    void updateSubStage(@Param("subStageName") String subStageName, @Param("subStageId") int subStageId,@Param("stage") Stage stage);
}
