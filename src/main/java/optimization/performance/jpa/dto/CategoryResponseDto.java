package optimization.performance.jpa.dto;

import lombok.Builder;
import lombok.Data;
import optimization.performance.jpa.domain.Category;

@Data
public class CategoryResponseDto {
    private Long categoryId;
    private String categoryName;

    @Builder
    public CategoryResponseDto(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public static CategoryResponseDto toDto(Category category) {
        return CategoryResponseDto.builder().categoryId(category.getId())
                .categoryName(category.getCategoryName())
                .build();
    }
}
