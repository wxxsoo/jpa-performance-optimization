package optimization.performance.jpa.domain;

import optimization.performance.jpa.dto.OutputResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OutputRepository extends JpaRepository<Output, Long>, OutputRepositoryCustom {

    @Query("select o from Output o " +
            "join fetch o.project p " +
            "join fetch o.category c")
    List<Output> findOutputsV2();

    @Query("select distinct o from Output o " +
            "join fetch o.project p " +
            "join fetch o.category c " +
            "join fetch o.outputTags ot " +
            "join fetch ot.tag")
    List<Output> findOutputsV3();

//    @Query("select distinct o from Output o " +
//            "join fetch o.project p " +
//            "join fetch o.category c " +
//            "join fetch o.outputTags ot " +
//            "join fetch ot.tag")
//    List<Output> findOutputsV4(Pageable pageable);

    @Query("select o from Output o " +
            "join fetch o.project p " +
            "join fetch o.category c")
    List<Output> findOutputsV4(Pageable pageable);
}
