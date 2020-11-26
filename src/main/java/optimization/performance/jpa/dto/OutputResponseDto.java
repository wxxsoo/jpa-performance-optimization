package optimization.performance.jpa.dto;

import lombok.Builder;
import lombok.Data;
import optimization.performance.jpa.domain.Output;
import optimization.performance.jpa.domain.Project;

import java.util.ArrayList;
import java.util.List;

@Data
public class OutputResponseDto {
    private Long outputId;
    private String outputName;
    private ProjectResponseDto project;
    private CategoryResponseDto category;
    private List<TagResponseDto> tags = new ArrayList<>();

    @Builder
    public OutputResponseDto(Long outputId, String outputName, ProjectResponseDto project, CategoryResponseDto category, List<TagResponseDto> tags) {
        this.outputId = outputId;
        this.outputName = outputName;
        this.project = project;
        this.category = category;
        this.tags = tags;
    }
}
