package optimization.performance.jpa.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OutputTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "output_tag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "output_id")
    private Output output;

    @Builder
    public OutputTag(Tag tag, Output output) {
        this.tag = tag;
        this.output = output;
        output.addOutputTag(this);
    }
}
