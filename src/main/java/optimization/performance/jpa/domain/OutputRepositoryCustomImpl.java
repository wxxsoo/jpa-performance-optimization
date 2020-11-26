package optimization.performance.jpa.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static optimization.performance.jpa.domain.QOutput.output;
import static optimization.performance.jpa.domain.QCategory.category;
import static optimization.performance.jpa.domain.QProject.project;

@RequiredArgsConstructor
public class OutputRepositoryCustomImpl implements OutputRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Output> findOutputsV5(Pageable pageable) {
        return queryFactory.selectFrom(output)
                .join(output.category, category).fetchJoin()
                .join(output.project, project).fetchJoin()
                .offset(pageable.getOffset()).limit(pageable.getPageSize())
                .fetch();
    }
}
