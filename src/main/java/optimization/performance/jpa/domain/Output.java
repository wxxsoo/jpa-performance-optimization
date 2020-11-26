package optimization.performance.jpa.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Output {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "output_id")
    private Long id;
    private String outputName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "output")
    private List<OutputTag> outputTags = new ArrayList<>();

    @Builder
    public Output(String outputName, Project project, Category category) {
        this.outputName = outputName;
        this.project = project;
        this.category = category;
        this.outputTags = new ArrayList<>();
    }

    public void addOutputTag(OutputTag outputTag) {
        this.outputTags.add(outputTag);
    }
}
