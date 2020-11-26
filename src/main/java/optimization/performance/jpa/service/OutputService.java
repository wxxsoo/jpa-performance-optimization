package optimization.performance.jpa.service;

import lombok.RequiredArgsConstructor;
import optimization.performance.jpa.domain.Category;
import optimization.performance.jpa.domain.Output;
import optimization.performance.jpa.domain.OutputRepository;
import optimization.performance.jpa.domain.Project;
import optimization.performance.jpa.dto.CategoryResponseDto;
import optimization.performance.jpa.dto.OutputResponseDto;
import optimization.performance.jpa.dto.ProjectResponseDto;
import optimization.performance.jpa.dto.TagResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OutputService {

    private final OutputRepository outputRepository;

    public List<OutputResponseDto> findOutputsV1() {
        List<Output> outputList = outputRepository.findAll();

        return outputList.stream().map(output -> {
            ProjectResponseDto projectResponseDto = ProjectResponseDto.toDto(output.getProject());
            CategoryResponseDto categoryResponseDto = CategoryResponseDto.toDto(output.getCategory());
             return OutputResponseDto.builder()
                    .outputId(output.getId())
                    .outputName(output.getOutputName())
                    .project(projectResponseDto)
                    .category(categoryResponseDto)
                    .build();
        }).collect(Collectors.toList());
    }

    public List<OutputResponseDto> findOutputsV2() {
        List<Output> outputList = outputRepository.findOutputsV2();

        return outputList.stream().map(output -> {
            ProjectResponseDto projectResponseDto = ProjectResponseDto.toDto(output.getProject());
            CategoryResponseDto categoryResponseDto = CategoryResponseDto.toDto(output.getCategory());
            return OutputResponseDto.builder()
                    .outputId(output.getId())
                    .outputName(output.getOutputName())
                    .project(projectResponseDto)
                    .category(categoryResponseDto)
                    .build();
        }).collect(Collectors.toList());
    }

    public List<OutputResponseDto> findOutputsV3() {
//        List<Output> outputList = outputRepository.findOutputsV2();
        List<Output> outputList = outputRepository.findOutputsV3();

        return outputList.stream().map(output -> {
            ProjectResponseDto projectResponseDto = ProjectResponseDto.toDto(output.getProject());
            CategoryResponseDto categoryResponseDto = CategoryResponseDto.toDto(output.getCategory());
            List<TagResponseDto> tagResponseDtos = output.getOutputTags()
                    .stream()
                    .map(
                            outputTag -> TagResponseDto.toDto(outputTag.getTag())
                    )
                    .collect(Collectors.toList());
            return OutputResponseDto.builder()
                    .outputId(output.getId())
                    .outputName(output.getOutputName())
                    .project(projectResponseDto)
                    .category(categoryResponseDto)
                    .tags(tagResponseDtos)
                    .build();
        }).collect(Collectors.toList());
    }

    public List<OutputResponseDto> findOutputsV4(Pageable pageable) {
        List<Output> outputList = outputRepository.findOutputsV4(pageable);

        return outputList.stream().map(output -> {
            ProjectResponseDto projectResponseDto = ProjectResponseDto.toDto(output.getProject());
            CategoryResponseDto categoryResponseDto = CategoryResponseDto.toDto(output.getCategory());
            List<TagResponseDto> tagResponseDtos = output.getOutputTags()
                    .stream()
                    .map(
                            outputTag -> TagResponseDto.toDto(outputTag.getTag())
                    )
                    .collect(Collectors.toList());
            return OutputResponseDto.builder()
                    .outputId(output.getId())
                    .outputName(output.getOutputName())
                    .project(projectResponseDto)
                    .category(categoryResponseDto)
                    .tags(tagResponseDtos)
                    .build();
        }).collect(Collectors.toList());
    }

    public List<OutputResponseDto> findOutputsV5(Pageable pageable) {
        List<Output> outputList = outputRepository.findOutputsV5(pageable);

        return outputList.stream().map(output -> {
            ProjectResponseDto projectResponseDto = ProjectResponseDto.toDto(output.getProject());
            CategoryResponseDto categoryResponseDto = CategoryResponseDto.toDto(output.getCategory());
            List<TagResponseDto> tagResponseDtos = output.getOutputTags()
                    .stream()
                    .map(
                            outputTag -> TagResponseDto.toDto(outputTag.getTag())
                    )
                    .collect(Collectors.toList());
            return OutputResponseDto.builder()
                    .outputId(output.getId())
                    .outputName(output.getOutputName())
                    .project(projectResponseDto)
                    .category(categoryResponseDto)
                    .tags(tagResponseDtos)
                    .build();
        }).collect(Collectors.toList());
    }
}
