package optimization.performance.jpa.dto;

import lombok.Builder;
import lombok.Data;
import optimization.performance.jpa.domain.Project;

@Data
public class ProjectResponseDto {

    private Long projectId;
    private String projectName;

    @Builder
    public ProjectResponseDto(Long projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public static ProjectResponseDto toDto(Project project) {
        return ProjectResponseDto.builder().projectId(project.getId()).projectName(project.getProjectName()).build();
    }
}
