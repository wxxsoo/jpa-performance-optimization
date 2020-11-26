package optimization.performance.jpa.domain;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OutputRepositoryCustom {
    List<Output> findOutputsV5(Pageable pageable);
}
