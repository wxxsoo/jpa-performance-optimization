package optimization.performance.jpa.config;

import lombok.RequiredArgsConstructor;
import optimization.performance.jpa.domain.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitData {

    private final InitDataService initDataService;

    @PostConstruct
    public void init() {
        initDataService.initData();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitDataService {

        private final TagRepository tagRepository;
        private final CategoryRepository categoryRepository;
        private final OutputRepository outputRepository;
        private final ProjectRepository projectRepository;
        private final OutputTagRepository outputTagRepository;


        public void initData() {
            //Category Data Init
            Category category = Category.builder().categoryName("category A").build();
            Category category2 = Category.builder().categoryName("category B").build();
            Category category3 = Category.builder().categoryName("category C").build();
            categoryRepository.save(category);
            categoryRepository.save(category2);
            categoryRepository.save(category3);

            Project project = Project.builder().projectName("project A").build();
            Project project2 = Project.builder().projectName("project B").build();
            Project project3 = Project.builder().projectName("project C").build();
            projectRepository.save(project);
            projectRepository.save(project2);
            projectRepository.save(project3);

            Tag tag = Tag.builder().tagName("tag A").build();
            Tag tag2 = Tag.builder().tagName("tag B").build();
            Tag tag3 = Tag.builder().tagName("tag C").build();
            tagRepository.save(tag);
            tagRepository.save(tag2);
            tagRepository.save(tag3);

            Output output = Output.builder().outputName("Output A from project A").category(category).project(project).build();
            Output output2 = Output.builder().outputName("Output B from project B").category(category2).project(project2).build();
            Output output3 = Output.builder().outputName("Output C from project C").category(category3).project(project3).build();

            outputRepository.save(output);
            outputRepository.save(output2);
            outputRepository.save(output3);

            OutputTag outputTag = OutputTag.builder().tag(tag).output(output).build();
            OutputTag outputTag2 = OutputTag.builder().tag(tag2).output(output).build();
            OutputTag outputTag3 = OutputTag.builder().tag(tag).output(output2).build();
            OutputTag outputTag4 = OutputTag.builder().tag(tag3).output(output2).build();
            OutputTag outputTag5 = OutputTag.builder().tag(tag2).output(output3).build();
            OutputTag outputTag6 = OutputTag.builder().tag(tag3).output(output3).build();

            outputTagRepository.save(outputTag);
            outputTagRepository.save(outputTag2);
            outputTagRepository.save(outputTag3);
            outputTagRepository.save(outputTag4);
            outputTagRepository.save(outputTag5);
            outputTagRepository.save(outputTag6);
        }
    }
}
