package com.secureQR.Service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * application.properties에서 설정한 정규식 매칭 패턴 호출
 */
@Component
@Data
public class ParsingPattern {
    @Value("${parsing.pattern}")
    private String regx;
}
