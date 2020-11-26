package optimization.performance.jpa.controller;

import lombok.RequiredArgsConstructor;
import optimization.performance.jpa.dto.OutputResponseDto;
import optimization.performance.jpa.service.OutputService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OutputController {
    private final OutputService outputService;

    @GetMapping("/api/v1/outputs")
    public ResponseEntity<List<OutputResponseDto>> findOutputsV1() {
        return new ResponseEntity<>(outputService.findOutputsV1(), HttpStatus.OK);
    }

    @GetMapping("/api/v2/outputs")
    public ResponseEntity<List<OutputResponseDto>> findOutputsV2() {
        return new ResponseEntity<>(outputService.findOutputsV2(), HttpStatus.OK);
    }

    @GetMapping("/api/v3/outputs")
    public ResponseEntity<List<OutputResponseDto>> findOutputsV3() {
        return new ResponseEntity<>(outputService.findOutputsV3(), HttpStatus.OK);
    }

    @GetMapping("/api/v4/outputs")
    public ResponseEntity<List<OutputResponseDto>> findOutputsV4(Pageable pageable) {
        return new ResponseEntity<>(outputService.findOutputsV4(pageable), HttpStatus.OK);
    }

    @GetMapping("/api/v5/outputs")
    public ResponseEntity<List<OutputResponseDto>> findOutputsV5(Pageable pageable) {
        return new ResponseEntity<>(outputService.findOutputsV5(pageable), HttpStatus.OK);
    }
}
