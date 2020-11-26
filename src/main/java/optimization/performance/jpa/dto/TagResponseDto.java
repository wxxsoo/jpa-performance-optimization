package optimization.performance.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import optimization.performance.jpa.domain.Tag;

@Data
public class TagResponseDto {

    private Long tagId;
    private String tagName;

    @Builder
    public TagResponseDto(Long tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }

    public static TagResponseDto toDto(Tag tag) {
        return TagResponseDto.builder()
                .tagId(tag.getId())
                .tagName(tag.getTagName())
                .build();
    }
}
